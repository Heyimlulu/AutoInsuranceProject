$(document).ready(function(){
    $("#update_policy_form").submit(function(evt) {
        evt.preventDefault();
        try {
            let policyId = $("#policyID").val();

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
                url: '/api/driver/updatebyid/' + policyId + "/",
                type: 'PUT',
                contentType : "application/json",
                data: JSON.stringify(formData),
                dataType : 'json',
                async: false,
                cache: false,
                success: function (response) {            
                    let successAlert = '<div class="alert alert-success alert-dismissible fade show" role="alert">' + 
                                            '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>' +
                                            '<strong> Driver N°' + policyId + ' has been successfully updated! Redirecting to all driver page... </strong>'
                                        '</div>'

                    $("#response").empty();
                    $("#response").append(successAlert);
                    $("#response").css({"display": "block"});
                    
                    setTimeout( () => { 
                    	window.location = "/driver/drivers.html";
                    }, 2500);
                },

                error: function (response) {
                    let errorAlert = '<div class="alert alert-danger alert-dismissible fade show" role="alert">' + 
                                        '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>' +
                                        '<strong> There was an error updating this driver, please try again </strong>'
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
                $("#Title").val(Title);
                $("#FirstName").val(FirstName);
                $("#LastName").val(LastName);
                $("#MiddleInital").val(MiddleInital);
                $("#DoB").val(DoB);
                $("#Email").val(Email);
                $("#PhoneNumber").val(PhoneNumber);
                $("#CellNumber").val(CellNumber);
                $("#SSN").val(SSN);
                $("#LicenseIssuedDate").val(LicenseIssuedDate);
                $("#LicenseIssuedState").val(LicenseIssuedState);
                $("#LicenseNumber").val(LicenseNumber);
                $("#IsPrimaryPolicyHolder").val(IsPrimaryPolicyHolder);
                $("#RelationWithPrimaryPolicyHolder").val(RelationWithPrimaryPolicyHolder);
                $("#Gender").val(Gender);
                $("#MaritalStatuts").val(MaritalStatuts);
                $("#CreatedDate").val(CreatedDate);
				$("#active").val(active);

                let url = "/driver/updatedriver.html?id=" + policy.id +
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