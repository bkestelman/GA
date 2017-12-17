/**
 * 
 */

function savePrefs() {
	var efficiencyGapPref = document.getElementById("efficiencyGapPref").checked;
	var consistentAdvantagePref = document.getElementById("consistentAdvantagePref").checked;
	var params = "";
	params += "efficiencyGapPref=" + efficiencyGapPref + "&";
	params += "consistentAdvantagePref=" + consistentAdvantagePref;
	simpleReqParams("POST", "/ga/savePrefs", params, function() {
	});
}

function userPrefs() {
	simpleReq("GET", "/ga/prefs", function() {
		document.getElementById("userPrefsPopup").innerHTML = this.responseText;
	});
}