$(document).ready(function(){
    (function(){
        $.ajax({
            type : "GET",
            url : "/api/vehicle/retrieveinfos",
            success: function(response){

                $.each(response.vehicle, (i, vehicle) => {

                    let deleteButton = '<button ' +
                        'id=' +
                        '\"' + 'btn_delete_' + vehicle.id + '\"'+
                        ' type="button" class="btn btn-danger btn_delete" data-bs-toggle="modal" data-bs-target="#delete-modal">' +
                        'Delete</button>';

                    let get_More_Info_Btn = '<button' +
                        ' id=' + '\"' + 'btn_id_' + vehicle.id + '\"' +
                        ' type="button" class="btn btn-warning btn_id">' +
                        'Edit' +
                        '</button>';

                    let active;
                    if (vehicle.active == true) {
                        active = 'Yes';
                    } else if (vehicle.active == false) {
                        active = 'No';
                    }

                    let tr_id = 'tr_' + vehicle.id;
                    let vehicleRow = '<tr id=\"' + tr_id + "\"" + '>' +
                        '<td>' + vehicle.id + '</td>' +
                        '<td class=\"td_created_date\">' + getDate(vehicle.createdDate) + '</td>' +
                        '<td class=\"td_active\">' + active + '</td>' +
                        '<td class=\"td_year\">' + vehicle.year + '</td>' +
                        '<td class=\"td_brand\">' + vehicle.make + '</td>' +
                        '<td class=\"td_model\">' + vehicle.model + '</td>' +
                        '<td class=\"td_color\">' + vehicle.color + '</td>' +
                        '<td class=\"td_trim\">' + vehicle.trim + '</td>' +
                        '<td class=\"td_mileage\">' + vehicle.mileAge + '</td>' +
                        '<td class=\"td_vinnumber\">' + vehicle.vinNumber + '</td>' +
                        '<td class=\"td_number_plate\">' + vehicle.vehicleNumberPlate + '</td>' +
                        '<td class=\"td_registered_state\">' + vehicle.vehicleRegisteredState + '</td>' +
                        '<td>' +  `${get_More_Info_Btn} <span class="separator">|</span> ${deleteButton}` + '</td>' +
                        '</tr>';
                    $('#vehicleTable tbody').append(vehicleRow);
                });

            },
            error : function(e) {
                alert("ERROR: ", e);
                console.log("ERROR: ", e);
            }
        });
    })();
});