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
