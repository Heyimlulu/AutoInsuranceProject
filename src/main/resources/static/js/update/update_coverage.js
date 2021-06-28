$(document).ready(function(){
    $("#update_coverage_form").submit(function(evt) {
        evt.preventDefault();
        try {
            let coverageId = $("#coverageId").val();

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
                url: '/api/coverage/updatebyid/' + coverageId + "/",
                type: 'PUT',
                contentType : "application/json",
                data: JSON.stringify(formData),
                dataType : 'json',
                async: false,
                cache: false,
                success: function (response) {
                    let successAlert = '<div class="alert alert-success alert-dismissible fade show" role="alert">' +
                        '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>' +
                        '<strong> Coverage N°' + coverageId + ' has been successfully updated! Redirecting to all coverage page... </strong>' +
                    '</div>'

                    $("#response").empty();
                    $("#response").append(successAlert);
                    $("#response").css({"display": "block"});

                    setTimeout( () => {
                        window.location = "/coverage/coverages.html";
                    }, 2500);
                },

                error: function (response) {
                    let errorAlert = '<div class="alert alert-danger alert-dismissible fade show" role="alert">' +
                        '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>' +
                        '<strong> There was an error updating this coverage, please try again </strong>' +
                    '</div>';

                    $("#response").empty();
                    $("#response").append(errorAlert);
                    $("#response").css({"display": "block"});
                }
            });
        } catch(error){
            console.log(error);
            alert(error);
        }
    });

    $(document).on("click", "table button.btn_id", function(){
        // split the ID from the component button and class .btn_id
        let id_of_button = (event.srcElement.id);
        let coverageId = id_of_button.split("_")[2];

        $.ajax({
            url: '/api/coverage/findone/' + coverageId,
            type: 'GET',
            success: function(response) {
                let coverage = response.coverage[0];

                $("#coverageId").val(coverage.id);
                $("#coverageName").val(coverage.coverageName);
                $("#coverageGroup").val(coverage.coverageGroup);
                $("#code").val(coverage.code);
                $("#isPolicyCoverage").val(coverage.isPolicyCoverage);
                $("#isVehicleCoverage").val(coverage.isVehicleCoverage);
                $("#description").val(coverage.description);

                let url = "/coverage/updatecoverage.html?id=" + coverage.id +
                    "&coverageName=" + coverage.coverageName +
                    "&coverageGroup=" + coverage.coverageGroup +
                    "&code=" + coverage.code +
                    "&isPolicyCoverage=" + coverage.isPolicyCoverage +
                    "&isVehicleCoverage=" + coverage.isVehicleCoverage +
                    "&description=" + coverage.description;

                window.location.href = url;

            },
            error: function(error){
                console.log(error);
                alert("Error -> " + error);
            }
        });
    });
});