<%@ page contentType="text/html;charset=UTF-8" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="/WEB-INF/jspf/head.jspf" %>
    <title>Sign in | <c:out value="${applicationScope.academyName}"/></title>
</head>
<body>
<div class="auth-wrap">
    <section class="auth-main">
        <div class="auth-card">
            <a class="brand auth-brand" href="${ctx}/login">
                <span class="brand-mark"><i class="bi bi-mortarboard-fill"></i></span>
                <span class="brand-text">SkillHub<small>Training Academy &middot; Colombo</small></span>
            </a>
            <span class="greeting">Ayubowan &middot; வணக்கம் &middot; Welcome</span>
            <h1>Welcome back</h1>
            <p class="text-muted mb-4">Sign in to continue to your dashboard.</p>

            <%@ include file="/WEB-INF/jspf/flash.jspf" %>
            <c:if test="${not empty error}">
                <div class="alert alert-danger flash-msg" role="alert"><i class="bi bi-exclamation-octagon-fill me-2"></i><c:out value="${error}"/></div>
            </c:if>

            <form method="post" action="${ctx}/login" class="needs-validation" novalidate>
                <input type="hidden" name="_csrf" value="${sessionScope.csrfToken}">
                <div class="mb-3">
                    <label class="form-label" for="username">Username</label>
                    <input type="text" class="form-control" id="username" name="username" value="<c:out value='${username}'/>"
                           required maxlength="20" autocomplete="username" autofocus>
                    <div class="invalid-feedback">Please enter your username.</div>
                </div>
                <div class="mb-4">
                    <label class="form-label" for="password">Password</label>
                    <div class="input-group">
                        <input type="password" class="form-control" id="password" name="password" required autocomplete="current-password">
                        <button class="btn btn-light-border" type="button" data-toggle-password="#password" aria-label="Show password"><i class="bi bi-eye"></i></button>
                        <div class="invalid-feedback">Please enter your password.</div>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary w-100 py-2"><i class="bi bi-box-arrow-in-right me-1"></i>Sign in</button>
            </form>

            <c:if test="${applicationScope.registrationOpen}">
                <p class="text-center text-muted mt-4 mb-0">New student? <a href="${ctx}/register" class="fw-semibold">Create an account</a></p>
            </c:if>

            <div class="demo-box mt-4">
                <strong><i class="bi bi-key me-1"></i>Demo accounts</strong>
                <div class="mt-2">Admin: <code>nuwan</code> / <code>Nuwan@2026</code></div>
                <div>Trainer: <code>dilani</code> / <code>Dilani@2026</code></div>
                <div>Student: <code>kasun</code> / <code>Kasun@2026</code></div>
            </div>
        </div>
    </section>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="${ctx}/assets/js/app.js"></script>
</body>
</html>
