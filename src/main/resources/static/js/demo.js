$(function(){
    //页面自动执行
    console.log(123);
    var v = $("#h1").html();
    console.log(v)
})


var test  =  function (){
    var name =  $("#name").val();//.val（）获得表单元素的值 //input select textarea(文本域）
    var pwd = $("#pwd").val();

    console.log(name+" , ",pwd)
}