$(document).ready(function(){
    let paymentDetailId = 0;

    $(document).on("click", "#div_paymentdetail_table table button.btn_delete", function() {
        let btn_id = (event.srcElement.id);
        paymentDetailId = btn_id.split("_")[2];

        $("div.delete-form").text("Payment detail N°" + paymentDetailId + " will be deleted, do you want to continue?");
        $("#model-delete-btn").css({"display": "inline"});
    });

    $(document).on("click", "#model-delete-btn", function() {
        $.ajax({
            url: '/api/paymentdetail/deletebyid/' + paymentDetailId,
            type: 'DELETE',
            success: function(response) {
                $("div.delete-form").text("Payment detail N°" + paymentDetailId + " has been successfully deleted" + "!");

                $("#model-delete-btn").css({"display": "none"});
                $("button.btn.btn-secondary").text("Close");

                // delete the policy row on html page
                let row_id = "tr_" + paymentDetailId;
                $("#" + row_id).remove();
                $("#div_policy_updating").css({"display": "none"});
            },
            error: function(error){
                console.log(error);
                $("#div_policy_updating").css({"display": "none"});
                alert("Error -> " + error);
            }
        });
    });
});