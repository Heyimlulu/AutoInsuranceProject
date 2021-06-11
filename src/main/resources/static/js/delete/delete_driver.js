	$(document).ready(function(){
    let policyId = 0;

    $(document).on("click", "#div_driver_table table button.btn_delete", function() {
        let btn_id = (event.srcElement.id);
        policyId = btn_id.split("_")[2];

        $("div.delete-form").text("Driver N°" + policyId + " will be deleted, do you want to continue?");
        $("#model-delete-btn").css({"display": "inline"});
    });

    $(document).on("click", "#model-delete-btn", function() {
        $.ajax({
            url: '/api/driver/deletebyid/' + policyId,
            type: 'DELETE',
            success: function(response) {
                $("div.delete-form").text("Driver N°" + policyId + " has been successfully deleted" + "!");

                $("#model-delete-btn").css({"display": "none"});
                $("button.btn.btn-secondary").text("Close");

                // delete the policy row on html page
                let row_id = "tr_" + policyId;
                $("#" + row_id).remove();
                $("#div_driver_updating").css({"display": "none"});
            },
            error: function(error){
                console.log(error);
                $("#div_driver_updating").css({"display": "none"});
                alert("Error -> " + error);
            }
        });
    });
});