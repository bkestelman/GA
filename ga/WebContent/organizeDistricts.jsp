<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<script src="districts.js"></script> <!-- Congress -->
	<script src="organizeDistricts.js"></script>
	<p id="content"></p>
	<script>
		downloadUS(districtsGeojson, "US.json");
	</script>
</body>
</html>