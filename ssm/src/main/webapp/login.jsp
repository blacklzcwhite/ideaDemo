
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <%@include file="commons/basePath.jsp"%>
</head>
<body>
<form action="user/login" method="post">
    <p>用户:<input name="userName"/></p>
    <p>密码:<input name="pwd" type="password"/></p>
    <p><input type="submit" value="登录"/></p>
    <a href="reg.html">注册</a>
    <p style="color: red">${msg}</p>
</form>

<input type="button" id="btn1" value="查单个">

<script>
    $(function () {
        $("#btn1").click(function () {
            $.ajax({
                url:"users/1",
                type:"get",
                dataType:"json",
                success:function (data) {
                     if(data){
                         var $li=$("<li>"+this.username+"</li>"+
                             "<li>"+this.userId+"</li>")
                         $("#btn1").append($li)
                     }else{
                         alert("查询失败")
                     }


                }
            })
        })
    })
</script>



</body>
</html>
