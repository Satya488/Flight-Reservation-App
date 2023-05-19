package com.Flight_Reservation_App.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Flight_Reservation_App.Entity.Passenger;



public interface PassengerRepository extends JpaRepository<Passenger,Long> {

}
