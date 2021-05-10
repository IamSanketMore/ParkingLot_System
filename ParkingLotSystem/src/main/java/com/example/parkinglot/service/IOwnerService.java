package com.example.parkinglot.service;

import com.example.parkinglot.dto.ParkingLotDTO;
import com.example.parkinglot.dto.ResponseDTO;
import com.example.parkinglot.dto.SlotsDTO;
import com.example.parkinglot.entities.ParkingLot;
import com.example.parkinglot.entities.Slots;
import com.example.parkinglot.entities.Vehicle;

import java.util.List;

public interface IOwnerService 
{

    ParkingLot addParkingLot(ParkingLotDTO parkingLotDTO);
    Slots addSlot(SlotsDTO slotDTO);

    List<Vehicle> getAllVehicles();

    ResponseDTO checkFull();
//    ParkingLot existsParkingLotByParkingLot_ID(int id);

    List<ParkingLot> findAll();
}
