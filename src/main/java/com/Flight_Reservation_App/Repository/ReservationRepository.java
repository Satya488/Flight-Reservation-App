package com.Flight_Reservation_App.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Flight_Reservation_App.Entity.Reservation;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
