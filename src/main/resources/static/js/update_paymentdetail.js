$(document).ready(function(){
    $("#update_paymentdetail_form").submit(function(evt) {
        evt.preventDefault();
        try {
            let paymentDetailId = $("#billID").val();

            // PREPARE FORM DATA
            let formData = {
                createdDate :  $("#createdDate").val(),
                paidDate: $("#paidDate").val(),

                payerFirstName: $("#payerFirstname").val(),
                payerLastName: $("#payerLastname").val(),
                amount: $("#amount").val(),
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
            }

            $.ajax({
                url: '/api/paymentdetail/updatebyid/' + paymentDetailId + "/",
                type: 'PUT',
                contentType : "application/json",
                data: JSON.stringify(formData),
                dataType : 'json',
                async: false,
                cache: false,
                success: function (response) {
                    let successAlert = '<div class="alert alert-success alert-dismissible fade show" role="alert">' +
                        '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>' +
                        '<strong> Payment detail N°' + paymentDetailId + ' has been successfully updated! Redirecting to all bill page... </strong>' +
                    '</div>'

                    $("#response").empty();
                    $("#response").append(successAlert);
                    $("#response").css({"display": "block"});

                    setTimeout( () => {
                        window.location = "/paymentdetails/paymentdetails.html";
                    }, 2500);
                },

                error: function (response) {
                    let errorAlert = '<div class="alert alert-danger alert-dismissible fade show" role="alert">' +
                        '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>' +
                        '<strong> There was an error updating this policy, please try again </strong>' +
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
        // split the ID from the component button and class .btn_id
        let id_of_button = (event.srcElement.id);
        let paymentDetailId = id_of_button.split("_")[2];

        $.ajax({
            url: '/api/paymentdetail/findone/' + paymentDetailId,
            type: 'GET',
            success: function(response) {
                let paymentDetail = response.paymentDetail[0];

                $("#billID").val(paymentDetail.id);
                $("#createdDate").val(paymentDetail.createdDate);
                $("#paidDate").val(paymentDetail.paidDate);

                $("#payerFirstName").val(paymentDetail.payerFirstName);
                $("#payerLastname").val(paymentDetail.payerLastname);
                $("#amount").val(paymentDetail.amount),
                $("#paymentMethod").val(paymentDetail.paymentMethod);
                $("#debitCredit").val(paymentDetail.debitCredit);
                $("#additionalInfo").val(paymentDetail.additionalInfo);

                $("#cardNumber").val(paymentDetail.cardNumber);
                $("#zipCode").val(paymentDetail.zipCode);
                $("#cardExpireDate").val(paymentDetail.cardExpireDate);
                $("#cardType").val(paymentDetail.cardType);

                $("#bankName").val(paymentDetail.bankName);
                $("#routingNumber").val(paymentDetail.routingNumber);
                $("#accountNumber").val(paymentDetail.accountNumber);
                $("#checkNumber").val(paymentDetail.checkNumber);
                $("#checkImage").val(paymentDetail.checkImage);

                let url = "/paymentdetail/updatepaymentdetail.html?id=" + paymentDetail.id +
                    "&createdDate=" + paymentDetail.createdDate +
                    "&paidDate=" + paymentDetail.paidDate +

                    "&payerFirstName=" + paymentDetail.payerFirstName +
                    "&payerLastName=" + paymentDetail.payerLastName +
                    "&amount=" + paymentDetail.amount +
                    "&paymentMethod=" + paymentDetail.paymentMethod +
                    "&debitCredit=" + paymentDetail.debitCredit +
                    "&additionalInfo=" + paymentDetail.additionalInfo +

                    "&cardNumber=" + paymentDetail.cardNumber +
                    "&zipCode=" + paymentDetail.zipCode +
                    "&cardExpireDate=" + paymentDetail.cardExpireDate +
                    "&cardType=" + paymentDetail.cardType +

                    "&bankName=" + paymentDetail.bankName +
                    "&routingNumber=" + paymentDetail.routingNumber +
                    "&accountNumber=" + paymentDetail.accountNumber +
                    "&checkNumber=" + paymentDetail.checkNumber

                window.location.href = url;

            },
            error: function(error){
                console.log(error);
                alert("Error -> " + error);
            }
        });
    });
});