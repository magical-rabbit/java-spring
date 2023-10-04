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