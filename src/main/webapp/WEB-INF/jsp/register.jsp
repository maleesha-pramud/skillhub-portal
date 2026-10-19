<%@ page contentType="text/html;charset=UTF-8" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="/WEB-INF/jspf/head.jspf" %>
    <title>Create account | <c:out value="${applicationScope.academyName}"/></title>
</head>
<body>
<div class="auth-wrap">
    <section class="auth-main">
        <div class="auth-card">
            <a class="brand auth-brand" href="${ctx}/login">
                <span class="brand-mark"><i class="bi bi-mortarboard-fill"></i></span>
                <span class="brand-text">SkillHub<small>Training Academy &middot; Colombo</small></span>
            </a>
            <h1>Create your account</h1>
            <p class="text-muted mb-4">Student registration</p>

            <c:if test="${not empty errors}">
                <div class="alert alert-danger flash-msg" role="alert">
                    <strong>Please fix the following:</strong>
                    <ul class="mb-0 mt-1 ps-3"><c:forEach var="e" items="${errors}"><li><c:out value="${e}"/></li></c:forEach></ul>
                </div>
            </c:if>

            <form method="post" action="${ctx}/register" class="needs-validation" novalidate>
                <input type="hidden" name="_csrf" value="${sessionScope.csrfToken}">
                <div class="mb-3">
                    <label class="form-label" for="fullName">Full name</label>
                    <input type="text" class="form-control" id="fullName" name="fullName" value="<c:out value='${formUser.fullName}'/>" required minlength="3" maxlength="60">
                    <div class="invalid-feedback">Enter your full name (3 to 60 characters).</div>
                </div>
                <div class="row g-3 mb-3">
                    <div class="col-sm-6">
                        <label class="form-label" for="username">Username</label>
                        <input type="text" class="form-control" id="username" name="username" value="<c:out value='${formUser.username}'/>" required pattern="[A-Za-z0-9._\-]{4,20}" autocomplete="username">
                        <div class="invalid-feedback">4 to 20 letters, numbers, . _ -</div>
                    </div>
                    <div class="col-sm-6">
                        <label class="form-label" for="phone">Phone <span class="text-muted fw-normal">(optional)</span></label>
                        <input type="tel" class="form-control" id="phone" name="phone" value="<c:out value='${formUser.phone}'/>" maxlength="15" placeholder="+94 77 123 4567">
                    </div>
                </div>
                <div class="mb-3">
                    <label class="form-label" for="email">Email</label>
                    <input type="email" class="form-control" id="email" name="email" value="<c:out value='${formUser.email}'/>" required maxlength="100">
                    <div class="invalid-feedback">Enter a valid email address.</div>
                </div>
                <div class="row g-3 mb-4">
                    <div class="col-sm-6">
                        <label class="form-label" for="password">Password</label>
                        <input type="password" class="form-control" id="password" name="password" required minlength="8" autocomplete="new-password">
                        <div class="form-text">At least 8 characters with a letter and a number.</div>
                    </div>
                    <div class="col-sm-6">
                        <label class="form-label" for="confirm">Confirm password</label>
                        <input type="password" class="form-control" id="confirm" name="confirm" required data-match="#password" autocomplete="new-password">
                        <div class="invalid-feedback">Passwords must match.</div>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary w-100 py-2"><i class="bi bi-person-plus me-1"></i>Create account</button>
            </form>
            <p class="text-center text-muted mt-4 mb-0">Already registered? <a href="${ctx}/login" class="fw-semibold">Sign in</a></p>
        </div>
    </section>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="${ctx}/assets/js/app.js"></script>
</body>
</html>
