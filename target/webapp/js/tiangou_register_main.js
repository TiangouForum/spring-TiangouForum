function checkForm() {
    var username = $('#userregnam').val();
    var password = $('#userpasswd').val();
    $.ajax({
        type: 'GET',//提交方式 post 或者get
        url: '/user/register.action?userregnam=' + username + '&userpasswd=' + password,
        complete: function (XMLHttpRequest, textStatus) {
            // 通过XMLHttpRequest取得响应头
            if (XMLHttpRequest.readyState == '4' && XMLHttpRequest.status == '200') {
                if (null != XMLHttpRequest.getResponseHeader("Location") && "" != XMLHttpRequest.getResponseHeader("Location")) {
                    window.location.href = XMLHttpRequest.getResponseHeader("Location");
                } else {
                    window.location.href = "/html/regFail.html";
                }
            }

        },
        error: function () {
            alert("fail!!!!!");
        }
    });
}