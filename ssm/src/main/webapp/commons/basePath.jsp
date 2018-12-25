
<%
	//获取当前请求的上下文路径
	//request:请求对象
	String path=request.getContextPath();
	//获取部署在服务器当前应用根目录的url
	String basePath=request.getScheme()+"://"
			+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<base href="<%=basePath%>">
<script src="js/jquery-3.3.1.min.js"></script>

