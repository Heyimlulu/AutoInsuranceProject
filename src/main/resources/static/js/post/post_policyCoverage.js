$(document).ready(function() {
    $("#add_new_policyCoverage").submit(function(evt) {
        evt.preventDefault();

        // PREPARE FORM DATA
        let formData = {
        	active : $("#active").val(),
            createdDate : $("#createdDate").val()
        }
		
        $.ajax({
            url: '/api/policycoverage/create/',
            type: 'POST',
            contentType : "application/json",
            data: JSON.stringify(formData),
            dataType : 'json',
            async: false,
            cache: false,
            success: function (response) {
                window.location = "/coverage/policiescoverage.html";
            },
            error: function (response) {
                let errorAlert = '<div class="alert alert-danger alert-dismissible fade show" role="alert">' +
                        '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>' +
                        '<strong> There was an error adding this policy coverage </strong>' +
                    '</div>';

                $("#response").append(errorAlert);
                $("#response").css({"display": "block"});
            }
        });
    });
});
