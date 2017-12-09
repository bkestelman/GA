<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  	<link rel="stylesheet" href="body.css"/>
	<link rel="stylesheet" href="map.css"/>
	<link rel="stylesheet" href="control.css"/>
	<link rel="stylesheet" href="popup.css"/>
  </head>
  <body>
    <div id="map"></div>
    <span id="control"><jsp:include page="control.jsp"/></span>
    <jsp:include page="popup.jsp"/>
    <script src="statesClean.js"></script>
    <script src="districts.js"></script>
    <script src="mapSettings.js"></script>
    <script src="state.js"></script>
    <script src="requests.js"></script>
    <script src="mapHandlers.js"></script>
    <script src="db.js"></script>
    <script src="map.js"></script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD2GxWpKIYyVx71cetBMonxi0wN9PH7WBU&callback=initMap">
    </script>
  </body>
</html>