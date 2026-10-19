<%@ page contentType="text/html;charset=UTF-8" %>
<c:set var="pageTitle" value="Reports"/>
<c:set var="pageSubtitle" value="Utilisation, attendance and system activity"/>
<c:set var="activeNav" value="reports"/>
<%@ include file="/WEB-INF/jspf/header.jspf" %>

<div class="d-flex justify-content-end mb-3">
    <a class="btn btn-light-border" href="${ctx}/admin/reports?format=csv"><i class="bi bi-download me-1"></i>Export enrolments (CSV)</a>
</div>

<div class="row g-3 mb-4">
    <div class="col-sm-6 col-xl-3"><div class="card stat-card"><div class="stat-label">Students</div><div class="stat-value"><c:out value="${studentTotal}"/></div></div></div>
    <div class="col-sm-6 col-xl-3"><div class="card stat-card"><div class="stat-label">Enrolments</div><div class="stat-value"><c:out value="${enrolmentTotal}"/></div></div></div>
    <div class="col-sm-6 col-xl-3"><div class="card stat-card"><div class="stat-label">Overall attendance</div><div class="stat-value"><c:out value="${overallAttendance}"/>%</div></div></div>
    <div class="col-sm-6 col-xl-3"><div class="card stat-card"><div class="stat-label">Expected fees (LKR)</div><div class="stat-value"><fmt:formatNumber value="${totalRevenue}" type="number" groupingUsed="true" maxFractionDigits="0"/></div></div></div>
</div>

<div class="card mb-4">
    <div class="card-header"><h3>Course performance</h3></div>
    <div class="table-responsive">
        <table class="table table-modern">
            <thead><tr><th>Course</th><th>Trainer</th><th style="min-width:180px">Seats</th><th>Attendance</th><th class="text-end">Expected fees (LKR)</th></tr></thead>
            <tbody>
            <c:forEach var="r" items="${courseRows}">
                <tr>
                    <td><span class="badge-soft blue"><c:out value="${r.code}"/></span> <c:out value="${r.title}"/></td>
                    <td><c:out value="${userNames[r.trainerId]}"/></td>
                    <td>
                        <div class="d-flex align-items-center gap-2">
                            <div class="progress flex-grow-1"><div class="progress-bar ${r.pct >= 100 ? 'full' : (r.pct >= 80 ? 'warn' : '')}" style="width: ${r.pct}%"></div></div>
                            <span class="small text-muted"><c:out value="${r.enrolled}"/>/<c:out value="${r.capacity}"/></span>
                        </div>
                    </td>
                    <td><c:out value="${r.attendance}"/>%</td>
                    <td class="text-end"><fmt:formatNumber value="${r.revenue}" type="number" groupingUsed="true" maxFractionDigits="0"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<div class="row g-4">
    <div class="col-lg-7">
        <div class="card h-100">
            <div class="card-header"><h3>Recent activity</h3></div>
            <div class="card-body">
                <c:forEach var="line" items="${activity}"><div class="log-line"><c:out value="${line}"/></div></c:forEach>
                <c:if test="${empty activity}"><div class="empty-state">No activity yet.</div></c:if>
            </div>
        </div>
    </div>
    <div class="col-lg-5">
        <div class="card h-100">
            <div class="card-header"><h3>System information</h3></div>
            <div class="card-body">
                <ul class="mini-list small">
                    <li><span class="text-muted">Active sessions</span><strong><c:out value="${activeSessions}"/></strong></li>
                    <li><span class="text-muted">Requests served</span><strong><c:out value="${totalRequests}"/></strong></li>
                    <li><span class="text-muted">Started</span><span><fmt:formatDate value="${startedAt}" pattern="dd MMM yyyy, HH:mm"/></span></li>
                    <li><span class="text-muted">Uptime</span><span><c:out value="${uptimeMinutes}"/> min</span></li>
                    <li><span class="text-muted">Servlet container</span><span><c:out value="${serverInfo}"/></span></li>
                    <li><span class="text-muted">Java</span><span><c:out value="${javaVersion}"/></span></li>
                </ul>
            </div>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/jspf/footer.jspf" %>
