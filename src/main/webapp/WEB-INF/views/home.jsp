<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>
<!-- Carousel
================================================== -->
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img class="first-slide home-image" src="<c:url value="/resources/images/back1.jpg"/>" alt="First slide">
            <div class="container">
                <div class="carousel-caption">

                </div>
            </div>
        </div>
        <div class="item">
            <img class="second-slide home-image" src="<c:url value="/resources/images/back2.jpg"/>" alt="Second slide">
            <div class="container">
                <div class="carousel-caption">

                </div>
            </div>
        </div>
        <div class="item">
            <img class="third-slide home-image" src="<c:url value="/resources/images/back0.jpg"/>" alt="Third slide">
            <div class="container">
                <div class="carousel-caption">

                </div>
            </div>
        </div>
    </div>
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
<!-- /.carousel -->


<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all articleContenttent. -->

<div class="container marketing">

    <!-- Three columns of text below the carousel -->
    <div class="row">
        <c:forEach items="${articles}" var="article">

            <div class="col-lg-4">
                <img class="img-circle" src="<c:url value="/resources/images/article/${article.articleId}.png"/>"
                     alt="Generic placeholder image" width="140" height="140">
                <h2>${article.articleTitle}</h2>
                <p><a class="btn btn-default" href="<spring:url value="/article/viewArticle/${article.articleId}" />" role="button">View details &raquo;</a></p>
            </div>
            <!-- /.col-lg-4 -->
        </c:forEach>
    </div><!-- /.row -->

<%@include file="/WEB-INF/views/templates/footer.jsp" %>