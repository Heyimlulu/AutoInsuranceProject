$(document).ready(function(){
    (function(){
        $.ajax({
            type : "GET",
            url : "/api/coverage/retrieveinfos",
            success: function(response){

                console.log(response);

              $.each(response.coverage  , (i, coverage) => {

                let deleteButton = '<button ' +
                    'id=' +
                    '\"' + 'btn_delete_' + coverage.id + '\"'+
                    ' type="button" class="btn btn-danger btn_delete" data-bs-toggle="modal" data-bs-target="#delete-modal"' +
                    '>Delete</button>';

                let get_More_Info_Btn = '<button' +
                    ' id=' + '\"' + 'btn_id_' + coverage.id + '\"' +
                    ' type="button" class="btn btn-warning btn_id">' +
                    'Edit' +
                    '</button>';
                
                let tr_id = 'tr_' + coverage.id;
                let coverageRow = '<tr id=\"' + tr_id + "\"" + '>' +
                    '<td>' + coverage.id + '</td>' +
                    '<td class=\"td_coverage_name\">' + coverage.coverageName + '</td>' +
                    '<td class=\"td_coverage_group\">' + coverage.coverageGroup + '</td>' +
                    '<td class=\"td_code\">' + coverage.code + '</td>' +
                    '<td class=\"td_isPolicyCoverage\">' + coverage.isPolicyCoverage + '</td>' +
                    '<td class=\"td_isVehicleCoverage\">' + coverage.isVehicleCoverage + '</td>' +
                    '<td class=\"td_description\">' + coverage.description + '</td>' +
                    '<td>' +  `${get_More_Info_Btn} <span class="separator">|</span> ${deleteButton}` + '</td>' +
                    '</tr>';

                $('#coverageTable tbody').append(coverageRow);
              });
            },
            error : function(e) {
              alert("ERROR: ", e);
              console.log("ERROR: ", e);
            }
        });
    })();
});