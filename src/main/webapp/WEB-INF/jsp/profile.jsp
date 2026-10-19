<%@ page contentType="text/html;charset=UTF-8" %>
<c:set var="pageTitle" value="My Profile"/>
<c:set var="pageSubtitle" value="Update your details and review your session"/>
<c:set var="activeNav" value="profile"/>
<c:set var="fu" value="${empty formUser ? currentUser : formUser}"/>
<%@ include file="/WEB-INF/jspf/header.jspf" %>

<c:if test="${not empty errors}">
    <div class="alert alert-danger flash-msg" role="alert">
        <strong>Please fix the following:</strong>
        <ul class="mb-0 mt-1 ps-3"><c:forEach var="e" items="${errors}"><li><c:out value="${e}"/></li></c:forEach></ul>
    </div>
</c:if>

<div class="row g-4">
    <div class="col-lg-4">
        <div class="card mb-4">
            <div class="card-body text-center">
                <span class="avatar avatar-lg avatar-blue mb-3"><c:out value="${currentUser.initials}"/></span>
                <h3 class="h5 mb-1"><c:out value="${currentUser.fullName}"/></h3>
                <span class="badge-soft navy"><c:out value="${currentUser.role.label}"/></span>
                <ul class="mini-list text-start mt-3">
                    <li><span class="text-muted">Username</span><strong><c:out value="${currentUser.username}"/></strong></li>
                    <li><span class="text-muted">Member since</span><strong><c:out value="${currentUser.createdAt}"/></strong></li>
                </ul>
            </div>
        </div>
        <div class="card">
            <div class="card-header"><h3>Current session</h3></div>
            <div class="card-body">
                <ul class="mini-list small">
                    <li><span class="text-muted">Session ID</span><code><c:out value="${sessionIdShort}"/></code></li>
                    <li><span class="text-muted">Signed in</span><span><fmt:formatDate value="${sessionScope.loginTime}" pattern="dd MMM, HH:mm"/></span></li>
                    <li><span class="text-muted">Last activity</span><span><fmt:formatDate value="${sessionLastAccess}" pattern="dd MMM, HH:mm:ss"/></span></li>
                    <li><span class="text-muted">Pages viewed</span><strong><c:out value="${sessionScope.pageViews}"/></strong></li>
                    <li><span class="text-muted">Auto sign-out after</span><span><c:out value="${sessionTimeoutMinutes}"/> min idle</span></li>
                </ul>
            </div>
        </div>
    </div>

    <div class="col-lg-8">
        <div class="card mb-4">
            <div class="card-header"><h3>Personal details</h3></div>
            <div class="card-body">
                <form method="post" action="${ctx}/profile" class="needs-validation" novalidate>
                    <input type="hidden" name="_csrf" value="${sessionScope.csrfToken}">
                    <input type="hidden" name="action" value="profile">
                    <div class="row g-3">
                        <div class="col-md-6">
                            <label class="form-label" for="fullName">Full name</label>
                            <input type="text" class="form-control" id="fullName" name="fullName" value="<c:out value='${fu.fullName}'/>" required minlength="3" maxlength="60">
                        </div>
                        <div class="col-md-6">
                            <label class="form-label" for="username">Username</label>
                            <input type="text" class="form-control" id="username" value="<c:out value='${currentUser.username}'/>" disabled>
                        </div>
                        <div class="col-md-6">
                            <label class="form-label" for="email">Email</label>
                            <input type="email" class="form-control" id="email" name="email" value="<c:out value='${fu.email}'/>" required maxlength="100">
                        </div>
                        <div class="col-md-6">
                            <label class="form-label" for="phone">Phone</label>
                            <input type="tel" class="form-control" id="phone" name="phone" value="<c:out value='${fu.phone}'/>" maxlength="15" placeholder="+94 77 123 4567">
                        </div>
                    </div>
                    <div class="text-end mt-4"><button type="submit" class="btn btn-primary"><i class="bi bi-check2 me-1"></i>Save changes</button></div>
                </form>
            </div>
        </div>

        <div class="card">
            <div class="card-header"><h3>Change password</h3></div>
            <div class="card-body">
                <form method="post" action="${ctx}/profile" class="needs-validation" novalidate>
                    <input type="hidden" name="_csrf" value="${sessionScope.csrfToken}">
                    <input type="hidden" name="action" value="password">
                    <div class="row g-3">
                        <div class="col-12">
                            <label class="form-label" for="current">Current password</label>
                            <input type="password" class="form-control" id="current" name="current" required autocomplete="current-password">
                        </div>
                        <div class="col-md-6">
                            <label class="form-label" for="newPassword">New password</label>
                            <input type="password" class="form-control" id="newPassword" name="password" required minlength="8" autocomplete="new-password">
                            <div class="form-text">At least 8 characters with a letter and a number.</div>
                        </div>
                        <div class="col-md-6">
                            <label class="form-label" for="confirm">Confirm new password</label>
                            <input type="password" class="form-control" id="confirm" name="confirm" required data-match="#newPassword" autocomplete="new-password">
                            <div class="invalid-feedback">Passwords must match.</div>
                        </div>
                    </div>
                    <div class="text-end mt-4"><button type="submit" class="btn btn-navy"><i class="bi bi-key me-1"></i>Update password</button></div>
                </form>
            </div>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/jspf/footer.jspf" %>
