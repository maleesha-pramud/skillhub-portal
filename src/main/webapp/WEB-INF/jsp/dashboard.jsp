<%@ page contentType="text/html;charset=UTF-8" %>
<c:set var="pageTitle" value="Dashboard"/>
<c:set var="pageSubtitle" value="Your academy at a glance"/>
<c:set var="activeNav" value="dashboard"/>
<%@ include file="/WEB-INF/jspf/header.jspf" %>
<jsp:useBean id="today" class="java.util.Date"/>

<c:choose>
<%-- ============================== ADMIN ============================== --%>
<c:when test="${currentUser.admin}">
    <section class="hero mb-4">
        <div class="d-flex flex-wrap align-items-center justify-content-between gap-3">
            <div>
                <span class="hero-eyebrow"><i class="bi bi-calendar3 me-1"></i><fmt:formatDate value="${today}" pattern="EEEE, d MMMM yyyy"/></span>
                <h2>Good to see you, <c:out value="${currentUser.fullName}"/></h2>
                <p>Here is what is happening across the academy right now.</p>
            </div>
            <div class="d-flex gap-2 flex-wrap">
                <a class="btn btn-light hero-btn" href="${ctx}/admin/students?action=new"><i class="bi bi-person-plus me-1"></i>Add student</a>
                <a class="btn btn-outline-light hero-btn" href="${ctx}/attendance/mark"><i class="bi bi-clipboard2-check me-1"></i>Mark attendance</a>
            </div>
        </div>
    </section>

    <div class="row g-3 mb-4">
        <div class="col-sm-6 col-xl-3">
            <a class="card stat-card stat-card-icon" href="${ctx}/admin/students">
                <span class="stat-icon tone-rose"><i class="bi bi-people"></i></span>
                <span class="stat-body"><span class="stat-value"><c:out value="${totalStudents}"/></span><span class="stat-label">Students</span></span>
            </a>
        </div>
        <div class="col-sm-6 col-xl-3">
            <a class="card stat-card stat-card-icon" href="${ctx}/admin/trainers">
                <span class="stat-icon tone-slate"><i class="bi bi-person-workspace"></i></span>
                <span class="stat-body"><span class="stat-value"><c:out value="${totalTrainers}"/></span><span class="stat-label">Trainers</span></span>
            </a>
        </div>
        <div class="col-sm-6 col-xl-3">
            <a class="card stat-card stat-card-icon" href="${ctx}/courses">
                <span class="stat-icon tone-green"><i class="bi bi-journal-bookmark"></i></span>
                <span class="stat-body"><span class="stat-value"><c:out value="${totalCourses}"/></span><span class="stat-label">Courses</span></span>
            </a>
        </div>
        <div class="col-sm-6 col-xl-3">
            <a class="card stat-card stat-card-icon" href="${ctx}/enrolments">
                <span class="stat-icon tone-amber"><i class="bi bi-card-checklist"></i></span>
                <span class="stat-body"><span class="stat-value"><c:out value="${totalEnrolments}"/></span><span class="stat-label">Enrolments</span></span>
            </a>
        </div>
    </div>

    <div class="row g-4 mb-4">
        <div class="col-lg-7">
            <div class="card h-100">
                <div class="card-header"><h3>Seat utilisation</h3><a href="${ctx}/courses" class="btn btn-sm btn-light-border">All courses</a></div>
                <div class="card-body">
                    <c:forEach var="row" items="${courseUtil}">
                        <div class="util-row">
                            <div class="d-flex justify-content-between align-items-baseline gap-2 mb-1">
                                <span class="util-title"><span class="badge-soft blue"><c:out value="${row.code}"/></span> <c:out value="${row.title}"/></span>
                                <span class="util-count"><strong><c:out value="${row.enrolled}"/></strong> / <c:out value="${row.capacity}"/> <small>(<c:out value="${row.pct}"/>%)</small></span>
                            </div>
                            <div class="progress"><div class="progress-bar ${row.pct >= 100 ? 'full' : (row.pct >= 80 ? 'warn' : '')}" style="width: ${row.pct}%"></div></div>
                        </div>
                    </c:forEach>
                    <c:if test="${empty courseUtil}"><div class="empty-state"><i class="bi bi-journal"></i>No courses yet.</div></c:if>
                </div>
            </div>
        </div>
        <div class="col-lg-5">
            <div class="card h-100">
                <div class="card-header"><h3>Courses by category</h3></div>
                <div class="card-body">
                    <c:forEach var="cat" items="${categoryCounts}">
                        <div class="util-row">
                            <div class="d-flex justify-content-between align-items-baseline mb-1"><span class="util-title"><c:out value="${cat.key}"/></span><span class="badge-soft gray"><c:out value="${cat.value}"/></span></div>
                            <div class="cat-bar"><span style="width: ${totalCourses > 0 ? cat.value * 100 / totalCourses : 0}%"></span></div>
                        </div>
                    </c:forEach>
                    <c:if test="${empty categoryCounts}"><div class="empty-state"><i class="bi bi-tags"></i>No categories yet.</div></c:if>
                </div>
            </div>
        </div>
    </div>

    <div class="row g-4">
        <div class="col-lg-7">
            <div class="card h-100">
                <div class="card-header"><h3>Recent enrolments</h3><a href="${ctx}/enrolments" class="btn btn-sm btn-light-border">View all</a></div>
                <div class="table-responsive">
                    <table class="table table-modern">
                        <thead><tr><th>Student</th><th>Course</th><th>Date</th></tr></thead>
                        <tbody>
                        <c:forEach var="e" items="${recentEnrolments}">
                            <tr>
                                <td>
                                    <span class="person"><span class="avatar"><c:out value="${fn:toUpperCase(fn:substring(userNames[e.studentId], 0, 1))}"/></span>
                                    <strong><c:out value="${userNames[e.studentId]}"/></strong></span>
                                </td>
                                <td><span class="badge-soft blue"><c:out value="${courseMap[e.courseId].code}"/></span> <c:out value="${courseMap[e.courseId].title}"/></td>
                                <td class="text-muted text-nowrap"><c:out value="${e.enrolledOn}"/></td>
                            </tr>
                        </c:forEach>
                        <c:if test="${empty recentEnrolments}"><tr><td colspan="3"><div class="empty-state"><i class="bi bi-card-checklist"></i>No enrolments yet.</div></td></tr></c:if>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="col-lg-5">
            <div class="card h-100">
                <div class="card-header"><h3>System status</h3><a href="${ctx}/admin/reports" class="btn btn-sm btn-light-border">Reports</a></div>
                <div class="card-body">
                    <ul class="mini-list status-list">
                        <li><span class="status-label"><span class="stat-icon sm tone-slate"><i class="bi bi-activity"></i></span>Active sessions</span><strong><c:out value="${activeSessions}"/></strong></li>
                        <li><span class="status-label"><span class="stat-icon sm tone-slate"><i class="bi bi-arrow-left-right"></i></span>Requests served</span><strong><c:out value="${totalRequests}"/></strong></li>
                        <li><span class="status-label"><span class="stat-icon sm tone-green"><i class="bi bi-check2-circle"></i></span>Overall attendance</span><strong><c:out value="${attendanceRate}"/>%</strong></li>
                        <li><span class="status-label"><span class="stat-icon sm tone-rose"><i class="bi bi-door-open"></i></span>Online registration</span>
                            <span class="badge-soft ${applicationScope.registrationOpen ? 'green' : 'gray'}">${applicationScope.registrationOpen ? 'Open' : 'Closed'}</span></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</c:when>

