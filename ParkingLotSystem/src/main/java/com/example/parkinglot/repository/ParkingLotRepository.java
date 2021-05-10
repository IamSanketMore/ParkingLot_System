package com.example.parkinglot.repository;

import com.example.parkinglot.entities.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingLotRepository extends JpaRepository<ParkingLot,Integer>
{
    //ParkingLot existsParkingLotByParkingLot_ID(int id);

    @Override
    List<ParkingLot> findAll();
}
