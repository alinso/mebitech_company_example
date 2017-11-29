var postJSONP = function (url, params, success) {

    //var params = "lorem=ipsum&name=binny";
    var http = new XMLHttpRequest()
    http.open("POST", url, true);


    http.setRequestHeader("Content-Type", "application/json");
    http.setRequestHeader("Accept", "application/json");

    http.onreadystatechange = function () {//Call a function when the state changes.
        if (http.readyState === 4 && http.status === 200) {

            success(JSON.parse(http.responseText));
        }
    }
    http.send(params);
}


var getJSONP = function (url, success) {
    var xmlhttp = new XMLHttpRequest();

    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == XMLHttpRequest.DONE) {   // XMLHttpRequest.DONE == 4
            if (xmlhttp.status == 200) {
                if(xmlhttp.responseText!=""){
                    success(JSON.parse(xmlhttp.responseText));
                }
                else{
                    console.log(url+" response is null");
                    success();
                }
            }
            else if (xmlhttp.status == 400) {
                console.log('There was an error 400 :' + url);
            }
            else {
                console.log('something else other than 200 was returned :' + url);
            }
        }
    };

    xmlhttp.open("GET", url, true);
    xmlhttp.send();
}



var deleteRecord = function (link) {
    var result = confirm("Are you sure that you want to delete this?");
    if(result===true)
        postJSONP(link,null,function () {
           console.log("deleted");
        });
}

var removeFromMeeting = function (link,meetingId,departmentId) {
    var result = confirm("Are you sure that you want to unattend this?");
    if(result===true) {

     var data  ={};
     data.meetingId = meetingId;
     data.departmentId  =departmentId;

        postJSONP(link, JSON.stringify(data), function () {
            console.log("deleted");
        });
    }
}