<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body>

<h2>HTML Table</h2>

<table>
  <tr>
    <th>EMPLOYEE_ID</th>
    <th>FIRST_NAME</th>
    <th>LAST_NAME</th>
    <th>EMAIL</th>
    <th>Ops(Edit)</th>
    <th>Ops(Delete)</th>
  </tr>
  <c:forEach var="book" items="${list}">
                <tr>
                    <td><c:out value="${book.EMPLOYEE_ID}" /></td>
                    <td><c:out value="${book.FIRST_NAME}" /></td>
                    <td><c:out value="${book.LAST_NAME}" /></td>
                    <td><c:out value="${book.EMAIL}" /></td>
                    <td>
                    <a class='btn btn-success' href="editAlchemy.jsp?id=<c:out value='${book.EMPLOYEE_ID}' />">Update</a>
                     </td>
                     <td>
                      <a class='btn btn-warning' href="editAlchemy.jsp?id=<c:out value='${book.EMPLOYEE_ID}' />">Delete</a>
                    </td>
                </tr>
            </c:forEach>
</table>

</body>

<script>
function edit(id){
	alert('Supp'+id);
	var update = 'update'
	var data = {'id':id,'update':update};
    $.ajax({
        type: "GET",
        url: "./CreateAlchemy",
        data: data,
        success: function(data){

            alert("Request successful");
        },
        error: function (data){
            alert("sorry payment failed");
        }
    });
}
</script>
</html>
