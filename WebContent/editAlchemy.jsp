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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <c:forEach var="updateResult" items="${list}">
  			<c:out value="${updateResult.EMPLOYEE_ID}" />
  			<c:out value="${updateResult.FIRST_NAME}" />
            </c:forEach>
<div class="container">
  <h2>FullMetal Update</h2>

  	<div class="row">
	  	<div class="col-sm-4">
	      <label for="Fname">FirstName:</label>
	      <input type="text" class="form-control" id="Fname" placeholder="Enter FirstName" name="Fname">
	    </div>
	    <div class="col-sm-4">
	      <label for="Lname">LastName:</label>
	      <input type="text" class="form-control" id="Lname" placeholder="Enter LastName" name="Lname">
	    </div>
  	</div>

  		<div class="row">
		  	<div class="col-sm-4">
		      <label for="email">Email:</label>
		      <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
		    </div>
		    <div class="col-sm-4">
		      <label for="phone">PHONE_NUMBER:</label>
		      <input type="text" class="form-control" id="phone" placeholder="Enter PhoneNumber" name="phone">
		    </div>
  		</div>
	<div class = 'row' style="margin-top: 15px;margin-left: 0px">
		 <button onclick="update();" class="btn btn-default">Submit</button>
	</div>

</div>
</body>
<script>

$( document ).ready(function() {

	var url = window.location.href;
	//console.log(url);
	var params;
	for (var i=0;i<url.length;i++) {
	    params = url[i].split("=");
	}
	var id = params[0];
	var fetch = 'fetch';
	var data = {'id':id,'fetch':fetch};
	console.log(data);
    $.ajax({
        type: "GET",
        url: "./CreateAlchemy",
        data: data,
        success: function(data){
      //      alert("Request successful");
            console.log(data);
            $('#Fname').val(data.FIRST_NAME);
            $('#Lname').val(data.LAST_NAME);
            $('#email').val(data.EMAIL);
            $('#phone').val(data.PHONE_NUMBER);

        },
        error: function (data){
            alert("Request failed!");
        }
    });
});


function update(){
	  var update = "update";
		var url = window.location.href;
		//console.log(url);
		var params;
		for (var i=0;i<url.length;i++) {
		    params = url[i].split("=");
		}
		var id = params[0];
	  var fname=$('#Fname').val();
	  var lname=$('#Lname').val();
	  var email=$('#email').val();
	  var phone=$('#phone').val();
	  
	  var data = {'update':update,'id':id,'fname':fname,'lname':lname,'email':email,'phone':phone};
	  
	  $.ajax({
		  type:"POST",
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

	  console.log(data);
}
</script>
</html>