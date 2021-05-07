$(document).ready(function(){
    let policyEditLogId = 0;

    $(document).on("click", "#div_edit_log_policy_table table button.btn_delete", function() {
        let btn_id = (event.srcElement.id);
        policyEditLogId = btn_id.split("_")[2];

        $("div.modal-body")
            .text("Policy Edit Log N°" + policyEditLogId + " will be deleted, do you want to continue?");
        $("#model-delete-btn").css({"display": "inline"});
    });

    $(document).on("click", "#model-delete-btn", function() {
        $.ajax({
            url: '/api/editLog/deletebyid/' + policyEditLogId,
            type: 'DELETE',
            success: function(response) {
                $("div.modal-body").text("Policy Edit Log N°" + policyEditLogId + " has been successfully deleted" + "!");

                $("#model-delete-btn").css({"display": "none"});
                $("button.btn.btn-secondary").text("Close");

                // delete the policy row on html page
                let row_id = "tr_" + policyEditLogId;
                $("#" + row_id).remove();
                $("#div_edit_log_policy_updating").css({"display": "none"});
            },
            error: function(error){
                console.log(error);
                $("#div_edit_log_policy_updating").css({"display": "none"});
                alert("Error -> " + error);
            }
        });
    });
});