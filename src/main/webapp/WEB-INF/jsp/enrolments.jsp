<%@ page contentType="text/html;charset=UTF-8" %>
<c:set var="pageTitle" value="${currentUser.admin ? 'Enrolments' : 'My Enrolments'}"/>
<c:set var="pageSubtitle" value="${currentUser.admin ? 'Enrol students and review every enrolment' : 'The courses you are enrolled in'}"/>
<c:set var="activeNav" value="enrolments"/>
<%@ include file="/WEB-INF/jspf/header.jspf" %>

<c:if test="${currentUser.admin}">
    <div class="card mb-4">
        <div class="card-header"><h3>Enrol a student</h3></div>
        <div class="card-body">
            <form method="post" action="${ctx}/enrolments" class="row g-3 align-items-end needs-validation" novalidate>
                <input type="hidden" name="_csrf" value="${sessionScope.csrfToken}">
                <div class="col-md-5">
                    <label class="form-label" for="studentId">Student</label>
                    <select class="form-select" id="studentId" name="studentId" required>
                        <option value="">Select a student</option>
                        <c:forEach var="s" items="${students}"><option value="${s.id}"><c:out value="${s.fullName}"/> (@<c:out value="${s.username}"/>)</option></c:forEach>
                    </select>
                </div>
                <div class="col-md-5">
                    <label class="form-label" for="courseId">Course</label>
                    <select class="form-select" id="courseId" name="courseId" required>
                        <option value="">Select a course</option>
                        <c:forEach var="c" items="${activeCourses}"><option value="${c.id}"><c:out value="${c.code}"/> - <c:out value="${c.title}"/> (<c:out value="${enrolByCourse[c.id]}"/>/<c:out value="${c.capacity}"/> seats)</option></c:forEach>
                    </select>
                </div>
                <div class="col-md-2"><button type="submit" class="btn btn-primary w-100"><i class="bi bi-person-plus me-1"></i>Enrol</button></div>
            </form>
        </div>
    </div>
</c:if>

<div class="card">
    <div class="card-header">
        <h3>Enrolment list</h3>
        <c:if test="${currentUser.student}"><a href="${ctx}/courses" class="btn btn-sm btn-primary"><i class="bi bi-plus-lg me-1"></i>Enrol in another course</a></c:if>
    </div>
    <div class="table-responsive">
        <table class="table table-modern">
            <thead>
            <tr>
                <c:if test="${currentUser.admin}"><th>Student</th></c:if>
                <th>Course</th><th>Trainer</th><th>Enrolled on</th><th>Status</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="e" items="${enrolments}">
                <tr>
                    <c:if test="${currentUser.admin}">
                        <td><div class="person"><span class="avatar"><c:out value="${fn:substring(userNames[e.studentId], 0, 1)}"/></span><strong><c:out value="${userNames[e.studentId]}"/></strong></div></td>
                    </c:if>
                    <td><span class="badge-soft blue"><c:out value="${courseMap[e.courseId].code}"/></span> <c:out value="${courseMap[e.courseId].title}"/></td>
                    <td><c:out value="${userNames[courseMap[e.courseId].trainerId]}"/></td>
                    <td class="text-muted"><c:out value="${e.enrolledOn}"/></td>
                    <td><span class="badge-soft green"><c:out value="${e.status}"/></span></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <c:if test="${empty enrolments}"><div class="empty-state"><i class="bi bi-card-checklist"></i>No enrolments yet.</div></c:if>
</div>

<%@ include file="/WEB-INF/jspf/footer.jspf" %>
