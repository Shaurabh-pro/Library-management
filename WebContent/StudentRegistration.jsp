<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap.min.css"/>
</head>
<body>


<nav class="navbar navbar-inverse">
  <div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="index.html">Login</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <!-- <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="index.html" class="active">Home</a></li>
        <li><a href="#">Admin</a></li>
        <li><a href="#">Librarian</a></li>
       </ul>

    </div> --><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
  
</nav>

<div class="container-fluid">
<h1>Library</h1>

<div class="row">
  <div class="col-md-6">
  <h3>Registration here</h3>
  <form action="StudentRegistration" method="post" style="width:300px">
 <!--  <div class="form-group">
    <label for="id1">ID</label>
    <input type="text" class="form-control" name="id" id="id1" placeholder="id"/>
  </div> -->
  
 <div class="form-group">
  <label for="name1">Name</label>
  <input type="text" class="form-control" name="name" id="name1" placeholder="name"/>
</div>
  
  <div class="form-group">
    <label for="email1">Email</label>
    <input type="email" class="form-control" name="email" id="email1" placeholder="email"/>
  </div>
  
  
  <div class="form-group">
    <label for="password1">Password</label>
    <input type="password" class="form-control" name="password" id="password1" placeholder="Password"/>
  </div>
  
  <div class="form-group">
    <label for="contact1">Contact</label>
    <input type="text" class="form-control" name="contact" id="contact1" placeholder="contact"/>
  </div> 
  
  <div class="form-group">
    <label for="address1">Address</label>
    <input type="text" class="form-control" name="address" id="address1" placeholder="address"/>
  </div> 
    
  <button type="submit" class="btn btn-primary">Register</button>
  </div>
  </div>
  </div>




  <script src="jquery.min.js"></script>
  <script src="bootstrap.min.js"></script>

</body>
</html>