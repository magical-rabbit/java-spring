var login = function (){

    //
    $("#login-box-msg").html("[dayi]登錄中...，请稍后，数据库性能可能较弱")
    //獲取輸入的用戶名密碼
    var username = $("#username").val()
    var password = $("#password").val()

    console.log(`${username} , ${password}`)

    if(!username){
        $("#login-box-msg").html("[dayi]用户名不能为空")
        alert("用戶名不能為空")
        return false
    }

    if(!password){
        $("#login-box-msg").html("[dayi]密碼不能為空")
        alert("密碼不能為空")
        return false
    }

    //請求後端
    $.ajax({
        type: "post",
        url : "/user/login",
        data:{
            "username" : username,
            "password" : password
        },
        //指定後端返回的數據類型
        //json xml html text
        dataType:"json",

        // 參數data是後端的返回值
        success: function (data){
            /*
            * ajax異步請求
            *
            * */
            console.log(data)
            if(data.code=="200"){
                window.location.href = "./index.html";
            }else{
                $("#login-box-msg").html("[dayi]用户名密码错误")
                alert("用户名密码错误")
            }

        }
    })
}