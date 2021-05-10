package com.example.parkinglot.entities;

import com.example.parkinglot.dto.ParkingLotDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "parking_lot")
public class ParkingLot
{
    @Id
    private int parkingLot_ID;
    private String parkingLotName;

    //@JsonIgnore
  //  @OneToMany(mappedBy = "parkingLot")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ParkingLot_fk_id")
    //@JoinColumn
    public List<Slots> slots;

    @JsonIgnore
    @OneToMany(mappedBy = "parkingLot")
    public List<User> User;

    public ParkingLot(ParkingLotDTO parkingLotDTO) {
        this.parkingLot_ID = parkingLotDTO.parkingLot_ID;
        this.parkingLotName = parkingLotDTO.parkingLotName;
    }
}
