
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="commons/basePath.jsp"%>
<html>
<head>
    <title>测试</title>

</head>
<body>

<input type="button" id="btn1" value="查询所有">

<ul id="articles">

</ul>

<hr>
<input type="button" value="查单本书" id="btn2">
<div>
    <form id="form1">
        <p>书籍编号<input id="articleId" name="articleId" readonly></p>
        <p>书名<input id="title" name="title"></p>
        <p>评价<input id="content" name="content"></p>
        <p>作者id<input id="id" name="author.id"></p>
    </form>
    <input type="button" value="添加" id="btn3"><br>
    <input type="button" value="修改" id="btn4"><br>
    <input type="button" value="删除" id="btn5"><br>
</div>

<script >


    $(function () {
        $("#btn1").click(function () {
            $.ajax({
                url:"articles",
                type:"get",
                dataType:"json",
                success:function (data) {
                    $("#articles").empty()
                    $.each(data,function () {
                        var $li=$("<li>"+this.title+"</li>")
                        $("#articles").append($li)
                    })


                }
            })
        })

        $("#btn2").click(function () {
            $.ajax({
                url:"articles/1",
                type: "get",
                dataType: "json",
                success:function (data) {
                    if(data){
                        $("#title").val(data.title)
                        $("#articleId").val(data.articleId)
                        $("#content").val(data.content)
                        $("#id").val(data.author.id)
                    }else{
                        alert("没有您查询的书籍信息!")
                    }

                }
            })
        })

        $("#btn3").click(function () {
            $.ajax({
                url:"articles",
                type:"post",
                data:$("#form1").serialize(),
                dataType:"json",
                success:function (data) {
                    if(data.count==1){
                        alert("添加成功")
                    }else {
                        alert("添加失败")
                    }
                }
            })
        })

        $("#btn5").click(function () {
            $.ajax({
                url:"articles/5",
                type:"delete",
                dataType:"json",
                success:function (data) {
                    if(data.count==1){
                        alert("删除成功")
                    }else {
                        alert("删除失败")
                    }
                }
            })
        })


        $("#btn4").click(function () {
            let obj={_method:"put",title:$("#title").val(),content:$("#content").val(),'author.id':$("#id").val()}

            $.ajax({
                url:"articles/"+$("#articleId").val(),
                type:"post",
                data:obj,
                dataType:"json",
                success:function (data) {
                    if(data.count==1){
                        alert("修改成功")
                    }else {
                        alert("修改失败")
                    }
                }
            })
        })

    })
</script>

</body>
</html>
