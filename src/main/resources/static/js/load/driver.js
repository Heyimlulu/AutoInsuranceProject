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
    document.getElementById('Title').value = decodeURI(data.title);
    document.getElementById('FirstName').value = decodeURI(data.firstname);
    document.getElementById('LastName').value = decodeURI(data.lastname);
    document.getElementById('MiddleInitial').value = decodeURI(data.middleinitial);
    document.getElementById('DoB').value = decodeURI(data.dob);
    document.getElementById('Email').value = decodeURI(data.email);
    document.getElementById('PhoneNumber').value = decodeURI(data.phonenumber);
    document.getElementById('CellNumber').value = decodeURI(data.cellnumber);
    document.getElementById('SSN').value = decodeURI(data.ssn);
    document.getElementById('LicenseIssuedDate').value = decodeURI(data.licenseissueddate);
    document.getElementById('LicenseIssuedState').value = decodeURI(data.licenseissuedstate);
    document.getElementById('LicenseNumber').value = decodeURI(data.licensenumber);
    document.getElementById('IsPrimaryPolicyHolder').value = decodeURI(data.isprimarypolicyholder)
    document.getElementById('RelationWithPrimaryPolicyHolder').value = decodeURI(data.relationwithprimarypolicyholder);
    document.getElementById('Gender').value = decodeURI(data.gender);
    document.getElementById('MaritalStatuts').value = decodeURI(data.maritalstatus);
    document.getElementById('CreatedDate').value = decodeURI(data.createddate);
    document.getElementById('active').value = decodeURI(data.active);
}