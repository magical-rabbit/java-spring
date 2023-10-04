var mysubmit = function(){
    // 获取到所有的输入的值，组装成json对象
    var params = {
        id: $("#id").val(),
        username: $("#username").val(),
        password: $("#password").val(),
        realName: $("#realName").val(),
        sex: $("#sex").val(),
        sno: $("#sno").val(),
        facultyId: $("#facultyId").val(),
        majorId: $("#majorId").val(),
        classId: $("#classId").val()
    };

    // ajax提交
    $.ajax({
        type: "post",
        url: "/user/update",
        data: params,
        dataType: "json",
        success: function(data){
            if(data.code == "200"){
                alert("修改成功");
            }else{
                alert("修改失败");
            }
        }
    });
}