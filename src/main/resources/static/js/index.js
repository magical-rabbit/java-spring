$(function () {
  //自动执行的逻辑
  $.ajax({
    type: "get",
    url: "./footer.html",
    success:function(data){//data是读取到的页面的html
      // console.log(data)
      // data+="999"
      $("#footer").html(data);
      
    }
  });


  $.ajax({
    type: "get",
    url: "./header.html",
    success:function(data){//data是读取到的页面的html
      $("#header").html(data);
    }
  });

  $.ajax({
    type: "get",
    url: "./left-menu.html",
    success:function(data){//data是读取到的页面的html
      $("#left-menu").html(data);

    }
  });


  $.ajax({
    type: "get",
    url: "./welcome.html",
    success:function(data){//data是读取到的页面的html
      $("#content").html(data);

    }
  });

})


//加載指定頁面到中間正文
var load_content=function (path){
  $.ajax({
    type: "get",
    url: `./${path}`,
    success:function(data){//data是读取到的页面的html
      $("#content").html(data);
      console.log(`[sys]Loaded ./${path} succeed`)
    }
  });
}