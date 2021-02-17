$(document).ready(function(){
    (function(){
        $.ajax({
            type : "GET",
            url : "/api/bill/retrieveinfos",
            success: function(response){
                $.each(response.bill, (i, bill) => {

                    let deleteButton = '<button ' +
                        'id=' +
                        '\"' + 'btn_delete_' + bill.id + '\"'+
                        ' type="button" class="btn btn-danger btn_delete" data-bs-toggle="modal" data-bs-target="#delete-modal">' +
                        '&times</button>';

                    let get_More_Info_Btn = '<button' +
                        ' id=' + '\"' + 'btn_id_' + bill.id + '\"' +
                        ' type="button" class="btn btn-info btn_id">' +
                        bill.id +
                        '</button>';

                    let tr_id = 'tr_' + bill.id;
                    let billRow = '<tr id=\"' + tr_id + "\"" + '>' +
                        '<td>' + get_More_Info_Btn + '</td>' +
                        '<td class=\"td_creation_date\">' + bill.createdDate + '</td>' +
                        '<td class=\"td_status\">' + bill.status + '</td>' +
                        '<td>' + deleteButton + '</td>' +
                        '</tr>';
                    $('#billTable tbody').append(billRow);
                });

            },
            error : function(e) {
                alert("ERROR: ", e);
                console.log("ERROR: ", e);
            }
        });
    })();
});