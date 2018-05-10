<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/5/10
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>修改商品信息</title>
</head>
<body>
<form id="itemForm" action="${pageContext.request.contextPath}/itemUpdate.action" method="post">
    <input type="hidden" name="items.id" value="${item.id}"/>修改商品信息:
    <table width="100%" border="1">
        <tr>
            <td>商品名称</td>
            <td><input type="text" name="items.name" value="${item.name}"></td>
        </tr>
        <tr>
            <td>商品价格</td>
            <td><input type="text" name="items.price" value="${item.price}"></td>
        </tr>
        <tr>
            <td>商品生产日期</td>
            <td><input type="text" name="createtime"
                       value="<fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>"></td>
        </tr>

 <%--       <tr>
            <td>商品图片</td>
            <td>
                <c:if test="${item.pic!=null}">
                    <img src="/pic/${item.pic}" width="100" height="100"/>
                    <br/>

                </c:if>
                <input type="file" name="pictureFile">
            </td>
        </tr>--%>

        <tr>
            <td>商品简介</td>
            <td><textarea rows=" 3" cols="30" name="items.detail">${item.detail}</textarea></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="提交"/> </td>
        </tr>

    </table>

</form>

</body>
</html>