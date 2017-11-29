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




var deleteRecord = function (link) {
    var result = confirm("Are you sure that you want to delete this?");
    if(result===true)
        postJSONP(link,null,function () {
           console.log("deleted");
        });
}