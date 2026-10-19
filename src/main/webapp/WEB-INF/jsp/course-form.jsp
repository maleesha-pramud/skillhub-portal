<%@ page contentType="text/html;charset=UTF-8" %>
<c:set var="pageTitle" value="${course.id == 0 ? 'Add course' : 'Edit course'}"/>
<c:set var="pageSubtitle" value="Course details and capacity"/>
<c:set var="activeNav" value="courses"/>
<%@ include file="/WEB-INF/jspf/header.jspf" %>

<div class="row justify-content-center">
<div class="col-xl-9">
    <c:if test="${not empty errors}">
        <div class="alert alert-danger flash-msg" role="alert">
            <strong>Please fix the following:</strong>
            <ul class="mb-0 mt-1 ps-3"><c:forEach var="e" items="${errors}"><li><c:out value="${e}"/></li></c:forEach></ul>
        </div>
    </c:if>

    <div class="card">
        <div class="card-header"><h3><c:out value="${pageTitle}"/></h3><a href="${ctx}/courses" class="btn btn-sm btn-light-border"><i class="bi bi-arrow-left me-1"></i>Back to courses</a></div>
        <div class="card-body">
            <form method="post" action="${ctx}/courses" class="needs-validation" novalidate>
                <input type="hidden" name="_csrf" value="${sessionScope.csrfToken}">
                <input type="hidden" name="id" value="${course.id}">
                <div class="row g-3">
                    <div class="col-md-4">
                        <label class="form-label" for="code">Course code</label>
                        <input type="text" class="form-control" id="code" name="code" value="<c:out value='${course.code}'/>" required pattern="[A-Za-z0-9]{4,10}" maxlength="10">
                        <div class="invalid-feedback">4 to 10 letters or numbers.</div>
                    </div>
                    <div class="col-md-8">
                        <label class="form-label" for="title">Title</label>
                        <input type="text" class="form-control" id="title" name="title" value="<c:out value='${course.title}'/>" required minlength="3" maxlength="80">
                        <div class="invalid-feedback">Enter a title (3 to 80 characters).</div>
                    </div>
                    <div class="col-md-6">
                        <label class="form-label" for="category">Category</label>
                        <select class="form-select" id="category" name="category" required>
                            <option value="">Choose a category</option>
                            <c:forEach var="cat" items="${categories}"><option value="${cat}" ${cat == course.category ? 'selected' : ''}>${cat}</option></c:forEach>
                        </select>
                        <div class="invalid-feedback">Please choose a category.</div>
                    </div>
                    <div class="col-md-6">
                        <label class="form-label" for="trainerId">Trainer</label>
                        <select class="form-select" id="trainerId" name="trainerId" required>
                            <option value="">Assign a trainer</option>
                            <c:forEach var="t" items="${trainers}"><option value="${t.id}" ${t.id == course.trainerId ? 'selected' : ''}><c:out value="${t.fullName}"/></option></c:forEach>
                        </select>
                        <div class="invalid-feedback">Please assign a trainer.</div>
                    </div>
                    <div class="col-md-4">
                        <label class="form-label" for="durationWeeks">Duration (weeks)</label>
                        <input type="number" class="form-control" id="durationWeeks" name="durationWeeks" value="${course.durationWeeks}" min="1" max="52" required>
                    </div>
                    <div class="col-md-4">
                        <label class="form-label" for="capacity">Capacity (seats)</label>
                        <input type="number" class="form-control" id="capacity" name="capacity" value="${course.capacity}" min="1" max="500" required>
                    </div>
                    <div class="col-md-4">
                        <label class="form-label" for="fee">Fee (LKR)</label>
                        <input type="number" class="form-control" id="fee" name="fee" value="${course.fee > 0 ? course.fee : ''}" min="0" step="1" required>
                    </div>
                    <div class="col-12">
                        <label class="form-label" for="schedule">Schedule</label>
                        <input type="text" class="form-control" id="schedule" name="schedule" value="<c:out value='${course.schedule}'/>" required maxlength="80" placeholder="e.g. Sat, 9:00 AM - 1:00 PM (Colombo 03)">
                    </div>
                    <div class="col-12">
                        <label class="form-label" for="description">Description</label>
                        <textarea class="form-control" id="description" name="description" rows="3" maxlength="300"><c:out value="${course.description}"/></textarea>
                        <div class="form-text">Up to 300 characters.</div>
                    </div>
                    <div class="col-12">
                        <div class="form-check form-switch">
                            <input class="form-check-input" type="checkbox" role="switch" id="active" name="active" value="true" ${course.active ? 'checked' : ''}>
                            <label class="form-check-label" for="active">Course is active (visible to students)</label>
                        </div>
                    </div>
                </div>
                <hr class="my-4">
                <div class="d-flex gap-2 justify-content-end">
                    <a href="${ctx}/courses" class="btn btn-light-border">Cancel</a>
                    <button type="submit" class="btn btn-primary"><i class="bi bi-check2 me-1"></i>Save course</button>
                </div>
            </form>
        </div>
    </div>
</div>
</div>

<%@ include file="/WEB-INF/jspf/footer.jspf" %>
