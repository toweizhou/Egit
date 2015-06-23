<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'cart.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <a href="getAllGoods">继续购物</a>
    <table border="1">
    	<thead>
    		<tr>
    			<td>商品编号</td>
    			<td>商品名称</td>
    			<td>商品价格</td>
    			<td>商品数量</td>
    			<td></td>
    		</tr>
    	</thead>
     	<c:forEach items="${sessionScope.cart}" var="items">
     		<tr>
     		<form action="processCart" method="post">
     		<input type="hidden" name="goodsId" value="${items.goods.goodsId}"/>
     			<td>${items.goods.goodsId}</td>
     			<td>${items.goods.goodsName}</td>
     			<td>${items.goods.price}</td>
     			<td>${items.count}</td>
     			<td><input type="submit" name="action" value="修改"/>
     				<input type="submit" name="action" value="删除"/>
     			</td>
     		</form>
     		</tr>
     	</c:forEach>
    </table>



  </body>
</html>
