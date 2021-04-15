$(document).ready(function() {
    $("#add_new_driver").submit(function(evt) {
        evt.preventDefault();

        let policyId = $("#policyID").val();

        // PREPARE FORM DATA
        let formData = {
        	policyId : $("#policyID").val(),
            dob : $("#dob").val(),
            gender : $("#gender").val(),
            email_adress :  $("#email_adress").val(),
            first_name: $("#first_name").val(),
            last_name: $("#last_name").val(),
            phone_number: $("#phone_number").val(),
            cellNumber: $("#cellNumber").val(),
            title: $("#title").val(),
            middleInitial: $("#middleInitial").val(),
            license_issue_date: $("#license_issue_date").val(),
            license_number: $("#license_number").val(),
            marital_statut: $("#marital_statut").val(),
            created_date: $("#created_date").val(), 
           	is_primary_policy_holder: $("#is_primary_policy_holder").val(), 
           	relation_withPrimary_policy_holder: $("#relation_withPrimary_policy_holder").val(),
           	license_issue_state: $("#license_issue_state").val(),
           	ssn: $("#ssn").val(),
        }

        $.ajax({
            url: '/api/driver/create/' + policyId,
            type: 'POST',
            contentType : "application/json",
            data: JSON.stringify(formData),
            dataType : 'json',
            async: false,
            cache: false,
            success: function (response) {
                window.location.href = "/driver/drivers.html";
            },
            error: function (response) {
                let errorAlert = '<div class="alert alert-danger alert-dismissible fade show" role="alert">' +
                        '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>' +
                        '<strong> There was an error adding this driver, please make sure the ID is correct </strong>' +
                    '</div>';

                $("#response").append(errorAlert);
                $("#response").css({"display": "block"});
            }
        });
    });
});
