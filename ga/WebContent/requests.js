function simpleReq(method, url, params, listener) {
	var req = new XMLHttpRequest();
	req.addEventListener("load", listener);
	if(method == "GET") url = url + "?" + params;
	req.open(method, url);
	req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	if(method == "POST") req.send(params);
	else if(method == "GET") req.send();
}

function simpleReqCallbackArg(method, url, params, listener, arg) {
	var req = new XMLHttpRequest();
	req.addEventListener("load", function() {
		listener(arg);
	});
	if(method == "GET") url = url + "?" + params;
	req.open(method, url);
	req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	if(method == "POST") req.send(params);
	else if(method == "GET") req.send();
}
