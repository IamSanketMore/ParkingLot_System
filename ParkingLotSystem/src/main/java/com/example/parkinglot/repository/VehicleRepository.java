package com.example.parkinglot.repository;

import com.example.parkinglot.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle,Integer>
{
}
