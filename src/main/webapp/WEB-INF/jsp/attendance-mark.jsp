<%@ page contentType="text/html;charset=UTF-8" %>
<c:set var="pageTitle" value="Mark Attendance"/>
<c:set var="pageSubtitle" value="Record who attended each session"/>
<c:set var="activeNav" value="mark"/>
<%@ include file="/WEB-INF/jspf/header.jspf" %>

<div class="card mb-4">
    <div class="card-body">
        <form method="get" action="${ctx}/attendance/mark" class="row g-3 align-items-end">
            <div class="col-md-6">
                <label class="form-label" for="courseId">Course</label>
                <select class="form-select" id="courseId" name="courseId" data-autosubmit>
                    <c:forEach var="c" items="${courses}">
                        <option value="${c.id}" ${selectedCourse.id == c.id ? 'selected' : ''}><c:out value="${c.code}"/> - <c:out value="${c.title}"/></option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-md-4">
                <label class="form-label" for="date">Session date</label>
                <input type="date" class="form-control" id="date" name="date" value="${sessionDate}" max="${today}" data-autosubmit>
            </div>
            <div class="col-md-2"><button type="submit" class="btn btn-light-border w-100">Load</button></div>
        </form>
    </div>
</div>

<c:choose>
<c:when test="${empty students}">
    <div class="card"><div class="empty-state"><i class="bi bi-people"></i>No students are enrolled in this course yet.</div></div>
</c:when>
<c:otherwise>
    <form method="post" action="${ctx}/attendance/mark">
        <input type="hidden" name="_csrf" value="${sessionScope.csrfToken}">
        <input type="hidden" name="courseId" value="${selectedCourse.id}">
        <input type="hidden" name="date" value="${sessionDate}">
        <div class="card">
            <div class="card-header">
                <h3><c:out value="${selectedCourse.code}"/> &middot; <c:out value="${sessionDate}"/></h3>
                <div class="d-flex gap-2 flex-wrap">
                    <button type="button" class="btn btn-sm btn-light-border" data-mark-all="PRESENT">All present</button>
                    <button type="button" class="btn btn-sm btn-light-border" data-mark-all="ABSENT">All absent</button>
                </div>
            </div>
            <div class="table-responsive">
                <table class="table table-modern">
                    <thead><tr><th>Student</th><th>Status</th></tr></thead>
                    <tbody>
                    <c:forEach var="s" items="${students}">
                        <c:set var="cur" value="${empty existing[s.id] ? 'PRESENT' : existing[s.id]}"/>
                        <tr>
                            <td><div class="person"><span class="avatar"><c:out value="${s.initials}"/></span><div><strong><c:out value="${s.fullName}"/></strong><small>@<c:out value="${s.username}"/></small></div></div></td>
                            <td>
                                <div class="btn-group mark-group" role="group" aria-label="Attendance for ${fn:escapeXml(s.fullName)}">
                                    <input type="radio" class="btn-check" name="status_${s.id}" id="p${s.id}" value="PRESENT" ${cur == 'PRESENT' ? 'checked' : ''}>
                                    <label class="btn btn-outline-success" for="p${s.id}">Present</label>
                                    <input type="radio" class="btn-check" name="status_${s.id}" id="l${s.id}" value="LATE" ${cur == 'LATE' ? 'checked' : ''}>
                                    <label class="btn btn-outline-warning" for="l${s.id}">Late</label>
                                    <input type="radio" class="btn-check" name="status_${s.id}" id="a${s.id}" value="ABSENT" ${cur == 'ABSENT' ? 'checked' : ''}>
                                    <label class="btn btn-outline-danger" for="a${s.id}">Absent</label>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="card-body border-top d-flex justify-content-end gap-2">
                <a class="btn btn-light-border" href="${ctx}/attendance?courseId=${selectedCourse.id}">Cancel</a>
                <button type="submit" class="btn btn-primary"><i class="bi bi-check2 me-1"></i>Save attendance</button>
            </div>
        </div>
    </form>
</c:otherwise>
</c:choose>

<%@ include file="/WEB-INF/jspf/footer.jspf" %>
