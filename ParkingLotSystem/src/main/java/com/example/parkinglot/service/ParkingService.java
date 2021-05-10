package com.example.parkinglot.service;

import com.example.parkinglot.dto.UserDTO;
import com.example.parkinglot.dto.VehicleDTO;
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

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class ParkingService implements  IParkingService
{
    //@Autowired
    //ParkingLotRepository parkingLotRepository;
    @Autowired
    VehicleRepository vehicleRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ParkingLotRepository parkingLotRepository;
    @Autowired
    SlotsRepository slotsRepository;

    @Override
    public Vehicle addVehicle(VehicleDTO vehicleDTO)
    {
        Vehicle vehicle = new Vehicle(vehicleDTO);
        vehicle.setInTime(new Date());
        return vehicleRepository.save(vehicle);
    }

    @Override
    public User addData(UserDTO userDTO , int vehicle_ID) {
        User user = new User(userDTO);
        Vehicle vehicle = vehicleRepository.findById(vehicle_ID).orElseThrow();
        user.setVehicle(vehicle);
        ParkingLot parkingLot = parkingLotRepository.findById(userDTO.getParkingLot_Id()).orElseThrow();
        user.setParkingLot(parkingLot);
        Slots slots = slotsRepository.findById(userDTO.getSlots_ID()).orElseThrow();
        user.setSlot(slots);
        return  userRepository.save(user);
    }

    @Override
    public Vehicle getVehicleId(int vehicle_ID) {
        return vehicleRepository.findById(vehicle_ID).orElseThrow();
    }

    @Override
    public void unParkVehicle(int user_id) {
        User user =this.getUserById(user_id);
        userRepository.delete(user);
    }

    @Override
    public User getUserById(int user_ID) {
        return userRepository.findById(user_ID).orElseThrow();
    }

    @Override
    public List<User> getAllVehicles() {
        return userRepository.findAll();
    }

    @Override
    public List<Vehicle> findByColor(String color) {
        List<Vehicle> vehicles = vehicleRepository.findByColor(color);
        return  vehicles;
    }


}
