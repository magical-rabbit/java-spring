//存放当前列表数据的数组
dayi_tmp_arr = {};


function loadDayiList() {
    // const xhr = new XMLHttpRequest();
    // // xhr.open('GET', '../js/dayi-lib/list-template.html', true);
    // xhr.onreadystatechange = function() {
    //     if (this.readyState === 4 && this.status === 200) {
    //         document.getElementById('dayi-list').innerHTML = this.responseText;
    //     }
    // };
    // xhr.send();
}


function dayi_load_list(fields=[{ title: "ID",name:"id", type: "text", width: 150 }],post_url="/user/list",object_="#jsGrid1",pageSize=3){
    initializePageGrid(fields,post_url,object_,pageSize)
}


function initializePageGrid(fields=[{ title: "ID",name:"id", type: "text", width: 150 }],post_url="/user/list",object_="#jsGrid1",pageSize=3) {
    const jsgrid = document.getElementById("jsGrid1")

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
                filter["search"] = $("#search").val();
                return $.ajax({
                    type: "post",
                    url: post_url,
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
        fields: fields
    })
}