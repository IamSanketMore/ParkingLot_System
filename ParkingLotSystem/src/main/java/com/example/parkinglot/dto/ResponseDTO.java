package com.example.parkinglot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class ResponseDTO
{
    public String message;
    public Object data;

    public ResponseDTO(String message)
    {
        this.message = message;
    }
}
