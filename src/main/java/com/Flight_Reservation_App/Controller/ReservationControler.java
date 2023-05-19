package com.Flight_Reservation_App.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Flight_Reservation_App.Dto.ReservationRequest;
import com.Flight_Reservation_App.Entity.Reservation;
import com.Flight_Reservation_App.Service.ReservationService;
import com.Flight_Reservation_App.utilities.PDFgenerator;

@Controller
public class ReservationControler {
	
	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping("/confirmReservation")
public String completeReservation(ReservationRequest request, ModelMap modelMap) {
		Reservation reservationId = reservationService.bookFlight(request);
		modelMap.addAttribute("reservationId",reservationId.getId());
	    return "confirmReservation";
	
}
}
