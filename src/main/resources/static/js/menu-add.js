mode_label = "add"

var menu_add_submit = function () {
    //获取所有的输入的值，组装成json对象
    var params = {
        menuName: $("#menuName").val(),
        menuCode: $("#menuCode").val(),
        menuLevel: $("#menuLevel").val(),
        menuUrl: $("#menuUrl").val(),
        parentId: $("#parentId").val(),
        sort: $("#sort").val()
    };
    //使用ajax提交
    $.ajax({
        type: "post",
        url: "/menu/add",
        data: params,
        dataType: "json",
        success:function (data){
            if(data.code === "200"){
                alert("新增成功");
            }
            else{
                alert("新增失败");
            }
        }
    });
};


var modify_menu_func =  function () {
    //获取id
    var id = $("#id").val();
    //使用ajax提交
    $.ajax({
        type: "post",
        url: "/menu/modify",
        data: {
            id: id,
            menuName: $("#menuName").val(),
            menuCode: $("#menuCode").val(),
            menuLevel: $("#menuLevel").val(),
            menuUrl: $("#menuUrl").val(),
            parentId: $("#parentId").val(),
            sort: $("#sort").val()
        },
        dataType: "json",
        success:function (data){
            if(data.code === "200"){
                alert("修改成功");
                console.log('[sys]success edit')
            }
            else{
                alert("修改失败");
                console.log('[sys]fail edit')
            }
        }
    });
}


//加载完成判断有没有值
$( document ).ready(function() {
    //检查id是否有值
    get_id = $("#id").val();
    if(get_id!= ""){
        //修改模式
        mode_label = "edit"
        //获得dayi-button
        var dayi_button = document.getElementById("dayi-button");
        //给dayi-button添加点击事件
        dayi_button.addEventListener("click",modify_menu_func);
        //命名
        $("#dayi-button").val('大白兔-修改')
        return
    }

    //新增模式
    mode_label = "add"
    //获得dayi-button
    var dayi_button = document.getElementById("dayi-button");
    //给dayi-button添加点击事件
    dayi_button.addEventListener("click",menu_add_submit);
    //命名
    $("#dayi-button").val('大白兔-新增')
});
