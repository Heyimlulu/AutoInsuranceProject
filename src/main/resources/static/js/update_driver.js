$(document).ready(function(){
    $("#update_driver_form").submit(function(evt) {
        evt.preventDefault();
        try {
            let policyId = $("#policyID").val();

            // PREPARE FORM DATA
            let formData = {
           	policyID: $("#policyID").val(),
        	title: $("#Title").val(),
        	first_name: $("#FirstName").val(),
        	last_name: $("#LastName").val(),
            middleInitial: $("#MiddleInitial").val(),
            dob: $("#DoB").val(),
            email_adress: $("#Email").val(),
            phone_number: $("#PhoneNumber").val(),
            cellNumber: $("#CellNumber").val(),
            ssn: $("#SSN").val(),
            license_issue_date: $("#LicenseIssuedDate").val(),
            license_issue_state: $("#LicenseIssuedState").val(),
            license_number: $("#LicenseNumber").val(),
            is_primary_policy_holder: $("#IsPrimaryPolicyHolder").val(),
            relation_withPrimary_policy_holder: $("#RelationWithPrimaryPolicyHolder").val(),
            gender: $("#Gender").val(),
            marital_statut: $("#MaritalStatuts").val(),
            created_date: $("#CreatedDate").val(),
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
            url: '/api/driver/findone/' + policyId,
            type: 'GET',
            success: function(response) {
                let driver = response.drivers[0];

                console.log(response.drivers[0]);

                $("#policyID").val(driver.id);
                $("#Title").val(driver.title);
                $("#FirstName").val(driver.first_name);
                $("#LastName").val(driver.last_name);
                $("#MiddleInital").val(driver.middleInitial);
                $("#DoB").val(driver.dob);
                $("#Email").val(driver.email_adress);
                $("#PhoneNumber").val(driver.phone_number);
                $("#CellNumber").val(driver.cellNumber);
                $("#SSN").val(driver.ssn);
                $("#LicenseIssuedDate").val(driver.license_issue_date);
                $("#LicenseIssuedState").val(driver.license_issue_state);
                $("#LicenseNumber").val(driver.license_number);
                $("#IsPrimaryPolicyHolder").val(driver.is_primary_policy_holder);
                $("#RelationWithPrimaryPolicyHolder").val(driver.relation_withPrimary_policy_holder);
                $("#Gender").val(driver.gender);
                $("#MaritalStatuts").val(driver.marital_statut);
                $("#CreatedDate").val(driver.created_date);
				$("#active").val(driver.active);

                let url = "/driver/updatedriver.html?id=" + driver.id +
                "&title=" + driver.title +
                "&firstname=" + driver.first_name +
                "&lastname=" + driver.last_name +
                "&middleinitial=" + driver.middleInitial +
                "&dob=" + driver.dob +
                "&email=" + driver.email_adress +
                "&phonenumber=" + driver.phone_number +
                "&cellnumber=" + driver.cellNumber +
                "&ssn=" + driver.ssn +
                "&licenseissueddate=" + driver.license_issue_date +
                "&licenseissuedstate=" + driver.license_issue_state +
                "&licensenumber=" + driver.license_number +
                "&isprimarypolicyholder=" + driver.is_primary_policy_holder +
                "&relationwithprimarypolicyholder=" + driver.relation_withPrimary_policy_holder +
                "&gender=" + driver.gender +
                "&maritalstatus=" + driver.marital_statut +
                "&createddate=" + driver.created_date +
                "&active=" + driver.active;
                
                window.location.href = url;

            },
            error: function(error){
                console.log(error);
                alert("Error -> " + error);
            }
        });    
    });
});