package com.example.parkinglot.service;

import com.example.parkinglot.dto.ParkingLotDTO;
import com.example.parkinglot.dto.ResponseDTO;
import com.example.parkinglot.dto.SlotsDTO;
import com.example.parkinglot.entities.ParkingLot;
import com.example.parkinglot.entities.Slots;
import com.example.parkinglot.entities.Vehicle;

import java.util.List;
import java.util.Optional;

public interface IOwnerService 
{

   ParkingLot addParkingLot(ParkingLotDTO parkingLotDTO);
    Slots addSlot(SlotsDTO slotDTO);

    List<Vehicle> getAllVehicles();

    ResponseDTO checkFull();
    Optional<Slots> findBySlots_ID(int id);
    List<ParkingLot> findAllParkingLots();

    Optional<ParkingLot> findlotByID(int parkingLot_id);

    List<Slots> findAllSlots();

    List<Slots> addslotsToParkingLots(int parkingLot_id, int slots_id);
}