<%-- ============================== TRAINER ============================== --%>
<c:when test="${currentUser.trainer}">
    <section class="hero mb-4">
        <div class="d-flex flex-wrap align-items-center justify-content-between gap-3">
            <div>
                <span class="hero-eyebrow"><i class="bi bi-calendar3 me-1"></i><fmt:formatDate value="${today}" pattern="EEEE, d MMMM yyyy"/></span>
                <h2>Hello, <c:out value="${currentUser.fullName}"/></h2>
                <p>Your assigned courses and attendance, all in one place.</p>
            </div>
            <a class="btn btn-light hero-btn" href="${ctx}/attendance"><i class="bi bi-calendar-check me-1"></i>View attendance</a>
        </div>
    </section>

    <div class="row g-3 mb-4">
        <div class="col-sm-6 col-xl-3">
            <a class="card stat-card stat-card-icon" href="${ctx}/courses">
                <span class="stat-icon tone-rose"><i class="bi bi-journal-bookmark"></i></span>
                <span class="stat-body"><span class="stat-value"><c:out value="${fn:length(myCourses)}"/></span><span class="stat-label">Assigned courses</span></span>
            </a>
        </div>
        <div class="col-sm-6 col-xl-3">
            <div class="card stat-card stat-card-icon">
                <span class="stat-icon tone-slate"><i class="bi bi-people"></i></span>
                <span class="stat-body"><span class="stat-value"><c:out value="${studentCount}"/></span><span class="stat-label">Students</span></span>
            </div>
        </div>
        <div class="col-sm-6 col-xl-3">
            <a class="card stat-card stat-card-icon" href="${ctx}/attendance">
                <span class="stat-icon tone-amber"><i class="bi bi-calendar-check"></i></span>
                <span class="stat-body"><span class="stat-value"><c:out value="${sessionCount}"/></span><span class="stat-label">Sessions recorded</span></span>
            </a>
        </div>
        <div class="col-sm-6 col-xl-3">
            <div class="card stat-card stat-card-icon">
                <span class="stat-icon tone-green"><i class="bi bi-check2-circle"></i></span>
                <span class="stat-body"><span class="stat-value"><c:out value="${attendanceRate}"/>%</span><span class="stat-label">Attendance rate</span></span>
            </div>
        </div>
    </div>

    <div class="row g-4">
        <div class="col-lg-7">
            <div class="card h-100">
                <div class="card-header"><h3>My courses</h3><a href="${ctx}/courses" class="btn btn-sm btn-light-border">Details</a></div>
                <div class="table-responsive">
                    <table class="table table-modern">
                        <thead><tr><th>Course</th><th>Schedule</th><th>Seats</th></tr></thead>
                        <tbody>
                        <c:forEach var="c" items="${myCourses}">
                            <tr>
                                <td><span class="badge-soft blue"><c:out value="${c.code}"/></span> <c:out value="${c.title}"/></td>
                                <td class="text-muted"><c:out value="${c.schedule}"/></td>
                                <td class="text-nowrap"><strong><c:out value="${enrolByCourse[c.id]}"/></strong> <span class="text-muted">/ <c:out value="${c.capacity}"/></span></td>
                            </tr>
                        </c:forEach>
                        <c:if test="${empty myCourses}"><tr><td colspan="3"><div class="empty-state"><i class="bi bi-journal"></i>No courses have been assigned to you yet.</div></td></tr></c:if>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="col-lg-5">
            <div class="card h-100">
                <div class="card-header"><h3>Recent attendance</h3><a href="${ctx}/attendance" class="btn btn-sm btn-light-border">Full record</a></div>
                <div class="card-body">
                    <ul class="mini-list">
                        <c:forEach var="a" items="${recentAttendance}">
                            <li>
                                <span class="person"><span class="avatar"><c:out value="${fn:toUpperCase(fn:substring(userNames[a.studentId], 0, 1))}"/></span>
                                <span><strong><c:out value="${userNames[a.studentId]}"/></strong><small><c:out value="${courseMap[a.courseId].code}"/> &middot; <c:out value="${a.date}"/></small></span></span>
                                <span class="status-pill status-${a.status}"><c:out value="${a.status}"/></span>
                            </li>
                        </c:forEach>
                    </ul>
                    <c:if test="${empty recentAttendance}"><div class="empty-state"><i class="bi bi-calendar"></i>No attendance recorded yet.</div></c:if>
                </div>
            </div>
        </div>
    </div>
