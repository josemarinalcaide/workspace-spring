<%@ page isELIgnored="false" %>
<%@ taglib prefix="spring" 	uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" 	uri="http://java.sun.com/jsp/jstl/fmt" 	%>

<html>
  <head><title><spring:message code="message.title"/></title></head>
  <body>
    <h1><spring:message code="message.hello"/></h1>
    <p><spring:message code="message.now"/> <c:out value="${now}"/></p>
    <h3>Products</h3>
    <c:forEach items="${model.productList}" var="product">
    	<c:out value="${product.description}"/> <i>$<c:out value="${product.price}"/></i><br/>
    </c:forEach>
  </body>
</html>