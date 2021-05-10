package com.example.parkinglot.service;

import com.example.parkinglot.dto.ParkingLotDTO;
import com.example.parkinglot.dto.ResponseDTO;
import com.example.parkinglot.dto.SlotsDTO;
import com.example.parkinglot.entities.ParkingLot;
import com.example.parkinglot.entities.Slots;

import com.example.parkinglot.entities.User;
import com.example.parkinglot.entities.Vehicle;
import com.example.parkinglot.repository.ParkingLotRepository;
import com.example.parkinglot.repository.SlotsRepository;
import com.example.parkinglot.repository.UserRepository;
import com.example.parkinglot.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService implements IOwnerService
{
    public static final int totalNumberOfSlots = 10;
    @Autowired
    ParkingLotRepository parkingLotRepository;
    @Autowired
    SlotsRepository slotsRepository;
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private UserRepository userRepository;


    public ParkingLot addParkingLot(ParkingLotDTO parkingLotDTO)
    {
        ParkingLot parkingLot=new ParkingLot(parkingLotDTO);
        return parkingLotRepository.save(parkingLot);
    }

    public Slots addSlot(SlotsDTO slotsDTO){
        Slots slot = new Slots(slotsDTO);
        ParkingLot parkingLot=parkingLotRepository.findById( slotsDTO.getParkingLotName()).orElseThrow();
        slot.setParkingLot(parkingLot);
        return slotsRepository.save(slot);

    }

    @Override
    public List<Vehicle> getAllVehicles() {
        List<Vehicle>vehicles=vehicleRepository.findAll();
        return vehicles;
    }

    @Override
    public ResponseDTO checkFull() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        List<User> users = userRepository.findAll();
         if (users.size() >=  10)
        {
            return new ResponseDTO(" ParkingLot is Full ! ");
        }
        else {
            return new ResponseDTO(" ParkingLot Have Empty Slots ! ");
        }

    }

//    @Override
//    public ParkingLot existsParkingLotByParkingLot_ID(int id) {
//        ParkingLot parkingLot = parkingLotRepository.existsParkingLotByParkingLot_ID(id);
//        return parkingLot;
//    }

    @Override
    public List<ParkingLot> findAll() {
        return parkingLotRepository.findAll();
    }

}
