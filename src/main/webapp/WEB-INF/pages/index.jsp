<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
  <h3><a href="/developer">Add Developer</a></h3>
  <table border="3">
  <c:forEach var="book" items="${books}">
   <tr>
       <td>
           ${book.id}
       </td>
       <td>
            ${book.title}
       </td>
       <td>
           ${book.description}
       </td>
       <td>
               ${book.isbn}
       </td>
   </tr>
  </c:forEach>
  </table>
</body>

</html>
