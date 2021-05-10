package com.example.parkinglot.repository;

import com.example.parkinglot.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Integer>
{
    List<Vehicle> findByColor(String color);
}
