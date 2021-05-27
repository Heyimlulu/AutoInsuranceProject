$(document).ready(function(){
    (function(){
        $.ajax({
            type : "GET",
            url : "/api/policy/retrieveinfos",
            success: function(response){
              $.each(response.policys, (i, policy) => {

                let deleteButton = '<button ' +
                                        'id=' +
                                        '\"' + 'btn_delete_' + policy.id + '\"'+
                                        ' type="button" class="btn btn-danger btn_delete" data-bs-toggle="modal" data-bs-target="#delete-modal">' +
                                        'Delete</button>';

                let get_More_Info_Btn = '<button' +
                                            ' id=' + '\"' + 'btn_id_' + policy.id + '\"' +
                                            ' type="button" class="btn btn-warning btn_id">' +
                                            'Edit' +
                                            '</button>';
                
                let tr_id = 'tr_' + policy.id;
                let policyRow = '<tr id=\"' + tr_id + "\"" + '>' +
                    '<td>' + policy.id + '</td>' +
                    '<td class=\"td_policy_number\">' + policy.policyNumber.toUpperCase() + '</td>' +
                    '<td class=\"td_creation_date\">' + policy.creationDate + '</td>' +
                    '<td class=\"td_effective_date\">' + policy.policyEffectiveDate + '</td>' +
                    '<td class=\"td_expiration_date\">' + policy.policyExpireDate + '</td>' +
                    '<td class=\"td_payment_option\">' + policy.paymentOption + '</td>' +
                    '<td class=\"td_total_amount\">' + policy.totalAmount + '</td>' +
                    '<td class=\"td_active\">' + policy.active + '</td>' +
                    '<td class=\"td_additionalInfos\">' + policy.additionalInfos + '</td>' +
                    '<td>' +  `${get_More_Info_Btn} <span class="separator">|</span> ${deleteButton}` + '</td>' +
                    '</tr>';
                $('#policyTable tbody').append(policyRow);
              });
            },
            error : function(e) {
              alert("ERROR: ", e);
              console.log("ERROR: ", e);
            }
        });
    })();        
    
    (function(){
        let pathname = window.location.pathname;
        if (pathname == "/policies.html") {
            $(".nav .nav-item a:last").addClass("active");
        }
    })();
});