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
	simpleReq("GET", "/ga/selectState", params, function() {
		var state = JSON.parse(this.responseText);
		map.data.forEach(function(feature) {
			console.log(feature);
		});
		zoomState(state);
		addDistricts(state);
	});
	
}

function zoomState(state) {
	var lat = state.latitude;
	var long = state.longitude;
	map.setCenter(new google.maps.LatLng(lat, long));
	map.setZoom(zoomSelect);
}

function addDistricts(state) {
	var prevState = window.selectedState;
	window.selectedState = state.fips;
	console.log("prevState " + prevState);
	console.log("selectedState " + selectedState);
	map.data.forEach(function(feature) {
		if(prevState != -1) {
			if(feature.f.STATEFP == prevState) map.data.remove(feature);
		}
		//map.data.remove(feature);
	});
	for(var i = 0; i < districtsGeojson.features.length; i++) {
		var district = districtsGeojson.features[i];
		if(district.properties.STATEFP == selectedState) {
			map.data.addGeoJson(district);
		}
	}
}

function highlight(feature) {
	map.data.overrideStyle(feature, {
		strokeWeight : strokeWeightHover
	});
}