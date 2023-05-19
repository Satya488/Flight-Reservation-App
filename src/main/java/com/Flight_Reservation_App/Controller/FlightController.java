package com.Flight_Reservation_App.Controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Flight_Reservation_App.Entity.Flight;
import com.Flight_Reservation_App.Repository.FlightRepository;


@Controller
public class FlightController {
	@Autowired
	private FlightRepository flightRepo;
	
	@RequestMapping("/findFlight")
	public String findFlight(@RequestParam("from") String from,@RequestParam("to")String to,@RequestParam("departureDate")@DateTimeFormat(pattern = "MM-dd-yyyy")Date departureDate, ModelMap modelMap) {
	List<Flight> findFlight = flightRepo.findFlight(from,to,departureDate);
	modelMap.addAttribute("findFlight",findFlight);
	return"displayFlightDetails";
	}
	
	@RequestMapping("/showCompleteReservation")
	public String showCompletReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {
		Optional<Flight> findById = flightRepo.findById(flightId);
		Flight flight = findById.get();
		modelMap.addAttribute("flight",flight);
		return"showReservation";
	}
}
