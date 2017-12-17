/**
 * 
 */

function login() {
	var params = "j_username=" + document.getElementById("username").value
			+ "&j_password=" + document.getElementById("password").value;
	simpleReqParams("POST", "/ga/login", params, function() {
		var response = JSON.parse(this.responseText);
		if (response.success == 'false') {
			document.getElementById("loginError").display = "block";
			return;
		}
		location.href = '#';
		var elements = document.getElementsByClassName("loggedIn");
		for (var i = 0; i < elements.length; i++) {
			elements[i].style.display = "inline";
		}
		var elements = document.getElementsByClassName("loggedOut");
		for (var i = 0; i < elements.length; i++) {
			elements[i].style.display = "none";
		}
	});
}

function logout() {
	// location.href = '#';
	simpleReq("POST", "/ga/logout", function() {
		var elements = document.getElementsByClassName("loggedIn");
		for (var i = 0; i < elements.length; i++) {
			elements[i].style.display = "none";
		}
		var elements = document.getElementsByClassName("loggedOut");
		for (var i = 0; i < elements.length; i++) {
			elements[i].style.display = "inline";
		}
	});
}

function newAcc() {
	console.log("Hello");
	document.getElementById("confirmDiv").style.display = "block";
	document.getElementById("newAccount").style.display = "none";
	document.getElementById("login").style.display = "none";

}

function register() {
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	var confirm = document.getElementById("confirm").value;
	if (password != confirm) {
		document.getElementById("loginError").display = "block";
		return;
	}
	var params = "j_username=" + username + "&j_password=" + password
			+ "&j_confirm=" + confirm;
	simpleReqParams("POST", "/ga/register", params, function() {
		location.href = '#';
		var elements = document.getElementsByClassName("loggedIn");
		for (var i = 0; i < elements.length; i++) {
			elements[i].style.display = "inline";
		}
		var elements = document.getElementsByClassName("loggedOut");
		for (var i = 0; i < elements.length; i++) {
			elements[i].style.display = "none";
		}
	});
}