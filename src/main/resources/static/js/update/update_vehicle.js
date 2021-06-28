$(document).ready(function(){
    $("#update_vehicle_form").submit(function(evt) {
        evt.preventDefault();
        try {
            let vehicleId = $("#policyID").val();

            // PREPARE FORM DATA
            let formData = {
                year :  $("#year").val(),
                make: $("#brand").val(),
                model: $("#model").val(),
                color: $("#color").val(),
                trim: $("#trim").val(),
                mileAge: $("#mileage").val(),
                vinNumber: $("#vinnumber").val(),
                vehicleNumberPlate: $("#vehicleNumberPlate").val(),
                vehicleRegisteredState: $("#vehicleRegisteredState").val(),
                createdDate :  $("#createdDate").val(),
                active :  $("#active").val()
            }

            $.ajax({
                url: '/api/vehicle/updatebyid/' + vehicleId + "/",
                type: 'PUT',
                contentType : "application/json",
                data: JSON.stringify(formData),
                dataType : 'json',
                async: false,
                cache: false,
                success: function (response) {
                    let successAlert = '<div class="alert alert-success alert-dismissible fade show" role="alert">' +
                        '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>' +
                        '<strong> Vehicle N°' + vehicleId + ' has been successfully updated! Redirecting to all Vehicles page... </strong>' +
                    '</div>'

                    $("#response").empty();
                    $("#response").append(successAlert);
                    $("#response").css({"display": "block"});

                    setTimeout( () => {
                        window.location = "/vehicle/vehicles.html";
                    }, 2500);
                },

                error: function (response) {
                    let errorAlert = '<div class="alert alert-danger alert-dismissible fade show" role="alert">' +
                        '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>' +
                        '<strong> There was an error updating this vehicle, please try again </strong>' +
                    '</div>';

                    $("#response").empty();
                    $("#response").append(errorAlert);
                    $("#response").css({"display": "block"});
                }
            });
        } catch(error){
            console.log(error);
            alert(error);
        }
    });

    $(document).on("click", "table button.btn_id", function(){
        // split the ID from the component button and class .btn_id
        let id_of_button = (event.srcElement.id);
        let vehicleId = id_of_button.split("_")[2];

        $.ajax({
            url: '/api/vehicle/findone/' + vehicleId,
            type: 'GET',
            success: function(response) {
                let vehicle = response.vehicle[0];

                $("#policyID").val(vehicle.id);
                $("#year").val(vehicle.year);
                $("#make").val(vehicle.make);
                $("#model").val(vehicle.model);
                $("#color").val(vehicle.color);
                $("#trim").val(vehicle.trim);
                $("#mileage").val(vehicle.mileAge);
                $("#vinnumber").val(vehicle.vinNumber);
                $("#vehicleNumberPlate").val(vehicle.vehicleNumberPlate);
                $("#vehicleRegisteredState").val(vehicle.vehicleRegisteredState);
                $("#createdDate").val(vehicle.creationDate);
                $("#active").val(vehicle.active);

                let url = "/vehicle/updatevehicle.html?id=" + vehicle.id +
                "&year=" + vehicle.year +
                "&brand=" + vehicle.make +
                "&model=" + vehicle.model +
                "&color=" + vehicle.color +
                "&trim=" + vehicle.trim +
                "&mileAge=" + vehicle.mileAge +
                "&vinNumber=" + vehicle.vinNumber +
                "&vehicleNumberPlate=" + vehicle.vehicleNumberPlate +
                "&vehicleRegisteredState=" + vehicle.vehicleRegisteredState +
                "&createdDate=" + vehicle.createdDate +
                "&active=" + vehicle.active

                window.location.href = url;

            },
            error: function(error){
                console.log(error);
                alert("Error -> " + error);
            }
        });
    });
});