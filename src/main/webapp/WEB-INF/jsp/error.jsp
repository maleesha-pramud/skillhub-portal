<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="code" value="${requestScope['javax.servlet.error.status_code']}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="/WEB-INF/jspf/head.jspf" %>
    <title>Something went wrong | SkillHub Training Academy</title>
</head>
<body>
<div class="error-wrap">
    <div class="card text-center" style="max-width: 520px; width: 100%;">
        <div class="card-body p-5">
            <div class="error-code"><c:out value="${empty code ? 500 : code}"/></div>
            <c:choose>
                <c:when test="${code == 403}">
                    <h2 class="mt-3">Access denied</h2>
                    <p class="text-muted">You do not have permission to do that, or your security token has expired. Go back, reload the page and try again.</p>
                </c:when>
                <c:when test="${code == 404}">
                    <h2 class="mt-3">Page not found</h2>
                    <p class="text-muted">The page you are looking for does not exist or has been moved.</p>
                </c:when>
                <c:when test="${code == 400 || code == 405}">
                    <h2 class="mt-3">Request not accepted</h2>
                    <p class="text-muted">That request could not be processed.</p>
                </c:when>
                <c:otherwise>
                    <h2 class="mt-3">Something went wrong</h2>
                    <p class="text-muted">An unexpected error occurred. Please try again, or contact support if it continues.</p>
                </c:otherwise>
            </c:choose>
            <a class="btn btn-primary mt-2" href="${ctx}/dashboard"><i class="bi bi-house me-1"></i>Back to dashboard</a>
        </div>
    </div>
</div>
</body>
</html>
