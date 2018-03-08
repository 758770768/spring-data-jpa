<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<!-- jstl循环显示商品数据表格 -->
<body>
<!-- action不写默认找自己即是list -->
   <form action="list">
   <!-- 产品分类信息下拉列表加载 -->
    <select name="cid">
     <option value="">--亲选择--</option>    
     <c:forEach items="${cl}" var="ca">
      <option value="${ca.cid}" ${ca.cid==cid?"selected":""}>${ca.cname}</option>
     </c:forEach>
    
    </select>
     pname:<input type="text"  name="pname" value="${empty pname?"":pname}"/>
     排序方式:
     <input type="radio" name="order" value="desc"/>降序
     <input type="radio" name="order" value="asc"/>升序
     <input type="submit"  value="查询"/>
   </form>

	<table border="1">
		<tr>
			<td>pid</td>
			<td>pname</td>
			<td>pmess</td>
			<td>pprice</td>
			<td>cname</td>
		</tr>
		<c:forEach items="${ps}" var="product">
			<tr>
				<td>${product.pid}</td>
				<td>${product.pname}</td>
				<td>${product.pprice}</td>
				<td>${product.pmess}</td>
				<td>${product.catagory.cname}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>