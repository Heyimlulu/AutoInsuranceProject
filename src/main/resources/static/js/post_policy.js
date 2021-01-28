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
                let errorAlert = '<div class="alert alert-danger alert-dismissible fade show" role="alert">' + 
                                    '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>' +
                                    '<strong>' + response.message + '</strong>' + ' ,Error: ' + message.error + 
                                '</div>'
                $("#response").append(errorAlert);
                $("#response").css({"display": "block"});

                location.replace("https://www.w3schools.com");
            }
        });
    });

    function todayDate() {
        var today = new Date(); // get the current date
        var dd = today.getDate(); // get the day from today.
        var mm = today.getMonth()+1; // get the month from today +1 because january is 0!
        var yyyy = today.getFullYear(); // get the year from today
    
        // if day is below 10, add a zero
        if(dd < 10) {
            dd = '0' + dd
        }
    
        // if day is below 10, add a zero
        if(mm < 10) {
            mm = '0' + mm
        }
    
        // final result is dd/mm/yyyy
        return dd + '/' + mm + '/' + yyyy;
    }

    $(document).ready(function(){
        $('#policyEffectiveDate').attr('min', todayDate());
        $('#policyExpireDate').attr('min', todayDate());
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
