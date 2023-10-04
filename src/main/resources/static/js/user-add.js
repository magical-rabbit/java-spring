var mysubmit = function () {
    //获取所有的输入的值，组装成json对象
    var params = {
        username: $("#username").val(),
        password: $("#password").val(),
        realName: $("#realName").val(),
        sex: $("#sex").val(),
        sno: $("#sno").val(),
        facultyId: $("#facultyId").val(),
        majorId: $("#majorId").val(),
        classId: $("#classId").val()
    };

    //使用ajax提交
    $.ajax({
        type: "post",
        url: "/user/add",
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



// var load_class_options = function (){
//     var majorId = $("#majorId").val()
//     $.ajax({
//         type: "post",
//         url: "/class/getByMajorId",
//         data: {"majorId":majorId},
//         dataType: "json",
//         success:function (data){
//            // console.log(data)
//             var opts = `<option value="">--请选择--</option>`
//             $.each(data,function(index,obj){
//                 opts+=`<option value="${obj.id}">${obj.className}</option>`
//             })
//
//             $("#classId").html(opts)
//         }
//     })
// }




var load_major_list = function (){
    var FacultyId = $("#facultyId").val()
    $.ajax({
        type: "post",
        url: "/major/getByFacultyId",
        data: {"FacultyId":FacultyId},
        dataType: "json",
        success:function (data){
            console.log(data)
            var opts = `<option value="">--请选择--</option>`
            $.each(data,function(index,obj){
                opts+=`<option value="${obj.id}">${obj.majorName}</option>`
            })

            $("#majorId" +
                "").html(opts)
        }
    })
}



var load_faculty_list = function (){
    $.ajax({
        type: "post",
        url: "/faculty/getAllFaculty",
        dataType: "json",
        success:function (data){
            console.log(data)
            var opts = `<option value="">--请选择--</option>`
            $.each(data,function(index,obj){
                opts+=`<option value="${obj.id}">${obj.facultyName}</option>`
            })

            $("#facultyId").html(opts)
        }
    })
}

$(function (){
    load_faculty_list();
})


/*
根据选择的专业加载班级下拉列表的选项
*/
var load_class_options = function(){
    // 获取当前选中的专业
    var majorId = $("#majorId").val();
    $.ajax({
        type: "post",
        url: "/class/getByMajorId",
        data: {"majorId": majorId},
        dataType: "json",
        success: function(data){
            console.log(data);
            var opts = '<option value="">--请选择--</option>';
            $.each(data, function(index, obj){
                opts += '<option value="$id">$text</option>'.replace("$id", obj.id).replace("$text", obj.className)
            });
            // 把选项放到下拉列表
            $("#classId").html(opts);

        }
    });
}