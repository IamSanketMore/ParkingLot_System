package com.example.parkinglot.repository;

import com.example.parkinglot.entities.Spot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpotRepository extends JpaRepository<Spot,Integer> {
}
