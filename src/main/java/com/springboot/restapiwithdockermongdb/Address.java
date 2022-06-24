package com.springboot.restapiwithdockermongdb;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {
    private String county;
    private String city;
    private String postCode;
}
