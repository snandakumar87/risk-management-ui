if (!!window.EventSource) {
    alert('here');
    var eventSource = new EventSource("/transaction/stream");

    eventSource.onmessage = function(event) {
    alert('here');

        data = JSON.parse(event.data);
        console.log("data"+JSON.stringify(data));

        var row = '<tr><td>' + data.correlationId + '</td><td>' + data.subProcessCorrelationId + '</td><td>' + data.entityType + '</td><td>' + data.entityId  ;
            row+='<div class="icon"><i class="ni ni-fat-remove"></i></td>';
            row+='<td><button class="btn btn-icon btn-primary" type="button" id="ajaxSubmit" onclick="checkout('+data.subProcessCorrelationId+')"><span class="btn-inner--icon">Details<i class="ni ni-bold-right"></i></span></button>';





         row+='</tr><tr width="200px" id="svg" style="width:100%"></tr>';

        $('#tbody').append(row);
    };



} else {
    window.alert("EventSource not available on this browser.")
}

function checkout(transactionId) {

window.open("/casedetails.html?txnId="+transactionId, '_blank');



}