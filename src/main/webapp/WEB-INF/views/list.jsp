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

                        <h5 class="card-title">Special title treatment</h5>
                        <button type="button" class="btn btn-primary float-end">게시글 작성</button>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">id</th>
                                    <th scope="col">title</th>
                                    <th scope="col">writer</th>
                                    <th scope="col">content</th>
                                    <th scope="col">createdAt</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${responseDto.articleDtoList}" var="articleDto">
                                <c:set var="i" value="${i+1}"/>
                                <tr>
                                    <th scope="row"><c:out value="${articleDto.id}"/> </th>
<%--                                    <th scope="row"><c:out value="${i}"/> </th>--%>
                                    <td><a href="/article/read?articleId=${articleDto.id}&page=${pageRequestDto.page}&size=${pageRequestDto.size}" class="text-decoration-none">
                                        <c:out value="${articleDto.title}"/></a></td>
                                    <td><c:out value="${articleDto.userDto.username}"/></td>
                                    <td><c:out value="${articleDto.content}"/></td>
                                    <td><c:out value="${articleDto.createdAt}"/></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>


                        <div class="d-flex justify-content-center">
                            <ul class="pagination flex-wrap">

                                <c:if test="${responseDto.prev}">
                                    <li class="page-item">
                                        <a class="page-link" data-num="${responseDto.startOnNavi-1}">이전</a>
                                    </li>
                                </c:if>

                                <c:forEach begin="${responseDto.startOnNavi}" end="${responseDto.endOnNavi}" var="num">

                                    <li class="page-item ${responseDto.page==num? "active":""}">
                                        <a class= "page-link" data-num="${num}">${num}</a>
                                    </li>
                                </c:forEach>

                                <c:if test="${responseDto.next}">
                                    <li class="page-item">
                                        <a class="page-link" data-num="${responseDto.endOnNavi+1}">다음</a>
                                    </li>
                                </c:if>
                            </ul>
                        </div>

                        <script>
                            document.querySelector(".pagination").addEventListener("click",function(e){
                                e.preventDefault()
                                e.stopPropagation()
                                const target= e.target
                                if(target.tagName !=='A'){
                                    return
                                }
                                const num=target.getAttribute("data-num")

                                self.location=`/article/list?page=\${num}`
                            },false)
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
<script>
    document.querySelector('.btn-primary').addEventListener("click",function(e){
        self.location='/article/register-form'
    },false)
</script>

</body>
</html>