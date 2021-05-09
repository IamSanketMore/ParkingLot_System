package com.example.parkinglot.controller;

import com.example.parkinglot.dto.ResponseDTO;
import com.example.parkinglot.dto.UserDTO;
import com.example.parkinglot.dto.VehicleDTO;
import com.example.parkinglot.entities.User;
import com.example.parkinglot.entities.Vehicle;
import com.example.parkinglot.service.IParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("parking")
public class ParkingLotController
{
    @Autowired
    private IParkingService iParkingService;

    @PostMapping("/parkVehicle")
    public ResponseEntity<ResponseDTO> addVehicle(@RequestBody VehicleDTO vehicleDTO ){
        Vehicle vehicles =  iParkingService.addVehicle(vehicleDTO);
        ResponseDTO responseDTO = new ResponseDTO("Add vehicles Details ",vehicles);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);
    }
    @GetMapping("/GetVehicleById/{vehicle_ID}")
    public ResponseEntity<ResponseDTO> getVehicleId(@PathVariable("vehicle_ID") int vehicle_ID) {
        Vehicle vehicles =  iParkingService.getVehicleId(vehicle_ID);
        ResponseDTO responseDTO= new ResponseDTO(" Get a Contact By Id", vehicles);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/GetUserById/{user_ID}")
    public ResponseEntity<ResponseDTO> getUserById(@PathVariable("user_ID") int user_ID) {
        User user =  iParkingService.getUserById(user_ID);
        ResponseDTO responseDTO= new ResponseDTO(" Get a Contact By Id", user);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @PostMapping("/addUser")
    public ResponseEntity<ResponseDTO> addData(@RequestBody UserDTO userDTO ,@RequestParam("vehicle_ID") int vehicle_ID){
        User user =  iParkingService.addData(userDTO,vehicle_ID);
        ResponseDTO responseDTO = new ResponseDTO("Add User Details ",user);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);
    }
    @DeleteMapping("/UnparkVehicle/{user_Id}")
    public ResponseEntity<ResponseDTO> deleteContactData(@PathVariable("user_Id") int user_Id) {
        iParkingService.unParkVehicle(user_Id);
        ResponseDTO respDTO = new ResponseDTO(" UnPark Vehicle By User Id :- ", user_Id);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }
    @GetMapping("/User/all")
    public ResponseEntity<ResponseDTO>  getAllUserDta(){
        ResponseDTO responseDTO=new ResponseDTO(" All User Data Is :- ", iParkingService.getAllVehicles());
        return new ResponseEntity<ResponseDTO> (responseDTO,HttpStatus.OK);
    }
}
