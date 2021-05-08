package com.example.parkinglot.entities;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "spot")
public class Spot
{
    @Id
    private int spotNumber;
}
