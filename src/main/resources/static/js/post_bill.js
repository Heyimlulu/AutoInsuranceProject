$(document).ready(function() {
    $("#add_new_bill").submit(function(evt) {
        evt.preventDefault();

        let policyId = $("#policyID").val();

        // PREPARE FORM DATA
        let formData = {
            policyID : $("#policyID").val(),
            dueDate :  $("#dueDate").val(),
            minimumPayment: $("#minimumPayment").val(),
            createdDate: $("#createdDate").val(),
            balance: $("#balance").val(),
            status: $("#status").val(),
        }

        // If the dates are all the same
        if(Date.parse($("#dueDate").val()) == Date.parse($("#createdDate").val())){
            let errorAlert = '<div class="alert alert-danger alert-dismissible fade show" role="alert">' +
                '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>' +
                '<strong>' + 'Error: Invalid dates' + '</strong>' +
                '</div>'
            $("#response").append(errorAlert);
            $("#response").css({"display": "block"});
            return;
        }

        $.ajax({
            url: '/api/bill/create/' + policyId,
            type: 'POST',
            contentType : "application/json",
            data: JSON.stringify(formData),
            dataType : 'json',
            async: false,
            cache: false,
            success: function (response) {
                window.location = "/bill/bills.html";
            },
            error: function (response) {
                let errorAlert = '<div class="alert alert-danger alert-dismissible fade show" role="alert">' +
                    '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>' +
                    '<strong> There was an error adding this bill, please make sure the ID is correct </strong>' +
                '</div>';

                $("#response").append(errorAlert);
                $("#response").css({"display": "block"});
            }
        });
    });
});
