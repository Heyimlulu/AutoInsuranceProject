$(document).ready(function() {
    $("#add_new_vehicle").submit(function(evt) {
        evt.preventDefault();

        let PolicyId = $("#policyID").val();

        // PREPARE FORM DATA
        let formData = {
            policyID : $("#policyID").val(),
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
            url: '/api/vehicle/create/' + PolicyId,
            type: 'POST',
            contentType : "application/json",
            data: JSON.stringify(formData),
            dataType : 'json',
            async: false,
            cache: false,
            success: function (response) {
                window.location = "/vehicle/vehicles.html";
            },
            error: function (response) {
                let errorAlert = '<div class="alert alert-danger alert-dismissible fade show" role="alert">' +
                    '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>' +
                    '<strong> There was an error adding this vehicle, please make sure the ID is correct </strong>' +
                '</div>';

                $("#response").append(errorAlert);
                $("#response").css({"display": "block"});
            }
        });
    });
});
