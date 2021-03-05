$(document).ready(function() {
    $("#add_new_paymentdetail").submit(function(evt) {
        evt.preventDefault();

        let billId = $("#billID").val();

        // PREPARE FORM DATA
        let formData = {
            billID : $("#billID").val(),
            createdDate :  $("#createdDate").val(),
            paidDate: $("#paidDate").val(),

            payerFirstName: $("#payerFirstname").val(),
            payerLastName: $("#payerLastname").val(),
            paymentMethod: $("#paymentMethod").val(),
            debitCredit: $("#debitCredit").val(),
            additionalInfo: $("#additionalInfo").val(),

            cardNumber: $("#cardNumber").val(),
            zipCode: $("#zipCode").val(),
            cardExpireDate: $("#cardExpireDate").val(),
            cardType: $("#cardType").val(),

            bankName: $("#bankName").val(),
            routingNumber: $("#routingNumber").val(),
            accountNumber: $("#accountNumber").val(),
            checkNumber: $("#checkNumber").val(),
            checkImage: $("#checkImage").val(),
        }

        $.ajax({
            url: '/api/paymentdetail/create/' + billId,
            type: 'POST',
            contentType : "application/json",
            data: JSON.stringify(formData),
            dataType : 'json',
            async: false,
            cache: false,
            success: function (response) {
                window.location = "/paymentdetail/paymentdetails.html";
            },
            error: function (response) {
                let errorAlert = '<div class="alert alert-danger alert-dismissible fade show" role="alert">' +
                    '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>' +
                    '<strong> There was an error adding this payment detail, please make sure the ID is correct </strong>' +
                '</div>';

                $("#response").append(errorAlert);
                $("#response").css({"display": "block"});
            }
        });
    });
});
