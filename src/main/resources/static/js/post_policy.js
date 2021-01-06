$(document).ready(function() {
    $("#add_new_police").submit(function(evt) {
        evt.preventDefault();

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

        $.ajax({
            url: '/api/policy/create',
            type: 'POST',
            contentType : "application/json",
            data: JSON.stringify(formData),
            dataType : 'json',
            async: false,
            cache: false,
            success: function (response) {
                let policy = response.policys[0];
                let policyString = "{ policy number: " + policy.policyNumber + 
                                            ", policy effective date: " + policy.policyEffectiveDate +
                                            ", policy expire date: " + policy.policyExpireDate +
                                            ", policy payment option: " + policy.paymentOption +
                                            ", policy total amount: " + policy.totalAmount +
                                            ", policy is active: " + policy.active +
                                            ", policy additional infos: " + policy.additionalInfos +
                                            ", policy creation date: " + policy.creationDate  + " }"
                let successAlert = '<div class="alert alert-success alert-dismissible">' + 
                                        '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                        '<strong>' + response.message + '</strong> Policies\'s Info = ' + policyString;
                                    '</div>'
                $("#response").append(successAlert);
                $("#response").css({"display": "block"});

                resetUploadForm();
            },
            error: function (response) {
                let errorAlert = '<div class="alert alert-danger alert-dismissible">' + 
                                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                    '<strong>' + response.message + '</strong>' + ' ,Error: ' + message.error + 
                                '</div>'
                $("#response").append(errorAlert);
                $("#response").css({"display": "block"});

                location.replace("https://www.w3schools.com");
            }
        });
    });

    (function(){
        let pathname = window.location.pathname;
        if(pathname === "/"){
            $(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/policies.html") {
            $(".nav .nav-item a:last").addClass("active");
        }
    })();
});
