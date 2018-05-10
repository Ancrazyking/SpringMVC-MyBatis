<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/5/10
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>查询商品列表</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/item/queryitem.action" method="post">
    查询条件:
    <table width="100%" border="1">
        <tr>
            <td><iput type="submit" value="查询"/></td>
        </tr>
    </table>
    商品列表:
    <table width="100%" border="1">
        <tr>
            <td>商品名称</td>
            <td>商品价格</td>
            <td>生产日期</td>
            <td>商品描述</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${itemList}" var="item">
            <tr>
                <td>${item.name}</td>
                <td>${item.price}</td>
                <td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>${item.detail }</td>
            </tr>
            <td><a href="${pageContext.request.contextPath}/item/itemEdit.action?id=${item.id}">修改</a></td>
        </c:forEach>
    </table>
</form>
</body>
</html>
