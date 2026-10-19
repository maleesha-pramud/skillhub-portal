<%@ page contentType="text/html;charset=UTF-8" %>
<c:set var="pageTitle" value="${isNew ? 'Add' : 'Edit'} ${fn:toLowerCase(singular)}"/>
<c:set var="pageSubtitle" value="Account and contact details"/>
<c:set var="activeNav" value="${navKey}"/>
<%@ include file="/WEB-INF/jspf/header.jspf" %>

<div class="row justify-content-center">
<div class="col-xl-8">
    <c:if test="${not empty errors}">
        <div class="alert alert-danger flash-msg" role="alert">
            <strong>Please fix the following:</strong>
            <ul class="mb-0 mt-1 ps-3"><c:forEach var="e" items="${errors}"><li><c:out value="${e}"/></li></c:forEach></ul>
        </div>
    </c:if>

    <div class="card">
        <div class="card-header"><h3><c:out value="${pageTitle}"/></h3><a href="${ctx}${basePath}" class="btn btn-sm btn-light-border"><i class="bi bi-arrow-left me-1"></i>Back to list</a></div>
        <div class="card-body">
            <form method="post" action="${ctx}${basePath}" class="needs-validation" novalidate>
                <input type="hidden" name="_csrf" value="${sessionScope.csrfToken}">
                <input type="hidden" name="action" value="save">
                <input type="hidden" name="id" value="${person.id}">
                <div class="row g-3">
                    <div class="col-md-6">
                        <label class="form-label" for="fullName">Full name</label>
                        <input type="text" class="form-control" id="fullName" name="fullName" value="<c:out value='${person.fullName}'/>" required minlength="3" maxlength="60">
                        <div class="invalid-feedback">Enter a full name (3 to 60 characters).</div>
                    </div>
                    <div class="col-md-6">
                        <label class="form-label" for="username">Username</label>
                        <input type="text" class="form-control" id="username" name="username" value="<c:out value='${person.username}'/>" required pattern="[A-Za-z0-9._\-]{4,20}">
                        <div class="invalid-feedback">4 to 20 letters, numbers, . _ -</div>
                    </div>
                    <div class="col-md-6">
                        <label class="form-label" for="email">Email</label>
                        <input type="email" class="form-control" id="email" name="email" value="<c:out value='${person.email}'/>" required maxlength="100">
                        <div class="invalid-feedback">Enter a valid email address.</div>
                    </div>
                    <div class="col-md-6">
                        <label class="form-label" for="phone">Phone <span class="text-muted fw-normal">(optional)</span></label>
                        <input type="tel" class="form-control" id="phone" name="phone" value="<c:out value='${person.phone}'/>" maxlength="15" placeholder="+94 77 123 4567">
                    </div>
                    <div class="col-md-6">
                        <label class="form-label" for="password">Password</label>
                        <input type="password" class="form-control" id="password" name="password" autocomplete="new-password" minlength="8" ${isNew ? 'required' : ''}>
                        <div class="form-text">${isNew ? 'At least 8 characters with a letter and a number.' : 'Leave blank to keep the current password.'}</div>
                        <div class="invalid-feedback">Enter a password of at least 8 characters.</div>
                    </div>
                </div>
                <hr class="my-4">
                <div class="d-flex gap-2 justify-content-end">
                    <a href="${ctx}${basePath}" class="btn btn-light-border">Cancel</a>
                    <button type="submit" class="btn btn-primary"><i class="bi bi-check2 me-1"></i>Save ${fn:toLowerCase(singular)}</button>
                </div>
            </form>
        </div>
    </div>
</div>
</div>

<%@ include file="/WEB-INF/jspf/footer.jspf" %>
