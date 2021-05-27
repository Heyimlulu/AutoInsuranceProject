$(document).ready(function(){
    (function(){
        $.ajax({
            type : "GET",
            url : "/api/paymentdetail/retrieveinfos",
            success: function(response){
                $.each(response.paymentDetail, (i, paymentDetail) => {

                    let deleteButton = '<button ' +
                        'id=' +
                        '\"' + 'btn_delete_' + paymentDetail.id + '\"'+
                        ' type="button" class="btn btn-danger btn_delete" data-bs-toggle="modal" data-bs-target="#delete-modal">' +
                        'Delete</button>';

                    let get_More_Info_Btn = '<button' +
                        ' id=' + '\"' + 'btn_id_' + paymentDetail.id + '\"' +
                        ' type="button" class="btn btn-warning btn_id">' +
                        'Edit' +
                        '</button>';

                    let tr_id = 'tr_' + paymentDetail.id;
                    let paymentDetailRow = '<tr id=\"' + tr_id + "\"" + '>' +
                        '<td>' + paymentDetail.id + '</td>' +
                        '<td class=\"td_created_date\">' + paymentDetail.createdDate + '</td>' +
                        '<td class=\"td_due_date\">' + paymentDetail.paidDate + '</td>' +
                        '<td class=\"td_payer_firstname\">' + paymentDetail.payerFirstName + '</td>' +
                        '<td class=\"td_payer_lastname\">' + paymentDetail.payerLastName + '</td>' +
                        '<td class=\"td_amount\">' + paymentDetail.amount + '</td>' +
                        '<td class=\"td_payment_method\">' + paymentDetail.paymentMethod + '</td>' +
                        '<td class=\"td_type\">' + paymentDetail.debitOrCredit + '</td>' +
                        '<td class=\"td_additionalInfos\">' + paymentDetail.additionalInfos + '</td>' +
                        '<td>' +  `${get_More_Info_Btn} <span class="separator">|</span> ${deleteButton}` + '</td>' +
                        '</tr>';
                    $('#paymentDetailTable tbody').append(paymentDetailRow);
                });

            },
            error : function(e) {
                alert("ERROR: ", e);
                console.log("ERROR: ", e);
            }
        });
    })();
});