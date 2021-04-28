/* Get input field parameter in URL */
window.onload = function () {
    var url = document.location.href,
        params = url.split('?')[1].split('&'),
        data = {}, tmp;
    for (var i = 0, l = params.length; i < l; i++) {
        tmp = params[i].split('=');
        data[tmp[0]] = tmp[1];
    }

    /* Decode input field to avoid URL syntax */
    document.getElementById('policyID').value = decodeURI(data.id);
    document.getElementById('policyNumber').value = decodeURI(data.policynumber);
    document.getElementById('policyEffectiveDate').value = decodeURI(data.effectivedate);
    document.getElementById('policyExpireDate').value = decodeURI(data.expiredate);
    document.getElementById('paymentOption').value = decodeURI(data.paymentoption);
    document.getElementById('totalAmount').value = decodeURI(data.totalamount);
    document.getElementById('active').value = decodeURI(data.active);
    document.getElementById('additionalInfos').value = decodeURI(data.additionalinfos);
    document.getElementById('creationDate').value = decodeURI(data.creationdate);
}