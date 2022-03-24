package com.petrol.fuelquote.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "quote")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="requested_gallon", nullable = false)
    private double requestedGallon;

    @Column(name="delivery_address", nullable = false)
    private String deliveryAddress;

    @DateTimeFormat(pattern = "yyy-MM-dd")
    @Column(name="delivery_date", nullable = false)
    private Date deliveryDate;

    @Column(name="price_per_gallon", nullable = false)
    private double pricePerGallon;

    @Column(name="total_amount", nullable = false)
    private double totalAmount;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @Column(name="request_date")
    private Date requestDate;

    public Quote(double requestedGallon, String deliveryAddress, Date deliveryDate, double pricePerGallon, double totalAmount, User user, Date requestDate) {
        this.requestedGallon = requestedGallon;
        this.deliveryAddress = deliveryAddress;
        this.deliveryDate = deliveryDate;
        this.pricePerGallon = pricePerGallon;
        this.totalAmount = totalAmount;
        this.user = user;
        this.requestDate = requestDate;
    }
}
