/* SkillHub portal - small UI behaviours. No inline scripts are used (see Content-Security-Policy). */
(function () {
    'use strict';

    // Off-canvas sidebar on small screens
    var sidebar = document.getElementById('sidebar');
    var backdrop = document.getElementById('sidebarBackdrop');
    var toggle = document.getElementById('sidebarToggle');
    function setSidebar(open) {
        if (!sidebar) return;
        sidebar.classList.toggle('open', open);
        if (backdrop) backdrop.classList.toggle('open', open);
    }
    if (toggle) toggle.addEventListener('click', function () { setSidebar(!sidebar.classList.contains('open')); });
    if (backdrop) backdrop.addEventListener('click', function () { setSidebar(false); });

    // Confirm dialog for destructive forms: <form data-confirm="Are you sure?">
    document.addEventListener('submit', function (e) {
        var msg = e.target.getAttribute && e.target.getAttribute('data-confirm');
        if (msg && !window.confirm(msg)) e.preventDefault();
    });

    // Live filter for tables and card grids:
    // <input data-filter="#id" ...> filters children matching "[data-filter-item]" inside #id
    document.querySelectorAll('[data-filter]').forEach(function (input) {
        var scope = document.querySelector(input.getAttribute('data-filter'));
        if (!scope) return;
        input.addEventListener('input', function () {
            var q = input.value.trim().toLowerCase();
            var shown = 0;
            scope.querySelectorAll('[data-filter-item]').forEach(function (item) {
                var match = item.textContent.toLowerCase().indexOf(q) !== -1;
                item.classList.toggle('d-none', !match);
                if (match) shown++;
            });
            var empty = document.getElementById('filterEmpty');
            if (empty) empty.classList.toggle('d-none', shown !== 0);
        });
    });

    // Show / hide password: <button data-toggle-password="#fieldId">
    document.querySelectorAll('[data-toggle-password]').forEach(function (btn) {
        btn.addEventListener('click', function () {
            var field = document.querySelector(btn.getAttribute('data-toggle-password'));
            if (!field) return;
            var show = field.type === 'password';
            field.type = show ? 'text' : 'password';
            var icon = btn.querySelector('i');
            if (icon) icon.className = show ? 'bi bi-eye-slash' : 'bi bi-eye';
        });
    });

    // Bootstrap client-side validation: <form class="needs-validation" novalidate>
    document.querySelectorAll('form.needs-validation').forEach(function (form) {
        form.addEventListener('submit', function (e) {
            if (!form.checkValidity()) {
                e.preventDefault();
                e.stopPropagation();
            }
            form.classList.add('was-validated');
        });
    });

    // Password match check: <input data-match="#otherFieldId">
    document.querySelectorAll('[data-match]').forEach(function (field) {
        var other = document.querySelector(field.getAttribute('data-match'));
        if (!other) return;
        function check() {
            field.setCustomValidity(field.value && field.value !== other.value ? 'Passwords do not match' : '');
        }
        field.addEventListener('input', check);
        other.addEventListener('input', check);
    });

    // "Mark all" buttons on the attendance sheet: <button data-mark-all="PRESENT">
    document.querySelectorAll('[data-mark-all]').forEach(function (btn) {
        btn.addEventListener('click', function () {
            var value = btn.getAttribute('data-mark-all');
            document.querySelectorAll('input[type=radio][value="' + value + '"]').forEach(function (r) { r.checked = true; });
        });
    });

    // Auto-submit selectors: <select data-autosubmit>
    document.querySelectorAll('[data-autosubmit]').forEach(function (el) {
        el.addEventListener('change', function () { el.form.submit(); });
    });

    // Fade out success messages after a few seconds (but keep temporary passwords on screen)
    document.querySelectorAll('.flash-msg.alert-success').forEach(function (alertEl) {
        if (alertEl.textContent.indexOf('Temporary password') !== -1) return;
        setTimeout(function () {
            if (window.bootstrap) bootstrap.Alert.getOrCreateInstance(alertEl).close();
        }, 5000);
    });
})();
