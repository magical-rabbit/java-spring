// 初始化全局变量

async function load_page() {
    try {
        const response = await fetch('../js/dayi-lib/template/update.html');
        if (response.ok) {
            const html = await response.text();
            document.getElementById('content').innerHTML = html;
        } else {
            console.error('[dayi-lib-page]Failed to fetch the HTML:', response.status);
        }
    } catch (error) {
        console.error('[dayi-lib-load-page]An error occurred while fetching the HTML:', error);
    }
}



function get_data() {
    document.getElementById("card-body")
}


function toCamelCase(str) {
    return str.replace(/_([a-z])/g, function (match, letter) {
        return letter.toUpperCase();
    });
}

//获得表单数据
function collectFormData(parentElementSelector) {
    var formData = {};
    $(parentElementSelector).find('input, select').each(function() {
        var $this = $(this);
        if($this.attr('type') !== 'submit') {
            var camelCaseName = toCamelCase($this.attr('id'));
            formData[camelCaseName] = $this.val();
        }
    });
    return formData;
}


//发送到后端
function sendDataToBackend(endpoint, data, successCallback, errorCallback) {
    $.ajax({
        type: "post",
        url: endpoint,
        data: data,
        dataType: "json",
        success: function(response) {
            if(response.code === "200") {
                console.log("[dayi-lib]成功发送到后端，数据:");
                console.log(data)
                successCallback(response);
            } else {
                console.log("[dayi-lib-error]发送到后端失败，数据:"+data+"，错误码:"+response.code);
                errorCallback(response);
            }
        },
        error: function(response) {
            console.log("[dayi-lib-error]发送到后端失败，数据:");
            console.log(data)
            alert("[dayi-lib-error]后端炸啦！或者网络原因请求发送失败")
            errorCallback(response);
        }
    });
}


//提交数据
async function dayi_update_data(update_url){
    //表单数据获得
    form_data = collectFormData(".card-body")
    console.log("[dayi-lib]from_data:")
    console.log(form_data);

    // debugger
    //发送到后端
    sendDataToBackend(update_url, form_data, function(response) {alert("修改成功");}, function(response) {alert("修改失败");});
}

//生成表单
async function gen_html(form_arr,nowdata_id,update_url){
    // debugge
    const formContainer = document.getElementById("card-body");


    // 生成ID
    const div = document.createElement("div");
    div.classList.add("form-group");
    const label = document.createElement("label");
    label.setAttribute("for", "ID");
    label.textContent = "ID（信息不可修改，但是不给你隐藏，哼OVO）";
    const input = document.createElement("input");
    input.setAttribute("type", "text");
    input.setAttribute("id", "id");
    input.setAttribute("name", "id");
    input.setAttribute("class", "form-control");
    input.setAttribute("readonly", "readonly");
    input.value = nowdata_id;
    input.style.width = `${300}px`;
    div.appendChild(label);
    div.appendChild(input);
    formContainer.appendChild(div);
    // 生成ID

    form_arr.forEach(field => {
        if(field.name=="id"){
            //跳过ID
            return
        }

        const div = document.createElement("div");
        div.classList.add("form-group");
        const label = document.createElement("label");
        label.setAttribute("for", field.name);
        label.textContent = field.title;
        const input = document.createElement("input");
        input.setAttribute("type", field.type);
        input.setAttribute("id", field.name);
        input.setAttribute("name", field.name);
        input.setAttribute("class", "form-control");
        //提示词
        input.setAttribute("placeholder", `${field.title}`);
        input.style.width = `${field.width*4}px`;
        div.appendChild(label);
        div.appendChild(input);
        formContainer.appendChild(div);
    });

    const buttonDiv = document.createElement("div");
    buttonDiv.classList.add("form-group");

    const saveButton = document.createElement("button");
    saveButton.setAttribute("type", "button");
    saveButton.setAttribute("class", "btn btn-primary");
    saveButton.setAttribute("onclick", `dayi_update_data("${update_url}");`);
    saveButton.textContent = "保存";
    // saveButton.onclick = dayi_update_data;

    buttonDiv.appendChild(saveButton);
    formContainer.appendChild(buttonDiv);
    
}





async function dayi_update_init(form_arr,nowdata_id,update_url,successCallback,errorCallback) {
    //加载模板文件
    await load_page();
    // 获得表单数据
    // 应该手动生成表单
    // form_arr = [
    //     { title: "ID",name:"id", type: "text", width: 150 },
    //     { title: "用户名",name:"username", type: "text", width: 150 },
    //     { title: "真是姓名",name:"realName", type: "text", width: 150 },
    //     { title: "学号",name:"sno", type: "text", width: 150 }
    // ]
    // 生成前端
    await gen_html(form_arr,nowdata_id,update_url);
}


async function upup_(form_arr,now_id,update_url,tmp_arr){
    // load_page()
    await dayi_update_init(form_arr,now_id,update_url);
    await fillfill_(tmp_arr[now_id])
}


async function fillfill_(item){
    console.log("[dayi-lib]尝试自动回填数据..")
    for (var key in item) {
        if (item.hasOwnProperty(key)) {
            // 构造对应表单字段的ID
            var fieldId = "#" + key;
            // 检查表单中是否存在具有相同ID的元素
            if ($(fieldId).length) {
                // 如果存在，设置其值为相应属性的值
                $(fieldId).val(item[key]);
            }
        }
    }
    console.log("[dayi-lib]自动回填数据完成..(不一定成功）")
}

//删除

//使用:
// id , "/class/del"  , 两个回调函数
async function deldel_(id,del_url,successCallback,errorCallback) {
    console.log(`[dayi-lib]尝试删除数据.. ${id}`)
    data = {"id": id};
    $.ajax({
        type: "post",
        url: del_url,
        data: data,
        dataType: "json",
        success: function(response) {
            if(response.code === "200") {
                console.log("[dayi-lib]成功发送到后端，数据:");
                console.log(data)
                successCallback(response);
            } else {
                console.log("[dayi-lib-error]发送到后端失败，数据:"+data+"，错误码:"+response.code);
                errorCallback(response);
            }
        },
        error: function(response) {
            console.log("[dayi-lib-error]发送到后端失败，数据:");
            console.log(data)
            alert("[dayi-lib-error]后端炸啦！或者网络原因请求发送失败")
            errorCallback(response);
        }
    });
}