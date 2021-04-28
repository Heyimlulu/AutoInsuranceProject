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
    document.getElementById('billID').value = decodeURI(data.id);
    document.getElementById('createdDate').value = decodeURI(data.createdDate);
    document.getElementById('paidDate').value = decodeURI(data.paidDate);

    document.getElementById('payerFirstname').value = decodeURI(data.payerFirstName);
    document.getElementById('payerLastname').value = decodeURI(data.payerLastName);
    document.getElementById('amount').value = decodeURI(data.amount);
    document.getElementById('paymentMethod').value = decodeURI(data.paymentMethod);
    document.getElementById('debitCredit').value = decodeURI(data.debitCredit);
    document.getElementById('additionalInfo').value = decodeURI(data.additionalInfo);

    document.getElementById('cardNumber').value = decodeURI(data.cardNumber);
    document.getElementById('zipCode').value = decodeURI(data.zipCode);
    document.getElementById('cardExpireDate').value = decodeURI(data.cardExpireDate);
    document.getElementById('cardType').value = decodeURI(data.cardType);

    document.getElementById('bankName').value = decodeURI(data.bankName);
    document.getElementById('routingNumber').value = decodeURI(data.routingNumber);
    document.getElementById('accountNumber').value = decodeURI(data.accountNumber);
    document.getElementById('checkNumber').value = decodeURI(data.checkNumber);
}