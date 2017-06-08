$(document).ready(function (){
    loadGoods();
    $('#makepurchase').bind('click', function (){
        makePurchase();
    });
    $('#return').bind('click', function (){
        setTotal(0);
        loadGoods();
        $('#item').val('');
        hideError();
        hideInfo();
        hideThankyou();
    });
});
function loadGoods(){
    $('#goods').empty();
    $.ajax({
        type: 'GET',
        url: "http://localhost:8080/items",
        dataType: 'json',
        success: function (data, textStatus, jqXHR) {
            var div = null;
            $.each(data, function (index, element){
                console.log(index % 3);
                if(index % 3 == 0){
                    div = document.createElement('div');
                    $(div).addClass('row');
                }

                var good = document.createElement('div');
                $(good).addClass('col-lg-3');
                $(good).addClass('col-lg-offset-1');
                $(good).addClass('good-container');

                $(good).append('<div>'+element.id+'</div><h4 class="header">'+element.name+'</h4><h4 class="header">'+element.price.toFixed(2)+'</h4><h5 class="header">Quantity Left: '+element.quantity+'</h5>');

                $(good).bind('click', function (){
                    $('#item').val(element.id);
                });

                $(div).append(good);
                console.log(element);
                if(index % 3 == 2){
                    $('#goods').append(div);
                    $('#goods').append('<br>');
                }
            });
        },
        error: function (jqXHR, textStatus, errorThrown) {
            $('#error-message').empty();
            $('#error-message').text('Rest-Full API is not available now!');
            $('#error-message').show();
            hideError();
        }
    });
}

function makePurchase(){
    $.ajax({
        type: 'GET',
        url: "http://localhost:8080/money/"+getTotal()+"/item/"+$('#item').val(),
        dataType: 'json',
        success: function (data, textStatus, jqXHR) {
            $('#thankyou-message').show();
            var result = "";
            if(data.quarters == 1){
                result += data.quarters + " Quarter";
            }else if(data.quarters > 1){
                result += data.quarters + " Quarters";
            }

            if(data.dimes == 1){
                result += data.dimes + " Dime";
            }else if(data.dimes > 1){
                result += data.dimes + " Dimes";
            }

            if(data.nickels == 1){
                result += data.nickels + " Nickel";
            }else if(data.nickels > 1){
                result += data.nickels + " Nickels";
            }

            if(data.pennies == 1){
                result += data.pennies + " Pennies";
            }else if(data.pennies > 1){
                result += data.pennies + " Penny";
            }
            setTotal(data.quarters * 0.25 + data.dimes * 0.1 + data.nickels * 0.05 + data.pennies);
            if(result.length > 0){
                $('#info-message').empty();
                $('#info-message').text(result);
                $('#info-message').show();
            }
            hideThankyou();
            hideInfo();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            if(jqXHR.status == 422){
                $('#error-message').empty();
                $('#error-message').text(JSON.parse(jqXHR.responseText).message);
            }else{
                $('#error-message').empty();
                $('#error-message').text('Rest-Full API is not available now!');
                $('#error-message').show();
            }
            hideError();
        }
    });
}

function addTotal(val){
    setTotal(getTotal() + val);
}

function getTotal(){
    return parseFloat($('#total').val());
}

function setTotal(val){
    return $('#total').val(val.toFixed(2));
}

function hideError(){
    setTimeout(function (){
        $('#error-message').hide();
    }, 2500);
}

function hideThankyou(){
    setTimeout(function (){
        $('#thankyou-message').hide();
    }, 2500);
}

function hideInfo(){
    setTimeout(function (){
        $('#info-message').hide();
    }, 2500);
}
