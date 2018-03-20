<!doctype html>
<html lang="en">
<head>
    <script>
        $(function () {
            $("#regist").click(function () {
                $.ajax({
                    type: "post",
                    url: "/regist",
                    data:{"userName":$("#userName").val(),
                          "mobileNo":$("#mobile").val(),
                          "password":$("#password").val()},
                    error: function (request) {
                        $.alert("注册异常！", "注册");
                    },
                    success: function (data) {
                        if (data.status==200) {
                            $.alert("注册成功！", "注册");
                            location.href="/gologin"
                        }
                        else {
                            $.alert(data.msg, "注册");
                        }
                    }
                });
            });
        })
    </script>
</head>
<body>
<div class="weui-cells weui-cells_form">
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">账号：</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" type="number" id="userName" name="userName" placeholder="请输入账号">
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">手机：</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" type="number" id="mobile" name="mobileNo" pattern="[0-9]*" placeholder="请输入手机号">
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">密码：</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" type="password" id="password" name="password"  placeholder="请输入密码">
        </div>
    </div>
    <a href="javascript:void(0);" id="regist" class="weui-btn weui-btn_primary">注册</a>
</div>
</body>
</html>