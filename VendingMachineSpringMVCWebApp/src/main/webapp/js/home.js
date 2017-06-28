function addElement(id, price) {
    $('#item').val(id);
    var rest = parseFloat(price) - parseFloat($('#total').val());
    // alert("rest: " + rest);
    if (rest < 0) {
        showChange(Math.abs(rest));
        rest = 0;
    }
    $('#messages').val("Please Deposit: $" + rest.toFixed(2));
}

function addTotal(val) {
    setTotal(getTotal() + val);
}

function getTotal() {
    return parseFloat($('#total').val());
}

function setTotal(val) {
    return $('#total').val(val.toFixed(2));
}

function submitData() {
    var form = document.createElement("form");
    form.setAttribute("method", "post");
    form.setAttribute("action", "/money");

    var params = new Object();
    params['total'] = $('#total').val();
    params['item'] = $('#item').val();

    console.log(params);

    for (var key in params) {
        if (params.hasOwnProperty(key)) {
            var hiddenField = document.createElement("input");
            hiddenField.setAttribute("type", "hidden");
            hiddenField.setAttribute("name", key);
            hiddenField.setAttribute("value", params[key]);

            form.appendChild(hiddenField);
        }
    }

    document.body.appendChild(form);
    form.submit();
}

function showChange(amount) {
    // alert("amount: " + amount);
    amount = amount.toFixed(2) * 100;
    // alert("amount: " + amount);
    var response = "";
    var dollars = parseInt(amount / 100);
    // alert("dollars: " + dollars);
    if (dollars != 0)
        response += dollars + " Dollar ";
    var quarter =parseInt(amount % 100 / 25);
    // alert("quarter: " + quarter);
    if (quarter != 0)
        response += quarter + " Quarter ";
    var dimes = parseInt(amount % 25 / 10);
    // alert("dimes: " + dimes);
    if (dimes != 0)
        response += dimes + " Dime ";
    var nickel = parseInt(amount % 10 / 5);
    // alert("NIKEL" + amount % 10 );
    if (nickel != 0)
        response += nickel + " Nickel";
    $('#change').val(response);
}
