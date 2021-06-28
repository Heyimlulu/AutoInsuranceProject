$(document).ready(function() {
    $("#add_new_coverage").submit(function(evt) {
        evt.preventDefault();

        let policyCoverage = 0;
        let vehicleCoverage = 0;

        if(document.getElementById('policyCoverage').checked) {
            policyCoverage = 1;
        } else if(document.getElementById('vehicleCoverage').checked) {
            vehicleCoverage = 1;
        }

        // PREPARE FORM DATA
        let formData = {
        	coverageName : $("#coverageName").val(),
            coverageGroup : $("#coverageGroup").val(),
            code :  $("#code").val(),
            isPolicyCoverage: policyCoverage,
            isVehicleCoverage: vehicleCoverage,
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
