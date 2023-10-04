var tmp_arr = {};
$(function () {
    load_page()
});

var load_page=function (){
    $("#jsGrid1").jsGrid({
        width: "100%",
        height: "auto",
        sorting: true,
        paging: true,
        pageLoading: true,
        autoload: true,

        controller: {
            loadData: function (filter) {

                tmp_arr = {}; // 初始化
                filter["search"]= $("#search").val()

                return $.ajax({
                    type: "post",
                    url: "/user/list",
                    dataType: "json",
                    data: filter
                });
            }
        },
        pageIndex: 1,
        pageSize: 3,

        pageButtonCount: 10,
        pagePrevText: "上一页",
        pageNextText: "下一页",
        pageFirstText: "首页",
        pageLastText: "尾页",

        fields: [
            { title: "ID",name:"id", type: "text", width: 150 },
            { title: "用户名",name:"username", type: "text", width: 150 },
            { title: "真是姓名",name:"realName", type: "text", width: 150 },
            { title: "学号",name:"sno", type: "text", width: 150 },

            { title: "性别",name:"sex", type: "text", width: 150,
                itemTemplate: function (value, item) {
                    if (item.sex == "1") {
                        return "女";
                    }
                    return "男";
                }
            },
            { name: "入学日期", type: "text", width: 150,
                itemTemplate: function (value, item) {
                    // 创建一个新的日期对象，将时间戳作为参数传递给构造函数
                    // debugger;
                    var timestamp = item['admissionDate']; // 例如，您的时间戳（以毫秒为单位）
                    var date = new Date(timestamp);// 去除毫秒部分
                    if(date instanceof Date && isNaN(date.getTime())){
                        console.log(`[sys-error]解析时间失败，原始数据:${item['admissionDate']}`)
                        return `[Err]解析时间失败，原始数据:${item['admissionDate']}`
                    }
                    date.setMilliseconds(0);
                    var year = date.getFullYear();
                    var month = (date.getMonth() + 1).toString().padStart(2, '0'); // 月份从0开始，需要加1
                    var day = date.getDate().toString().padStart(2, '0'); // 天数
                    var hours = date.getHours().toString().padStart(2, '0'); // 小时
                    var minutes = date.getMinutes().toString().padStart(2, '0'); // 分钟
                    var seconds = date.getSeconds().toString().padStart(2, '0'); // 秒
                    var formattedDate = year + '-' + month + '-' + day + ' ' + hours + ':' + minutes + ':' + seconds;
                    // console.log()
                    return formattedDate;
                }


            },
            {title: "操作", name: "id", type: "text", width: 150 ,
                itemTemplate: function(value, item){
                    tmp_arr[value] = item;
                    return "<a href='javascript:void(0)' onclick='update($id)'>修改</a>".replace("$id", value)
                        + "&nbsp;&nbsp;&nbsp;&nbsp;<a href='javascript:void(0)' onclick='del($id)'>删除</a>".replace("$id", value);
                }
            }

        ]
    });
}

var del=function(id){
    // alert(id)
    $.ajax({
        type:"post",
        url:"/user/del",
        data:{"id":id},
        dataType: "json",
        success:function (){
            if(data.code!="200"){
                alert("删除失败")
                console.log(`[sys]Del ${id} failed.`)
            }

            if(data.code=="200"){
                alert("删除成功")
                console.log(`[sys]Del ${id} succeed.`)
            }
        }
    })
}


/*
修改
*/
var update = function(id){
    var obj = tmp_arr[id];

    $.ajax({
        type: "get",
        url: "./user-edit.html",
        success: function(data){ // 这个参数data就是读取到的页面的HTML代码
            //console.log(data);
            $("#content").html(data); // 加载新增修改页

            // 数据回填
            $("#id").val(obj.id);
            $("#username").val(obj.username);
            $("#password").val(obj.password);
            $("#realName").val(obj.realName);
            $("#sex").val(obj.sex);
            $("#sno").val(obj.sno);

            // 加载班级下拉列表
            $.ajax({
                type: "post",
                url: "/class/getByMajorId",
                data: {"majorId": obj.majorId},
                dataType: "json",
                success: function(data){
                    console.log(data);
                    var opts = '<option value="">--请选择--</option>';
                    $.each(data, function(index, obj){
                        opts += '<option value="$id">$text</option>'.replace("$id", obj.id).replace("$text", obj.className)
                    });
                    // 把选项放到下拉列表
                    $("#classId").html(opts);
                    // 设置选中
                    $("#classId").val(obj.classId);
                }
            });
        }
    });
}