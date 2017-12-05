/**
 * 
 */

var map;

function handlersUseMap(map) {
	window.map = map;
}

function handleMouseOver(event) {
	map.data.revertStyle();
	highlight(event.feature);
}

function handleMouseOut(event) {
	map.data.revertStyle();
}

function handleMouseClick(event) {
	console.log(event.feature);
}

function highlight(feature) {
	map.data.overrideStyle(feature, {
		strokeWeight : strokeWeightHover
	});
}