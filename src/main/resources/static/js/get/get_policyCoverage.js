$(document).ready(function(){
    (function(){
        $.ajax({
            type : "GET",
            url : "/api/policycoverage/retrieveinfos",
            success: function(response){

                console.log(response);

              $.each(response.policyCoverage  , (i, policyCoverage) => {

                let deleteButton = '<button ' +
                    'id=' +
                    '\"' + 'btn_delete_' + policyCoverage.id + '\"'+
                    ' type="button" class="btn btn-danger btn_delete" data-bs-toggle="modal" data-bs-target="#delete-modal"' +
                    '>Delete</button>';

                let get_More_Info_Btn = '<button' +
                    ' id=' + '\"' + 'btn_id_' + policyCoverage.id + '\"' +
                    ' type="button" class="btn btn-warning btn_id">' +
                    'Edit' +
                    '</button>';

                  let active;
                  if (policyCoverage.active == true) {
                      active = 'Yes';
                  } else if (policyCoverage.active == false) {
                      active = 'No';
                  }

                let tr_id = 'tr_' + policyCoverage.id;
                let policyCoverageRow = '<tr id=\"' + tr_id + "\"" + '>' +
                    '<td>' + policyCoverage.id + '</td>' +
                    '<td class=\"td_active\">' + active + '</td>' +
                    '<td class=\"td_createdDate\">' + getDate(policyCoverage.createdDate) + '</td>' +
                    '<td>' +  `${get_More_Info_Btn} <span class="separator">|</span> ${deleteButton}` + '</td>' +
                    '</tr>';

                $('#policyCoverageTable tbody').append(policyCoverageRow);
              });
            },
            error : function(e) {
              alert("ERROR: ", e);
              console.log("ERROR: ", e);
            }
        });
    })();
});