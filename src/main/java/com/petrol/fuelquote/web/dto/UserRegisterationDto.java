package com.petrol.fuelquote.web.dto;

import com.petrol.fuelquote.model.Quote;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class UserRegisterationDto {

    private String username;
    private String password;
    private String fullName;
    private String city;
    private String state;
    private String address01;
    private String address02;
    private String zipCode;
    private Set<Quote> quotes;


}
