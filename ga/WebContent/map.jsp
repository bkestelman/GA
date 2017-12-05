<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <style>
       #map {
        height: 400px;
        width: 100%;
       }
    </style>
  </head>
  <body>
    <h3>My Google Maps Demo</h3>
    <div id="map"></div>
    <script src="statesClean.js"></script>
    <script src="mapSettings.js"></script>
    <script src="mapHandlers.js"></script>
    <script src="initDB.js"></script>
    <script src="map.js"></script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD2GxWpKIYyVx71cetBMonxi0wN9PH7WBU&callback=initMap">
    </script>
  </body>
</html>