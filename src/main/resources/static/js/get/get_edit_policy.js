$(document).ready(function(){
    (function(){
        $.ajax({
            type : "GET",
            url : "/api/editLog/retrieveinfos",
            success: function(response){
               $.each(response.editLogPolicies, (i, PolicyEditLog) => {  
              /*  <button type="button" class="btn btn-danger btn_delete" data-toggle="modal" data-target="#myModal">
                Open modal
              </button>*/

                let deleteButton = '<button ' + 'id=' + '\"' + 'btn_delete_' + PolicyEditLog.id + '\"'+
                                        ' type="button" class="btn btn-danger btn_delete" data-bs-toggle="modal" data-bs-target="#delete-modal"' +
                                        '>&times</button>';

                let get_More_Info_Btn = '<button' +
                                            ' id=' + '\"' + 'btn_id_' + PolicyEditLog.id + '\"' +
                                            ' type="button" class="btn btn-info btn_id">' + 
                                            PolicyEditLog.id +
                                            '</button>';
                
                let tr_id = 'tr_' + PolicyEditLog.id;
                let policyEditRow = '<tr id=\"' + tr_id + "\"" + '>' +
                          '<td>' + get_More_Info_Btn + '</td>' +
                          '<td class=\"td_edited_by\">' + PolicyEditLog.editedBy.toUpperCase() + '</td>' +
                          '<td class=\"td_edited_date\">' + PolicyEditLog.editedDate + '</td>' +
                          '<td>' + deleteButton + '</td>' +
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