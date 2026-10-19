<%@ page contentType="text/html;charset=UTF-8" %>
<c:set var="pageTitle" value="${plural}"/>
<c:set var="pageSubtitle" value="${isStudentList ? 'Register and maintain student records' : 'Maintain the trainer directory'}"/>
<c:set var="activeNav" value="${navKey}"/>
<%@ include file="/WEB-INF/jspf/header.jspf" %>

<div class="card">
    <div class="card-header">
        <div class="search-box">
            <i class="bi bi-search"></i>
            <input type="search" class="form-control" placeholder="Search ${fn:toLowerCase(plural)}" data-filter="#peopleTable" aria-label="Search">
        </div>
        <a class="btn btn-primary" href="${ctx}${basePath}?action=new"><i class="bi bi-plus-lg me-1"></i>Add ${fn:toLowerCase(singular)}</a>
    </div>
    <div class="table-responsive">
        <table class="table table-modern" id="peopleTable">
            <thead>
            <tr>
                <th><c:out value="${singular}"/></th><th>Email</th><th>Phone</th>
                <th><c:out value="${isStudentList ? 'Enrolments' : 'Courses'}"/></th><th>Status</th><th class="text-end">Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="p" items="${people}">
                <tr data-filter-item>
                    <td>
                        <div class="person">
                            <span class="avatar"><c:out value="${p.initials}"/></span>
                            <div><strong><c:out value="${p.fullName}"/></strong><small>@<c:out value="${p.username}"/></small></div>
                        </div>
                    </td>
                    <td><c:out value="${p.email}"/></td>
                    <td><c:out value="${empty p.phone ? '-' : p.phone}"/></td>
                    <td><c:out value="${isStudentList ? enrolByStudent[p.id] : coursesByTrainer[p.id]}"/></td>
                    <td><span class="badge-soft ${p.active ? 'green' : 'gray'}">${p.active ? 'Active' : 'Inactive'}</span></td>
                    <td class="text-end">
                        <div class="d-inline-flex gap-1">
                            <a class="btn btn-sm btn-light-border" href="${ctx}${basePath}?action=edit&amp;id=${p.id}" title="Edit"><i class="bi bi-pencil"></i></a>
                            <form method="post" action="${ctx}${basePath}" data-confirm="${p.active ? 'Deactivate' : 'Activate'} ${fn:escapeXml(p.fullName)}?">
                                <input type="hidden" name="_csrf" value="${sessionScope.csrfToken}">
                                <input type="hidden" name="action" value="toggle">
                                <input type="hidden" name="id" value="${p.id}">
                                <button type="submit" class="btn btn-sm btn-light-border ${p.active ? 'text-danger' : 'text-success'}" title="${p.active ? 'Deactivate' : 'Activate'}">
                                    <i class="bi ${p.active ? 'bi-person-slash' : 'bi-person-check'}"></i>
                                </button>
                            </form>
                            <c:if test="${allowDelete}">
                                <form method="post" action="${ctx}${basePath}" data-confirm="Delete ${fn:escapeXml(p.fullName)}? Their enrolments and attendance will also be removed.">
                                    <input type="hidden" name="_csrf" value="${sessionScope.csrfToken}">
                                    <input type="hidden" name="action" value="delete">
                                    <input type="hidden" name="id" value="${p.id}">
                                    <button type="submit" class="btn btn-sm btn-light-border text-danger" title="Delete"><i class="bi bi-trash"></i></button>
                                </form>
                            </c:if>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <c:if test="${empty people}"><div class="empty-state"><i class="bi bi-people"></i>No <c:out value="${fn:toLowerCase(plural)}"/> yet. Add the first one.</div></c:if>
    <div id="filterEmpty" class="empty-state d-none"><i class="bi bi-search"></i>No matches found.</div>
</div>

<%@ include file="/WEB-INF/jspf/footer.jspf" %>
