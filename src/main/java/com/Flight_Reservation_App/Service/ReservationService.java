package com.Flight_Reservation_App.Service;

import com.Flight_Reservation_App.Dto.ReservationRequest;
import com.Flight_Reservation_App.Entity.Reservation;

public interface ReservationService {
Reservation bookFlight(ReservationRequest request);

}
