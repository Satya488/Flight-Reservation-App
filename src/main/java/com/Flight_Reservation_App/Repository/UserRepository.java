package com.Flight_Reservation_App.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Flight_Reservation_App.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
 
}
