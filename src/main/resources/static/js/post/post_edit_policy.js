$(document).ready(function() {
    $("#add_new_edit_policy").submit(function(evt) {
        evt.preventDefault();
        let policyId = $("#policy_id_artifact").val();

        // PREPARE FORM DATA
        let formData = {
        	policyId : $("#policy_id_artifact").val(),
            editedTableName : $("#editedTableName").val(),
            editedDate :  $("#editedDate").val(),
            editedBy: $("#editedBy").val(),
            additionalInfos: $("#additionalInfos").val()
        }
		
        $.ajax({
            url: '/api/editLog/create/' + policyId,
            type: 'POST',
            contentType : "application/json",
            data: JSON.stringify(formData),
            dataType : 'json',
            async: false,
            cache: false,
            success: function (response) {
                window.location = "/policy/policieseditlog.html";
            },
            error: function (response) {
                let errorAlert = '<div class="alert alert-danger alert-dismissible fade show" role="alert">' + 
                                    '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>' +
                                    '<strong>' + response.message + '</strong>' + ' ,Error: ' + message.error + 
                                '</div>'
                $("#response").append(errorAlert);
                $("#response").css({"display": "block"});

                resetUploadForm();
            }
        });
    });

    function resetUploadForm(){
        $("#editedTableName").val("");
        $("#editedDate").val("");
        $("#editedBy").val("");
        $("#additionalInfos").val("");
    }

    (function(){
        let pathname = window.location.pathname;
        if(pathname === "/"){
            $(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/edit_policies.html") {
            $(".nav .nav-item a:last").addClass("active");
        }
    })();
});
