/**
 * 
 */

function persistStates(map) {
	map.data.forEach(function(feature) {
		requestPersistState(feature);
	});
}

function requestPersistState(feature) {
	var req = new XMLHttpRequest();
	req.addEventListener("load", persistStateListener);
	req.open("POST", "/ga/persistState");
	req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	console.log(feature.f.Name);
	var params = "name=" + feature.f.Name;
	console.log(params);
	req.send(params);
}

function persistStateListener() {
}