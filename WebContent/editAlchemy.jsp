<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
  <h2>FullMetal Create</h2>
  <form action="./CreateAlchemy" method="post">
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
		      <label for="pwd">Password:</label>
		      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
		    </div>
  		</div>

  		<div class="row">
		  	<div class="col-sm-4">
		  		<div>
		  			<label>Languages Known:</label>
			        <div class="checkbox">
				      <label><input type="checkbox" value="English">English</label>
				    </div>
				    <div class="checkbox">
				      <label><input type="checkbox" value="Marathi">Marathi</label>
				    </div>
				    <div class="checkbox">
				      <label><input type="checkbox" value="Hindi">Hindi</label>
				    </div>
			    </div>
		    </div>
		    <div class="col-sm-4">
		    <label>Gender:</label>
		       <div class="radio">
      				<label><input type="radio" name="optradio">Male</label>
    			</div>
    			<div class="radio">
      				<label><input type="radio" name="optradio">Female</label>
    			</div>
		    </div>
  		</div>

  		<div class="row">
		  	<div class="col-sm-4">
		     	<label for="sel1">Select list (select one):</label>
			      <select class="form-control" id="sel1">
			        <option>1</option>
			        <option>2</option>
			        <option>3</option>
			        <option>4</option>
			      </select>
		    </div>
  		</div>
	<div class = 'row' style="margin-top: 15px;margin-left: 0px">
		 <button type="submit" class="btn btn-default">Submit</button>
	</div>

  </form>
</div>
</body>
</html>