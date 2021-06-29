/* Get input field parameter in URL */
window.onload = function () {
    var url = document.location.href,
        params = url.split('?')[1].split('&'),
        data = {}, tmp;
    for (var i = 0, l = params.length; i < l; i++) {
        tmp = params[i].split('=');
        data[tmp[0]] = tmp[1];
    }

    console.log(data);

    /* Decode input field to avoid URL syntax */
    document.getElementById('coverageId').value = decodeURI(data.id);
    document.getElementById('coverageName').value = decodeURI(data.coverageName);
    document.getElementById('coverageGroup').value = decodeURI(data.coverageGroup);
    document.getElementById('code').value = decodeURI(data.code);
    document.getElementById('isPolicyCoverage').value = decodeURI(data.isPolicyCoverage);
    document.getElementById('isVehicleCoverage').value = decodeURI(data.isVehicleCoverage);
    document.getElementById('description').value = decodeURI(data.description);
}