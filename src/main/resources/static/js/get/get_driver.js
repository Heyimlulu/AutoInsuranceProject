$(document).ready(function(){
    (function(){
        $.ajax({
            type : "GET",
            url : "/api/driver/retrieveinfos",
            success: function(response){

              $.each(response.drivers, (i, driver) => {

                let deleteButton = '<button ' +
                    'id=' +
                    '\"' + 'btn_delete_' + driver.id + '\"'+
                    ' type="button" class="btn btn-danger btn_delete" data-bs-toggle="modal" data-bs-target="#delete-modal"' +
                    '>&times</button>';

                let get_More_Info_Btn = '<button' +
                    ' id=' + '\"' + 'btn_id_' + driver.id + '\"' +
                    ' type="button" class="btn btn-info btn_id">' +
                    driver.id +
                    '</button>';
                
                let tr_id = 'tr_' + driver.id;
                let driverRow = '<tr id=\"' + tr_id + "\"" + '>' +
                    '<td>' + get_More_Info_Btn + '</td>' +
                    '<td class=\"td_first_name\">' + driver.first_name + '</td>' +
                    '<td class=\"td_last_name\">' + driver.last_name + '</td>' +
                    '<td class=\"td_creation_date\">' + driver.created_date + '</td>' +
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
});