<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Clean Districts</title>
</head>
<body>
	<p id="content"></p>
	<script src="districts103.js"></script> <!-- Congress -->
	<script src="organizeDistricts.js"></script>
	<script>
		downloadUS(districts103, "districts103clean.json");
	</script>
</body>
</html>