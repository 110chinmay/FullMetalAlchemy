<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<button style='margin-top:10px;' class = 'btn btn-success' onclick = 'List()'>Alchemy List</button>
  <h2>FullMetal Create</h2>
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
		 <button onclick="insert();" class="btn btn-primary">Submit</button>
		 <button onclick="Cancel();" class="btn btn-warning">Cancel</button>
	</div>
</div>
</body>
<script>


function insert(){
	  var fname=$('#Fname').val();
	  var lname=$('#Lname').val();
	  var email=$('#email').val();
	  var phone=$('#phone').val();

	  var data = {'fname':fname,'lname':lname,'email':email,'phone':phone};

	  $.ajax({
		  type:"POST",
	       url: "./CreateAlchemy",
	        data: data,
	        success: function(data){
	          location.href = "createAlchemyTable.jsp";
	        },
	        error: function (data){
	            alert("Request failed! some thing went wrong!!");
	        }
	  });

	  console.log(data);
}

function List(){
	location.href = 'createAlchemyTable.jsp';
}

function Cancel(){
	location.href='createAlchemyTable.jsp';
}


</script>
</html>