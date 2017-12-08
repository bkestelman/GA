/**
 * 
 */

var map;

function handlersUseMap(map) {
	window.map = map;
}

function handleMouseOver(event) {
	//map.data.revertStyle();
	highlight(event.feature);
}

function handleMouseOut(event) {
	map.data.overrideStyle(event.feature, {"strokeWeight": strokeWeightInit});
	//map.data.revertStyle();
}

function handleMouseClick(event) {
	var params = "name=" + event.feature.f.Name;
	//console.log("Sending selectState request with params " + params);
	simpleReq("GET", "/ga/selectState", params, zoomState);
	//console.log(event.feature);
}

function zoomState() {
	var state = JSON.parse(this.responseText);
	var lat = state.latitude;
	var long = state.longitude;
	map.setCenter(new google.maps.LatLng(lat, long));
	map.setZoom(zoomSelect);
}

function highlight(feature) {
	map.data.overrideStyle(feature, {
		strokeWeight : strokeWeightHover
	});
}