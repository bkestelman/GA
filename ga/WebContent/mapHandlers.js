/**
 * Types to keep in mind feature: google maps feature (different from original
 * Geojson!) info: response from server containing info about a state results:
 * response from server containing election results by party for one district
 */

var map;
var selectedState; // {feature:feature, info:info, districts:{
					// CD115FP:{feature:, results:{ party:{result:} }} }}
var selectedDistrict; // {feature:feature, results:[], infowindow:infowindow}

function handlersUseMap(map) {
	window.map = map;
	selectedState = null;
}
function handleMouseOver(event) {
	highlight(event.feature);
}
function handleMouseOut(event) {
	map.data.overrideStyle(event.feature, {"strokeWeight": strokeWeightInit});
}
function handleMouseClick(event) {
	if(selectedDistrict && selectedDistrict.infowindow) {
		selectedDistrict.infowindow.close();
	}
	if(event.feature.f.Name) {
		handleStateClick(event);
	}
	else {
		handleDistrictClick(event);
	}
}
	
function handleStateClick(event) {
	var params = "statefp=" + event.feature.f.statefp;
	simpleReqParams("GET", "/ga/selectState", params, function() {
		var districts = JSON.parse(this.responseText);
		if(selectedState) {
			removeDistricts(selectedState.districts); // remove districts from
														// map and from
														// selectedState
			unhide(selectedState.feature);
		}
		else {
			selectedState = {"feature":{}, "info":{}, "districts":{}};
		}
		selectedState.feature = event.feature;
		selectedState.info = states[event.feature.f.statefp]; //maybe districts should be renamed to state
		selectedState.districts = districts.geojson;
		selectedState.districts.features = {};
		addDistricts(districts, event.feature.f.statefp); // add districts to
															// map and to
															// selected state
		zoomState(selectedState);
		hide(selectedState.feature);
	});
}
function handleDistrictClick(event) {
	var cd115fp = event.feature.f.CD115FP;
	selectedDistrict = selectedState.districts[cd115fp];
	var infowindow = new google.maps.InfoWindow({
		content: showInfo(selectedDistrict),
		position: event.latLng
	});
	infowindow.open(map);
	map.setCenter(event.latLng);
	selectedDistrict.infowindow = infowindow;
}

function zoomState(state) {
	console.log(state);
	var lat = state.info.latitude;
	var long = state.info.longitude;
	map.setCenter(new google.maps.LatLng(lat, long));
	map.setZoom(zoomSelect);
}
function removeDistricts() {
	var features = selectedState.districts.features;
	for(var cd115fp in features) {
		features[cd115fp].forEach(function(feature) {
			map.data.remove(feature); // remove districts from map
		});
	}
	selectedState.districts = {}; // clear districts from selectedState
}
function hide(feature) {
	map.data.overrideStyle(feature, {visible: false});
}
function unhide(feature) {
	map.data.overrideStyle(feature, {visible: true});
}
function hideall() {
	map.data.forEach(function(feature) {
		map.data.overrideStyle(feature, {visible: false});
	});
}
function unhideall() {
	map.data.forEach(function(feature) {
		map.data.overrideStyle(feature, {visible: true});
	});
}

function addDistricts(districts, statefp) {
	var features = {};
	var districtsGeojson = districts.geojson;
	var colors = {};
	districts.info.forEach(function(districtInfo) {
		colors[districtInfo.cd115fp] = getColor(districtInfo);
	})
	for(var cdfp in districtsGeojson) {
		var isnum = /^\d+$/.test(cdfp);
		if(isnum) {
			features[cdfp] = map.data.addGeoJson(districtsGeojson[cdfp]);
			selectedState.districts.features[cdfp] = features[cdfp];
			features[cdfp].forEach(function(feature) {
				map.data.overrideStyle(feature, {fillColor: colors[parseInt(cdfp)]});
			});
		}
	}
}

function getColor(districtInfo) {
	var color = "green";
	var r = noComma(districtInfo.r);
	var d = noComma(districtInfo.d);
	if(r > d) {
		color = "red";
	}
	else if(d > r) {
		color = "blue";
	}
	return color;
}

function cleanVotes(result) {
	if(!result.generalVotes) {
		result.generalVotes = "0";
	}
}

function showInfo(district) {
	var info = "";
	var f = district.feature.f;
	var dvotes = "0"; // good defaults
	var rvotes = "0";
	if(district.results["D"]) {
		var dvotes = district.results["D"].generalVotes;
	}
	if(district.results["R"]) {
		var rvotes = district.results["R"].generalVotes;
	}
	var dvotesWasted = wastedVotes(dvotes, rvotes).toLocaleString();
	var rvotesWasted = wastedVotes(rvotes, dvotes).toLocaleString();
	info += "<h3>District Code: " + f.CD115FP + "</h3>";
	info += "<p>Democratic General Votes: " + dvotes + "<br>Republican General Votes: " + rvotes + "</p>";
	info += "<p>Democratic Votes Wasted: " + dvotesWasted + "<br>Republican Votes Wasted: " + rvotesWasted + "</p>";
	return info;
}

function wastedVotes(votes, other) {
	votes = noComma(votes);
	other = noComma(other);
	if(votes < other) return votes; // if loss, all votes are wasted
	else return votes - other; // if win, extra votes are wasted
}

function noComma(num) {
	return parseInt(num.replace(',', ''));
}

function highlight(feature) {
	map.data.overrideStyle(feature, {
		strokeWeight : strokeWeightHover
	});
}