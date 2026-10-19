<%@ page contentType="text/html;charset=UTF-8" %>
<c:set var="pageTitle" value="${currentUser.admin ? 'Attendance Report' : (currentUser.trainer ? 'Attendance' : 'My Attendance')}"/>
<c:set var="pageSubtitle" value="${currentUser.student ? 'Your attendance across enrolled courses' : 'Review attendance by course and student'}"/>
<c:set var="activeNav" value="attendance"/>
<%@ include file="/WEB-INF/jspf/header.jspf" %>

<div class="d-flex flex-wrap gap-2 justify-content-between align-items-center mb-4">
    <form method="get" action="${ctx}/attendance" class="d-flex gap-2 align-items-center">
        <label class="form-label mb-0 text-muted" for="courseId">Course</label>
        <select class="form-select" id="courseId" name="courseId" data-autosubmit style="min-width: 260px">
            <option value="">${currentUser.trainer ? 'All my courses' : 'All courses'}</option>
            <c:forEach var="c" items="${selectableCourses}">
                <option value="${c.id}" ${selectedCourse.id == c.id ? 'selected' : ''}><c:out value="${c.code}"/> - <c:out value="${c.title}"/></option>
            </c:forEach>
        </select>
        <noscript><button class="btn btn-primary" type="submit">Filter</button></noscript>
    </form>
    <c:if test="${currentUser.admin}">
        <c:url var="markUrl" value="/attendance/mark"><c:if test="${not empty selectedCourse}"><c:param name="courseId" value="${selectedCourse.id}"/></c:if></c:url>
        <a class="btn btn-primary" href="${markUrl}"><i class="bi bi-clipboard2-check me-1"></i>Mark attendance</a>
    </c:if>
</div>

<div class="row g-3 mb-4">
    <div class="col-6 col-xl-3"><div class="card stat-card"><div class="stat-label">Present</div><div class="stat-value"><c:out value="${presentCount}"/></div></div></div>
    <div class="col-6 col-xl-3"><div class="card stat-card"><div class="stat-label">Late</div><div class="stat-value"><c:out value="${lateCount}"/></div></div></div>
    <div class="col-6 col-xl-3"><div class="card stat-card"><div class="stat-label">Absent</div><div class="stat-value"><c:out value="${absentCount}"/></div></div></div>
    <div class="col-6 col-xl-3"><div class="card stat-card"><div class="stat-label">Attendance rate</div><div class="stat-value"><c:out value="${rate}"/>%</div></div></div>
</div>

<div class="row g-4">
    <c:if test="${not currentUser.student and not empty report}">
        <div class="col-lg-5">
            <div class="card h-100">
                <div class="card-header"><h3>By student</h3></div>
                <div class="table-responsive">
                    <table class="table table-modern">
                        <thead><tr><th>Student</th><th>P</th><th>L</th><th>A</th><th style="min-width:120px">Rate</th></tr></thead>
                        <tbody>
                        <c:forEach var="r" items="${report}">
                            <tr>
                                <td><c:out value="${userNames[r.studentId]}"/></td>
                                <td><c:out value="${r.present}"/></td><td><c:out value="${r.late}"/></td><td><c:out value="${r.absent}"/></td>
                                <td>
                                    <div class="d-flex align-items-center gap-2">
                                        <div class="progress flex-grow-1"><div class="progress-bar ${r.rate < 75 ? 'warn' : ''}" style="width: ${r.rate}%"></div></div>
                                        <span class="small fw-semibold"><c:out value="${r.rate}"/>%</span>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </c:if>
    <div class="${(not currentUser.student and not empty report) ? 'col-lg-7' : 'col-12'}">
        <div class="card h-100">
            <div class="card-header"><h3>Session records</h3><span class="text-muted small"><c:out value="${fn:length(records)}"/> records</span></div>
            <div class="table-responsive">
                <table class="table table-modern">
                    <thead>
                    <tr><th>Date</th><th>Course</th><c:if test="${not currentUser.student}"><th>Student</th></c:if><th>Status</th></tr>
                    </thead>
                    <tbody>
                    <c:forEach var="a" items="${records}">
                        <tr>
                            <td><c:out value="${a.date}"/></td>
                            <td><span class="badge-soft blue"><c:out value="${courseMap[a.courseId].code}"/></span> <span class="d-none d-md-inline"><c:out value="${courseMap[a.courseId].title}"/></span></td>
                            <c:if test="${not currentUser.student}"><td><c:out value="${userNames[a.studentId]}"/></td></c:if>
                            <td><span class="status-pill status-${a.status}"><c:out value="${a.status}"/></span></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <c:if test="${empty records}"><div class="empty-state"><i class="bi bi-calendar-x"></i>No attendance has been recorded yet.</div></c:if>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/jspf/footer.jspf" %>
