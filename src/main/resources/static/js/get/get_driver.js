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
                    '>Delete</button>';

                let get_More_Info_Btn = '<button' +
                    ' id=' + '\"' + 'btn_id_' + driver.id + '\"' +
                    ' type="button" class="btn btn-warning btn_id">' +
                    'Edit' +
                    '</button>';
                
                let tr_id = 'tr_' + driver.id;
                let driverRow = '<tr id=\"' + tr_id + "\"" + '>' +
                    '<td>' + driver.id + '</td>' +
                    '<td class=\"td_creation_date\">' + driver.created_date + '</td>' +
                    '<td class=\"td_active\">' + driver.active + '</td>' +
                    '<td class=\"td_title\">' + driver.title + '</td>' +
                    '<td class=\"td_first_name\">' + driver.first_name + '</td>' +
                    '<td class=\"td_last_name\">' + driver.last_name + '</td>' +
                    '<td class=\"td_middleInitial\">' + driver.middleInitial + '</td>' +
                    '<td class=\"td_dob\">' + driver.dob + '</td>' +
                    '<td class=\"td_email\">' + driver.email_adress + '</td>' +
                    '<td class=\"td_phone\">' + driver.phone_number + '</td>' +
                    '<td class=\"td_cellphone\">' + driver.cellNumber + '</td>' +
                    '<td class=\"td_gender\">' + driver.gender + '</td>' +
                    '<td class=\"td_maritalStatus\">' + driver.marital_statut + '</td>' +
                    '<td>' +  `${get_More_Info_Btn} <span class="separator">|</span> ${deleteButton}` + '</td>' +
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