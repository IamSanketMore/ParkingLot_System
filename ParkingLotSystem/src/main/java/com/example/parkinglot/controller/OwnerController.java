package com.example.parkinglot.controller;

import com.example.parkinglot.dto.ParkingLotDTO;
import com.example.parkinglot.dto.ResponseDTO;
import com.example.parkinglot.dto.SlotsDTO;
import com.example.parkinglot.entities.ParkingLot;
import com.example.parkinglot.entities.Slots;
import com.example.parkinglot.entities.User;
import com.example.parkinglot.service.IOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

//    @GetMapping("/existsParkingLotByParkingLot_ID")
//    public  ResponseEntity<ResponseDTO> existsParkingLotByParkingLot_ID(@PathVariable("id") int id){
//        ResponseDTO responseDTO = new ResponseDTO("Parking Exists: ", iOwnerService.existsParkingLotByParkingLot_ID(id));
//        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
//    }
    @GetMapping("/slotsByID/{slots_ID}")
    public ResponseEntity<ResponseDTO> findBySlots_ID(@PathVariable("slots_ID") int slots_ID) {
        Optional<Slots> slots = iOwnerService.findBySlots_ID(slots_ID);
        ResponseDTO responseDTO= new ResponseDTO(" Get a Contact By Id", slots);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/lotByID/{parkingLot_ID}")
    public ResponseEntity<ResponseDTO> findlotByID(@PathVariable("parkingLot_ID") int parkingLot_ID) {
        Optional<ParkingLot> parkingLot = iOwnerService.findlotByID(parkingLot_ID);
        ResponseDTO responseDTO= new ResponseDTO(" Get a Parking Lots By Id "+parkingLot_ID+"", parkingLot);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/findAllParkinglot")
    public  ResponseEntity<ResponseDTO> findAllParkingLots(){
        ResponseDTO responseDTO = new ResponseDTO("All Parking Lots IS: ", iOwnerService.findAllParkingLots());
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
    @GetMapping("/findAllSlots")
    public  ResponseEntity<ResponseDTO> findAllSlots(){
        ResponseDTO responseDTO = new ResponseDTO("All Slots Is :- ", iOwnerService.findAllSlots());
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
    @GetMapping("/addSlotstoParkingLots")
    public ResponseEntity<ResponseDTO> addslotsToParkingLots( @RequestParam ("parkingLot_ID") int parkingLot_ID,@RequestParam ("slots_ID") int slots_ID) {
        ResponseDTO responseDTO = new ResponseDTO(" Add All Slots into parkin glots",
                iOwnerService.addslotsToParkingLots(parkingLot_ID,slots_ID));
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);

    }

}
