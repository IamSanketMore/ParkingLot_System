package com.example.parkinglot.service;

import com.example.parkinglot.dto.UserDTO;
import com.example.parkinglot.dto.VehicleDTO;
import com.example.parkinglot.entities.User;
import com.example.parkinglot.entities.Vehicle;

import java.util.List;

public interface IParkingService
{
    Vehicle addVehicle(VehicleDTO vehicleDTO);

    User addData(UserDTO userDTO,int vehicle_ID);

    Vehicle getVehicleId(int vehicle_ID);
}
