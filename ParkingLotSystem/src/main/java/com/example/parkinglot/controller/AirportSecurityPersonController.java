package com.example.parkinglot.controller;

import com.example.parkinglot.dto.ResponseDTO;
import com.example.parkinglot.service.IOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/AirportSecurity")
public class AirportSecurityPersonController
{
    @Autowired
    private IOwnerService iOwnerService;

    @GetMapping("/checkfull")
    public ResponseEntity<ResponseDTO> checkFull(){
        ResponseDTO responseDto = new ResponseDTO("ParkingLot Status : ", iOwnerService.checkFull());
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

}
