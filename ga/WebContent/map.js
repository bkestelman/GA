/**
 * 
 */

var selectedState = {fips: 0, name: ""};

function initMap() {
	var cookies = document.cookie.split(';');
	deleteCookie("username");
	
	var map = newMap();
	useMap(map);	
	initStyle(map);
	
	map.data.addListener('mouseover', function(event) {
		handleMouseOver(event);
	});
	map.data.addListener('mouseout', function(event) {
		handleMouseOut(event);
	});
	map.data.addListener('click', function(event) {
		handleMouseClick(event);
	});
	
	simpleReq("GET", "/ga/statesGeojson", loadStates);
}

function loadStates() {
	statesGeojson = JSON.parse(this.responseText);
	// enhanceProperties(statesGeojson);
	map.data.addGeoJson(statesGeojson); // add all US states to map
	var req = buildReq("GET", "/ga/statesInfo", colorStates);
	// req.map = map;
	req.send();
	// colorStates(map);
}

function newMap() {
	return new google.maps.Map(document.getElementById('map'), {
		zoom : zoomInit,
		center : center_us
	});
}
/*
 * function enhanceProperties(statesGeojson) {
 * statesGeojson.features.forEach(function(state) { state.properties.isState =
 * true; }); }
 */

function useMap(map) {
	handlersUseMap(map);
}

function initStyle(map) {
	map.data.setStyle(function(feature) {
		return 
		({
			strokeWeight : strokeWeightInit,
		});
	});
}

function colorStates() {
	temp = JSON.parse(this.responseText);
	states = {};
	for(var i = 0; i < temp.length; i++) {
		states[temp[i].fips] = temp[i];
	}
	map.data.forEach(function(feature) {
		if(states[feature.f.statefp]) {
			var color;
			if (isRepublican(states[feature.f.statefp])) color = 'red';
			else if (isDemocratic(states[feature.f.statefp])) color = 'blue';
			map.data.overrideStyle(feature, {fillColor: color});
		}
	});
}

function deleteCookie(name) {
	document.cookie = name + '=; expires=Thu, 01 Jan 1970 00:00:01 GMT;';
}