/**
 * 
 */

function initMap() {
	var center_us = {
		lat : 39.8283,
		lng : -98.5795
	};
	var map = new google.maps.Map(document.getElementById('map'), {
		zoom : zoomInit,
		center : center_us
	});
	useMap(map);

	map.data.addGeoJson(statesGeojson);

	map.data.setStyle(function(feature) {
		var color = 'gray';
		if (feature.getProperty('isColorful')) {
			color = feature.getProperty('color');
		}
		return /** @type {google.maps.Data.StyleOptions} */
		({
			fillColor : color,
			strokeColor : color,
			strokeWeight : strokeWeightInit
		});
	});

	map.data.addListener('mouseover', function(event) {
		handleMouseOver(event);
	});
	map.data.addListener('mouseout', function(event) {
		handleMouseOut(event);
	});
	map.data.addListener('click', function(event) {
		handleMouseClick(event);
	});
	
	initStates(map);
}

function useMap(map) {
	handlersUseMap(map);
}

function initStates(map) {
	map.data.forEach(function(feature) {
		var params = "name=" + feature.f.Name;
		/*simpleReq("GET", "/ga/selectState", params, function() {
			initState(feature);
		});*/
		var req = new XMLHttpRequest();
		req.addEventListener("load", function() {
				var state = JSON.parse(this.responseText);
				var color;
				if (isRepublican(state)) color = 'red';
				else if (isDemocratic(state)) color = 'blue';
				map.data.overrideStyle(feature, {fillColor: color});
				feature.setProperty("isColorful", true);
				feature.setProperty("color", color);
		});
		req.open("GET", "/ga/selectState?" + params);
		req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		req.send();
	});
}

function changeColor(feature, color) {
	map.data.overrideStyle(feature, {fillColor: color});
}