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
                window.location = "/policies.html"; 
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
