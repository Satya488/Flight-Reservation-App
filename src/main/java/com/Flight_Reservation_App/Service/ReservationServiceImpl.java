package com.Flight_Reservation_App.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Flight_Reservation_App.Dto.ReservationRequest;
import com.Flight_Reservation_App.Entity.Flight;
import com.Flight_Reservation_App.Entity.Passenger;
import com.Flight_Reservation_App.Entity.Reservation;
import com.Flight_Reservation_App.Repository.FlightRepository;
import com.Flight_Reservation_App.Repository.PassengerRepository;
import com.Flight_Reservation_App.Repository.ReservationRepository;
import com.Flight_Reservation_App.utilities.EmailUtil;
import com.Flight_Reservation_App.utilities.PDFgenerator;

@Service
public class ReservationServiceImpl implements ReservationService {
	@Autowired
    private PassengerRepository passengerRepo;
	@Autowired
	private FlightRepository flightRepo;
	@Autowired
	private PDFgenerator pdfGenerator;
	@Autowired
	private EmailUtil emailUtil;
	@Autowired
	private ReservationRepository reservationRepo;
	
	
	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
	
		
	Passenger passenger = new Passenger();
	passenger.setFirstName(request.getFirstName());
	passenger.setLastName(request.getLastName());
	passenger.setMiddleName(request.getMiddleName());
	passenger.setEmail(request.getEmail());
	passenger.setMobile(request.getMobile());
	
	Passenger savePassenger = passengerRepo.save(passenger);
	
	long flightId = request.getFlightId();
	Optional<Flight> findById = flightRepo.findById(flightId);
	Flight flight = findById.get();
	
	Reservation reservation = new Reservation();
	reservation.setFlight(flight);
	reservation.setPassenger(savePassenger);
	reservation.setCheckedIn(false);
	reservation.setNumberOfBags(0);
	String filePath ="E:\\Old Version STS Code\\Flight_Reservation_App\\Tickets\\reservation"+reservation.getId()+".pdf";
	reservationRepo.save(reservation);
	pdfGenerator.generatePDF(reservation, filePath);{
	emailUtil.sendItinerary(passenger.getEmail(),filePath);
	}
	
	return reservation;
	}

}
