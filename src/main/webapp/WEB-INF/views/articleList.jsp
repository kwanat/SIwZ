<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/templates/header.jsp"%>

<script>
    $(document).ready(function() {
        var searchCondition = '${searchCondition}';

        $('.table').DataTable({
            "lengthMenu" : [[10,2,3,5,15,20,-1], [10,2,3,5,15,20,"All"]],
            "oSearch" : {"sSearch" : searchCondition}
        });
    });
</script>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Articles</h1>

            <p class="lead">Checkout all the awesome articles and news right now!</p>
        </div>

        <table id="pages" class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Photo Thumb</th>
                <th>Title</th>
                <th>Added on</th>
                <th></th>
            </tr>
            </thead>
            <c:forEach items="${articles}" var="article">
                <tr>
                    <td><img src="<c:url value="/resources/images/article/${article.articleId}.png" />"
                             alt="image" style="width:30%" /></td>
                    <td>${article.articleTitle}</td>
                    <td>${article.articleDate}</td>
                    <td><a href="<spring:url value="/product/viewProduct/${article.articleId}" />">
                        <span class="glyphicon glyphicon-info-sign"></span></a>
                    </td>
                </tr>
            </c:forEach>
        </table>

<%@include file="/WEB-INF/views/templates/footer.jsp"%>