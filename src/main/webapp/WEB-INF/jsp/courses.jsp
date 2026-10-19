<%@ page contentType="text/html;charset=UTF-8" %>
<c:set var="pageTitle" value="${currentUser.trainer ? 'Assigned Courses' : 'Courses'}"/>
<c:set var="pageSubtitle" value="${currentUser.student ? 'Choose a programme and enrol in one click' : (currentUser.trainer ? 'Courses you are teaching' : 'Manage the academy course catalogue')}"/>
<c:set var="activeNav" value="courses"/>
<%@ include file="/WEB-INF/jspf/header.jspf" %>

<div class="d-flex flex-wrap gap-2 justify-content-between align-items-center mb-4">
    <div class="search-box">
        <i class="bi bi-search"></i>
        <input type="search" class="form-control" placeholder="Search courses" data-filter="#courseGrid" aria-label="Search courses">
    </div>
    <c:if test="${currentUser.admin}">
        <a class="btn btn-primary" href="${ctx}/courses?action=new"><i class="bi bi-plus-lg me-1"></i>Add course</a>
    </c:if>
</div>

<c:choose>
<c:when test="${empty courses}">
    <div class="card"><div class="empty-state"><i class="bi bi-journal-x"></i>
        <c:choose>
            <c:when test="${currentUser.trainer}">No courses have been assigned to you yet.</c:when>
            <c:otherwise>No courses are available right now.</c:otherwise>
        </c:choose>
    </div></div>
</c:when>
<c:otherwise>
    <div class="row g-4" id="courseGrid">
        <c:forEach var="c" items="${courses}">
            <c:set var="taken" value="${enrolByCourse[c.id]}"/>
            <c:set var="pct" value="${c.capacity > 0 ? taken * 100 / c.capacity : 0}"/>
            <div class="col-md-6 col-xl-4" data-filter-item>
                <article class="card course-card">
                    <div class="card-body">
                        <div class="d-flex justify-content-between align-items-start gap-2 mb-2">
                            <span class="course-code"><c:out value="${c.code}"/></span>
                            <span class="fee">LKR <fmt:formatNumber value="${c.fee}" type="number" groupingUsed="true" maxFractionDigits="0"/></span>
                        </div>
                        <h3><c:out value="${c.title}"/></h3>
                        <div class="small mb-2">
                            <span class="text-muted"><c:out value="${c.category}"/></span>
                            <c:if test="${not c.active}"><span class="badge-soft gray ms-1">Inactive</span></c:if>
                        </div>
                        <p class="text-muted small"><c:out value="${c.description}"/></p>
                        <dl class="course-meta">
                            <dt>Trainer</dt><dd><c:out value="${userNames[c.trainerId]}"/></dd>
                            <dt>Schedule</dt><dd><c:out value="${c.schedule}"/></dd>
                            <dt>Duration</dt><dd><c:out value="${c.durationWeeks}"/> weeks</dd>
                            <dt>Seats</dt><dd><c:out value="${taken}"/> / <c:out value="${c.capacity}"/></dd>
                        </dl>
                        <div class="progress"><div class="progress-bar ${pct >= 100 ? 'full' : (pct >= 80 ? 'warn' : '')}" style="width: ${pct > 100 ? 100 : pct}%"></div></div>
                    </div>
                    <div class="course-foot">
                        <c:choose>
                            <c:when test="${currentUser.admin}">
                                <a class="btn btn-sm btn-outline-primary" href="${ctx}/courses?action=edit&amp;id=${c.id}"><i class="bi bi-pencil me-1"></i>Edit</a>
                            </c:when>
                            <c:when test="${currentUser.trainer}">
                                <a class="btn btn-sm btn-outline-primary" href="${ctx}/attendance?courseId=${c.id}"><i class="bi bi-calendar-check me-1"></i>Attendance</a>
                            </c:when>
                            <c:when test="${enrolledIds.contains(c.id)}">
                                <span class="badge-soft green"><i class="bi bi-check-circle me-1"></i>Enrolled</span>
                            </c:when>
                            <c:when test="${taken >= c.capacity}">
                                <button class="btn btn-sm btn-light-border" disabled>Course full</button>
                            </c:when>
                            <c:otherwise>
                                <form method="post" action="${ctx}/enrolments" data-confirm="Enrol in ${fn:escapeXml(c.code)}?">
                                    <input type="hidden" name="_csrf" value="${sessionScope.csrfToken}">
                                    <input type="hidden" name="courseId" value="${c.id}">
                                    <button type="submit" class="btn btn-sm btn-primary"><i class="bi bi-plus-circle me-1"></i>Enrol</button>
                                </form>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </article>
            </div>
        </c:forEach>
    </div>
    <div id="filterEmpty" class="card d-none mt-4"><div class="empty-state"><i class="bi bi-search"></i>No courses match your search.</div></div>
</c:otherwise>
</c:choose>

<%@ include file="/WEB-INF/jspf/footer.jspf" %>
