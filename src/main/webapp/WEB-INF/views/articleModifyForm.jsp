<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

  <title>Hello, world!</title>
</head>
<body>

<div class="container-fluid">


  <div class="row">

    <!--    header대신 네비-->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="#">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Link</a>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                Dropdown
              </a>
              <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                <li><a class="dropdown-item" href="#">Action</a></li>
                <li><a class="dropdown-item" href="#">Another action</a></li>
                <li><hr class="dropdown-divider"></li>
                <li><a class="dropdown-item" href="#">Something else here</a></li>
              </ul>
            </li>
            <li class="nav-item">
              <a class="nav-link disabled">Disabled</a>
            </li>
          </ul>
          <form class="d-flex">
            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success" type="submit">Search</button>
          </form>
        </div>
      </div>
    </nav>
    <!--    <h1>Header</h1>-->

    <div class="row content">
      <div class="col">

        <!--        카드부분-->
        <div class="card">
          <div class="card-header">
            Featured
          </div>
          <div class="card-body">

          <form id="actionForm" action="/article/modify" method="post">
            <div class="input-group mb-3">
              <span class="input-group-text">aid</span>
              <input type="text" name="articleId" class="form-control"
                     value=<c:out value="${articleDto.id}"></c:out> readonly>
            </div>

            <div class="input-group mb-3">
              <span class="input-group-text">Title</span>
              <input type="text" name="title" class="form-control"
                     value='<c:out value="${articleDto.title}"></c:out>'>
            </div>

            <div class="input-group mb-3">
              <span class="input-group-text">writer</span>
              <input type="text" name="writer" class="form-control"
                     value=<c:out value="${articleDto.userDto.username}"></c:out> readonly>

              <input type="hidden" name="writerId" class="form-control"
                     value=<c:out value="${articleDto.userDto.id}"></c:out> >

            </div>

            <div class="input-group mb-3">
              <span class="input-group-text">content</span>
              <input type="text" name="content" class="form-control"
                     value=<c:out value="${articleDto.content}"></c:out> >
            </div>

            <div class="input-group mb-3">
              <span class="input-group-text">createdAt</span>
              <input type="text" name="createdAt" class="form-control"
                     value=<c:out value="${articleDto.createdAt}"></c:out> readonly>
            </div>
          </form>

            <script>
              const serverValidResult={}
              <c:forEach items="${errors}" var="error">
                serverValidResult['${error.getField()}']= '${error.defaultMessage}'
              </c:forEach>
              console.log(serverValidResult)
            </script>


            <div class="my-4">
              <div class="float-end">
                <button type="button" class="btn btn-danger">삭제</button>
                <button type="button" class="btn btn-primary">수정</button>
                <button type="button" class="btn btn-secondary">목록</button>
              </div>
            </div>


            <script>
              const formObj2 = document.querySelector("#actionForm");
              document.querySelector(".btn-primary").addEventListener("click",function(e){
                e.preventDefault()
                e.stopPropagation()
                formObj2.action="/article/modify"
                formObj2.method="post"
                formObj2.submit()
              },false)

              document.querySelector(".btn-secondary").addEventListener("click",function(e){
                self.location="/article/list";
              },false)

              const formObj=document.querySelector("#actionForm")
              document.querySelector(".btn-danger").addEventListener("click",function(e){

                e.preventDefault()
                e.stopPropagation()
                formObj.action="/article/remove"
                formObj.method="post"
                formObj.submit()
              },false);
            </script>


          </div>
        </div>


      </div>
    </div>

  </div>





  <div class="row content">
    <h1>Content</h1>
  </div>




  <div class="row footer">
    <div class="row fixed-bottom" style="z-index: -100">
      <footer class="py-1 my-1 ">
        <p class="text-center text-muted">
          Footer
        </p>
      </footer>

    </div>
    <!--    <h1>Footer</h1>-->
  </div>


</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>


</body>
</html>