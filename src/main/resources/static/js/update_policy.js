$(document).ready(function(){
    $("#update_policy_form").submit(function(evt) {
        evt.preventDefault();
        try {
            let policyId = $("#policy_id").val();

            // PREPARE FORM DATA
            let formData = {
            policyNumber : $("#policy_number").val(),
                policyEffectiveDate :  $("#policy_effective_date").val(),
                policyExpireDate: $("#policy_expire_date").val(),
                paymentOption: $("#payment_option").val(),
                totalAmount: $("#total_amount").val(),
                active: $("#active").val(),
                additionalInfos: $("#additional_infos").val(),
                creationDate: $("#creation_date").val()
        }         
            $.ajax({
                url: '/api/policy/updatebyid/' + policyId + "/",
                type: 'PUT',
                contentType : "application/json",
                data: JSON.stringify(formData),
                dataType : 'json',
                async: false,
                cache: false,
                success: function (response) {            
                    let successAlert = '<div class="alert alert-success alert-dismissible fade show" role="alert">' + 
                                            '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>' +
                                            '<strong> Policy N°' + policyId + ' has been successfully updated! Redirecting to all policies page... </strong>'
                                        '</div>'

                    $("#response").empty();
                    $("#response").append(successAlert);
                    $("#response").css({"display": "block"});
                    
                    setTimeout( () => { 
                    	window.location = "/policies.html";
                    }, 2500);
                },

                error: function (response) {
                    let errorAlert = '<div class="alert alert-danger alert-dismissible fade show" role="alert">' + 
                                        '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>' +
                                        '<strong> There was an error updating this policy, please try again </strong>'
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
        let id_of_button = (event.srcElement.id);
        let policyId = id_of_button.split("_")[2];
  
        $.ajax({
            url: '/api/policy/findone/' + policyId,
            type: 'GET',
            success: function(response) {
                let policy = response.policys[0];                
                $("#policy_id").val(policy.id);
                $("#policy_number").val(policy.policyNumber);
                $("#policy_effective_date").val(policy.policyEffectiveDate);
                $("#policy_expire_date").val(policy.policyExpireDate);
                $("#payment_option").val(policy.paymentOption);
                $("#total_amount").val(policy.totalAmount);
                $("#active").val(policy.active);
                $("#additional_infos").val(policy.additionalInfos);
                $("#creation_date").val(policy.creationDate);

                let url = "/policy_update.html?id=" + policy.id + 
                "&policynumber=" + policy.policyNumber + 
                "&effectivedate=" + policy.policyEffectiveDate +
                "&expiredate=" + policy.policyExpireDate +
                "&paymentoption=" + policy.paymentOption +
                "&totalamount=" + policy.totalAmount +
                "&active=" + policy.active +
                "&additionalinfos=" + policy.additionalInfos +
                "&creationdate=" + policy.creationDate;
                
                window.location.href = url;

            },
            error: function(error){
                console.log(error);
                alert("Error -> " + error);
            }
        });    
    });
});