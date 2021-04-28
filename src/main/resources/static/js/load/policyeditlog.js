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
    document.getElementById('edit_log_policy_id').value = decodeURI(data.editlogid);
    document.getElementById('edit_log_policy_edited_table').value = decodeURI(data.editedtablename);
    document.getElementById('policy_id_artifact').value = decodeURI(data.idartifact);
    document.getElementById('edit_log_policy_edited_date').value = decodeURI(data.editeddate);
    document.getElementById('edit_log_policy_edited_by').value = decodeURI(data.editedby);
    document.getElementById('edit_log_additional_info').value = decodeURI(data.additionalinfos);
}