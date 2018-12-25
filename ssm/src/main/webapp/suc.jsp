
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图片</title>
    <%@include file="commons/basePath.jsp"%>
</head>
<body>
   <div>
       <img src="imgs/${fileName}">
       <p><a href="download?fileName=${fileName}">点击下载</a></p>
   </div>

</body>
</html>
