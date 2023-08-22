<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" />
<meta charset="ISO-8859-1">
<title>todo list</title>
</head>
<body>
 <div class="mainDiv">
      <header class="header">
        <nav id="main-navbar" class="navbar navbar-dark navbar-expand-md">
          <div class="container-fluid">
            <a class="navbar-brand ms-5" href="#"
              ><img src="<%=request.getContextPath()%>/images/icons8_Checkmark_50px.png" alt="" />
              <span>tasky</span></a
            >

            <button
              class="navbar-toggler"
              type="button"
              data-bs-toggle="collapse"
              data-bs-target="#navbarNavAltMarkup"
              aria-controls="navbarNav"
              aria-expanded="false"
              aria-label="Toggle navigation"
            >
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
              <div class="navbar-nav ms-auto">
                <a class="nav-link active" aria-current="page" href="index.jsp">
                  <img
                    src="<%=request.getContextPath()%>/images/icons8_home_20px.png"
                    alt="home icon"
                    class="rounded-circle"
                  />
                  <span id="labelName">Home | </span>
                </a>
                 <a class="nav-link active" aria-current="page" href="#">
                  <img
                    src="<%=request.getContextPath()%>/images/icons8_user_20px.png"
                    alt="Profile"
                    class="rounded-circle"
                  />
                  <span id="labelName"><%=request.getAttribute("username") %></span>
                </a>
              </div>
              <div class="d-flex ms-auto" role="search">
                <button id="logout-btn" class="btn btn-primary btn--look" type="Login">
                  <a href="<%=request.getContextPath()%>/view/login.jsp"> Logout</a>
                </button>
              </div>
            </div>
          </div>
        </nav>
        
       <div class="main-modal cust-main">
       <button class="add--item btn--look"><img src="<%=request.getContextPath()%>/images/icons8_xbox_cross_20px.png"/>Add task</button>
       <h1>tasks</h1>
       <table class="table">
  <thead>
    <tr>
      <th >Title</th>
      <th >Date</th>
      <th >Status</th>
      <th >Actions</th>
    </tr>
  </thead>
  <tbody>
  	<c:forEach var="todoItem" items="${todoList}">
    <tr>
      <th><c:out value="${todoItem.title}"> </c:out></th>
      <td><c:out value="${todoItem.targetDate}"></c:out></td>
      <td><c:out value="${todoItem.isDone}"></c:out></td>
      <td><a href="delete?id=<c:out value='${todoItem.id }'/>&username=<c:out value='${username}'/>"> Delete</a></td>
    </tr>
	</c:forEach>
    
  </tbody>
</table>
</div>

<div class="additem-modal trim cust-additem-modal hidden">
	 <form action="<%=request.getContextPath()%>/insert?username=<c:out value='${username}'/>" method="post">
        <h1><img src="<%=request.getContextPath()%>/images/icons8_Checkmark_50px.png" alt="" /> Add task</h1>
        <div class="mb-3">
          <label for="Input1" class="form-label"
            >Title</label
          >
          <input
            type="text"
            class="form-control inputlook "
            id="Input1"
            name="title"
            required
            minlength="7"
          />
        </div>

        <div class="mb-3">
          <label for="Input2" class="form-label"
            >Status</label
          >
          <select
            class="form-control inputlook"
            id="Input2"
            name="isDone">
            <option value="false">Active</option>
            <option value="true"> Completed </option>
          </select>
        </div>
        
        <div class="mb-3">
          <label for="Input3" class="form-label"
            >Date</label
          >
          <input
            type="date"
            class="form-control inputlook"
            id="Input3"
            name="targetDate"
            requred
          />
          
          
        </div>
        
        
        <div class="mb-3">
          <button type="submit" class="btn btn-primary btn--look ">
            Add task
          </button>
        </div>
      </form>
      
</div>
        
</header>
</div>
       
 <div class="overlay hidden"></div> 
        

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
<script src="<%=request.getContextPath()%>/js/scripts.js"></script>
</body>
</html>