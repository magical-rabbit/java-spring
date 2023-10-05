
// this_is => thisIs
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
            console.log("[dayi-lib-error]发送到后端失败，数据:"+data.tostring());
            alert("[dayi-lib-error]后端炸啦！或者网络原因请求发送失败")
            errorCallback(response);
        }
    });
}
