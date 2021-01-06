$(document).ready(function(){
    $("#update_edit_log_policy_form").submit(function(evt) {
        evt.preventDefault();
        try {
            let policyEditLogId = $("#edit_log_policy_id").val();

            // PREPARE FORM DATA
            let formData = {
            editedTableName : $("#edit_log_policy_edited_table").val(),
                policy_id_artifact :  $("#policy_id_artifact").val(),
                editedDate: $("#edit_log_policy_edited_date").val(),
                editedBy: $("#edit_log_policy_edited_by").val(),
                additionalInfos: $("#edit_log_additional_info").val()
        }        
            $.ajax({
                url: '/api/editLog/updatebyid/' + policyEditLogId + "/",
                type: 'PUT',
                contentType : "application/json",
                data: JSON.stringify(formData),
                dataType : 'json',
                async: false,
                cache: false,
                success: function (response) {
                    let policyEditLog = response.editLogPolicies[0];
                    let policyEditLogString = "{editedTableName:" + policyEditLog.editedTableName + 
                                                " ,policy_id_artifact:" + policyEditLog.policy_id_artifact + 
                                                ", editedDate:" + policyEditLog.editedDate +
                                                ", editedBy:" + policyEditLog.editedBy +  
                                                ", additionalInfos:" + policyEditLog.additionalInfos  + "}"
                    
                    let successAlert = '<div class="alert alert-success alert-dismissible">' + 
                                            '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                            '<strong>' + response.message + '</strong> PolicyEditLog\'s Info = ' + policyEditLogString;
                                        '</div>'

                    // change the updated data for policy edit log table record
                    $("#tr_" + policyEditLogId + " td.td_edited_by").text(policyEditLog.editedBy.toUpperCase());
                    $("#tr_" + policyEditLogId + " td.td_edited_date").text(policyEditLog.editedDate.toUpperCase());

                    $("#response").empty();
                    $("#response").append(successAlert);
                    $("#response").css({"display": "block"});
                },

                error: function (response) {
                    let errorAlert = '<div class="alert alert-danger alert-dismissible">' + 
                                        '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                        '<strong>' + response.message + '</strong>' + ' ,Error: ' + message.error + 
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
        let id_of_button = (event.srcElement.id);
        let policyEditLogId = id_of_button.split("_")[2];
  
        $.ajax({
            url: '/api/editLog/findone/' + policyEditLogId,
            type: 'GET',
            success: function(response) {
                let policyEditLog = response.editLogPolicies[0];                
                $("#edit_log_policy_id").val(policyEditLog.id);
                $("#edit_log_policy_edited_table").val(policyEditLog.editedTableName);
                $("#policy_id_artifact").val(policyEditLog.policy_id_artifact);
                $("#edit_log_policy_edited_date").val(policyEditLog.editedDate);
                $("#edit_log_policy_edited_by").val(policyEditLog.editedBy);
                $("#edit_log_additional_info").val(policyEditLog.additionalInfos);
                $("#div_edit_log_policy_updating").css({"display": "block"});
            },
            error: function(error){
                console.log(error);
                alert("Error -> " + error);
            }
        });        
    });
});