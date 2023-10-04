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
