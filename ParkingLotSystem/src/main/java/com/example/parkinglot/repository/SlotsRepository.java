package com.example.parkinglot.repository;

import com.example.parkinglot.entities.Slots;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SlotsRepository extends JpaRepository<Slots,Integer> {
}
