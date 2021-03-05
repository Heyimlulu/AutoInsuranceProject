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
                        '&times</button>';

                    let get_More_Info_Btn = '<button' +
                        ' id=' + '\"' + 'btn_id_' + paymentDetail.id + '\"' +
                        ' type="button" class="btn btn-info btn_id">' +
                        paymentDetail.id +
                        '</button>';

                    let tr_id = 'tr_' + paymentDetail.id;
                    let paymentDetailRow = '<tr id=\"' + tr_id + "\"" + '>' +
                        '<td>' + get_More_Info_Btn + '</td>' +
                        '<td class=\"td_payer_firstname\">' + paymentDetail.payerFirstName + '</td>' +
                        '<td class=\"td_payer_lastname\">' + paymentDetail.payerLastName + '</td>' +
                        '<td class=\"td_created_date\">' + paymentDetail.createdDate + '</td>' +
                        '<td>' + deleteButton + '</td>' +
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