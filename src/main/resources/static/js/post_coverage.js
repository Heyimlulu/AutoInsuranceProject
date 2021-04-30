$(document).ready(function() {
    $("#add_new_coverage").submit(function(evt) {
        evt.preventDefault();

        if (!$("#policyCoverage").val()) $("#policyCoverage").val() = 0;
        if (!$("#vehicleCoverage").val()) $("#vehicleCoverage").val() = 0;
        
        // PREPARE FORM DATA
        let formData = {
        	coverageName : $("#coverageName").val(),
            coverageGroup : $("#coverageGroup").val(),
            code :  $("#code").val(),
            isPolicyCoverage: $("#policyCoverage").val(),
            isVehicleCoverage: $("#vehicleCoverage").val(),
            description: $("#description").val()
        }
		
        $.ajax({
            url: '/api/coverage/create/',
            type: 'POST',
            contentType : "application/json",
            data: JSON.stringify(formData),
            dataType : 'json',
            async: false,
            cache: false,
            success: function (response) {
                window.location = "/coverage/coverages.html";
            },
            error: function (response) {
                let errorAlert = '<div class="alert alert-danger alert-dismissible fade show" role="alert">' +
                        '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>' +
                        '<strong> There was an error adding this coverage </strong>' +
                    '</div>';

                $("#response").append(errorAlert);
                $("#response").css({"display": "block"});
            }
        });
    });
});
