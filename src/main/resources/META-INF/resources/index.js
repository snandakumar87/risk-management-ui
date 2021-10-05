if (!!window.EventSource) {

    var eventSource = new EventSource("/transaction/stream");

    eventSource.onmessage = function(event) {

        data = JSON.parse(event.data);
        console.log("data"+data.val());
        var row = "<td></td>";
//        var row = '<tr><td>' + data.result.correlationId + '</td><td>' + data.result.subProcessCorrelationId + '</td><td>' ;
//            row+='<div class="icon"><i class="ni ni-fat-remove"></i></td>';
//            row+='<td><button class="btn btn-icon btn-primary" type="button" id="ajaxSubmit" onclick="checkout('+data.result.subProcessCorrelationId+')"><span class="btn-inner--icon">Details<i class="ni ni-bold-right"></i></span></button>';
//
//
//
//
//
//         row+='</tr><tr width="200px" id="svg" style="width:100%"></tr>';

        $('#tbody').append(row);
    };



} else {
    window.alert("EventSource not available on this browser.")
}

function checkout(transactionId) {

window.open("/TransactionDetails.html?txnId="+transactionId, '_blank');


}