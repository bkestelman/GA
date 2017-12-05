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
}

function useMap(map) {
	handlersUseMap(map);
}