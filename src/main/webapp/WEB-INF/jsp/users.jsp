<%@ page contentType="text/html;charset=UTF-8" %>
<c:set var="pageTitle" value="Manage Users"/>
<c:set var="pageSubtitle" value="Control access for every account in the system"/>
<c:set var="activeNav" value="users"/>
<%@ include file="/WEB-INF/jspf/header.jspf" %>

<div class="card">
    <div class="card-header">
        <div class="search-box"><i class="bi bi-search"></i><input type="search" class="form-control" placeholder="Search users" data-filter="#userTable" aria-label="Search users"></div>
        <span class="text-muted small"><c:out value="${fn:length(users)}"/> accounts</span>
    </div>
    <div class="table-responsive">
        <table class="table table-modern" id="userTable">
            <thead><tr><th>User</th><th>Role</th><th>Status</th><th>Created</th><th class="text-end">Actions</th></tr></thead>
            <tbody>
            <c:forEach var="u" items="${users}">
                <tr data-filter-item>
                    <td><div class="person"><span class="avatar"><c:out value="${u.initials}"/></span><div><strong><c:out value="${u.fullName}"/></strong><small>@<c:out value="${u.username}"/></small></div></div></td>
                    <td><span class="badge-soft ${u.admin ? 'navy' : (u.trainer ? 'blue' : 'gray')}"><c:out value="${u.role.label}"/></span></td>
                    <td><span class="badge-soft ${u.active ? 'green' : 'red'}">${u.active ? 'Active' : 'Deactivated'}</span></td>
                    <td class="text-muted"><c:out value="${u.createdAt}"/></td>
                    <td class="text-end">
                        <div class="d-inline-flex gap-1">
                            <form method="post" action="${ctx}/admin/users" data-confirm="Reset the password for ${fn:escapeXml(u.username)}?">
                                <input type="hidden" name="_csrf" value="${sessionScope.csrfToken}">
                                <input type="hidden" name="action" value="reset">
                                <input type="hidden" name="id" value="${u.id}">
                                <button type="submit" class="btn btn-sm btn-light-border" title="Reset password"><i class="bi bi-key"></i></button>
                            </form>
                            <form method="post" action="${ctx}/admin/users" data-confirm="${u.active ? 'Deactivate' : 'Activate'} ${fn:escapeXml(u.username)}?">
                                <input type="hidden" name="_csrf" value="${sessionScope.csrfToken}">
                                <input type="hidden" name="action" value="toggle">
                                <input type="hidden" name="id" value="${u.id}">
                                <button type="submit" class="btn btn-sm btn-light-border ${u.active ? 'text-danger' : 'text-success'}" ${u.id == currentUser.id ? 'disabled' : ''} title="${u.active ? 'Deactivate' : 'Activate'}">
                                    <i class="bi ${u.active ? 'bi-person-slash' : 'bi-person-check'}"></i>
                                </button>
                            </form>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div id="filterEmpty" class="empty-state d-none"><i class="bi bi-search"></i>No matching users.</div>
</div>

<%@ include file="/WEB-INF/jspf/footer.jspf" %>
