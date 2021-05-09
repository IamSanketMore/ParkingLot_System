package com.example.parkinglot.controller;

import com.example.parkinglot.dto.ParkingLotDTO;
import com.example.parkinglot.dto.ResponseDTO;
import com.example.parkinglot.dto.SlotsDTO;
import com.example.parkinglot.entities.ParkingLot;
import com.example.parkinglot.service.IOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Owner")
public class OwnerController
{
    @Autowired
    private IOwnerService iOwnerService;

    @PostMapping("/add/parkinglot")
    public ResponseEntity<ResponseDTO> addParkingLot(@RequestBody ParkingLotDTO parkingLotDTO){

        ResponseDTO responseDTO=new ResponseDTO("Added parking lot",iOwnerService.addParkingLot(parkingLotDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);

    }

    @PostMapping("/add/slot")
    public ResponseEntity<ResponseDTO> addSlot(@RequestBody SlotsDTO slotDTO){

        ResponseDTO responseDTO=new ResponseDTO("added new slot",iOwnerService.addSlot(slotDTO));
        return  new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);

    }
    @GetMapping("/vehicle/all")
    public ResponseEntity<ResponseDTO>  allVehicles(){
        ResponseDTO responseDTO=new ResponseDTO("All vehicles:", iOwnerService.getAllVehicles());
        return new ResponseEntity<ResponseDTO> (responseDTO,HttpStatus.OK);
    }
    @GetMapping("/checkfull")
    public  ResponseEntity<ResponseDTO> checkFull(){
        ResponseDTO responseDTO = new ResponseDTO("Parking Lot Status: ", iOwnerService.checkFull());
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }


}
