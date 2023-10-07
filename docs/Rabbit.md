# 闸瓦实训

> 我发现，这网页（cmd.dayi.ink）好卡啊。
>
> 目前进度：0.7（也没想到有这么多内容）


> 我知道你想要什么：这里 <https://ghproxy.com/https://github.com/magical-rabbit/java-spring/archive/refs/heads/main.zip>

请到这里继续看：

Github:  https://github.com/magical-rabbit/java-spring/blob/main/docs/Rabbit.md

老博客：https://type.dayiyi.top/index.php/archives/206/

----

## 代码下载（包括最新的文档）

**都在这里：https://github.com/magical-rabbit/java-spring**

![](https://cmd.dayi.ink/uploads/upload_09ef0bbe68de67795544fd8eddbed6a0.png)



>打开缓慢：可以用Steam++来加速访问（选github）（https://steampp.net/ 下载：选蓝奏云 https://wwn.lanzouy.com/imM6D19nxt9a 密码1234 ）

不是很想用gitee，限制特别多，如果你们需要，请跟我说

代码：在这里👇，打开慢请用steam++试试。

https://github.com/magical-rabbit/java-spring

https://github.com/magical-rabbit/java-spring/tree/main/src/main/java/net/dabbit/skd21/exam

如何下载？

![image-20231006125304164](https://lspro.icee.top/i/2023/10/06/651f92bcbec1d.webp)



直链:https://github.com/magical-rabbit/java-spring/archive/refs/heads/main.zip

---



## 1. 配置mvn

创建仓库文件夹（不要带中文就好）

```xml
<!-- 你的不一定是 -->
<localRepository>F:/zhawa_/lib_repo/repository</localRepository>
```

mvn 文件夹



![](https://cmd.dayi.ink/uploads/upload_0ba11fa1d12ad7078ae19110f8137ffb.png)

`File` -> `Settings` -> `Build tools` -> `Maven`

![](https://cmd.dayi.ink/uploads/upload_713932a8a9f30335acdc421573d9d7e4.png)


## 2. new project


![](https://cmd.dayi.ink/uploads/upload_58d1232a6f944ae30e2412d6a3a14186.png)


## 3. 项目结构

pom.xml
![](https://cmd.dayi.ink/uploads/upload_99e6224a2829f7651ee71ac3c897ff94.png)


结构
![](https://cmd.dayi.ink/uploads/upload_7c1d0a56e0eced45f4b3c670cc5964a8.png)


resource失效:
![](https://cmd.dayi.ink/uploads/upload_4641ae662622d8d76215a574c8b9b448.png)

## 4. 依赖

微信文件pom.xml

复制

![](https://cmd.dayi.ink/uploads/upload_7997b8a4e4bae25a9ee15adc1a949ec3.png)

复制2
![](https://cmd.dayi.ink/uploads/upload_834a077803e2a63fa07cddf61cc8065a.png)


重新load
![](https://cmd.dayi.ink/uploads/upload_202bc5b8f401357c8caa41c1096006b9.png)

（如果失败了，试试把那个repository全删掉试试）

目前xml
```xml


    <!-- 引入springboot的父工程 -->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.6.2</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>


    <!--ovo?依赖-->
    <dependencies>
        <!-- springboot的web模块，接收请求和响应请求 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>


</project>
```

## 4. 启动


新建class

```javascript=    
package net.dabbit.skd21;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}

```

![](https://cmd.dayi.ink/uploads/upload_9a070b03134a5d990c285461bb0285cb.png)


看看启动时间和端口

![](https://cmd.dayi.ink/uploads/upload_028d9d00321b8b768901c70402ed6617.png)


新建包`com.exam.controller`

新建文件
![](https://cmd.dayi.ink/uploads/upload_e28c750543dc96bcb904e75d33795599.png)


```javascript=
package net.dabbit.skd21.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
    /*
    * localhost:8080/index
    * */
    @RequestMapping("/index")
    @ResponseBody // 返回值是一个具体的值（非路径）
    public String index(){
        return "你好";
    }
}

```

差不多这样

![](https://cmd.dayi.ink/uploads/upload_b54d797f6f544a1edb68580a4052b5e7.png)


重启
![](https://cmd.dayi.ink/uploads/upload_70c32d89bbb41eb39e8808939846aa9e.png)


重启后：
<http://localhost:8080/index>

![](https://cmd.dayi.ink/uploads/upload_6a3e27a22fa3a77bb1c0cb6d74c01560.png)



### BookController

book
```javascript=

package net.dabbit.skd21.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/book")
public class BookController {
    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "book";
    }
}

```

demo
```javascript=
package net.dabbit.skd21.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class DemoController {
    /*
    * localhost:8080/demo/index
    * */
    @RequestMapping("/index")
    @ResponseBody // 返回值是一 个具体的值（非路径）
    public String index(){
        return "你好";
    }

    /*
    * name
    * age
    * */
    @RequestMapping("/add")
    @ResponseBody // 返回值是一 个具体的值（非路径）
    public String add(String name,Integer age){
        return name + ","+age;
    }
}


```


![带参数](https://cmd.dayi.ink/uploads/upload_98ca9dd20351354abde83c75980557e0.png)

http://localhost:8080/demo/add?name=ck&age=112


![](https://cmd.dayi.ink/uploads/upload_d3b0e94b72e941a2ea170d56e0cac88f.png)


生成实体

![](https://cmd.dayi.ink/uploads/upload_d0e85fb549c5a259b265edcb8339dec5.png)

![](https://cmd.dayi.ink/uploads/upload_c7295b4c43cfd46af10107de5cd80cb0.png)

然后全选（ctrl键）

确定

最后的代码
`dir`

![](https://cmd.dayi.ink/uploads/upload_8ce220ae6758318d03047f48939c9521.png)


测试demo2

![](https://cmd.dayi.ink/uploads/upload_27de0bfe8ad250a269c333fcd87f18ae.png)

<http://localhost:8080/demo/add1?name=ck&age=112>


`demo.java`
```javascript=
package net.dabbit.skd21.exam.controller;

import net.dabbit.skd21.exam.entity.DemoEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class DemoController {
    /*
    * localhost:8080/demo/index
    * */
    @RequestMapping("/index")
    @ResponseBody // 返回值是一 个具体的值（非路径）
    public String index(){
        return "你好";
    }

    /*
    * name
    * age
    * */
    @RequestMapping("/add")
    @ResponseBody // 返回值是一 个具体的值（非路径）
    public String add(String name,Integer age){
        return name + ","+age;
    }

    /*
     * 实体类对象
     * 实体名
     * */
    @RequestMapping("/add1")
    @ResponseBody // 返回值是一 个具体的值（非路径）
    public String add1(DemoEntity demoEntity){
        return demoEntity.getName()+"--"+demoEntity.getAge();
    }
}
```

`DemoEntity.java`
```java=
package net.dabbit.skd21.exam.entity;

public class DemoEntity {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

```

---

以上为周一上午

文件下载



<https://pic.icee.top/blog/pic_bed/2023/09/emis_23_9_18_周一上午.7z>

---

​    


## 5. 静态文件

![](https://cmd.dayi.ink/uploads/upload_a3fba70c0523120385a84836cb2bb798.png)


![](https://cmd.dayi.ink/uploads/upload_c02b871d6add87b7dc6a2b5a44281a35.png)


`demo.html`

```htmlmixed=
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<!--
localhost:8080/pages/demo.html
-->

<script src="../js/jquery-3.4.1.js"></script>
<script src="../js/demo.js"></script>

<h1 id="h1">demo1111页</h1>
<input type="text" id="name">
<input type="password" id="pwd">

<input type="button" value="测试" onclick="test()">


</body>
</html>
```

`demo.js`
```javascript=
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
```


### 


复制文件之后

ctrl+r替换


---

以上为周一下午

文件下载



<https://pic.icee.top/blog/pic_bed/2023/09/emis23_9_18_周一下午.7z>

---



## 7. 代码

`index.js`
```javascript=
$(function () {
  //自动执行的逻辑
  $.ajax({
    type: "get",
    url: "./footer.html",
    success:function(data){//data是读取到的页面的html
      console.log(data)  
    }
  });
})
```



![](https://cmd.dayi.ink/uploads/upload_3e427533ad3ab699ccc61815137654bc.png)


### 头部

![](https://cmd.dayi.ink/uploads/upload_79917f832bfb4a0bc61bd286ebf708a3.png)

```javascript=
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
      // console.log(data)
      // data+="233"
      $("#header").html(data);

    }
  });

  $.ajax({
    type: "get",
    url: "./left-menu.html",
    success:function(data){//data是读取到的页面的html
      // console.log(data)
      // data+="233"
      $("#left-menu").html(data);

    }
  });


  $.ajax({
    type: "get",
    url: "./welcome.html",
    success:function(data){//data是读取到的页面的html
      // console.log(data)
      // data+="233"
      $("#content").html(data);

    }
  });

})
```

![](https://cmd.dayi.ink/uploads/upload_8c6972835946a5a6d15aa3c9a08e8c31.png)



`index.html`
```htmlmixed=
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>AdminLTE 3 | Dashboard</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="../plugins/fontawesome-free/css/all.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Tempusdominus Bootstrap 4 -->
  <link rel="stylesheet" href="../plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="../plugins/icheck-bootstrap/icheck-bootstrap.min.css">
  <!-- JQVMap -->
  <link rel="stylesheet" href="../plugins/jqvmap/jqvmap.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../dist/css/adminlte.min.css">
  <!-- overlayScrollbars -->
  <link rel="stylesheet" href="../plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
  <!-- Daterange picker -->
  <link rel="stylesheet" href="../plugins/daterangepicker/daterangepicker.css">
  <!-- summernote -->
  <link rel="stylesheet" href="../plugins/summernote/summernote-bs4.min.css">
</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">

  <!-- Navbar头部 -->
  <nav id="header" class="main-header navbar navbar-expand navbar-white navbar-light">

  </nav>
  <!-- /.navbar -->

  <!-- Main Sidebar Container左侧 -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="index3.html" class="brand-link">
      <img src="../dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
      <span class="brand-text font-weight-light">AdminLTE 3</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user panel (optional) -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="image">
          <img src="../dist/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
        </div>
        <div class="info">
          <a href="#" class="d-block">Alexander Pierce</a>
        </div>
      </div>

      <!-- SidebarSearch Form -->
      <div class="form-inline">
        <div class="input-group" data-widget="sidebar-search">
          <input class="form-control form-control-sidebar" type="search" placeholder="Search" aria-label="Search">
          <div class="input-group-append">
            <button class="btn btn-sidebar">
              <i class="fas fa-search fa-fw"></i>
            </button>
          </div>
        </div>
      </div>

      <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul id="left-menu" class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->






        </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>
  <!-- Main Sidebar Container -->

  <!-- Content Wrapper. Contains page content中间正文 -->

  <div id="content" class="content-wrapper"></div>

  <!-- /.content-wrapper -->

  <!-- mian-footer页脚  -->
  <footer id="footer" class="main-footer">

  </footer>
  <!-- mian-footer -->

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
  </aside>
  <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<!-- jQuery -->
<script src="../plugins/jquery/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="../plugins/jquery-ui/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button)
</script>
<!-- Bootstrap 4 -->
<script src="../plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- ChartJS -->
<script src="../plugins/chart.js/Chart.min.js"></script>
<!-- Sparkline -->
<script src="../plugins/sparklines/sparkline.js"></script>
<!-- JQVMap -->
<script src="../plugins/jqvmap/jquery.vmap.min.js"></script>
<script src="../plugins/jqvmap/maps/jquery.vmap.usa.js"></script>
<!-- jQuery Knob Chart -->
<script src="../plugins/jquery-knob/jquery.knob.min.js"></script>
<!-- daterangepicker -->
<script src="../plugins/moment/moment.min.js"></script>
<script src="../plugins/daterangepicker/daterangepicker.js"></script>
<!-- Tempusdominus Bootstrap 4 -->
<script src="../plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
<!-- Summernote -->
<script src="../plugins/summernote/summernote-bs4.min.js"></script>
<!-- overlayScrollbars -->
<script src="../plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
<!-- AdminLTE App -->
<script src="../dist/js/adminlte.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../dist/js/demo.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="../dist/js/pages/dashboard.js"></script>
<script src="../js/index.js"></script>

</body>
</html>
```


project-add.html

![](https://cmd.dayi.ink/uploads/upload_6fe8daa7d62038aa7b718e23828ff195.png)



----
以上为 周二上午

----

### 文件下载

https://pic.icee.top/blog/pic_bed/2023/09/static_small_23_9_19.zip
(仅包含修改文件)






## 周二下午

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>net.dabbit.skd21</groupId>
    <artifactId>emis</artifactId>
    <version>1.0-SNAPSHOT</version>

    <!-- 引入springboot的父工程 -->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.6.2</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <!--ovo?依赖-->
    <dependencies>
        <!-- springboot的web模块，接收请求和响应请求 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <!-- mybatis与springboot整合依赖 -->
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>2.2.1</version>
        </dependency>

        <!-- mysql驱动 -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>

        <!-- mybatis逆向工程依赖 -->
        <dependency>
            <groupId>org.mybatis.generator</groupId>
            <artifactId>mybatis-generator-core</artifactId>
            <version>1.4.0</version>
        </dependency>

        <!-- 数据库连接池 -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.1.23</version>
        </dependency>

        <!-- json 相关工具类 -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
            <version>1.2.73</version>
        </dependency>

        <!-- poi解析Excel文件的依赖 -->
        <dependency>
            <groupId>org.apache.poi</groupId>
            <artifactId>poi</artifactId>
            <version>3.14</version>
        </dependency>
        <dependency>
            <groupId>org.apache.poi</groupId>
            <artifactId>poi-ooxml</artifactId>
            <version>3.14</version>
        </dependency>
    </dependencies>


</project>
```


![](https://cmd.dayi.ink/uploads/upload_dc707a39fc11170ee16ef10e5df409c1.png)


`jdbc:mysql://192.168.83.132:3306/ovo?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=true`


- `ovo`是你的数据库名



### login.js

```javascript=
var login = function (){

    //獲取輸入的用戶名密碼
    var username = $("#username").val()
    var password = $("#password").val()

    console.log(`${username} , ${password}`)

    if(!username){
        alert("用戶名不能為空")
        return false
    }

    if(!password){
        alert("密碼不能為空")
        return false
    }

    //請求後端
    $.ajax({
        type: "post",
        url : "",
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
        }
    })
}
```

### login.html

```htmlmixed=
<input id="password" type="password" class="form-control" placeholder="密码">

 <input id="username" type="text" class="form-control" placeholder="用户名">

<button type="button" class="btn btn-primary btn-block" onclick="login()">登录</button>
```


### 文件下载

<https://pic.icee.top/blog/pic_bed/2023/09/emis_23_9_19周二晚上.zip>



## 周三上午


### User.java (entity)

```javascript=
package net.dabbit.skd21.exam.entity;

import java.util.Date;

public class User {
    private Integer id;
    private String username;
    private String password;
    private String realName;
    private String sex;
    private String sno;
    private Date admissionDate;
    private Integer facultyId;
    private Integer majorId;
    private Integer classId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Integer getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Integer facultyId) {
        this.facultyId = facultyId;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }
}
```




---
9_20——10点 文件下载

:-1: 

https://pic.icee.top/blog/pic_bed/2023/09/emis_23_9_20_周三上午10点.zip


---


## 23.9.20_上午

![](https://cmd.dayi.ink/uploads/upload_d32f36ac54162b065f17842d17b71944.png)



---
9_20——11点 文件下载

:-1: 

https://pic.icee.top/blog/pic_bed/2023/09/emis_23_9_20_周三上午11点.zip


---


---
9_20——12点 文件下载

:-1: 

https://pic.icee.top/blog/pic_bed/2023/09/emis_23_9_20_周三上午12点.zip


---



## 2023年9月20日_下午

### `user-list.js`

```javascript=
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
            }
        ]
    });
}
```


## 23.9.21

`user-add.js`
```javascript=
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

```

`UserMapper.xml`
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="net.dabbit.skd21.exam.mapper.UserMapper">

    <resultMap id="BaseResultMap" type="net.dabbit.skd21.exam.entity.User">
        <id column="id" property="id"></id>
        <result column="username" property="username"></result>
        <result column="password" property="password"></result>
        <result column="real_name" property="realName"></result>
        <result column="sex" property="sex"></result>
        <result column="sno" property="sno"></result>
        <result column="admission_date" property="admissionDate"></result>
        <result column="faculty_id" property="facultyId"></result>
        <result column="major_id" property="majorId"></result>
        <result column="class_id" property="classId"></result>
    </resultMap>


<!--    <resultMap id="" type=""-->

    <select id="login" parameterType="net.dabbit.skd21.exam.entity.User" resultMap="BaseResultMap">
        SELECT * FROM user WHERE username = #{username} AND password = #{password}
    </select>


<!--
#{offset}
调用了getter方法

#{属性名} 如果是字符串，自动补充一个单引号
${属性名} 原样输出

-->
    <select id="list" parameterType="net.dabbit.skd21.exam.entity.JsGridData" resultMap="BaseResultMap">
        SELECT * FROM user
        <if test="search != ''">
            where real_name like '%${search}%'
        </if>
        limit #{offset},#{pageSize}
    </select>


<!--    返回值能直接被result接受的用resulttype, 不行的用map做中转-->
    <select id="count" parameterType="net.dabbit.skd21.exam.entity.JsGridData" resultType="java.lang.Long">
        SELECT count(*) FROM user
        <if test="search != ''">
            where real_name like '%${search}%'
        </if>
    </select>



    <delete id="del" parameterType="java.lang.Integer">
        delete from user where
        id = #{id}
    </delete>

    <insert id="add" parameterType="net.dabbit.skd21.exam.entity.User">
        INSERT INTO user (
        <if test="username != null">`username`,</if>
        <if test="password != null">`password`,</if>
        <if test="realName != null">`real_name`,</if>
        <if test="sex != null">`sex`,</if>
        <if test="sno != null">`sno`,</if>
        `admission_date`,
        <if test="facultyId != null">`faculty_id`,</if>
        <if test="majorId != null">`major_id`,</if>
        <if test="classId != null">`class_id`</if>
        )
        VALUES (
        <if test="username != null">#{username},</if>
        <if test="password != null">#{password},</if>
        <if test="realName != null">#{realName},</if>
        <if test="sex != null">#{sex},</if>
        <if test="sno != null">#{sno},</if>
        NOW(),
        <if test="facultyId != null">#{facultyId},</if>
        <if test="majorId != null">#{majorId},</if>
        <if test="classId != null">#{classId}</if>
        )
    </insert>



</mapper>
```

## 9. Mybatis 逆向工程

> 这一步可以自动生成一些类，项目计划书上有的，跟着照做也可以，但是推荐你包名不一样，或者先把项目备份（复制粘贴）一下，防止替换。

### 9.1 创建账号

数据库创建账号：

直接写SQL吧（Navicat执行）

```sql
CREATE USER 'mybatis'@'%' IDENTIFIED BY '123456';
GRANT SELECT ON `ovo`.* TO 'mybatis'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;
```

这样就可以啦，新建了一个用户

- 用户名: mybatis
- 密码: 123456


### 9.2 添加依赖

```xml
<dependency>
   <groupId>org.mybatis.generator</groupId>
   <artifactId>mybatis-generator-core</artifactId>
   <version>1.4.0</version>
</dependency>
```

![](https://cmd.dayi.ink/uploads/upload_cd214ba76478850067c40b033e047eb7.png)

### 9.3 generatorConfig.xml

> 源文件从项目书上复制就好啦。

这里我把源文件，放在resources里了。

但感觉老师都是手写的sql，不知道这样会发生什么，先备个份。


![](https://cmd.dayi.ink/uploads/upload_d31e33d154f07799e7363294ca4ec41e.png)


这里原文的好像多了几个空格

![](https://cmd.dayi.ink/uploads/upload_a0e59c0c6707a6fafd1a8e7f48be4663.png)


### 9.4 新建类Generator.java

文件也是复制的那个项目书的文件（package 不用复制）

![](https://cmd.dayi.ink/uploads/upload_85ce597eb25575c06e9ccc4f71011e71.png)


这里，选择绝对路径，然后放到这里

![](https://cmd.dayi.ink/uploads/upload_cdda3498bf5a086b11fe5ac805e8b1a9.png)


### 9.5 运行类

> 说实在我也不知道会发生什么

然后他在这个包（文件夹里）生成了好多文件。


![](https://cmd.dayi.ink/uploads/upload_929d0c47347456478cb7244e05aaddda.png)


如果你的包名也是这样（`com.test.emis`）我不太建议你运行，有可能会**替换你的文件**，但如果你的包名不是这个，我觉得可以试试，感觉里面的文件可以参考。

![](https://cmd.dayi.ink/uploads/upload_be9b957d205af061196bc4a6b54be766.png)


到此，本步结束。


## 10. springboot项目中是使用myBatis

> 这里其实都已经做啦，为了跟文档对起来，稍微解释下。

### 10.1 三层架构

UI（用户交互）+BLL（业务逻辑，验证、计算、业务规则。）+DAL（数据访问层）

使用三层结构，写一大堆来实现一个sql语句），但可以进行代码维护。

MVC

前端—>controller —>service->dao

```bash
前端:html+css+js
controller : springboot controller
service：面向接口
dao: mybatis

```

### 10.2.1 pom.xml

pom.xml前文有啦,这里再复制一遍。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>net.dabbit.skd21</groupId>
    <artifactId>emis</artifactId>
    <version>1.0-SNAPSHOT</version>

    <!-- 引入springboot的父工程 -->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.6.2</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <!--ovo?依赖-->
    <dependencies>
        <!-- springboot的web模块，接收请求和响应请求 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <!-- mybatis与springboot整合依赖 -->
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>2.2.1</version>
        </dependency>

        <!-- mysql驱动 -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>

        <!-- mybatis逆向工程依赖 -->
        <dependency>
            <groupId>org.mybatis.generator</groupId>
            <artifactId>mybatis-generator-core</artifactId>
            <version>1.4.0</version>
        </dependency>

        <!-- 数据库连接池 -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.1.23</version>
        </dependency>

        <!-- json 相关工具类 -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
            <version>1.2.73</version>
        </dependency>

        <!-- poi解析Excel文件的依赖 -->
        <dependency>
            <groupId>org.apache.poi</groupId>
            <artifactId>poi</artifactId>
            <version>3.14</version>
        </dependency>
        <dependency>
            <groupId>org.apache.poi</groupId>
            <artifactId>poi-ooxml</artifactId>
            <version>3.14</version>
        </dependency>

        <dependency>
            <groupId>org.mybatis.generator</groupId>
            <artifactId>mybatis-generator-core</artifactId>
            <version>1.4.0</version>
        </dependency>

    </dependencies>

    <build>
        <!--
        springboot项目启动时，默认过滤掉src/main/java下的所有xml文件
        我们要使用mybatis，mybatis的xml文件在mapper包下，mapper在src/main/java下
        需要通过以下配置，指定pringboot项目启动时，不过滤src/main/java下的所有xml文件
        -->
        <resources>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.xml</include>
                </includes>
                <filtering>false</filtering>
            </resource>
        </resources>
    </build>
</project>
```

### 10.2.2 application.yml

同理同理，这里就是相关的信息。

```yaml=
spring:
  mvc:
    view:
      # 如果属性后面有值，类似prefix: /pages/，:后面需要有一个空格
      prefix: /pages/
      suffix: .html
  datasource:
    # mysql5.x，以下被注释的url和driver-class-name
    #url: jdbc:mysql://master:3306/reclamation?useUnicode=true&characterEncoding=UTF-8
    #driver-class-name: com.mysql.jdbc.Driver
    # mysql8，用以下的url和driver-class-name
    url: jdbc:mysql://192.168.83.132:3306/ovo?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=true
    driver-class-name: com.mysql.cj.jdbc.Driver
    # 这里的用户名密码，不要使用之前逆向工程的那个用户名和密码（之前的用户只能查询），去使用正常的用户
    username: root
    password: "123456"
    # 数据库连接池
    type: com.alibaba.druid.pool.DruidDataSource
```

都说的很明白啦。而且还用了数据库pool

#### Dao

接口上加上注解`@Mapper`

![](https://cmd.dayi.ink/uploads/upload_1c832a1a9f93be9e39206837ee7b4cfe.png)


service

![](https://cmd.dayi.ink/uploads/upload_c10b4bc5ad3bdd049681ac34da66bb44.png)


Mapper.xml

![](https://cmd.dayi.ink/uploads/upload_fb7ab0664f4269124cc3aafc53ecf2e6.png)

#### service实现类

![](https://cmd.dayi.ink/uploads/upload_898569f120429eda286426022c196867.png)


#### controller

![](https://cmd.dayi.ink/uploads/upload_83de22c7a3f9611b08ac0bb056babee2.png)


## 11 功能实现

## 11.1 菜单


我觉得写一个新的类和controller吧。


![](https://cmd.dayi.ink/uploads/upload_886526d9474764388eb13f47655a51d0.png)

### 11.1.1 后端实现

`Menu.java`类
![](https://cmd.dayi.ink/uploads/upload_172a7a5be2b97a6e9bbbdf7676366273.png)

1. java类

```javascript=
package net.dabbit.skd21.exam.entity;

public class Menu {
    private Integer id;

    private String menuCode;

    private String menuName;

    private String menuUrl;

    private String menuLevel;

    private Integer parentId;

    private Integer sort;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(String menuLevel) {
        this.menuLevel = menuLevel;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}


```

2. 服务类

`MenuService.java`
```java
package net.dabbit.skd21.exam.service;

import net.dabbit.skd21.exam.entity.JsGridData;
import org.springframework.stereotype.Service;

@Service
public interface MenuService {
    String list(JsGridData jsGridData);
}
```

3. 服务实现

`MenuServiceImpl`
```javascript=
package net.dabbit.skd21.exam.service.impl;

import com.alibaba.fastjson.JSONObject;
import net.dabbit.skd21.exam.entity.JsGridData;
import net.dabbit.skd21.exam.entity.Menu;
import net.dabbit.skd21.exam.mapper.MenuMapper;  
import net.dabbit.skd21.exam.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService{
    @Autowired
    MenuMapper menuMapper;

    @Override
    public String list(JsGridData jsGridData) {
        List<Menu> ls = menuMapper.list(jsGridData);
        Long cnt = menuMapper.count(jsGridData);
        jsGridData.setItemsCount(cnt);
        jsGridData.setData(ls);
        return JSONObject.toJSONString(jsGridData);
    }
}
```

4. SQL查询实现

`MenuMapper.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="net.dabbit.skd21.exam.mapper.MenuMapper">
    <resultMap id="BaseResultMap" type="net.dabbit.skd21.exam.entity.Menu">
        <id column="id" jdbcType="INTEGER" property="id" />
        <result column="menu_code" jdbcType="VARCHAR" property="menuCode" />
        <result column="menu_name" jdbcType="VARCHAR" property="menuName" />
        <result column="menu_url" jdbcType="VARCHAR" property="menuUrl" />
        <result column="menu_level" jdbcType="VARCHAR" property="menuLevel" />
        <result column="parent_id" jdbcType="INTEGER" property="parentId" />
        <result column="sort" jdbcType="INTEGER" property="sort" />
    </resultMap>
    <select id="list" parameterType="net.dabbit.skd21.exam.entity.JsGridData" resultMap="BaseResultMap">
        select * from menu
    </select>

    <select id="count" parameterType="net.dabbit.skd21.exam.entity.JsGridData" resultType="java.lang.Long">
        select count(*) from menu
    </select>

</mapper>
```

![](https://cmd.dayi.ink/uploads/upload_8c2c4abd7a71ccf022daedca2f21edb5.png)


5. 传参可能会发生空指针错误

然后这里小修一下:

![](https://cmd.dayi.ink/uploads/upload_a3b2d8663b27efb3c30a65834485d8a1.png)

防止空指针报错。


6. 测试请求（后端）

测试下请求：（工具APIFOX、POSTMAN）

![](https://cmd.dayi.ink/uploads/upload_f323403e12da60caecdaea17a30b5cb5.png)


这样前端就可以拿菜单了。


### 11.1.2 前端实现




1. 这个文件里添加一行这个，等会动态显示目录。

`left-menu.html`

```html
<div id="show-menu">

</div>
```

![](https://cmd.dayi.ink/uploads/upload_e9cadce4f09256e217a5836b077eef88.png)

这样写一个div

![](https://cmd.dayi.ink/uploads/upload_b1e658a9b6f34121e397ca65de2313d8.png)





2. JS代码（能用，但是有BUG）


    js(能用，但是不完全能用，目录树解析还有问题，没解析完美)
    
    ```javascript=
    function generateMenu(menuData) {
        var menuContainer = document.getElementById("show-menu");
        var ul = document.createElement("ul");
        ul.classList.add("nav", "nav-sidebar");
    
        // Sort the menu items based on the 'sort' property
        menuData.data.sort(function (a, b) {
            return a.sort - b.sort;
        });
    
        menuData.data.forEach(function (menuItem) {
            var li = document.createElement("li");
            li.classList.add("nav-item");
    
            var a = document.createElement("a");
            a.href = menuItem.menuUrl;
            a.classList.add("nav-link");
    
            var i = document.createElement("i");
            i.classList.add("nav-icon", "fas", "fa-circle");
    
            var p = document.createElement("p");
            p.textContent = menuItem.menuName;
    
            a.appendChild(i);
            a.appendChild(p);
            li.appendChild(a);
    
            // Check if there are submenus (menuLevel 2 or 3)
            var submenus = menuData.data.filter(function (submenu) {
                return submenu.parentId === menuItem.id;
            });
    
            if (submenus.length > 0) {
                var submenuUl = document.createElement("ul");
                submenuUl.classList.add("nav", "nav-treeview");
    
                submenus.forEach(function (submenuItem) {
                    var submenuLi = document.createElement("li");
                    submenuLi.classList.add("nav-item");
    
                    var submenuA = document.createElement("a");
                    submenuA.href = submenuItem.menuUrl;
                    submenuA.classList.add("nav-link");
    
                    var submenuI = document.createElement("i");
                    submenuI.classList.add("far", "fa-circle", "nav-icon");
    
                    var submenuP = document.createElement("p");
                    submenuP.textContent = submenuItem.menuName;
    
                    submenuA.appendChild(submenuI);
                    submenuA.appendChild(submenuP);
                    submenuLi.appendChild(submenuA);
                    submenuUl.appendChild(submenuLi);
                });
    
                li.appendChild(submenuUl);
            }
    
            ul.appendChild(li);
        });
    
        menuContainer.appendChild(ul);
    }


    function getMenuDataAndGenerateMenu() {
        $.ajax({
            type: "GET",
            url: "/menu/list",
            dataType: "json",
            success: function (data) {
                if (data && data.data) {
                    generateMenu(data); // Call the generateMenu function with the received data
                } else {
                    console.log("[dayi-error]获得菜单数据失败");
                }
            },
            error: function () {
                console.log("[dayi-error]An error occurred while retrieving menu data.");
            },
        });
    }
    
    $(document).ready(function () {
        getMenuDataAndGenerateMenu(); // Fetch and generate menu data on page load
    });


    ```


3. 前端真要命

差不多这个效果。


![](https://cmd.dayi.ink/uploads/upload_1a223cf5187e2c9a98223a8a5ed0595c.png)



## 11.1.1 新增菜单-功能实现

>下拉选项从数据库查询，写个新增菜单功能。

1. 先来个列表

### 11.1.1.1 `menu-list.html`

代码直接从user-list.html

去拿。

```htmlmixed=
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>AdminLTE 3 | jsGrid</title>

    <!-- Google Font: Source Sans Pro -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="../plugins/fontawesome-free/css/all.min.css">
    <!-- jsGrid -->
    <link rel="stylesheet" href="../plugins/jsgrid/jsgrid.min.css">
    <link rel="stylesheet" href="../plugins/jsgrid/jsgrid-theme.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="../dist/css/adminlte.min.css">
</head>
<body class="hold-transition sidebar-mini">

<!-- Content Wrapper. Contains page content -->

<!-- Content Header (Page header) -->
<section class="content-header">
    <div class="container-fluid">
        <div class="row mb-2">
            <div class="col-sm-6">
                <h1>jsGrid</h1>
            </div>
            <div class="col-sm-6">
                <ol class="breadcrumb float-sm-right">
                    <li class="breadcrumb-item"><a href="#">Home</a></li>
                    <li class="breadcrumb-item active">jsGrid</li>
                </ol>
            </div>
        </div>
    </div><!-- /.container-fluid -->
</section>

<!-- Main content -->
<section class="content">
    <div class="card">
        <div class="card-header">
            <!-- 查询框 -->
            <div class="input-group">
                <input type="search" id="search" class="form-control form-control-lg" placeholder="请输入姓名关键字">
                <div class="input-group-append">
                    <button type="button" class="btn btn-lg btn-default" onclick="load_page()">
                        <i class="fa fa-search"></i>
                    </button>
                </div>
            </div>
        </div>
        <!-- /.card-header -->
        <div class="card-body">
            <div id="jsGrid1"></div>
        </div>
        <!-- /.card-body -->
    </div>
    <!-- /.card -->
</section>
<!-- /.content -->
<!-- jQuery -->
<script src="../plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="../plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- jsGrid -->
<script src="../plugins/jsgrid/demos/db.js"></script>
<script src="../plugins/jsgrid/jsgrid.min.js"></script>
<!-- AdminLTE App -->
<script src="../dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../dist/js/demo.js"></script>


<!--菜单列表管理:-->
<script src="../js/menu-list.js"></script>

<script>

</script>
</body>
</html>
```


你需要修改的差不多就是这个图的 9和 12 行，剩下的找JS去实现。（不是图中这么简单）


![](https://cmd.dayi.ink/uploads/upload_5b9bd95babc799d81b8a9f1aec2dd2b7.png)


2. 写个JS

### 11.1.1.2 menu-add.js

这里直接复制文档的就可以。


```javascript=
$(function () {
    $("#jsGrid1").jsGrid({
//        height: "100%",
        width: "100%",
        height: "auto",
//        width: "auto",
        sorting: true, // 排序
        paging: true, // 分页计算，底部上一页下一页展示
        pageLoading: true, //启动后台加载分页数据
        autoload: true, //自动加载
        controller:{
            loadData: function(filter){
//            alert(filter.pageIndex);
                return $.ajax({
                    type: "post",
                    url: "/menu/list",
                    dataType: "json",
                    data: filter
                });
            }
        },
        pageIndex: 1, // 当前页数，是第几页
        pageSize: 3, // 每页数据条数
        pageButtonCount: 10, // 展示可选页码数量
        pagePrevText: "上一页",
        pageNextText: "下一页",
        pageFirstText: "首页",
        pageLastText: "尾页",
        fields: [
            {
                title: "", name: "id", type: "text", width: 20, align: "center",
                itemTemplate: function(value, item){
                    return "<input type='checkbox' value='" + value + "'>";
                }
            },
            { title: "菜单名", name: "menuName", type: "text", width: 100 },
            { title: "菜单编码", name: "menuCode", type: "text", width: 80 },
            { title: "菜单url", name: "menuUrl", type: "text", width: 80 },
            { title: "上级菜单", name: "parentMenu", type: "text", width: 80 },
            {
                title: "操作", name: "id", type: "text", width: 60, align: "center",
                itemTemplate: function(value, item){
                    return "<a href='javascript:void(0)' onclick='alert("+value+");'>修改</a>"
                        + "&nbsp;&nbsp;&nbsp;&nbsp;<a href='javascript:void(0)' onclick='alert("+value+");'>删除</a>";
                }
            }
        ]
    });
});
```





### 11.1.1.3 `MenuController.java`

![](https://cmd.dayi.ink/uploads/upload_72a08913cad1515c1638ea837335e4c1.png)


之前写的就可以，返回的请求信息是符合文档的。

![](https://cmd.dayi.ink/uploads/upload_5e31c62a1649f401b18c11218e1ec0aa.png)






## 11.1.2 菜单列表

在mapper里添加

`limit #{offset},#{pageSize}`

![](https://cmd.dayi.ink/uploads/upload_23af29ee3ea6d524094f1790c6cce2a3.png)


这样限制条数。


### 11.1.2.1. **为了防止出现空指针问题，如果PageSize==null的话，就返回一个5**

修改在: `JsGridData.java`

![](https://cmd.dayi.ink/uploads/upload_47a2196bc22c8b148977be9c2c319aed.png)

这样GET请求就没问题了
![](https://cmd.dayi.ink/uploads/upload_9d03d2ac639e44232fa97670e9969d76.png)



### 11.1.2.2. 前端默认会传递一个参数PageSize=3，请求方式为POST

用POSTMAN 模拟下请求（APIFOX，虽然有协作功能，但是好卡）

![](https://cmd.dayi.ink/uploads/upload_b8512a99443bff1289b466ff0f586c0a.png)


### 11.1.2.3. 菜单列表这样就可以啦

访问地址: `http://localhost:8080/pages/menu-list.html`

![](https://cmd.dayi.ink/uploads/upload_4c9965e920eabf3a684c4b5427133f1b.png)


## 11.1.1 新增菜单


1. 写一个新增菜单，直接从project-add.html复制就好

    `menu-add.html`

    ```htmlmixed=
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>AdminLTE 3 | Project Add</title>
    
        <!-- Google Font: Source Sans Pro -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="../plugins/fontawesome-free/css/all.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="../dist/css/adminlte.min.css">
    </head>
    <body class="hold-transition sidebar-mini">
    <!-- Site wrapper -->
    
    <!-- Navbar -->
    
    <!-- /.navbar -->
    
    <!-- Main Sidebar Container -->
    
    <!-- Content Wrapper. Contains page content -->
    
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1>Project Add</h1>
                </div>
                <div class="col-sm-6">
                    <ol class="breadcrumb float-sm-right">
                        <li class="breadcrumb-item"><a href="#">Home</a></li>
                        <li class="breadcrumb-item active">Project Add</li>
                    </ol>
                </div>
            </div>
        </div><!-- /.container-fluid -->
    </section>
    
    <!-- Main content -->
    <section class="content">
        <div class="row">
            <div class="col-md-8 offset-md-2">
                <div class="card card-primary">
                    <div class="card-header">
                        <h3 class="card-title">General</h3>
    
                        <div class="card-tools">
                            <button type="button" class="btn btn-tool" data-card-widget="collapse" title="Collapse">
                                <i class="fas fa-minus"></i>
                            </button>
                        </div>
                    </div>
                    <div class="card-body">
    <!--菜单名-->
                        <div class="form-group">
                            <label for="menuName">菜单名</label>
                            <input type="text" id="menuName" class="form-control">
                        </div>
    <!--菜单代码-->
                        <div class="form-group">
                            <label for="menuCode">菜单代码</label>
                            <input id="menuCode" class="form-control">
                        </div>
    <!--菜单等级-->
                        <div class="form-group">
                            <label for="menuLevel">菜单Level</label>
                            <input type="text" id="menuLevel" class="form-control">
                        </div>
    
    <!--菜单URL-->
                        <div class="form-group">
                            <label for="menuUrl">菜单URL</label>
                            <input type="text" id="menuUrl" class="form-control">
                        </div>
    <!--父节点ID-->
                        <!--      学号    -->
                        <div class="form-group">
                            <label for="parentId">上级菜单（父节点ID）</label>
                            <input type="text" id="parentId" class="form-control">
                        </div>
    <!--排序-->
                        <div class="form-group">
                            <label for="sort">排序</label>
                            <input type="text" id="sort" class="form-control">
                        </div>


                    </div>
                    <!-- /.card-body -->
                </div>
                <!-- /.card -->
            </div>
    
        </div>
    
        <div class="row">
            <div class="col-md-8 offset-md-2">
                <a href="#" class="btn btn-secondary">Cancel</a>
                <input type="button" value="大白兔" class="btn btn-success float-right" onclick="mysubmit()">
            </div>
        </div>
    </section>


    <!-- jQuery -->
    <script src="../plugins/jquery/jquery.min.js"></script>
    <!-- Bootstrap 4 -->
    <script src="../plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- AdminLTE App -->
    <script src="../dist/js/adminlte.min.js"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="../dist/js/demo.js"></script>


    <!--dayi_js-->
    <!--js-->
    <script src="../js/menu-add.js"></script>
    <!--js-->
    
    </body>
    </html>


    ```
    
    对着菜单信息进行改一下：
    
    ![](https://cmd.dayi.ink/uploads/upload_6d480b03928fac7303bfa8c3370b9d60.png)
    
    效果差不多这个样子：
    
    ![](https://cmd.dayi.ink/uploads/upload_014845f3023cbf338b33dc4044718b37.png)



2. 然后写menu-add.js

    ```javascript=
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
    ```

3. 写后端 controller

    ```java
    @RequestMapping(value = "/add",produces = "application/json; charset=utf-8")
        @ResponseBody
        public String add(JsGridData jsGridData){
            String res = menuService.add(jsGridData);
            return res;
        }
    ```

4. service

    ```java
    String add(JsGridData jsGridData);


    @Override
        public String add(JsGridData jsGridData) {
            int add_ = menuMapper.add(jsGridData);
            Map<String,String> msg = new HashMap<>();
            msg.put("msg","999");
    
            if(add_>0){
                msg.put("code","200");
            }
    
            return JSONObject.toJSONString(msg);
    
    }
    ```

5. 写个mapper

    ```java=
    public interface MenuMapper {
        List<Menu> list(JsGridData jsGridData);
        Long count(JsGridData jsGridData);
        Integer add(JsGridData jsGridData);
    }
    ```
    
6. mapper xml

	这样写，方便加表，也能防止一些错误。相关代码都在github上（文章末尾），请直接看最新的就好。

	```xml
	   <insert id="add" parameterMap="net.dabbit.skd21.exam.entity.Menu" resultType="java.lang.Integer">
        insert into menu
        <trim prefix="(" suffix=")" suffixOverrides=",">
            <if test="id != null">
                id,
            </if>
            <if test="menuCode != null">
                menu_code,
            </if>
            <if test="menuName != null">
                menu_name,
            </if>
            <if test="menuUrl != null">
                menu_url,
            </if>
            <if test="menuLevel != null">
                menu_level,
            </if>
            <if test="parentId != null">
                parent_id,
            </if>
            <if test="sort != null">
                sort,
            </if>
        </trim>
        <trim prefix="values (" suffix=")" suffixOverrides=",">
            <if test="id != null">
                #{id,jdbcType=INTEGER},
            </if>
            <if test="menuCode != null">
                #{menuCode,jdbcType=VARCHAR},
            </if>
            <if test="menuName != null">
                #{menuName,jdbcType=VARCHAR},
            </if>
            <if test="menuUrl != null">
                #{menuUrl,jdbcType=VARCHAR},
            </if>
            <if test="menuLevel != null">
                #{menuLevel,jdbcType=VARCHAR},
            </if>
            <if test="parentId != null">
                #{parentId,jdbcType=INTEGER},
            </if>
            <if test="sort != null">
                #{sort,jdbcType=INTEGER},
            </if>
        </trim>
    </insert>
	```




    ![](https://cmd.dayi.ink/uploads/upload_1cff4c83b1b1dfa01757c30834a54785.png)


7. 测试添加是否成功

![](https://cmd.dayi.ink/uploads/upload_7050672dc295d6249d80a93b3e01f733.png)


8. 看看数据库

成功插入


![](https://cmd.dayi.ink/uploads/upload_81f857a7e6a6bd48194ad49e58a29734.png)



push代码到Github,记得下载下来自己改一下数据库连接属性（还有资源文件夹mark一下）








### 11.1.3 菜单删除

1. 先写后端

2. Controller

![](https://cmd.dayi.ink/uploads/upload_e798ba8ebc95247edd0372f8ac1f7aef.png)

3. mapper service

![](https://cmd.dayi.ink/uploads/upload_e815e6708c774e0b992b3791cc60bc03.png)


service 

![](https://cmd.dayi.ink/uploads/upload_f54d3ca3b159321ae4550584cbef8fc0.png)





4. 实现类

![](https://cmd.dayi.ink/uploads/upload_ce5b989a4ef645b1e5a0dbc1b99b6e71.png)


5. Mapper XML

![](https://cmd.dayi.ink/uploads/upload_75c31156e189f84dc1ec00f18db82094.png)


6. POST请求测试


![](https://cmd.dayi.ink/uploads/upload_cc8c0218a960979b5428feed9a6bdc1f.png)


成功啦，这样再写前端JS就行了 


7. JS

上面的修改部分：
![](https://cmd.dayi.ink/uploads/upload_25b0602e0281aa357e33c02edb4fc2a9.png)


```javascript=
res_str = `<a href='javascript:void(0)' onclick='modify_menu_func(${value});'>修改</a>`
                        + "&nbsp;&nbsp;&nbsp;&nbsp;"+`<a href='javascript:void(0)' onclick="del_menu_fuc(${value});">删除</a>`;
                    return res_str
```

下面的函数如图：

![](https://cmd.dayi.ink/uploads/upload_3d4ae48b6bed4e6d555d4d5f66326c1b.png)


```javascript=
var del_menu_fuc = function (del_id) {
    $.ajax({
        type:"post",
        url:"/menu/del",
        data:{"id":del_id},
        dataType: "json",
        success:function (data){
            if(data.code!="200"){
                alert("删除失败")
                console.log(`[sys]Del ${del_id} failed.`)
            }
            if(data.code=="200"){
                alert("删除成功")
                console.log(`[sys]Del ${del_id} succeed.`)
            }
        }
    })
}
```

8. 测试：

![](https://cmd.dayi.ink/uploads/upload_0fb03008303e79797011ab5d1c35a61e.png)

呃呃？

再试试

**CTRL+F5强制加载JS**

![](https://cmd.dayi.ink/uploads/upload_f143667da71d019d3914c839ee9ff053.png)


这样就可以了。




## 11.1.4 菜单修改


1. controller

![](https://cmd.dayi.ink/uploads/upload_b3f91c195bbecf33c095f0488038b940.png)

2. service

![](https://cmd.dayi.ink/uploads/upload_cb9d253e72d1743e08145351a66004a8.png)

3. service impl

![](https://cmd.dayi.ink/uploads/upload_4b7ccdd32a8aa0e371bac48d3aeffc31.png)


4. mapper


![](https://cmd.dayi.ink/uploads/upload_8f3675431a799d2d764c4a8a54882845.png)


5. mapper xml

![](https://cmd.dayi.ink/uploads/upload_76c628b596906ee37969585946e95fc4.png)

```xml
<update id="updateByPrimaryKeySelective" parameterType="net.dabbit.skd21.exam.entity.Menu">
        update menu
        <set>
            <if test="menuCode != null">
                menu_code = #{menuCode,jdbcType=VARCHAR},
            </if>
            <if test="menuName != null">
                menu_name = #{menuName,jdbcType=VARCHAR},
            </if>
            <if test="menuUrl != null">
                menu_url = #{menuUrl,jdbcType=VARCHAR},
            </if>
            <if test="menuLevel != null">
                menu_level = #{menuLevel,jdbcType=VARCHAR},
            </if>
            <if test="parentId != null">
                parent_id = #{parentId,jdbcType=INTEGER},
            </if>
            <if test="sort != null">
                sort = #{sort,jdbcType=INTEGER},
            </if>
        </set>
        where id = #{id,jdbcType=INTEGER}
    </update>
```




相关代码复制在github中（文章末尾）。


6. 测试一下

![](https://cmd.dayi.ink/uploads/upload_333b36ed070625c7341a47878b6a0b67.png)

![](https://cmd.dayi.ink/uploads/upload_a8e2ed4174850ce8e8dd8c2f80d293d4.png)
修改成功


7. 前端：

改的内容不少，新增页面要判断是否为新增模式。也要判断是否为修改模式。

这样就JS实现一下，把按钮换掉就好。

menu-list.js

![](https://cmd.dayi.ink/uploads/upload_971fdb17fd6607857ec24713dce08c68.png)

![](https://cmd.dayi.ink/uploads/upload_d4d6a9645589e1fa0b8dc1a5030cf3b9.png)


menu-add.js

![](https://cmd.dayi.ink/uploads/upload_7c6e3f99d37dfd41cffb11f5801ed643.png)

![](https://cmd.dayi.ink/uploads/upload_9bf3ce1b6c64a92144ee70d0a8cdd203.png)

![](https://cmd.dayi.ink/uploads/upload_713f648ee04cd6d9ef70e5f005cb8b7a.png)



完整:

```javascript=
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
```



menu-add.html

![](https://cmd.dayi.ink/uploads/upload_a8cefc49ca3b971a9b2715d20496a887.png)

![](https://cmd.dayi.ink/uploads/upload_83b94f6a0044f19abc0c7b0d17cc8d1d.png)


有点丑，改成这样：


![](https://cmd.dayi.ink/uploads/upload_3ad5dd9e241ea6b2ae2cdd54f5939961.png)



8. 动态加载菜单修复代码之前临时写一下：

![](https://cmd.dayi.ink/uploads/upload_66dbe4968c828918f9f4653ef7c31966.png)

不然加载不上。

9. 查看效果

![](https://cmd.dayi.ink/uploads/upload_30ba3734922aadfbf3f80ceffbc77283.png)

![](https://cmd.dayi.ink/uploads/upload_520916d8f97a7e8c9b1d94dcf0f6ed4a.png)


![](https://cmd.dayi.ink/uploads/upload_aa40d13c7101fef567bf6a1b7e00e974.png)




菜单倒是没问题了，但是后端炸了，估计传参的时候掉了，两个都是正常的功能。

10. 改bug


好像载荷不对劲


JS在这里改一下


![](https://cmd.dayi.ink/uploads/upload_a05a0db8dd9e585fe421744631352b54.png)


OK ，修好了。


最新代码见文件末尾


## 11.1.5 左边的菜单

从数据库中更新：


这个实现起来JS写吐了

差不多这个样子

JS还要改，先这样放上，临时够用了。

![](https://cmd.dayi.ink/uploads/upload_caec150ca468e54b50b8d29b9129b063.png)

文件见：

`left-list.js`

![](https://cmd.dayi.ink/uploads/upload_9c2dbab6ad8cbc334e059353d169af81.png)


```javascript=
//不完善版本0.5
function createNavItemWithLink(text, iconClass, link, onClick) {
    // 创建 <li> 元素
    var listItem = document.createElement("li");
    listItem.classList.add("nav-item");

    // 创建 <a> 元素
    var linkElement = document.createElement("a");
    linkElement.setAttribute("href", link);
    linkElement.classList.add("nav-link");
    linkElement.addEventListener("click", onClick);

    // 创建 <i> 元素
    var icon = document.createElement("i");
    icon.classList.add(iconClass);
    icon.classList.add("nav-icon");

    // 创建 <p> 元素
    var linkText = document.createElement("p");
    linkText.innerText = text;

    // 把 <i> 元素添加到 <a> 元素中
    linkElement.appendChild(icon);

    // 把 <p> 元素添加到 <a> 元素中
    linkElement.appendChild(linkText);

    // 把 <a> 元素添加到 <li> 元素中
    listItem.appendChild(linkElement);

    // 返回生成的 <li> 元素
    return listItem;
}

/*
使用方法：

var listItem1 = createNavItemWithLink("新增頁", "far fa-circle", "javascript:void(0)", function() {
  load_content('project-add.html');
});

var listItem2 = createNavItemWithLink("列表", "far fa-circle", "javascript:void(0)", function() {
  load_content('project-list.html');
});

*/


function createMenuItems(menuData, parentMenuId, menuContainer) {
    // Filter out the submenu items for the specified parent menu
    var subMenuItems = menuData.filter(function (menu) {
        return menu.parentId === parentMenuId;
    });

    // Iterate over the submenu items
    for (var i = 0; i < subMenuItems.length; i++) {
        var menu = subMenuItems[i];
        
        //一级菜单
        var listItem = document.createElement("li");
        listItem.classList.add("nav-item");

        var arror = document.createElement("a");
        //<i class="right fas fa-angle-left"></i>
        arror.classList.add("right");
        arror.classList.add("fas");
        arror.classList.add("fa-angle-left");
        
        // listItem.appendChild(arror);

        //链接
        var linkElement = document.createElement("a");
        linkElement.setAttribute("href", "#");
        linkElement.classList.add("nav-link");


        //如果链接不为空，则进行访问
        if(menu.menuUrl){
            linkElement.setAttribute("onclick", `load_content("${menu.menuUrl}")`);
        }
        
        linkElement.textContent = menu.menuName;

        listItem.appendChild(linkElement);

        //添加
        menuContainer.appendChild(listItem);

        //递归菜单
        var subMenuContainer = document.createElement("ul");

        //class
        // subMenuContainer.classList.add("nav");
        // subMenuContainer.classList.add("nav-treeview");
        
        //添加
        listItem.appendChild(subMenuContainer);
        createMenuItems(menuData, menu.id, subMenuContainer);
    }
}

function generateMenu(menuData) {
    //处理一下data
    menuData = { "data": menuData.data };
    var menuContainer = document.getElementById("show-menu");
    createMenuItems(menuData.data, 0, menuContainer);
}


function getMenuDataAndGenerateMenu() {
    $.ajax({
        type: "GET",
        url: "/menu/list",
        data: { "pageSize": 114514 },
        dataType: "json",
        success: function (data) {
            if (data && data.data) {
                generateMenu(data); // Call the generateMenu function with the received data
            } else {
                console.log("[dayi-error]获得菜单数据失败");
            }
        },
        error: function () {
            console.log("[dayi-error]An error occurred while retrieving menu data.");
        },
    });
}

$(document).ready(function () {
    getMenuDataAndGenerateMenu(); // Fetch and generate menu data on page load
});


```

目前版本:

https://github.com/magical-rabbit/java-spring/commit/2117709371bab8669b08f1acc491a39c52361e92




## 11.2 角色管理

OK 下一部分

## 11.2.1 新增角色


1. 先复制他要求的css和js，从那个ztree文件里解压

> zTree_v3-master\js下的文件都放到webapp/js/ztree下
> zTree_v3-master\css下的文件都放到webapp/css下

![](https://cmd.dayi.ink/uploads/upload_9934e4a9df737af86b8591d4d7e0631a.png)


2. 新建role-add.html

内容先直接复制`ztree示例.html`

复制这俩到head标签里，然后原先的就没有用了，直接删掉就好

```htmlmixed=
<link rel="stylesheet" href="../css/zTreeStyle/zTreeStyle.css" type="text/css">
<script src="../js/ztree/jquery.ztree.all.min.js"></script>
```

![](https://cmd.dayi.ink/uploads/upload_347cc914412acc75270010c39d516d84.png)


3. 我也不知道下来列表是什么

就直接这样复制上了。

```htmlmixed=
<div class="form-group">
  <label for="menuTree">菜单列表</label>
  <ul id="menuTree" class="ztree"></ul>
  <input type="hidden" id="menuIds" class="form-control">
</div>
```

![](https://cmd.dayi.ink/uploads/upload_1e14c7659f98863165ef767180693a15.png)

4. 我打开这个页面的时候会报错

![](https://cmd.dayi.ink/uploads/upload_504b429ed4175831a6efe398075e927c.png)


5. 先把JS复制上

```javascript=
这个参照文档 59-60 页
```
![](https://cmd.dayi.ink/uploads/upload_53b6a24b6664bbac57fe984e6d34910e.png)


6. 改了改代码跑起来了，但是不知道怎么用

![](https://cmd.dayi.ink/uploads/upload_6ba39133eb5e422dce955291afdb5fbe.png)


相关代码，见github

---
**目前没做出来， 我有点理解不了他的内容**

----

这里更新一下，ROLE一样的实现：

![](https://cmd.dayi.ink/uploads/upload_178aec14f88f5b964ed75d7b0a7329d6.png)




![](https://cmd.dayi.ink/uploads/upload_c171a4fcf266fe9074a6d27ff56965c0.png)



![](https://cmd.dayi.ink/uploads/upload_72af09bdba904a0ddc890b0790e395d4.png)



然后是前端

![](https://cmd.dayi.ink/uploads/upload_73b879d76494391289ea13c959830076.png)

![](https://cmd.dayi.ink/uploads/upload_904593e31a5378d1a5dceb317feecc47.png)

看样子没问题啦


![](https://cmd.dayi.ink/uploads/upload_6b497b1685baff05baeb1cbe72e88f54.png)



角色树

![](https://cmd.dayi.ink/uploads/upload_d2edd064ebac45d1088a1d0fda0abfe6.png)





-----
## 11.3 用户管理

## 11.3.1 新增用户

咱们之前就写完了，但是之前的文件名叫`project-add.html`

这里咱们直接复制一个文件

![](https://cmd.dayi.ink/uploads/upload_49c0ed85bb2db45d9ec85760f724ef8f.png)

![](https://cmd.dayi.ink/uploads/upload_ef896be30468a0e0edc3bd1f53c439a7.png)


## 11.3.2 用户列表

也写完啦

但是左边的菜单不会自动出现，所以写sql语句(添加到数据库)

左边的用户管理，应该对应的是user-list.html，他也写错了。

(见项目文件tools/sql_fix.sql)
```sql
INSERT INTO `menu` (`menu_code`, `menu_name`, `menu_url`, `menu_level`, `parent_id`, `sort`) VALUES ('user-add', '新增用户', 'user-add.html', '2', 28, 2);

UPDATE `menu` SET `menu_url` = 'user-list.html' WHERE `id` = 36

```
![](https://cmd.dayi.ink/uploads/upload_e47dc17781936af58762609cde333d75.png)


## 11.3.3 修改用户

逻辑实现了

![](https://cmd.dayi.ink/uploads/upload_438f5a514b1359247f9c259429fc43f8.png)

可以完善一下，但是也可以用

## 11.3.4 删除用户

逻辑没问题
![](https://cmd.dayi.ink/uploads/upload_a82502bd85de7c5740f934dc7e6dbeea.png)



## 11.4 模板管理


## 11.4.1 新建模板-前端部分

我复制来了，你看这个条子，多好看，能跑不就行PVP




![](https://cmd.dayi.ink/uploads/upload_b985ad4f34efbea6d1b395a2589a79c4.png)



丑对不对，来行这个

```htmlmixed=
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/picnic">
```

![](https://cmd.dayi.ink/uploads/upload_f2f28fcc706ac33b03aa159be5ff0a43.png)



这样就更丑啦！

![](https://cmd.dayi.ink/uploads/upload_1a77d32bf18fb2b8b7276a9add6a47c3.png)


加点CSS
![](https://cmd.dayi.ink/uploads/upload_7106f6960c3c9f1efe3b0877bf5b60cd.png)


这样还可以能看。

## 11.4.1 新建模板-后端

1. 我找到对应的数据库了

![image-20231005211001736](https://lspro.icee.top/i/2023/10/05/651eb5bc5b163.webp)

2.这样根据这个数据库写就好。

还是老套路



3. 实体类

   `QuestionTemplate.java`

   ![image-20231005211246318](https://lspro.icee.top/i/2023/10/05/651eb65029078.webp)

4. 这次反着写 mapper
    QuestionTemplateMapper

  因为后面还有，这里就直接一起写了

  ```bash
  11.4.2 模板列表
  11.4.3 修改模板
  11.4.4 删除模板
  ```

  ![image-20231005215755229](https://lspro.icee.top/i/2023/10/05/651ec0e47584f.webp)

5. 然后来写mapper xml

   ```xml
   排版原因，请看GITHUB上的源码
   ```

   ![image-20231005212910907](https://lspro.icee.top/i/2023/10/05/651eba291dc13.webp)

6. 再写service

   ![image-20231005215551357](https://lspro.icee.top/i/2023/10/05/651ec0688d6e3.webp)

   实现类：

   ![image-20231005215539930](https://lspro.icee.top/i/2023/10/05/651ec05def274.webp)

   ```java
   package net.dabbit.skd21.exam.service.impl;
   
   import java.util.HashMap;
   import java.util.List;
   import java.util.Map;
   
   import org.springframework.beans.factory.annotation.Autowired;
   import org.springframework.stereotype.Service;
   
   import com.alibaba.fastjson.JSONObject;
   
   import net.dabbit.skd21.exam.entity.JsGridData;
   import net.dabbit.skd21.exam.entity.QuestionTemplate;
   import net.dabbit.skd21.exam.mapper.QuestionTemplateMapper;
   import net.dabbit.skd21.exam.service.QuestionTemplateService;
   
   
   @Service
   public class QuestionTemplateServiceImpl implements QuestionTemplateService{
       @Autowired
       QuestionTemplateMapper questionTemplateMapper;
   
       @Override
       public String add(QuestionTemplate questionTemplate) {
           Map<String,String> msg = new HashMap<String,String>();
           msg.put("msg","2333");
   
           int add_ = questionTemplateMapper.add(questionTemplate);
           if(add_>0){
               msg.put("code","200");
           }else{
               msg.put("code","401");
               msg.put("info", "添加失败,修改条数小于1");
           }
           return JSONObject.toJSONString(msg);
       }
   
       @Override
       public String list(JsGridData jsdata) {
           long cnt = questionTemplateMapper.count(jsdata);
           List<QuestionTemplate> list = questionTemplateMapper.list(jsdata);
   
           //设置数据，设置列表数量
           jsdata.setData(list);
           jsdata.setItemsCount(cnt);
   
           //返回数据
   
           return JSONObject.toJSONString(jsdata);
       }
   
       @Override
       public String update(QuestionTemplate questionTemplate) {
   
           Map<String,String> msg = new HashMap<String,String>();
           msg.put("msg","2333");
           int update_ = questionTemplateMapper.update(questionTemplate);
           if(update_>0){
               msg.put("code","200");
           }else{
               msg.put("code","401");
               msg.put("info", "修改失败,修改条数小于1");
           }
           return JSONObject.toJSONString(msg);
       }
   
       @Override
       public String del(Integer id) {
           Map<String,String> msg = new HashMap<String,String>();
           msg.put("msg","2333");
           int del_ = questionTemplateMapper.del(id);
           if(del_>0){
               msg.put("code","200");
           }else{
               msg.put("code","401");
               msg.put("info", "删除失败,修改条数小于1");
           }
           return JSONObject.toJSONString(msg);
       }
   
   }
   ```

7. controller

   ![image-20231005215456151](https://lspro.icee.top/i/2023/10/05/651ec031eff06.webp)



8. 测试一下

![image-20231005220636560](https://lspro.icee.top/i/2023/10/05/651ec2ee1588c.webp)

要哭了

9. 出来了，呜呜呜

   ![image-20231005223254448](https://lspro.icee.top/i/2023/10/05/651ec9230c216.webp)

10. 真的写哭了

​		具体代码看github的源码bia



## 11.4.1 新建模板-前端2

-  院系、专业、学期、科目四个下拉列表，是一个三级联动

- 然后就写）

- 不是，学期是啥啊？

- 我在数据库里没找到`学期`这个东西，有个是`school_year`，但是没有单独的表。

- 补：他在html叫这个

  ![image-20231006003319141](C:\Users\dayi\AppData\Roaming\Typora\typora-user-images\image-20231006003319141.png)

  数据库里的表：

  ![image-20231006003308930](C:\Users\dayi\AppData\Roaming\Typora\typora-user-images\image-20231006003308930.png)

- 把两个写上就跑路。（没有学期，没有科目，怎么加载）

- JS如下

  ```javascript
  
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
  ```

  ![image-20231006003052816](https://lspro.icee.top/i/2023/10/06/651ee4be94234.png)

- 能跑了

  ![image-20231006003414114](https://lspro.icee.top/i/2023/10/06/651ee59261156.png)

- 但，我发现他好像用CLASS应付的

  ![image-20231006003027722](https://lspro.icee.top/i/2023/10/06/651ee4b0951fe.png)

- 那就把学期当做班级，先写上，占上位置。

- 效果这样，但是有问题

  ![image-20231006003621343](https://lspro.icee.top/i/2023/10/06/651ee62bbbe7c.png)

  这个必须做完之后的才能正常，要么就随便填个假的。

## 11.4.1  新建模板-前端3-dayi函数库-测试

1. dayi函数库

   ![image-20231006005320111](https://lspro.icee.top/i/2023/10/06/651eea0d051d2.webp)

    感觉重复性的工作太多了，想直接写个库，这样就可以直接获得表单的数据啦。

![image-20231006005210783](https://lspro.icee.top/i/2023/10/06/651ee9c8d1ef9.png)

2. 添加功能：

   ![image-20231006005946677](https://lspro.icee.top/i/2023/10/06/651eeb8441f3c.webp)

   写个按钮

3. 使用袋一函数库，两行解决问题，你值得拥有

   ![image-20231006011056397](https://lspro.icee.top/i/2023/10/06/651eee222dd99.webp)

4. 贴心报错提示，随时告诉你后端**爆炸**

   ![image-20231006010522708](https://lspro.icee.top/i/2023/10/06/651eecdf6a753.webp)

5. 我发现数据库，这个实体压根没有院系

   ![image-20231006011344921](https://lspro.icee.top/i/2023/10/06/651eeecabd928.webp)

6. dayi-LIB 自动驼峰命名，你值得拥有

   ![image-20231006011728628](https://lspro.icee.top/i/2023/10/06/651eefb80ff07.webp)

   ![image-20231006011910196](https://lspro.icee.top/i/2023/10/06/651ef01a55977.webp)

7. dayi-lib可以在最新代码那个地方下载。

8. 已经添加成功了

   ![image-20231006012020340](https://lsp.dayi.ink/i/2023/10/06/651ef04ab100b.webp)

## 11.4.2 模板列表

1. 又是一个列表啊

   又是重复工作

   没关系，dayi-lib会尝试拯救你（2023年10月6日01:24:32，但没法拯救dayi）

2. 你只需要复制这么一点，就可以自动加载列表

   ![image-20231006012925736](https://lspro.icee.top/i/2023/10/06/651ef2772cfeb.webp)

3. 好像效果也不是特别好，还得优化一下，但是问题不大

   ![image-20231006013831698](https://lspro.icee.top/i/2023/10/06/651ef4a58a70e.webp)

4. 写列表加载

写到这里，代码已经push到github

---

改为写完一个章节，再写这个文档，错误太多了，代码请直接从github上复制。

---

![image-20231006112710066](https://lspro.icee.top/i/2023/10/06/651f7e9b0ff0a.webp)





5. 列表加载写完啦

   就写这点就可以自动加载啦（快夸夸我）

   ![image-20231006113532309](https://lspro.icee.top/i/2023/10/06/651f80910a38d.webp)估计可以用啦，这样就把基本的lib库函数写完啦。

   这个样子：
   
   ![image-20231006115513147](https://lspro.icee.top/i/2023/10/06/651f852272c30.webp)

## 11.4.3 更新列表-前端-dayi lib库的完善

> 测试库的开发

1. 直接写成脚本库

![image-20231006121720433](https://lspro.icee.top/i/2023/10/06/651f8a5cdd525.webp)

![image-20231006121728445](https://lspro.icee.top/i/2023/10/06/651f8a597e6ad.webp)

2. 被迫用了点异步，因为表单会提前加载，需要等待完成。

![image-20231006123043086](https://lspro.icee.top/i/2023/10/06/651f8d8004ae6.webp)

3. 效果这个样子

   ![image-20231006123823776](https://lspro.icee.top/i/2023/10/06/651f8f4bf26fe.webp)

4. 好累）

   ![image-20231006130652617](https://lspro.icee.top/i/2023/10/06/651f95f978602.webp)

5. 传参试试

   ![image-20231006134737018](https://lspro.icee.top/i/2023/10/06/651f9f857a5dd.webp)

![image-20231006134811743](https://lspro.icee.top/i/2023/10/06/651f9f9d00733.webp)

6. 修改成功www![image-20231006134912661](https://lspro.icee.top/i/2023/10/06/651f9fe53f670.webp)

7. 然后把要修改的数据传过来

8. 直接写一个新函数填表吧

   回填

   ![image-20231006135507445](https://lspro.icee.top/i/2023/10/06/651fa147e1dad.webp)

9. 回填成功！

   ![image-20231006135614284](https://lspro.icee.top/i/2023/10/06/651fa18b5dd8e.webp)

   好开心）））

   ![image-20231006135749318](https://lspro.icee.top/i/2023/10/06/651fa1e98b4e3.webp)

10. 剩下的就是删除了，这个简单

    ![image-20231006140358203](https://lspro.icee.top/i/2023/10/06/651fa35aba96f.webp)

11. 最后就是封装

    这点点代码就可以把整个重复逻辑给实现啦

    ![image-20231006140606151](https://lspro.icee.top/i/2023/10/06/651fa3daeb3f6.webp)

12. 试试

    ![image-20231006140908145](C:\Users\dayi\AppData\Roaming\Typora\typora-user-images\image-20231006140908145.png)

    好好好

    是后端炸了

    ![image-20231006141001024](https://lspro.icee.top/i/2023/10/06/651fa4baaf57f.webp)

13. 写成delete了

    ![image-20231006141115724](https://lspro.icee.top/i/2023/10/06/651fa504d9e60.webp)

14. 成功啦

    ![image-20231006141156641](https://lspro.icee.top/i/2023/10/06/651fa52e6b630.webp)

这样就算完成啦

## 11.4.4 删除模板

写完啦！

上面都有图啦

![image-20231006141501417](https://lspro.icee.top/i/2023/10/06/651fa5f2379ae.webp)



## 11.5 题库管理

先把代码复制上，看看是什么bia

这个样子诶（文件`test-upload.html`）

![image-20231006144858593](https://lspro.icee.top/i/2023/10/06/651fadf4820fb.webp)



### 11.5.1 题库管理-前端

1. 复制上HTML代码之后

2. 左侧连接直接去数据库添加条目就可以

   ```sql
   INSERT INTO `menu` (`id`, `menu_code`, `menu_name`, `menu_level`, `parent_id`, `sort`) VALUES ('43', 'exam', '试题管理', '1', '0', '1');
   
   INSERT INTO `menu` (`id`, `menu_code`, `menu_name`, `menu_url`, `menu_level`, `parent_id`, `sort`) VALUES ('44', 'exam-uploader', '试题上传', 'test-upload.html', '2', '43', '1');
   
   ```

   ![image-20231006145828879](https://lspro.icee.top/i/2023/10/06/651fb0166c3b9.webp)

3. 这样侧边栏就会有菜单了

   ![image-20231006150704508](https://lspro.icee.top/i/2023/10/06/651fd17cb928c.png)

4. 3

5. 3

6. 3

7. 3

8. 3

9. 

10. 

### 11.5.2 题库管理-后端

1. 依赖文件

   复制上就好

   ```xml
           <dependency>
               <groupId>org.apache.poi</groupId>
               <artifactId>poi</artifactId>
               <version>3.14</version>
           </dependency>
           <dependency>
               <groupId>org.apache.poi</groupId>
               <artifactId>poi-ooxml</artifactId>
               <version>3.14</version>
           </dependency>
   ```

      ![image-20231006150820612](https://lspro.icee.top/i/2023/10/06/651fc94143bf7.png)

2. 记得点那个小蓝，同步下仓库

3. 然后把他的库粘贴上，大概这个样子，依赖库

   ```java
   import org.apache.poi.hssf.usermodel.HSSFWorkbook;
   import org.apache.poi.ss.usermodel.Cell;
   import org.apache.poi.ss.usermodel.Row;
   import org.apache.poi.ss.usermodel.Sheet;
   import org.apache.poi.ss.usermodel.Workbook;
   
   import java.io.InputStream;
   import java.util.*;
   ```

   ![image-20231006151213192](https://lspro.icee.top/i/2023/10/06/651fc95790389.png)

4. 写controller

   我看他URL用的是

   这样表单直接飞上来的。

   `/test/upload`

   ![image-20231006152040352](https://lspro.icee.top/i/2023/10/06/651fc93d07236.png)

5. 这样照着写一个

6. 好奇怪

   ![image-20231006153126864](https://lspro.icee.top/i/2023/10/06/651fc94aac093.png)

7. 然后要保存，就要写数据库了

8. 但是dayi也很想吐槽：

   ![image-20231006153424896](https://lspro.icee.top/i/2023/10/06/651fc936432d1.png)

   

   数据库这个应该就是

   ![image-20231006153617973](https://lspro.icee.top/i/2023/10/06/651fc947206bd.png)

9. Question.java

   ![image-20231006153729124](https://lspro.icee.top/i/2023/10/06/651fc935666a2.png)

10. QuestionOptions.java

    ![image-20231006154027090](https://lspro.icee.top/i/2023/10/06/651fc9359d4f5.png)

11. 然后是mapper

    我觉得这两个写一个mapper就可以

    ![image-20231006154124413](https://lspro.icee.top/i/2023/10/06/651fc92d8bf16.png)

    问题和选项添加：

    ![image-20231006161319616](https://lspro.icee.top/i/2023/10/06/651fc93292d92.png)

    查询问题：

    ![image-20231006161303019](https://lspro.icee.top/i/2023/10/06/651fc939bbced.png)

12. 连接表，但好像没什么用，可以直接后端拉信息，然后再去查具体的题目选项。

    ```sql
    SELECT * 
    FROM question_bank inner join question_options on question_bank.question_code=question_options.question_code
    ```

    ![image-20231006160340198](https://lspro.icee.top/i/2023/10/06/651fc93a2018c.png)

    所以并不需要直接在数据库里合并表格

    ![image-20231006160813565](https://lspro.icee.top/i/2023/10/06/651fc92926044.png)

13. 然后是mapper

    ![image-20231006161551317](https://lspro.icee.top/i/2023/10/06/651fc923c1a24.png)

14. 服务接口

    ![image-20231006162135666](https://lspro.icee.top/i/2023/10/06/651fc922199d7.png)

15. 服务实现：

    ![image-20231006163704149](https://lspro.icee.top/i/2023/10/06/651fc921ea51d.png)

    ![image-20231006164429913](https://lspro.icee.top/i/2023/10/06/651fc90ceacfa.png)

16. 写完了，试一试

    ![image-20231006164638570](https://lspro.icee.top/i/2023/10/06/651fc98d80a42.png)

17. 有个Autowire要这么写

    > 然后不是这里的问题，是impl没写@service（找了3个小时的BUG）

    ![image-20231006173202759](https://lspro.icee.top/i/2023/10/06/651fd4177e4c2.png)

18. 试一试

    ![image-20231006173151882](https://lspro.icee.top/i/2023/10/06/651fd40e6edb3.png)

19. 要命，改了4个小时了

    ![image-20231006190033679](https://lspro.icee.top/i/2023/10/06/651fe8dee25c8.png)

20. 心态爆炸

    ![image-20231006190153295](https://lspro.icee.top/i/2023/10/06/651fe943b7dce.png)

21. 不插入了，先这样吧

    ![](https://lspro.icee.top/i/2023/10/06/651feb9ab41ed.png)

    

### 11.5.3 修改的文件：

![image-20231006191311028](https://lspro.icee.top/i/2023/10/06/651febcf984ba.png)



  



## 11.6 院系管理

11.6.1 新建院系

11.6.2 院系列表

11.6.3 修改院系

11.6.4 删除院系

这些分一个做完就好，很简单啦。



### 11.6.1 院系管理-后端

因为之前写了一部分了：

![image-20231006191721339](https://lspro.icee.top/i/2023/10/06/651fecd10c1ab.png)

然后开始写：

1. mapper xml

   ![image-20231006192646440](https://lspro.icee.top/i/2023/10/06/651fef0dc832e.png)

2. mapper

   ![image-20231006192656597](https://lspro.icee.top/i/2023/10/06/651fef0455d67.png)

3. service

   ![image-20231006194418709](https://lspro.icee.top/i/2023/10/06/651ff3441b615.png)

4. controller

   ![image-20231006194356737](https://lspro.icee.top/i/2023/10/06/651ff308c4ca4.png)

5. 测试：

   ![image-20231006194514535](https://lspro.icee.top/i/2023/10/06/651ff3639dfec.png)

6. 好累，我让这个东西，那个叫mybatis生成器，生成了一点文件

![image-20231006193154894](https://lspro.icee.top/i/2023/10/06/651ff0399334b.png)



### 11.6.2 院系管理-前端

> dayi-lib库，你只需要几行就可以完成整个前端！



1.列表：

这样改一下就好：

![image-20231006194858706](https://lspro.icee.top/i/2023/10/06/651ff43c97d2f.png)

2. 新增：

   也是，有了lib，直接去生成就好。

   ![image-20231006195120563](https://lspro.icee.top/i/2023/10/06/651ff4c6747b4.png)

3. 这样用dayilib 轻松解决问题：

   ![image-20231006195423240](https://lspro.icee.top/i/2023/10/06/651ff573e3761.png)

4. 你看怎么样？

   ![image-20231006195440962](https://lspro.icee.top/i/2023/10/06/651ff586a8c4c.png)

5. 轻松新增

   ![image-20231006195634304](https://lspro.icee.top/i/2023/10/06/651ff5f3dedc1.png)

6. 修改代码不足20行

   ![image-20231006195856530](https://lspro.icee.top/i/2023/10/06/651ff682c5aa2.png)

   ![image-20231006195911996](https://lspro.icee.top/i/2023/10/06/651ff6922eb86.png)

   ![image-20231006195928519](https://lspro.icee.top/i/2023/10/06/651ff6a540d5d.png)

8. 轻松添加猴子系，你还在等什么？

   ![image-20231006200025963](https://lspro.icee.top/i/2023/10/06/651ff6dc8647c.png)

9. 轻松删除猴子系，你还在等什么？

   ![image-20231006200118809](https://lspro.icee.top/i/2023/10/06/651ff710cd6e8.png)

10. 轻松修改猴子系，你还在等什么？

    ![image-20231006200204093](https://lspro.icee.top/i/2023/10/06/651ff73e55d09.png)

相关文件：

![image-20231006202601893](https://lspro.icee.top/i/2023/10/06/651ffcdc22477.png)



## 11.7 专业管理

### 11.7.1 后端

1. controller

   ![image-20231006205134308](https://lspro.icee.top/i/2023/10/06/652002de6fec6.png)

2. mapper

   ![image-20231006205153455](https://lspro.icee.top/i/2023/10/06/652002ed7e55c.png)

3. mapper xml

   ![image-20231006205207607](https://lspro.icee.top/i/2023/10/06/6520030060119.png)

4. service impl

   ![image-20231006205242579](https://lspro.icee.top/i/2023/10/06/652003244724b.png)

5. service

   ![image-20231006205301485](https://lspro.icee.top/i/2023/10/06/652003314bb8f.png)

6. POSTMAN测试

   ![image-20231006205316821](https://lspro.icee.top/i/2023/10/06/652003408acd2.png)





### 11.7.2 前端

![image-20231006205646644](https://lspro.icee.top/i/2023/10/06/65200410ea66c.png)



![image-20231006205558937](https://lspro.icee.top/i/2023/10/06/652003e1c551a.png)



![image-20231006205632306](https://lspro.icee.top/i/2023/10/06/65200404247f9.png)



新增专业测试：人生是没有回头路的。

![image-20231006210452341](https://lspro.icee.top/i/2023/10/06/652005f81b514.png)

然后我们可以找到：

![image-20231006210525062](https://lspro.icee.top/i/2023/10/06/652006177d1df.png)

保存成功

![image-20231006210617615](https://lsp.dayi.ink/i/2023/10/06/6520064b8946b.png)

删除成功：

![image-20231006210736394](https://lspro.icee.top/i/2023/10/06/6520069a72430.png)

本章节修改的文件：

![image-20231006210834092](https://lspro.icee.top/i/2023/10/06/652006d5331a3.png)



## 11.8  班级管理

### 11.8.1 后端

- mapper xml
- controller 
- service
- serviceImpl

都差不多啦

![image-20231006215146623](https://lspro.icee.top/i/2023/10/06/652010f5b3318.png)

### 11.8.2 前端

前段也是，复制两个html文件，稍微改一改就好。

![image-20231006220537850](https://lspro.icee.top/i/2023/10/06/65201434c0558.png)

![image-20231006220548669](https://lspro.icee.top/i/2023/10/06/6520143f2eede.png)

![image-20231006220600257](https://lspro.icee.top/i/2023/10/06/6520144be381c.png)





![image-20231006220702200](https://lspro.icee.top/i/2023/10/06/6520148a901b6.png)



![image-20231006220719581](https://lspro.icee.top/i/2023/10/06/65201499b9e81.png)



![image-20231006220741609](https://lspro.icee.top/i/2023/10/06/652014af9ea8f.png)

![image-20231006220750177](https://lspro.icee.top/i/2023/10/06/652014b86edb0.png)

### 11.8.3 本章节修改的文件

![image-20231006220848434](https://lspro.icee.top/i/2023/10/06/652014f3ab3a8.png)



## 11.9 科目管理


### 11.9.1 后端

感觉没什么好说的啦， 就是发现生成的xml又生成了一次，导致报错了。

![](https://lspro.icee.top/i/2023/10/06/6520225519161.webp)



### 11.9.2 前端

还是用了dayi-lib的JS库，这样你就额可以10行写一个前端啦。

![](https://cmd.dayi.ink/uploads/upload_7ed81181b0ba363a8213fd17b0670561.png)

列表：
![](https://cmd.dayi.ink/uploads/upload_47e8e3a4402bb44e092792ae0f6b27c3.png)

修改:
![](https://cmd.dayi.ink/uploads/upload_ba9f45343a8042b6ec1216f8fb5bc424.png)

删除：
![](https://cmd.dayi.ink/uploads/upload_0f467fb6113d0a98fffb8386aec7d68e.png)




## 11.10 专业学期管理

### 11.10.1 后端


> 专业学期增删改查

老样子

服务
![](https://cmd.dayi.ink/uploads/upload_011796977b4dda375466f5283b2fa0eb.png)


实现:
![](https://cmd.dayi.ink/uploads/upload_d621d3caf259ed1e47128b9452dfe50a.png)

controller:

![](https://cmd.dayi.ink/uploads/upload_655ec60658d3d8dabc4a7bde553434b7.png)


测试:
![](https://cmd.dayi.ink/uploads/upload_54de36794e9feb2735b47a3029354602.png)

### 11.10.2 前端

还是用超级dayi库


1. 文件1：

![](https://cmd.dayi.ink/uploads/upload_a4aca1a69266b9782897cb56fd60d0d8.png)
![](https://cmd.dayi.ink/uploads/upload_ccc2767a804c088217f04be6a989721b.png)


2. 文件2：

![](https://cmd.dayi.ink/uploads/upload_a64333923065f5ca1a7fa74303d0174b.png)

新增功能:

把url提炼出来，这样就只需要修改一个地方啦。

![](https://cmd.dayi.ink/uploads/upload_d7c8d2c688d16e0c850d30638ffd1c2d.png)

3. 测试

数据库：(修改菜单)
![](https://cmd.dayi.ink/uploads/upload_ce21153dbaf6ebb0ccb9a0162bc9f60d.png)


增加：
![](https://cmd.dayi.ink/uploads/upload_5cfc2b53d4929b12d16471df4fc44695.png)


列表：
![](https://cmd.dayi.ink/uploads/upload_0e3a06ac17e49c3677d4f47f77dff791.png)

列表2:(刚才新增的地方写错了一点)

![](https://cmd.dayi.ink/uploads/upload_75ac7395875e627621476a56b7d38c31.png)


修改:

![](https://cmd.dayi.ink/uploads/upload_8b403e636afa74f5b928b73b99467133.png)


删除:
![](https://cmd.dayi.ink/uploads/upload_4f666ac4e08eb7211a516227f1bfddcb.png)

![](https://cmd.dayi.ink/uploads/upload_1fbeb84416f15af5eaf08677037ff22d.png)


### 11.10.3 本次修改的文件：

![](https://cmd.dayi.ink/uploads/upload_3652b2e85d59f8a6ddb4ebef41c2ff98.png)


### 11.10.4 目前的menu数据库:

```sql

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `menu_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `menu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `menu_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `menu_level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parent_id` int NULL DEFAULT NULL,
  `sort` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 60 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (25, 'menu-1-template', '一级菜单', '', '1', 0, 1);
INSERT INTO `menu` VALUES (27, 'role', '角色管理', '', '1', 0, 3);
INSERT INTO `menu` VALUES (28, 'user', '用户管理', '', '1', 0, 4);
INSERT INTO `menu` VALUES (29, 'project-add', '二级菜单-新增/修改模板', 'project-add.html', '2', 25, 1);
INSERT INTO `menu` VALUES (30, 'project-list', '二级菜单-数据列表模板', 'project-list.html', '2', 25, 2);
INSERT INTO `menu` VALUES (31, 'choose', '二级菜单-在线考试模板', 'choose.html', '2', 25, 3);
INSERT INTO `menu` VALUES (32, 'menu-add', '新增菜单', 'menu-add.html', '2', 26, 1);
INSERT INTO `menu` VALUES (33, 'menu-list', '菜单列表', 'menu-list.html', '2', 26, 2);
INSERT INTO `menu` VALUES (34, 'role-add', '新增角色', 'role-add.html', '2', 27, 1);
INSERT INTO `menu` VALUES (35, 'role-list', '角色列表', 'role-list.html', '2', 27, 2);
INSERT INTO `menu` VALUES (36, 'user-add', '用户管理', 'user-add.html', '2', 28, 1);
INSERT INTO `menu` VALUES (37, 'questions', '题库管理', '', '1', 0, 5);
INSERT INTO `menu` VALUES (38, 'file-upload', '试题上传', 'file-upload.html', '2', 37, 1);
INSERT INTO `menu` VALUES (39, '', '', '', '', NULL, NULL);
INSERT INTO `menu` VALUES (40, 'template', '模板管理', '', '1', 0, 1);
INSERT INTO `menu` VALUES (41, 'template-list', '模板列表', 'template-list.html', '2', 40, 1);
INSERT INTO `menu` VALUES (42, 'template-add', '模板新增', 'template.html', '2', 40, 2);
INSERT INTO `menu` VALUES (43, 'exam', '试题管理', NULL, '1', 0, 1);
INSERT INTO `menu` VALUES (44, 'exam-uploader', '试题上传', 'test-upload.html', '2', 43, 1);
INSERT INTO `menu` VALUES (45, 'faculty', '院系管理', NULL, '1', 0, 1);
INSERT INTO `menu` VALUES (46, 'faculty-add', '院系添加', 'faculty-add.html', '2', 45, 1);
INSERT INTO `menu` VALUES (47, 'faculty-list', '院系列表', 'faculty-list.html', '2', 45, 2);
INSERT INTO `menu` VALUES (48, 'major', '专业', NULL, '1', 0, 1);
INSERT INTO `menu` VALUES (49, 'major-add', '专业-添加', 'major-add.html', '2', 48, 1);
INSERT INTO `menu` VALUES (50, 'major-list', '专业列表', 'major-list.html', '2', 48, 2);
INSERT INTO `menu` VALUES (51, 'class', '班级管理', NULL, '1', 0, 1);
INSERT INTO `menu` VALUES (52, 'class-add', '班级新增', 'class-add.html', '2', 51, 1);
INSERT INTO `menu` VALUES (53, 'class-list', '班级列表', 'class-list.html', '2', 51, 2);
INSERT INTO `menu` VALUES (54, 'subject', '课程管理', NULL, '1', 0, 1);
INSERT INTO `menu` VALUES (55, 'subject-add', '课程添加', 'subject-add.html', '2', 54, 1);
INSERT INTO `menu` VALUES (56, 'subject-list', '课程列表', 'subject-list.html', '2', 54, 2);
INSERT INTO `menu` VALUES (57, 'major-semester', '专业学年管理', NULL, '1', 0, 1);
INSERT INTO `menu` VALUES (58, 'major-semester-add', '专业学年增加', 'major-semester-add.html', '2', 57, 1);
INSERT INTO `menu` VALUES (59, 'major-semester-list', '专业学年列表', 'major-semester-list.html', '2', 57, 2);

SET FOREIGN_KEY_CHECKS = 1;

```

![](https://cmd.dayi.ink/uploads/upload_d56abc71a4ef8e70d74cb7bab5164b65.png)



## 11.11 试卷管理



### 11.11.1 复制类

但是有个包导入失败

pom.xml


```xml
<dependency>
    <groupId>com.mchange</groupId>
    <artifactId>c3p0</artifactId>
    <version>0.9.5.5</version> <!-- 或者您需要的版本号 -->
</dependency>
```


### 11.11.1 复制类

但是有个包导入失败

![](https://cmd.dayi.ink/uploads/upload_ccbfee999e15cfea15cbdd80a1195dd3.png)


pom.xml


```xml
<dependency>
    <groupId>com.mchange</groupId>
    <artifactId>c3p0</artifactId>
    <version>0.9.5.5</version> <!-- 或者您需要的版本号 -->
</dependency>
```

直接把类重新生成了一下

![](https://cmd.dayi.ink/uploads/upload_96df4df6fab6bbf29ed9acf40a52be5c.png)

可以正常抽题了。

![](https://cmd.dayi.ink/uploads/upload_2556e10f17f9a6b3789cc946cf0d703d.png)


### 11.11.2 把包重写了一下，然后直接塞controller了。


![](https://cmd.dayi.ink/uploads/upload_aa62fbb20ddbc812f79f790196a82b59.png)

![](https://cmd.dayi.ink/uploads/upload_72b837ca2391523540f52978011cc44e.png)


这里是controller

简陋，但是实现了功能。具体的规范性如果还有时间再来规范。

![](https://cmd.dayi.ink/uploads/upload_8a92acc7f98a5779e8e0f84525393789.png)


```json
{
    "EASY": [
        37,
        34,
        51,
        44,
        24,
        20,
        41,
        22,
        29,
        38,
        35,
        40,
        27,
        30
    ],
    "MEDIUM": [
        62,
        59,
        89,
        68,
        32,
        51,
        95,
        33
    ],
    "HARD": [
        27,
        114
    ],
    "VERY_HARD": [
        109,
        120
    ]
}

```



### 11.11.3 然后是根据题目编号获得题目

随便写写，就这个样子

![](https://cmd.dayi.ink/uploads/upload_60530b0ba59d3aae77bbbcd68ab5226f.png)


返回的json

这里答案肯定是应该要隐藏的，但是实际上，某些平台的好像也就这样，直接能拿答案）

主要是内容有点多，先实现功能，然后是能跑。


```json
{
    {
        "answer": "D ",
        "createTime": 1639065652000,
        "difficulty": 0,
        "id": 19,
        "questionCode": "0-f1dad818-5c94-4a27-b071-f1582652e7df",
        "questionName": "资本主义经济危机的根源在于（ ）。",
        "subjectId": 1,
        "type": 0
    }: [
        {
            "id": 73,
            "optionsCode": "A",
            "optionsText": " 生产和消费的矛盾  ",
            "questionCode": "0-f1dad818-5c94-4a27-b071-f1582652e7df"
        },
        {
            "id": 74,
            "optionsCode": "B",
            "optionsText": " 劳动人民的消费不足 ",
            "questionCode": "0-f1dad818-5c94-4a27-b071-f1582652e7df"
        },
        {
            "id": 75,
            "optionsCode": "C",
            "optionsText": " 消费需求和投资需求的不足 ",
            "questionCode": "0-f1dad818-5c94-4a27-b071-f1582652e7df"
        },
        {
            "id": 76,
            "optionsCode": "D",
            "optionsText": " 资本主义基本矛盾 ",
            "questionCode": "0-f1dad818-5c94-4a27-b071-f1582652e7df"
        }
    ]
}
```




### 11.11.4 前端

生成啦一个，还可以

这样可以直接做题并且自动打分。

（就当练习啦）

![](https://cmd.dayi.ink/uploads/upload_f12079f020bdd74c9e750b60b4dc11cd.png)


![](https://cmd.dayi.ink/uploads/upload_afbaa9e2ae0602de63e0e0bdc6a65d80.png)

然后再美化下CSS




![](https://cmd.dayi.ink/uploads/upload_b0e4f846d67c39bdb0a87897a8c47a8c.png)


效果图2：

![](https://cmd.dayi.ink/uploads/upload_85540e6b3ff6a9cb04ad55dfb6604b05.png)


### 11.11.5 前端倒计时，时间到了自动提交代码

![](https://cmd.dayi.ink/uploads/upload_132c3eebb2ac9a1ebb8d5df16b8f84ed.png)


倒计时：

![](https://cmd.dayi.ink/uploads/upload_e2df2d933c412e80df122dbea17efef6.png)




## 11.12 在线考试


### 11.12.1 在线考试


我觉得已经差不多实现了。剩下的就是完善功能了。

考虑到时间关系，先实现功能，然后再慢慢完善，光这个markdown文件也4204行了。

### 11.12.2 成绩查询

> 根据院系、专业、学期、科目、当前登录的用户id，查询当前登录用户的指定科目的成绩。



![](https://cmd.dayi.ink/uploads/upload_80875dca80201aede4cd7e70137b644f.png)

### 11.12.2 成绩查询


### 11.12.2 后端

> 根据院系、专业、学期、科目、当前登录的用户id，查询当前登录用户的指定科目的成绩。

1. 实现逻辑：

- 从后端获得当前登录的用户。
- 很遗憾，我们的登录功能是假的。
- 所以要写一个登录功能，并且存cookie

- 好像时间有点来不及了，所以，我们将错就错，直接登录，然后返回成绩。

- 这样就简单多了。

2. 开始实现。

- 成绩是有一个实体，叫score。

- 先写mapper

3. mapper 和 xml

这里直接用他的库，所以，我们直接修改一下，然后直接写servcie就可以。

4. service

- 我们需要一个能够实现按用户id查询成绩就可以了。

- 根据实体，传入的参数有，科目名，用户id。

![](https://cmd.dayi.ink/uploads/upload_cc37ff1bd31fe505193d50704964c24c.png)



5. 开始实现

- mapper xml

![](https://cmd.dayi.ink/uploads/upload_e129ac589d75ebd39b073b6423361bcd.png)

- mapper

![](https://cmd.dayi.ink/uploads/upload_0efff83b681976273c71b9ffe70e6a64.png)


- service

因为分数这种东西，肯定是只能增加，不能修改！

所以，只写了查询和新增，从根本上杜绝修改分数（才不是懒）

![](https://cmd.dayi.ink/uploads/upload_ff3a4b94dbcfba59cdd9cd088449c8b8.png)


- controller

要实现：用户登录，验证身份成功后，给他分数！

大概就是这样子，别怪咱写的太少，呜呜呜，实在是写不完了。


稍微改改，把他全部的都返回bia

![](https://cmd.dayi.ink/uploads/upload_bbed2b0a8b3ba58001483a131a09b732.png)


![](https://cmd.dayi.ink/uploads/upload_41affba964b394abdec720ec205be7d9.png)

感觉应该差不多了。

试一试bia


没有用户名密码：
![](https://cmd.dayi.ink/uploads/upload_3d881a8c1dcbc408345e4fd50a51ace9.png)


好的，获得500

![](https://cmd.dayi.ink/uploads/upload_2d39a0cdf8b1c09b76d7377d820f2415.png)


好好好

![](https://cmd.dayi.ink/uploads/upload_8e04db366d96d50e4f3add9c759a8005.png)

![](https://cmd.dayi.ink/uploads/upload_5be8318e0b2e649cbef6f02cba052795.png)

拿错变量了。
![](https://cmd.dayi.ink/uploads/upload_2f09f3374f4b2a18e972b708256815f6.png)



---


场外话：

这是题目练习结束自动提交PVP

![](https://cmd.dayi.ink/uploads/upload_bee2f0348305df16f809e376d4e3dd31.png)

---


看样子是可以啦：

![](https://cmd.dayi.ink/uploads/upload_8e485f056bb956a1c9fccc3b8df407a0.png)




### 11.12.3 前端

1. 生成一个前端


![](https://cmd.dayi.ink/uploads/upload_0d925740e5b9bb1c760f9c02b122bc1f.png)


2. 加数据库

![](https://cmd.dayi.ink/uploads/upload_3041ab74ab406f90a5f50cef03b17dfb.png)


3. 试一试


![](https://cmd.dayi.ink/uploads/upload_f552ca344691b37a2fb21683955498fd.png)


4. 出错啦

![](https://cmd.dayi.ink/uploads/upload_815077f95ebdd06714a7161028cac7fe.png)


5. 没问题啦（还挺好看）

这个answer我一开始以为是答案。

![](https://cmd.dayi.ink/uploads/upload_0ff6e74ced8f6f495040b93102b9c7a0.png)

## 11.13 统计信息

### 11.13.1 统计成绩

汇总学生成绩，进行相应的统计，通过图表展示。

就写一个bia。

这样就是管理端直接获取全部的Score。


其实也蛮简单的。


直接去刚才的地方的数据库表改一下就好PVP

写一个mapper：


我想了想，直接写个分数管理就好啦呀。

分数添加，分数查询，分数删除，分数修改。

就这些就够啦。

说干就干。

![](https://cmd.dayi.ink/uploads/upload_d70c29d6d8f36fd25e0d90a64c1e25a7.png)


![](https://cmd.dayi.ink/uploads/upload_94815cf4695ecd600759ac0bd76a7dc0.png)


### ** 并且！你想都别想改分数 **

![](https://cmd.dayi.ink/uploads/upload_1868bfff0a7dc0f98639c11e01ed3007.png)


![](https://cmd.dayi.ink/uploads/upload_43a74bb762adfc36b2a96c57a55d89ac.png)

**真男人是无法修改分数的！**

他真的改了吗？

**如改！**


mapper剩下的直接跟之前的一样就可以。

![](https://cmd.dayi.ink/uploads/upload_ea9d61b7a66cb796cf7bfa1cc1197f07.png)


controller:

![](https://cmd.dayi.ink/uploads/upload_0beb7f1be2a6a7ba4668325cb7a1d620.png)

测试：
![](https://cmd.dayi.ink/uploads/upload_135d845d8ebc6f3202a0149986256d70.png)

数据不对

![](https://cmd.dayi.ink/uploads/upload_2608d3a3cfc89170c3a493c619e20cc2.png)

改过来啦。

![](https://cmd.dayi.ink/uploads/upload_86c9aa544b78c8b05a7e24ad6b074f8b.png)


### 11.13.1 统计成绩-前端

还是一样，利用dayijs只需要改几行即可完成。

![](https://cmd.dayi.ink/uploads/upload_f72fa4fffda6e79e2dcde4c811881dcb.png)


维护下菜单数据库
![](https://cmd.dayi.ink/uploads/upload_330ab38f25b6f824b3ec47c6a03f8b7d.png)


1. 新增分数

![](https://cmd.dayi.ink/uploads/upload_619186e97a4180ae98baf05665dbb23d.png)

分数当然是不可以新增的啦。
给你留接口，你能填进去Date类，就去改分数吧。


![](https://cmd.dayi.ink/uploads/upload_2a1904f9653e8c3ab6328fbba74c1ff8.png)

2. 列表

![](https://cmd.dayi.ink/uploads/upload_889165a7faecd99c4fa28ee06ef0bdf4.png)

![](https://cmd.dayi.ink/uploads/upload_9883539b39c066500c8fa95cb9b05262.png)


ok，这样子就差不多啦。（超级超级累，一个人肝出来真的要命）




## 菜单数据库



![](https://cmd.dayi.ink/uploads/upload_afbef33b20c42bdfd83de735e11c8adf.png)



```sql
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `menu_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `menu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `menu_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `menu_level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parent_id` int NULL DEFAULT NULL,
  `sort` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 66 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (25, 'menu-1-template', '一级菜单', '', '1', 0, 1);
INSERT INTO `menu` VALUES (27, 'role', '角色管理', '', '1', 0, 3);
INSERT INTO `menu` VALUES (28, 'user', '用户管理', '', '1', 0, 4);
INSERT INTO `menu` VALUES (29, 'project-add', '二级菜单-新增/修改模板', 'project-add.html', '2', 25, 1);
INSERT INTO `menu` VALUES (30, 'project-list', '二级菜单-数据列表模板', 'project-list.html', '2', 25, 2);
INSERT INTO `menu` VALUES (31, 'role-tree', '角色树', 'role-tree.html', '2', 25, 3);
INSERT INTO `menu` VALUES (32, 'menu-add', '新增菜单', 'menu-add.html', '2', 26, 1);
INSERT INTO `menu` VALUES (33, 'menu-list', '菜单列表', 'menu-list.html', '2', 26, 2);
INSERT INTO `menu` VALUES (34, 'role-add', '新增角色', 'role-add.html', '2', 27, 1);
INSERT INTO `menu` VALUES (35, 'role-list', '角色列表', 'role-list.html', '2', 27, 2);
INSERT INTO `menu` VALUES (36, 'user-add', '用户管理', 'user-add.html', '2', 28, 1);
INSERT INTO `menu` VALUES (37, 'questions', '题库管理', '', '1', 0, 5);
INSERT INTO `menu` VALUES (38, 'file-upload', '试题上传', 'file-upload.html', '2', 37, 1);
INSERT INTO `menu` VALUES (40, 'template', '模板管理', '', '1', 0, 1);
INSERT INTO `menu` VALUES (41, 'template-list', '模板列表', 'template-list.html', '2', 40, 1);
INSERT INTO `menu` VALUES (42, 'template-add', '模板新增', 'template.html', '2', 40, 2);
INSERT INTO `menu` VALUES (43, 'exam', '试题管理', NULL, '1', 0, 1);
INSERT INTO `menu` VALUES (44, 'exam-uploader', '试题上传', 'test-upload.html', '2', 43, 1);
INSERT INTO `menu` VALUES (45, 'faculty', '院系管理', NULL, '1', 0, 1);
INSERT INTO `menu` VALUES (46, 'faculty-add', '院系添加', 'faculty-add.html', '2', 45, 1);
INSERT INTO `menu` VALUES (47, 'faculty-list', '院系列表', 'faculty-list.html', '2', 45, 2);
INSERT INTO `menu` VALUES (48, 'major', '专业', NULL, '1', 0, 1);
INSERT INTO `menu` VALUES (49, 'major-add', '专业-添加', 'major-add.html', '2', 48, 1);
INSERT INTO `menu` VALUES (50, 'major-list', '专业列表', 'major-list.html', '2', 48, 2);
INSERT INTO `menu` VALUES (51, 'class', '班级管理', NULL, '1', 0, 1);
INSERT INTO `menu` VALUES (52, 'class-add', '班级新增', 'class-add.html', '2', 51, 1);
INSERT INTO `menu` VALUES (53, 'class-list', '班级列表', 'class-list.html', '2', 51, 2);
INSERT INTO `menu` VALUES (54, 'subject', '课程管理', NULL, '1', 0, 1);
INSERT INTO `menu` VALUES (55, 'subject-add', '课程添加', 'subject-add.html', '2', 54, 1);
INSERT INTO `menu` VALUES (56, 'subject-list', '课程列表', 'subject-list.html', '2', 54, 2);
INSERT INTO `menu` VALUES (57, 'major-semester', '专业学年管理', NULL, '1', 0, 1);
INSERT INTO `menu` VALUES (58, 'major-semester-add', '专业学年增加', 'major-semester-add.html', '2', 57, 1);
INSERT INTO `menu` VALUES (59, 'major-semester-list', '专业学年列表', 'major-semester-list.html', '2', 57, 2);
INSERT INTO `menu` VALUES (60, 'for-exam', '考试', 'letmegodie.html', '1', 0, 1);
INSERT INTO `menu` VALUES (61, 'show-my-score', '查询分数', 'show-my-score.html', '1', 0, 1);
INSERT INTO `menu` VALUES (62, 'score', '分数管理', NULL, '1', 0, 1);
INSERT INTO `menu` VALUES (63, 'score-add', '新增分数（确定吗）', 'score-add.html', '2', 62, 1);
INSERT INTO `menu` VALUES (64, 'score-list', '分数列表', 'score-list.html', '2', 62, 1);

SET FOREIGN_KEY_CHECKS = 1;
```



## 项目结构

还是不少内容的）
![](https://cmd.dayi.ink/uploads/upload_41590fe07351b45107d970d5fe917700.png)
![](https://cmd.dayi.ink/uploads/upload_df6adab1720121ed3ed66dcaff7997a8.png)



----


## **最新代码**：

![](https://cmd.dayi.ink/uploads/upload_09ef0bbe68de67795544fd8eddbed6a0.png)

**都在这里：**

>打开缓慢：可以用Steam++来加速访问（选github）（https://steampp.net/ 下载：选蓝奏云 https://wwn.lanzouy.com/imM6D19nxt9a 密码1234 ）

不是很想用gitee，限制特别多，如果你们需要，请跟我说

代码：在这里👇，打开慢请用steam++试试。

https://github.com/magical-rabbit/java-spring

https://github.com/magical-rabbit/java-spring/tree/main/src/main/java/net/dabbit/skd21/exam



如何下载？

![image-20231006125304164](https://lspro.icee.top/i/2023/10/06/651f92bcbec1d.webp)



直链:https://github.com/magical-rabbit/java-spring/archive/refs/heads/main.zip



---


## 文件下载

- 周三下午3点: <https://pic.icee.top/blog/pic_bed/2023/09/emis_23_9_20_周三下午3点.zip>

- 周四上午9点: <https://pic.icee.top/blog/pic_bed/2023/09/emis_23_9_20_周四上午9点.zip>

- 周四上午12点: <https://pic.icee.top/blog/pic_bed/2023/09/emis_23_9_20_周四上午12点.zip>



### 工具:

- POSTMAN(好像也不如APIfox): https://dl.pstmn.io/download/latest/win64
- JAVA中文报错: https://www.cnblogs.com/jayworld/p/8495174.html