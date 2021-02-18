$(document).ready(function(){
    $("#update_bill_form").submit(function(evt) {
        evt.preventDefault();
        try {
            let billId = $("#bill_id").val();

            // PREPARE FORM DATA
            let formData = {
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
                url: '/api/bill/updatebyid/' + billId + "/",
                type: 'PUT',
                contentType : "application/json",
                data: JSON.stringify(formData),
                dataType : 'json',
                async: false,
                cache: false,
                success: function (response) {
                    let successAlert = '<div class="alert alert-success alert-dismissible fade show" role="alert">' +
                        '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>' +
                        '<strong> Bill N°' + billId + ' has been successfully updated! Redirecting to all bill page... </strong>' +
                    '</div>'

                    $("#response").empty();
                    $("#response").append(successAlert);
                    $("#response").css({"display": "block"});

                    setTimeout( () => {
                        window.location = "/bill/bills.html";
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
        let billId = id_of_button.split("_")[2];

        $.ajax({
            url: '/api/bill/findone/' + billId,
            type: 'GET',
            success: function(response) {
                let bill = response.bill[0];

                console.log(response);

                $("#policyID").val(bill.id);
                $("#dueDate").val(bill.dueDate);
                $("#minimumPayment").val(bill.minimumPayment);
                $("#createdDate").val(bill.createdDate);
                $("#balance").val(bill.balance);
                $("#status").val(bill.status);

                let url = "/paymentdetail/updatebill.html?id=" + bill.id +
                    "&dueDate=" + bill.dueDate +
                    "&minimumPayment=" + bill.minimumPayment +
                    "&createdDate=" + bill.createdDate +
                    "&balance=" + bill.balance +
                    "&status=" + bill.status;

                window.location.href = url;

            },
            error: function(error){
                console.log(error);
                alert("Error -> " + error);
            }
        });
    });
});