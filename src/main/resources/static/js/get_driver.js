$(document).ready(function(){
    (function(){
        $.ajax({
            type : "GET",
            url : "/api/driver/retrieveinfos",
            success: function(response){
              $.each(response.driver, (i, driver) => { 

              /*  <button type="button" class="btn btn-danger btn_delete" data-toggle="modal" data-target="#myModal">
                Open modal
              </button>*/

                let deleteButton = '<button ' +
                                        'id=' +
                                        '\"' + 'btn_delete_' + driver.id + '\"'+
                                        ' type="button" class="btn btn-danger btn_delete" data-toggle="modal" data-target="#delete-modal"' +
                                        '>&times</button>';

                let get_More_Info_Btn = '<button' +
                                            ' id=' + '\"' + 'btn_id_' + driver.id + '\"' +
                                            ' type="button" class="btn btn-info btn_id">' + 
                                            driver.id +
                                            '</button>';
                
                let tr_id = 'tr_' + policy.id;
                let driverRow = '<tr id=\"' + tr_id + "\"" + '>' +
                          '<td>' + get_More_Info_Btn + '</td>' +
                          '<td class=\"td_creation_date\">' + driver.creationDate + '</td>' +
                          '<td>' + deleteButton + '</td>' +
                          '</tr>';              
                $('#driverTable tbody').append(driverRow);
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
        if (pathname == "/all_driver.html") {
            $(".nav .nav-item a:last").addClass("active");
        }
    })();
});