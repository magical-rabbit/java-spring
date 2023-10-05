function loadDayiList() {
    const xhr = new XMLHttpRequest();
    xhr.open('GET', '../js/dayi-lib/list-template.html', true);
    xhr.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            document.getElementById('dayi-list').innerHTML = this.responseText;
        }
    };
    xhr.send();
}


function dayi_load_list2(){

}


function initializePageGrid(elementSelector, configOverrides) {
    var defaultConfig = {
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
            // ... 其他的字段配置不变 ...
        ]
    };

    // 使用jQuery的extend函数来合并和覆盖默认配置
    var finalConfig = $.extend(true, {}, defaultConfig, configOverrides);

    initializeJsGrid(elementSelector, finalConfig);
}