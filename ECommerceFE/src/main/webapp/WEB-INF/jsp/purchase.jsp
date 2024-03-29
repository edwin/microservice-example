<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>My Ecommerce</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/static/css/shop-homepage.css" rel="stylesheet">

    <!-- icon -->
    <link rel="shortcut icon" href="https://www.redhat.com/profiles/rh/themes/redhatdotcom/favicon.ico" type="image/x-icon" />

</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/">RedHat Store</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.request.contextPath}/">Home
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Page Content -->
<div class="container">

    <div class="row">

        <div class="col-lg-3">

            <h1 class="my-4">
                <img src="https://www.redhat.com/cms/managed-files/styles/xlarge/s3/red-hat-logo-c-sample_1.png?itok=P_8HYEng" width="100%" />
            </h1>
            <div class="list-group">
                <div class="list-group-item" style="background-color: #6c757d;color: white;">Nearest Store</div>
                <c:forEach items="${locations}" var="item">
                    <a href="#" class="list-group-item">${item}</a>
                </c:forEach>
            </div>

        </div>
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">

            <br />

            <div class="row">

                <div class="col-lg-12 col-md-6 mb-4">
                    <div class="card h-100">
                        <a href="#"><img class="card-img-top" src="https://picsum.photos/700/400?random=${item.productId}" alt=""></a>
                        <div class="card-body">
                            <h4 class="card-title">
                                ${item.productName}
                            </h4>
                            <h5>$24.99</h5>
                            <p class="card-text">${item.productDescription}</p>
                        </div>
                        <div class="card-footer">
                            <c:if test="${empty error }" >
                                <span class="badge badge-success">Purchase Success</span>
                            </c:if>
                            <c:if test="${not empty error }" >
                                <span class="badge badge-danger">Purchase Fail</span>
                                <small class="text-muted">Error Code : ${error}</small>
                            </c:if>
                        </div>
                    </div>
                </div>

            </div>
            <!-- /.row -->

        </div>
        <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->

</div>
<!-- /.container -->

<!-- Footer -->
<footer class="py-5 bg-dark">
    <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; RedHat 2019</p>
    </div>
    <!-- /.container -->
</footer>

<!-- Bootstrap core JavaScript -->
<script src="${pageContext.request.contextPath}/static/vendor/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>