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
                    let successAlert = '<div class="alert alert-success alert-dismissible fade show" role="alert">' +
                                            '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>' +
                                            '<strong> Policy Edit Log N°' + policyEditLogId + ' has been successfully updated! Redirecting to all edit log policies page... </strong>' +
                                        '</div>'

                    $("#response").empty();
                    $("#response").append(successAlert);
                    $("#response").css({"display": "block"});

                    setTimeout( () => {
                        window.location = "/policyeditlog/policies_edit_log.html";
                    }, 2500);
                },

                error: function (response) {
                    let errorAlert = '<div class="alert alert-danger alert-dismissible fade show" role="alert">' +
                                        '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>' +
                                        '<strong> There was an error updating this edit log policy, please try again </strong>' +
                                    '</div>'

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

                let url = "/policyeditlog/policy_edit_log_update.html?editlogid=" + policyEditLog.id +
                    "&editedtablename=" + policyEditLog.editedTableName +
                    "&idartifact=" + policyEditLog.policy_id_artifact +
                    "&editeddate=" + policyEditLog.editedDate +
                    "&editedby=" + policyEditLog.editedBy +
                    "&additionalinfos=" + policyEditLog.additionalInfos;

                window.location.href = url;
            },
            error: function(error){
                console.log(error);
                alert("Error -> " + error);
            }
        });        
    });
});