</c:when>

<%-- ============================== STUDENT ============================== --%>
<c:otherwise>
    <section class="hero mb-4">
        <div class="d-flex flex-wrap align-items-center justify-content-between gap-3">
            <div>
                <span class="hero-eyebrow"><i class="bi bi-calendar3 me-1"></i><fmt:formatDate value="${today}" pattern="EEEE, d MMMM yyyy"/></span>
                <h2>Welcome, <c:out value="${currentUser.fullName}"/></h2>
                <p>Keep learning. Here is your progress at SkillHub.</p>
            </div>
            <a class="btn btn-light hero-btn" href="${ctx}/courses"><i class="bi bi-search me-1"></i>Browse courses</a>
        </div>
    </section>

    <div class="row g-3 mb-4">
        <div class="col-sm-6 col-xl-3">
            <a class="card stat-card stat-card-icon" href="${ctx}/enrolments">
                <span class="stat-icon tone-rose"><i class="bi bi-journal-bookmark"></i></span>
                <span class="stat-body"><span class="stat-value"><c:out value="${fn:length(myEnrolments)}"/></span><span class="stat-label">My courses</span></span>
            </a>
        </div>
        <div class="col-sm-6 col-xl-3">
            <div class="card stat-card stat-card-icon">
                <span class="stat-icon tone-green"><i class="bi bi-check2-circle"></i></span>
                <span class="stat-body"><span class="stat-value"><c:out value="${attendanceRate}"/>%</span><span class="stat-label">Attendance rate</span></span>
            </div>
        </div>
        <div class="col-sm-6 col-xl-3">
            <a class="card stat-card stat-card-icon" href="${ctx}/attendance">
                <span class="stat-icon tone-amber"><i class="bi bi-calendar-check"></i></span>
                <span class="stat-body"><span class="stat-value"><c:out value="${sessionCount}"/></span><span class="stat-label">Sessions recorded</span></span>
            </a>
        </div>
        <div class="col-sm-6 col-xl-3">
            <a class="card stat-card stat-card-icon" href="${ctx}/courses">
                <span class="stat-icon tone-slate"><i class="bi bi-compass"></i></span>
                <span class="stat-body"><span class="stat-value"><c:out value="${availableCourses}"/></span><span class="stat-label">Courses to explore</span></span>
            </a>
        </div>
    </div>

    <div class="row g-4">
        <div class="col-lg-7">
            <div class="card h-100">
                <div class="card-header"><h3>My courses</h3><a href="${ctx}/enrolments" class="btn btn-sm btn-light-border">View all</a></div>
                <div class="table-responsive">
                    <table class="table table-modern">
                        <thead><tr><th>Course</th><th>Trainer</th><th>Schedule</th></tr></thead>
                        <tbody>
                        <c:forEach var="e" items="${myEnrolments}">
                            <tr>
                                <td><span class="badge-soft blue"><c:out value="${courseMap[e.courseId].code}"/></span> <c:out value="${courseMap[e.courseId].title}"/></td>
                                <td><c:out value="${userNames[courseMap[e.courseId].trainerId]}"/></td>
                                <td class="text-muted"><c:out value="${courseMap[e.courseId].schedule}"/></td>
                            </tr>
                        </c:forEach>
                        <c:if test="${empty myEnrolments}"><tr><td colspan="3"><div class="empty-state"><i class="bi bi-journal"></i>You are not enrolled in any course yet. <a href="${ctx}/courses">Find one</a>.</div></td></tr></c:if>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="col-lg-5">
            <div class="card h-100">
                <div class="card-header"><h3>Recent attendance</h3><a href="${ctx}/attendance" class="btn btn-sm btn-light-border">Full record</a></div>
                <div class="card-body">
                    <ul class="mini-list">
                        <c:forEach var="a" items="${recentAttendance}">
                            <li>
                                <span class="person">
                                    <span class="stat-icon sm tone-slate"><i class="bi bi-calendar-event"></i></span>
                                    <span><strong><c:out value="${courseMap[a.courseId].title}"/></strong><small><c:out value="${a.date}"/></small></span>
                                </span>
                                <span class="status-pill status-${a.status}"><c:out value="${a.status}"/></span>
                            </li>
                        </c:forEach>
                    </ul>
                    <c:if test="${empty recentAttendance}"><div class="empty-state"><i class="bi bi-calendar"></i>No attendance recorded yet.</div></c:if>
                </div>
            </div>
        </div>
    </div>
</c:otherwise>
</c:choose>

<%@ include file="/WEB-INF/jspf/footer.jspf" %>
