$(document).ready(function(){
    let coverageId = 0;

    $(document).on("click", "#div_coverage_table table button.btn_delete", function() {
        let btn_id = (event.srcElement.id);
        coverageId = btn_id.split("_")[2];

        $("div.delete-form").text("All datas registered in coverage N°" + coverageId + " will be deleted, do you want to continue?");
        $("#model-delete-btn").css({"display": "inline"});
    });

    $(document).on("click", "#model-delete-btn", function() {
        $.ajax({
            url: '/api/coverage/deletebyid/' + coverageId,
            type: 'DELETE',
            success: function(response) {
                $("div.delete-form").text("All datas in coverage N°" + coverageId + " has been successfully deleted" + "!");

                $("#model-delete-btn").css({"display": "none"});
                $("button.btn.btn-secondary").text("Close");

                // delete the row on html page
                let row_id = "tr_" + coverageId;
                $("#" + row_id).remove();
                $("#div_coverage_updating").css({"display": "none"});
            },
            error: function(error){
                console.log(error);
                $("#div_coverage_updating").css({"display": "none"});
                alert("Error -> " + error);
            }
        });
    });
});