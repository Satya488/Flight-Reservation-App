<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservation Details</title>
</head>
<body>
	<h2>Flight Details</h2>
	<table border="1">
		<tr>
			<td>Flight Number</td>
			<td>${flight.flightNumber}</td>
		</tr>
		<tr>
			<td>Operating Airlines</td>
			<td>${flight.operatingAirlines}</td>
		</tr>
		<tr>
			<td>Departure City</td>
			<td>${flight.departureCity}</td>
		</tr>
		<tr>
			<td>Arrival City</td>
			<td>${flight.arrivalCity}</td>
		</tr>
		<tr>
			<td>Departure Date</td>
			<td>${flight.dateOfDeparture}</td>
		</tr>
	</table>
	<h2>Enter Passenger Details</h2>
	<form action="confirmReservation" method="Post">
		<table border="1">
			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastName" /></td>
			</tr>
			<tr>
				<td>Middle Name</td>
				<td><input type="text" name="middleName" /></td>
			</tr>
			<tr>
				<td>Email ID</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>Mobile</td>
				<td><input type="text" name="mobile" /></td>
			</tr>
			<tr>
				<td><input type="hidden" name="flightId" value="${flight.id}"/></td>
			</tr>
		</table>
		<h2>Enter the payment details</h2>
		<table>
			<tr>
				<td>Name On The Card</td>
				<td><input type="text" name="nameOfTheCard" /></td>
			</tr>
			<tr>
				<td>Card Number</td>
				<td><input type="text" name="cardNumber" /></td>
			</tr>
			<tr>
				<td>CVV</td>
				<td><input type="text" name="cvvCode" /></td>
			</tr>
			<tr>
				<td>Expiry Date</td>
				<td><input type="text" name="expiryDate" /></td>
			</tr>
			<tr>
				<td><input type="Submit" value="Complete Reservation" /></td>
			</tr>
		</table>
	</form>
</body>
</html>