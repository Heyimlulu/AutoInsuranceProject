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
    document.getElementById('coverageID').value = decodeURI(data.id);
    document.getElementById('active').value = decodeURI(data.active);
    document.getElementById('createdDate').value = decodeURI(data.createddate);
}