$(document).ready(function(){
    (function(){
        $.ajax({
            type : "GET",
            url : "/api/driver/retrieveinfos",
            success: function(response){
              $.each(response.policys, (i, driver) => { 

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
                          '<td class=\"td_first_name\">' + driver.FirstName.toUpperCase() + '</td>' +
                          '<td class=\"td_last_name\">' + driver.LastName + '</td>' +
                          '<td class=\"td_creation_date\">' + driver.CreatedDate + '</td>' +
                          '<td>' + deleteButton + '</td>' +
                          '</tr>';              
                $('#driverTable tbody').append(policyRow);
              });
            },
            error : function(e) {
              alert("ERROR: ", e);
              console.log("ERROR: ", e);
            }
        });      
    })();
});