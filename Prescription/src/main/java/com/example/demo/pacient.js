/*<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    $(function() {
    $.get('/users', { role: 'patient' }, function(data) {
        var userList = data;


        var patientList = userList.map(function(user) {
            return user.name;
        });


        $('#patientName').autocomplete({
            source: patientList,
            minLength: 1
        });
    });
});
</script>
*/