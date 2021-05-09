package com.example.parkinglot.entities;
import com.example.parkinglot.dto.SlotsDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "slots")
public class Slots
{
    @Id
    private int slots_ID;
    private String slotName;

    @ManyToOne
    @JsonIgnore
    @JoinColumn
    private ParkingLot parkingLot;

    @OneToOne(mappedBy = "slot")
    @JsonIgnore
    private User User;

    public Slots(SlotsDTO slotsDTO) {
        this.slots_ID = slotsDTO.slots_ID;
        this.slotName = slotsDTO.slotsName;
    }

}
