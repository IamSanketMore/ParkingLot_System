package com.example.parkinglot.repository;

import com.example.parkinglot.entities.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingLotRepository extends JpaRepository<ParkingLot,Integer>
{

}
