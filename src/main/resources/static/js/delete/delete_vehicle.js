$(document).ready(function(){
    let vehicleId = 0;

    $(document).on("click", "#div_vehicle_table table button.btn_delete", function() {
        let btn_id = (event.srcElement.id);
        vehicleId = btn_id.split("_")[2];

        $("div.delete-form").text("Vehicle N°" + vehicleId + " will be deleted, do you want to continue?");
        $("#model-delete-btn").css({"display": "inline"});
    });

    $(document).on("click", "#model-delete-btn", function() {
        $.ajax({
            url: '/api/vehicle/deletebyid/' + vehicleId,
            type: 'DELETE',
            success: function(response) {
                $("div.delete-form").text("Vehicle N°" + vehicleId + " has been successfully deleted" + "!");

                $("#model-delete-btn").css({"display": "none"});
                $("button.btn.btn-secondary").text("Close");

                // delete the policy row on html page
                let row_id = "tr_" + vehicleId;
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