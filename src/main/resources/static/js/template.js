
//加载院系函数
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

            $("#faculty_id").html(opts)
        }
    })
}

//加载专业
var load_major_options = function (){
    var FacultyId = $("#faculty_id").val()
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

            $("#major_id").html(opts)
        }
    })
}


//加载班级
var load_class_options = function(){
    // 获取当前选中的专业
    var majorId = $("#major_id").val();
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
            $("#major_semester_id").html(opts);
        }
    });
}





//页面加载完成，自动加载

$(document).ready(function () {
    //加载院系
    load_faculty_list();
});



var add_template_func = function () {
    var formData = collectFormData('.card-body');
    sendDataToBackend("/questionTemplate/add", formData, function(response) {alert("新增成功");}, function(response) {alert("新增失败");});
    

}