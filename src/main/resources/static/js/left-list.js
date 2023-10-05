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
