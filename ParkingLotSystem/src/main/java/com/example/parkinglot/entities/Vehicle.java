package com.example.parkinglot.entities;

import com.example.parkinglot.dto.VehicleDTO;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "vehicles")
public class Vehicle
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="vehicle_Id")
    private int vehicle_ID;
    @Column(name="vehicle_number", nullable = false)
    @NotNull
    private String regNo;

    @Column(name="model_Name", nullable = false)
    @NotNull
    private String modelName;

    @Column(name="vehicle_color", nullable = false)
    @NotNull
    private String color;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name= "in_time", nullable = false)
    private Date inTime;
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name= "out_time")
    private Date outTime;

    public Vehicle(VehicleDTO vehicleDTO)
    {
        super();
        this.regNo = vehicleDTO.regNo;
        this.modelName =  vehicleDTO.modelName;
        this.color =  vehicleDTO.color;
    }
}
