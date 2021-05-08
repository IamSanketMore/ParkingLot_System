package com.example.parkinglot.service;

import com.example.parkinglot.dto.UserDTO;
import com.example.parkinglot.dto.VehicleDTO;
import com.example.parkinglot.entities.User;
import com.example.parkinglot.entities.Vehicle;
import com.example.parkinglot.repository.ParkingLotRepository;
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
        return  userRepository.save(user);
    }

    @Override
    public Vehicle getVehicleId(int vehicle_ID) {
        return vehicleRepository.findById(vehicle_ID).orElseThrow();
    }
}
