<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/templates/header.jsp"%>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h2>Add Article</h2>
            <p class="lead">Fill the below information to add an Article:</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/warehouseMaster/articleInventory/article/addArticle"
                   method="post"
                   commandName="article" enctype="multipart/form-data">
        <div class="form-group">
            <label for="name">Title</label><form:errors path="articleTitle" cssStyle="color:#ff0000" />
            <form:input path="articleTitle" id="name" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="articleContent">Content</label>
            <form:textarea path="articleContent" id="articleContent" class="form-Control" />
        </div>
        <div class="form-group">
            <label class="control-label" for="articleImage">Upload Picture</label>
            <form:input id="articleImage" path="articleImage" type="file" class="form:input-large" />
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <form:input type="hidden" path="articleDate" id="articleDate" class="form-Control" value=""/>
        <br>
        <input type="submit" value="submit" class="btn btn-default">
        <a href="<c:url value="/warehouseMaster/articleInventory" />" class="btn btn-default">Cancel</a>
        </form:form>

<%@include file="/WEB-INF/views/templates/footer.jsp"%>