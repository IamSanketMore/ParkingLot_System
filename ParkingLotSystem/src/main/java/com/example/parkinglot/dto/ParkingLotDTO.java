package com.example.parkinglot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ParkingLotDTO
{
    public int parkingLot_ID;
    public String parkingLotName;

    //public int slots_ID;
}
