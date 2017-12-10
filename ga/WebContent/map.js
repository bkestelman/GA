/**
 * 
 */

var selectedState = {fips: 0, name: ""};

function initMap() {
	var map = newMap();
	useMap(map);
	enhanceProperties(statesGeojson);
	map.data.addGeoJson(statesGeojson); //add all US states to map
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
	
	colorStates(map);
}

function newMap() {
	return new google.maps.Map(document.getElementById('map'), {
		zoom : zoomInit,
		center : center_us
	});
}
function enhanceProperties(statesGeojson) {
	statesGeojson.features.forEach(function(state) {
		state.properties.isState = true;
	});
}

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

function colorStates(map) {
	map.data.forEach(function(feature) {
		var params = "name=" + feature.f.Name;
		simpleReq("GET", "/ga/selectState", params, function() {
				var state = JSON.parse(this.responseText);
				var color;
				if (isRepublican(state)) color = 'red';
				else if (isDemocratic(state)) color = 'blue';
				map.data.overrideStyle(feature, {fillColor: color});
		});
	});
}