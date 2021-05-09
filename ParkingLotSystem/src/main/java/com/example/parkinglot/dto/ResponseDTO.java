package com.example.parkinglot.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
