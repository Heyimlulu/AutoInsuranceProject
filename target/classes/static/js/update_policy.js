$(document).ready(function(){
    $("#update_policy_form").submit(function(evt) {
        evt.preventDefault();
        try {
            let policyId = $("#policyID").val();

            // PREPARE FORM DATA
            let formData = {
                policyNumber : $("#policyNumber").val(),
                policyEffectiveDate :  $("#policyEffectiveDate").val(),
                policyExpireDate: $("#policyExpireDate").val(),
                paymentOption: $("#paymentOption").val(),
                totalAmount: $("#totalAmount").val(),
                active: $("#active").val(),
                additionalInfos: $("#additionalInfos").val(),
                creationDate: $("#creationDate").val()
            }

            // If effective date is greater than expiracy date
            if(Date.parse($("#policyEffectiveDate").val()) > Date.parse($("#policyExpireDate").val())){
                let errorAlert = '<div class="alert alert-danger alert-dismissible fade show" role="alert">' +
                    '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>' +
                    '<strong>' + 'Error: Effective date cannot be greater than expiracy date' + '</strong>' +
                    '</div>'
                $("#response").append(errorAlert);
                $("#response").css({"display": "block"});
                return;
            }

            // Effective date plus grande que effective date
            if(Date.parse($("#policyEffectiveDate").val()) < Date.parse($("#creationDate").val())){
                let errorAlert = '<div class="alert alert-danger alert-dismissible fade show" role="alert">' +
                    '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>' +
                    '<strong>' + 'Error: Invalid creation date' + '</strong>' +
                    '</div>'
                $("#response").append(errorAlert);
                $("#response").css({"display": "block"});
                return;
            }

            // If the dates are all the same
            if(Date.parse($("#policyEffectiveDate").val()) == Date.parse($("#policyExpireDate").val()) || Date.parse($("#policyEffectiveDate").val()) == Date.parse($("#creationDate"))){
                let errorAlert = '<div class="alert alert-danger alert-dismissible fade show" role="alert">' +
                    '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>' +
                    '<strong>' + 'Error: Invalid dates' + '</strong>' +
                    '</div>'
                $("#response").append(errorAlert);
                $("#response").css({"display": "block"});
                return;
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
                $("#policyID").val(policy.id);
                $("#policyNumber").val(policy.policyNumber);
                $("#policyEffectiveDate").val(policy.policyEffectiveDate);
                $("#policyExpireDate").val(policy.policyExpireDate);
                $("#paymentOption").val(policy.paymentOption);
                $("#totalAmount").val(policy.totalAmount);
                $("#active").val(policy.active);
                $("#additionalInfos").val(policy.additionalInfos);
                $("#creationDate").val(policy.creationDate);

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