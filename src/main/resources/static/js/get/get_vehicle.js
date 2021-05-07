$(document).ready(function(){
    (function(){
        $.ajax({
            type : "GET",
            url : "/api/vehicle/retrieveinfos",
            success: function(response){
                console.log(response);
                $.each(response.vehicle, (i, vehicle) => {

                    let deleteButton = '<button ' +
                        'id=' +
                        '\"' + 'btn_delete_' + vehicle.id + '\"'+
                        ' type="button" class="btn btn-danger btn_delete" data-bs-toggle="modal" data-bs-target="#delete-modal">' +
                        '&times</button>';

                    let get_More_Info_Btn = '<button' +
                        ' id=' + '\"' + 'btn_id_' + vehicle.id + '\"' +
                        ' type="button" class="btn btn-info btn_id">' +
                        vehicle.id +
                        '</button>';

                    let tr_id = 'tr_' + vehicle.id;
                    let vehicleRow = '<tr id=\"' + tr_id + "\"" + '>' +
                        '<td>' + get_More_Info_Btn + '</td>' +
                        '<td class=\"td_vehicle_number_plate\">' + vehicle.vehicleNumberPlate + '</td>' +
                        '<td class=\"td_vehicle_registered_state\">' + vehicle.vehicleRegisteredState + '</td>' +
                        '<td class=\"td_created_date\">' + vehicle.createdDate + '</td>' +
                        '<td>' + deleteButton + '</td>' +
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