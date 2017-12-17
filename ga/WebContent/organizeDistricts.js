var wyoming = 56;

function downloadUS(geojson, filename) {
	var US = organizeDistricts(geojson);
	download(filename, JSON.stringify(US));
}

function downloadStates(geojson, filename) {
	var states = organizeStates(geojson);
	downlaod(filename, JSON.stringify(states));
}

/*
function organizeStates(geojson) {
	for(var statefp = 1; statefp < wyoming; statefp++) {
		geojson.features.forEach(function(feature) {
			if(feature.properties.statefp == statefp) {
				feature
			}
		})
	}
}*/

function organizeDistricts(geojson) {
	var districts = [];
	for (var statefp = 1; statefp <= wyoming; statefp++) {
		var state = buildState(statefp, geojson);
		districts.push(state);
	}
	return districts;
}
function buildState(statefp, geojson) { 
	var state = {"statefp":statefp};
	geojson.features.forEach(function(feature) {
		if (feature.properties.STATEFP == statefp) {
			state[feature.properties.CD115FP] = feature;
		}
	});
	return state;
}

function originalDistricts() {
	document.getElementById("content").innerHTML = JSON
			.stringify(districtsGeojson);
}

// {"type":"FeatureCollection", "features": [ DISTRICTS ] }

// "features": { {statefp, cd115fp}...: DISTRICT }

function iowa() {
	document.getElementById("content").innerText = JSON
			.stringify(buildState(19));
}
/*
function US() {
	document.getElementById("content").innerText = JSON
	.stringify(buildUS());
}

function buildState(statefp) { // DEPRECATED, use buildState(statefp, geojson),
								// unless you are only using the 115th Congress
	var state = {};
	districtsGeojson.features.forEach(function(feature) {
		if (feature.properties.STATEFP == statefp) {
			state[feature.properties.CD115FP] = feature;
		}
	});
	return state;
}
function buildState(statefp, geojson) { 
	var state = {};
	geojson.features.forEach(function(feature) {
		if (feature.properties.STATEFP == statefp) {
			state[feature.properties.CD115FP] = feature;
		}
	});
	return state;
}

function buildUS() { // DEPRECATED, use buildUS(congress, geojson)
	var wyoming = 56;
	var US = {};
	for (var statefp = 1; statefp <= wyoming; statefp++) {
		var state = buildState(statefp);
		US[statefp] = state;
	}
	return US;
}
function organizeDistricts(geojson) {
	var districts = {};
	for (var statefp = 1; statefp <= wyoming; statefp++) {
		var state = buildState(statefp, geojson);
		districts[statefp] = state;
	}
	return districts;
}

function addCongress(congress, geojson) {
	USdistricts[congress] = buildUS(geojson);
	download("USdistricts.json", JSON.stringify(USdistricts));
}*/

function download(filename, text) {
	var element = document.createElement('a');
	element.setAttribute('href', 'data:text/plain;charset=utf-8,'
			+ encodeURIComponent(text));
	element.setAttribute('download', filename);

	element.style.display = 'none';
	document.body.appendChild(element);

	element.click();

	document.body.removeChild(element);
}