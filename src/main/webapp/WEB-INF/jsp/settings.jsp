<%@ page contentType="text/html;charset=UTF-8" %>
<c:set var="pageTitle" value="Application Settings"/>
<c:set var="pageSubtitle" value="Configure the academy portal"/>
<c:set var="activeNav" value="settings"/>
<%@ include file="/WEB-INF/jspf/header.jspf" %>

<c:if test="${not empty errors}">
    <div class="alert alert-danger flash-msg" role="alert">
        <strong>Please fix the following:</strong>
        <ul class="mb-0 mt-1 ps-3"><c:forEach var="e" items="${errors}"><li><c:out value="${e}"/></li></c:forEach></ul>
    </div>
</c:if>

<div class="row g-4">
    <div class="col-lg-8">
        <div class="card">
            <div class="card-header"><h3>General</h3></div>
            <div class="card-body">
                <form method="post" action="${ctx}/admin/settings" class="needs-validation" novalidate>
                    <input type="hidden" name="_csrf" value="${sessionScope.csrfToken}">
                    <div class="row g-3">
                        <div class="col-12">
                            <label class="form-label" for="academyName">Academy name</label>
                            <input type="text" class="form-control" id="academyName" name="academyName" value="<c:out value='${applicationScope.academyName}'/>" required minlength="3" maxlength="60">
                        </div>
                        <div class="col-md-8">
                            <label class="form-label" for="supportEmail">Support email</label>
                            <input type="email" class="form-control" id="supportEmail" name="supportEmail" value="<c:out value='${applicationScope.supportEmail}'/>" required maxlength="100">
                        </div>
                        <div class="col-md-4">
                            <label class="form-label" for="defaultCapacity">Default class size</label>
                            <input type="number" class="form-control" id="defaultCapacity" name="defaultCapacity" value="${applicationScope.defaultCapacity}" min="1" max="500" required>
                        </div>
                        <div class="col-12">
                            <div class="form-check form-switch">
                                <input class="form-check-input" type="checkbox" role="switch" id="registrationOpen" name="registrationOpen" value="true" ${applicationScope.registrationOpen ? 'checked' : ''}>
                                <label class="form-check-label" for="registrationOpen">Allow students to register online</label>
                            </div>
                        </div>
                    </div>
                    <div class="text-end mt-4"><button type="submit" class="btn btn-primary"><i class="bi bi-check2 me-1"></i>Save settings</button></div>
                </form>
            </div>
        </div>
    </div>
    <div class="col-lg-4">
        <div class="card">
            <div class="card-body">
                <h3 class="h6">How these settings work</h3>
                <p class="text-muted small mb-0">Settings are held in the application scope (ServletContext) and start from the defaults in <code>web.xml</code>. Changes apply immediately for everyone, and reset to the defaults when the application restarts.</p>
            </div>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/jspf/footer.jspf" %>
