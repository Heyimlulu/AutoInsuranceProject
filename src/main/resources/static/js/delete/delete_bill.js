$(document).ready(function(){
    let billId = 0;

    $(document).on("click", "#div_bill_table table button.btn_delete", function() {
        let btn_id = (event.srcElement.id);
        billId = btn_id.split("_")[2];

        $("div.modal-body").text("All datas registered in bill N°" + billId + " will be deleted, do you want to continue?");
        $("#model-delete-btn").css({"display": "inline"});
    });

    $(document).on("click", "#model-delete-btn", function() {
        $.ajax({
            url: '/api/bill/deletebyid/' + billId,
            type: 'DELETE',
            success: function(response) {
                $("div.modal-body").text("All datas in bill N°" + billId + " has been successfully deleted" + "!");

                $("#model-delete-btn").css({"display": "none"});
                $("button.btn.btn-secondary").text("Close");

                // delete the policy row on html page
                let row_id = "tr_" + billId;
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