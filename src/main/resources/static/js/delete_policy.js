$(document).ready(function(){
    let policyId = 0;

    $(document).on("click", "#div_policy_table table button.btn_delete", function() {
        let btn_id = (event.srcElement.id);
        policyId = btn_id.split("_")[2];

        $("div.modal-body")
            .text("Do you want delete a Policy with id = " + policyId + " ?");
        $("#model-delete-btn").css({"display": "inline"});
    });

    $(document).on("click", "#model-delete-btn", function() {
        $.ajax({
            url: '/api/policy/deletebyid/' + policyId,
            type: 'DELETE',
            success: function(response) {
                $("div.modal-body")
                    .text("Delete successfully a Policy with id = " + policyId + "!");

                $("#model-delete-btn").css({"display": "none"});
                $("button.btn.btn-secondary").text("Close");

                // delete the policy row on html page
                let row_id = "tr_" + policyId;
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