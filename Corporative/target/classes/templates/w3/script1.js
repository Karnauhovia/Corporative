

var InputFile = function () {
    var file = $("#idfile").val().replace("C:\\fakepath\\","");

    $.ajax({
        method: 'GET',
        type: 'GET',
        url: '/person/input/'+file+'.xlsx',
        data: {
            file
        },
        async: true,
        success: function (result) {
            alert('success!');
        }
    });
    document.getElementById('id04').style.display = 'none';
}

//location.reload();


var Refresh = function () {
    location.reload();

}

var RestCash = function () {
    var JSONObject1 = {
        "cash_id": $("#cash_id").val()
        , "pay_date": $("#pay_date").val().toString()
        , "cash_pay": $("#cash_pay").val()
        , "count": $("#cash_count").val()
        , "cash_course": $("#cash_course").val()
    };

    $.ajax({
        method: 'POST',
        type: 'POST',
        url: '/transfers/put/',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(JSONObject1),
        dataType: 'json',
        async: true,
        success: function (result) {
            alert('success!');
        }
    });
    location.reload();
}

var RestUpdate = function () {

    var JSONObject = {
        "id": $("#upId").val()
        , "name": $("#upName").val()
        , "name2": $("#upName2").val()
        , "name3": $("#upName3").val()
        , "department": $("#upDepartment").val()
        , "position": $("#upPosition").val()
        , "cash_date": $("#upCash_date").val().toString()
        , "date_recruit": $("#upDate_recruit").val().toString()
        , "comments": $("#upComments").val()
        , "rate": $("#upRate").val()
        , "count": $("#upCount").val().replace(",",".")
        , "dinners": $("#upDinners").val()
        , "taxes": $("#upTaxes").val()
        , "overtimes": $("#upOvertimes").val()
        , "bonus": $("#upBonus").val()
        , "another": $("#upAnother").val()
        , "shows": "0"
    };


    $.ajax({
        method: 'POST',
        type: 'POST',
        url: '/person/update/' ,
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(JSONObject),
        dataType: 'json',
        async: true,
        success: function (result) {
            alert('success!');
        }
    });
    document.getElementById('id02').style.display = 'none';
    location.reload();
}

var RestUpdateDel = function () {

    var JSONObject = {
        "id": $("#upId").val()
        , "name": $("#upName").val()
        , "name2": $("#upName2").val()
        , "name3": $("#upName3").val()
        , "department": $("#upDepartment").val()
        , "position": $("#upPosition").val()
        , "cash_date": $("#upCash_date").val().toString()
        , "date_recruit": $("#upDate_recruit").val().toString()
        , "comments": $("#upComments").val()
        , "rate": $("#upRate").val()
        , "count": $("#upCount").val().replace(",",".")
        , "dinners": $("#upDinners").val()
        , "taxes": $("#upTaxes").val()
        , "overtimes": $("#upOvertimes").val()
        , "bonus": $("#upBonus").val()
        , "another": $("#upAnother").val()
        , "shows": "0"
    };


    $.ajax({
        method: 'POST',
        type: 'POST',
        url: '/person/update/' ,
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(JSONObject),
        dataType: 'json',
        async: true,
        success: function (result) {
            alert('success!');
        }
    });
    document.getElementById('id02').style.display = 'none';
    location.reload();
}

var RestPut  = function () {
    var JSONObject = {
        "name": $("#name").val()
        , "name2": $("#2name").val()
        , "name3": $("#3name").val()
        , "department": $("#department").val()
        , "position": $("#position").val()
        , "cash_date": $("#pweek").val().toString()
        , "date_recruit": $("#date_recruit").val().toString()
        , "comments": $("#comment").val()
        , "dinners": $("#dinners").val()
        , "taxes": $("#taxes").val()
        , "overtimes": $("#overtimes").val()
        , "bonus": $("#bonus").val()
        , "another": $("#another").val()
        , "rate": $("#rate").val()
        , "shows": "0"

    };

    //var e = Base64.encode(JSON.stringify(JSONObject));

    $.ajax({
        method: 'POST',
        type: 'POST',
        url: '/person/put/',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(JSONObject),
        dataType: 'json',
        async: true,
        success: function (result) {
            alert('success!');
        }
    });
    document.getElementById('id01').style.display = 'none';
    location.reload();
}

var ChangeCourse  = function () {
    var JSONObject = {
        "id": '1'
        ,"exchange_course": $("#exchange_course").val()
    };

    $.ajax({
        method: 'POST',
        type: 'POST',
        url: '/person/course//set/',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(JSONObject),
        dataType: 'json',
        async: true
    });

    location.reload();
}

//    function GetExchangeCourse() {
var xhr = new XMLHttpRequest();
xhr.onreadystatechange = function() {
    if (xhr.readyState == XMLHttpRequest.DONE) {
        document.getElementById("exchange_course").value = xhr.responseText;
    }
}
xhr.open('GET', '/person/course/get/', true);
xhr.send(null);




