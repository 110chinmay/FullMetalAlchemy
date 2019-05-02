<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://unpkg.com/bootstrap-table@1.14.2/dist/bootstrap-table.min.js"></script>
  <link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.14.2/dist/bootstrap-table.min.css">
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

<h2 style = 'margin-left: 10px;'>Alchemy List</h2>
<button style = 'margin-bottom: 10px;margin-left: 10px;' class = 'btn btn-success' onclick = 'createAlLink()' >Create Alchemy</button>


<table id = 'table_data' data-height="460">
<thead>
  <tr>
    <th data-field="EMPLOYEE_ID">EMPLOYEE_ID</th>
    <th data-field="FIRST_NAME">FIRST_NAME</th>
    <th data-field="LAST_NAME">LAST_NAME</th>
    <th data-field="EMAIL">EMAIL</th>
    <th data-field="EMPLOYEE_ID">Ops(Edit)</th>
    <th data-field="EMPLOYEE_ID">Ops(Delete)</th>
  </tr>
</thead>

        <tr></tr>
</table>

</body>
<script>

$( document ).ready(function() {
	var list = 'list';
	var data = {'list':list};
	console.log(data);
    $.ajax({
        type: "GET",
        url: "./CreateAlchemy",
        data: data,
        success: function(data){
			/* console.log(data);
			 $('#table_data').bootstrapTable({
			        data: data
			    }); */

	 		var html = "<tbody>";


            for (var i=0;i<=(data.length-1);i++){

            	 html+="<tr>";
                 html+="<td>"+data[i].EMPLOYEE_ID+"</td>";
                 html+="<td>"+data[i].FIRST_NAME+"</td>";
                 html+="<td>"+data[i].LAST_NAME+"</td>";
                 html+="<td>"+data[i].EMAIL+"</td>";
                 html+="<td>"+"<button class='btn btn-primary' value='Update' onclick=\"(updateAlchemy('"+data[i].EMPLOYEE_ID+" '))\">Update</button>"+"</td>";
                 html+="<td>"+"<button class='btn btn-warning' value='Delete' onclick=\"(deleteAlchemy('"+data[i].EMPLOYEE_ID+" '))\">Delete</button>"+"</td>";
                 html+="</tr>";

             }
             html+="</tbody>";
             $("#table_data").append(html);

        },
        error: function (data){
            alert("Request failed!");
        }
    });
});


function updateAlchemy(EMPLOYEE_ID){
	location.href="editAlchemy.jsp?"+EMPLOYEE_ID+"";
}

function deleteAlchemy(EMPLOYEE_ID){
	var deletee = "delete";
	var data = {'EMPLOYEE_ID':EMPLOYEE_ID,'delete':deletee};
	  $.ajax({
		  type:"GET",
	       url: "./CreateAlchemy",
	        data: data,
	        success: function(data){
	            console.log(data);
	            location.href = "createAlchemyTable.jsp";
	        },
	        error: function (data){
	            alert("Request failed!");
	        }
	  });
}

function createAlLink(){
	location.href="CreateAlchemy.jsp";
}

</script>
</html>
