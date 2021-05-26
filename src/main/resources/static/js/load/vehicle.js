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
    document.getElementById('year').value = decodeURI(data.year);
    document.getElementById('brand').value = decodeURI(data.brand);
    document.getElementById('model').value = decodeURI(data.model);
    document.getElementById('color').value = decodeURI(data.color);
    document.getElementById('trim').value = decodeURI(data.trim);
    document.getElementById('mileage').value = decodeURI(data.mileAge);
    document.getElementById('vinnumber').value = decodeURI(data.vinNumber);
    document.getElementById('vehicleNumberPlate').value = decodeURI(data.vehicleNumberPlate);
    document.getElementById('vehicleRegisteredState').value = decodeURI(data.vehicleRegisteredState);
    document.getElementById('createdDate').value = decodeURI(data.createdDate);
    document.getElementById('active').value = decodeURI(data.active);
}