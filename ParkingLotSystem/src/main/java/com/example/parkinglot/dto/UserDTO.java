package com.example.parkinglot.dto;

import com.example.parkinglot.entities.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDTO
{
    public String userName;
    public String mobileNumber;
    public String city;
    public String state;
    public int vehicle_ID;
}
