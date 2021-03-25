$(document).ready(function() {
    $("#add_new_driver").submit(function(evt) {
        evt.preventDefault();

        // PREPARE FORM DATA
        let formData = {
        	
        	policyID: $("#policyID").val(),
        	Title: $("#Title").val(),
        	FirstName: $("#FirstName").val(),
        	LastName: $("#LastName").val(),
            MiddleInital: $("#MiddleInitial").val(),
            DoB: $("#DoB").val(),
            Email: $("#Email").val(),
            PhoneNumber: $("#PhoneNumber").val(),
            CellNumber: $("#CellNumber").val(),
            SSN: $("#SSN").val(),
            LicenseIssuedDate: $("#LicenseIssuedDate").val(),
            LicenseIssuedState: $("#LicenseIssuedState").val(),
            LicenseNumber: $("#LicenseNumber").val(),
            IsPrimaryPolicyHolder: $("#IsPrimaryPolicyHolder").val(),
            RelationWithPrimaryPolicyHolder: $("#RelationWithPrimaryPolicyHolder").val(),
            Gender: $("#Gender").val(),
            MaritalStatuts: $("#MaritalStatuts").val(),
            CreatedDate: $("#CreatedDate").val(),
            active: $("#active").val()            
            
        }
        $.ajax({
            url: '/api/driver/create',
            type: 'POST',
            contentType : "application/json",
            data: JSON.stringify(formData),
            dataType : 'json',
            async: false,
            cache: false,
            success: function (response) {
                window.location = "/driver/drivers.html";
            },
            error: function (response) {
                let errorAlert = '<div class="alert alert-danger alert-dismissible fade show" role="alert">' + 
                                    '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>' +
                                    '<strong>' + response.message + '</strong>' + ' ,Error: ' + message.error + 
                                '</div>'
                $("#response").append(errorAlert);
                $("#response").css({"display": "block"});
            }
        });
    });
});
