<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/templates/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>${article.articleTitle}</h1>
        </div>

        <div class="container" ng-app = "cartApp">
            <div>
                <div class="col-md-5">
                    <img src="<c:url value="/resources/images/article/${article.articleId}.png" />"
                         alt="image" style="width:100%" />
                </div>
                <div class="col-md-5">
                    <p>Added on: ${article.articleDate}</p>
                    <p>${article.articleContent}</p>
                    <br>
                </div>
            </div>
        </div>
<%@include file="/WEB-INF/views/templates/footer.jsp"%>