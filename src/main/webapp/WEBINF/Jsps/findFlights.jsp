<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Flights</title>
</head>
<body>
	<h2>Find Flights here</h2>
	<form action="findFlight" method="Post">
		<table>

			<tr>
				<td>From</td>
				<td><input type="text" name="from" /></td>
			</tr>
			<tr>
				<td>To</td>
				<td><input type="text" name="to" /></td>
			</tr>
			<tr>
				<td>Departure Date</td>
				<td><input type="text" name="departureDate" /></td>
			</tr>
			<tr>
				<td><input type="Submit" value="Search" /></td>
			</tr>

		</table>
	</form>
</body>
</html>