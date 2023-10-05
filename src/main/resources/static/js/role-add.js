$(function(){
    $.ajax({
        "type" : "POST",
        "url" : "/emis/menu/tree.do",
        "dataType" : "json",
        "success" : function(data){
            loadMenuTree(data);
        }
    });
});

var loadMenuTree = function(zNodes){
    var zTreeObj;//zTree对象
    // zTree 的参数配置
    var setting = {
        view: {
            selectedMulti: true, //设置是否能够同时选中多个节点
            showIcon: true,  //设置是否显示节点图标
            showLine: true,  //设置是否显示节点与节点之间的连线
            showTitle: true,  //设置是否显示节点的title提示信息
        },
        data: {
            simpleData: {
                enable: true, //设置是否启用简单数据格式（zTree支持标准数据格式跟简单数据格式）
                idKey: "id",  //设置启用简单数据格式时id对应的属性名称
                pIdKey: "parentId",//设置启用简单数据格式时parentId对应的属性名称,ztree根据id及pId层级关系构建树结构
                rootPId: "0"
            },
            key: { // 当要组装树的数据的json结构与当前设置的不相符的时候，可以通过这里设置映射关系
                // 在ztree节点展示中，节点的name属性的值从数据中的menuName对应的值获取
                name: "menuName"
            }
        },
        check:{
            enable: true   //设置是否显示checkbox复选框
        }
    };
    zTreeObj = $.fn.zTree.init($("#menuTree"), setting, zNodes);
}

var getCheckedMenuIds = function(){
    var treeObj = $.fn.zTree.getZTreeObj("menuTree");
    var nodes = treeObj.getCheckedNodes(true);

    var ids = "";
    $.each(nodes, function(index, node){
        ids += "," + node.id;
    });
    ids = ids.substring(1, ids.length);
    return ids;
}