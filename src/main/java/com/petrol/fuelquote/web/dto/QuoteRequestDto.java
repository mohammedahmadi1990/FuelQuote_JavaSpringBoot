package com.petrol.fuelquote.web.dto;

import com.petrol.fuelquote.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class QuoteRequestDto {

    private double requestedGallon;
    private String deliveryAddress;

    @DateTimeFormat(pattern = "yyy-MM-dd")
    private Date deliveryDate;
    private double pricePerGallon;
    private double totalAmount;
    private User user;
    private Date requestDate;
}
