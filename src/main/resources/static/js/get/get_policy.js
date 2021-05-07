$(document).ready(function(){
    (function(){
        $.ajax({
            type : "GET",
            url : "/api/policy/retrieveinfos",
            success: function(response){
              $.each(response.policys, (i, policy) => { 

              /*  <button type="button" class="btn btn-danger btn_delete" data-toggle="modal" data-target="#myModal">
                Open modal
              </button>*/

                let deleteButton = '<button ' +
                                        'id=' +
                                        '\"' + 'btn_delete_' + policy.id + '\"'+
                                        ' type="button" class="btn btn-danger btn_delete" data-bs-toggle="modal" data-bs-target="#delete-modal">' +
                                        '&times</button>';

                let get_More_Info_Btn = '<button' +
                                            ' id=' + '\"' + 'btn_id_' + policy.id + '\"' +
                                            ' type="button" class="btn btn-info btn_id">' + 
                                            policy.id +
                                            '</button>';
                
                let tr_id = 'tr_' + policy.id;
                let policyRow = '<tr id=\"' + tr_id + "\"" + '>' +
                          '<td>' + get_More_Info_Btn + '</td>' +
                          '<td class=\"td_policy_number\">' + policy.policyNumber.toUpperCase() + '</td>' +
                          '<td class=\"td_creation_date\">' + policy.creationDate + '</td>' +
                          '<td>' + deleteButton + '</td>' +
                          '</tr>';              
                $('#policyTable tbody').append(policyRow);
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
        if (pathname == "/policies.html") {
            $(".nav .nav-item a:last").addClass("active");
        }
    })();
});