$(document).ready(function(){
    $("#update_policyCoverage_form").submit(function(evt) {
        evt.preventDefault();
        try {
            let policyCoverageId = $("#policyID").val();

            // PREPARE FORM DATA
            let formData = {
                active : $("#active").val(),
                createdDate: $("#createdDate").val()
        }        
            $.ajax({
                url: '/api/policycoverage/updatebyid/' + policyCoverageId + "/",
                type: 'PUT',
                contentType : "application/json",
                data: JSON.stringify(formData),
                dataType : 'json',
                async: false,
                cache: false,
                success: function (response) {
                    let successAlert = '<div class="alert alert-success alert-dismissible fade show" role="alert">' +
                                            '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>' +
                                            '<strong> Policy Coverage N°' + policyCoverageId + ' has been successfully updated! Redirecting to all policy coverages page... </strong>' +
                                        '</div>'

                    $("#response").empty();
                    $("#response").append(successAlert);
                    $("#response").css({"display": "block"});

                    setTimeout( () => {
                        window.location = "/coverage/policiescoverage.html";
                    }, 2500);
                },

                error: function (response) {
                    let errorAlert = '<div class="alert alert-danger alert-dismissible fade show" role="alert">' +
                                        '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>' +
                                        '<strong> There was an error updating this policy coverage, please try again </strong>' +
                                    '</div>'

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
        let id_of_button = (event.srcElement.id);
        let policyCoverageId = id_of_button.split("_")[2];
  
        $.ajax({
            url: '/api/policycoverage/findone/' + policyCoverageId,
            type: 'GET',
            success: function(response) {
                let policyCoverage = response.policyCoverage[0];
                $("#active").val(policyCoverage.active);
                $("#createdDate").val(policyCoverage.createdDate);

                let url = "/coverage/updatepolicycoverage.html?id=" + policyCoverage.id +
                    "&active=" + policyCoverage.active +
                    "&createddate=" + policyCoverage.createdDate;

                window.location.href = url;
            },
            error: function(error){
                console.log(error);
                alert("Error -> " + error);
            }
        });        
    });
});