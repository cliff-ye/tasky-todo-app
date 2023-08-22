<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" />
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body >

<div class="login-modal">
	 <form action="<%=request.getContextPath()%>/login" method="post">
        <h1><img src="<%=request.getContextPath()%>/images/icons8_Checkmark_50px.png" alt="" /> login</h1>
        <div class="mb-3">
          <label for="Input1" class="form-label"
            >Username</label
          >
          <input
            type="text"
            class="form-control inputlook input--username"
            id="Input1"
            name="username"
            required
          />
        </div>

        <div class="mb-3">
          <label for="Input2" class="form-label"
            >Password</label
          >
          <input
            type="password"
            class="form-control inputlook input--password"
            id="Input2"
            name="password"
            required
          />
        </div>
        <div class="mb-3">
          <button type="submit" class="btn btn-primary btn--look ">
            Login
          </button>
        </div>
      </form>
      <p> Don't have an Account?<a href="signup.jsp">Sign up</a></p>
</div>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>

</body>
</html>