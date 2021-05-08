package com.example.parkinglot.entities;
import com.example.parkinglot.dto.UserDTO;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "UserDetails")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_Id")
    private int userID;

    @Column(name="User_Name", nullable = false)
    @NotNull
    private String userName;

    @Column(name="Mobile_number", nullable = false)
    @NotNull
    private String mobileNumber;

    @Column(name="City", nullable = false)
    @NotNull
    private String city;

    @Column(name="State", nullable = false)
    @NotNull
    private String state;

    @OneToOne(cascade = CascadeType.ALL)
    private Vehicle vehicle;

    public User(UserDTO userDTO) {
        super();
        this.userName = userDTO.userName;
        this.mobileNumber = userDTO.mobileNumber;
        this.city = userDTO.city;
        this.state = userDTO.state;
    }
}
