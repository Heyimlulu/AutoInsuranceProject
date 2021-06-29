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
                        'Delete</button>';

                    let get_More_Info_Btn = '<button' +
                        ' id=' + '\"' + 'btn_id_' + bill.id + '\"' +
                        ' type="button" class="btn btn-warning btn_id">' +
                        'Edit' +
                        '</button>';

                    let tr_id = 'tr_' + bill.id;
                    let billRow = '<tr id=\"' + tr_id + "\"" + '>' +
                        '<td>' + bill.id + '</td>' +
                        '<td class=\"td_created_date\">' + getDate(bill.createdDate) + '</td>' +
                        '<td class=\"td_due_date\">' + getDate(bill.dueDate) + '</td>' +
                        '<td class=\"td_minimum_payment\">' + bill.minimumPayment + '</td>' +
                        '<td class=\"td_balance\">' + bill.balance + '</td>' +
                        '<td class=\"td_status\">' + bill.status + '</td>' +
                        '<td>' +  `${get_More_Info_Btn} <span class="separator">|</span> ${deleteButton}` + '</td>' +
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