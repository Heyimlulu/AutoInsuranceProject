$(document).ready(function(){
    (function(){
        $.ajax({
            type : "GET",
            url : "/api/editLog/retrieveinfos",
            success: function(response){
               $.each(response.editLogPolicies, (i, PolicyEditLog) => {

                let deleteButton = '<button ' + 'id=' + '\"' + 'btn_delete_' + PolicyEditLog.id + '\"'+
                                        ' type="button" class="btn btn-danger btn_delete" data-bs-toggle="modal" data-bs-target="#delete-modal"' +
                                        '>Delete</button>';

                let get_More_Info_Btn = '<button' +
                    ' id=' + '\"' + 'btn_id_' + PolicyEditLog.id + '\"' +
                    ' type="button" class="btn btn-warning btn_id">' +
                    'Edit' +
                    '</button>';
                
                let tr_id = 'tr_' + PolicyEditLog.id;
                let policyEditRow = '<tr id=\"' + tr_id + "\"" + '>' +
                    '<td>' + PolicyEditLog.id + '</td>' +
                    '<td class=\"td_edited_tablename\">' + PolicyEditLog.editedTableName + '</td>' +
                    '<td class=\"td_edited_date\">' + PolicyEditLog.editedDate + '</td>' +
                    '<td class=\"td_edited_by\">' + PolicyEditLog.editedBy + '</td>' +
                    '<td class=\"td_additionalInfos\">' + PolicyEditLog.additionalInfos + '</td>' +
                    '<td>' +  `${get_More_Info_Btn} <span class="separator">|</span> ${deleteButton}` + '</td>' +
                    '</tr>';
                $('#PolicyEditLogTable tbody').append(policyEditRow);
              });
            },
            error : function(e) {
              alert("ERROR: ", e);
              console.log("ERROR: ", e);
            }
        });
    })();        
    
    (function(){
        let pathname = window.location.pathname;
        if (pathname == "/edit_policies.html") {
            $(".nav .nav-item a:last").addClass("active");
        }
    })();
});