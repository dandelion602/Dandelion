package com.dandelion.backend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@Table(name = "deal")
@Entity
public class Deal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;

    @OneToOne
    @JoinColumn(name = "board_number", nullable = false)
    private Board boardNumber;

    @JoinColumn(name = "seller_number", nullable = false)
    private int sellerNumber;

    @JoinColumn(name = "buyer_number")
    private int buyerNumber;

    @JoinColumn(name = "bird_number")
    private int birdNumber;

    @JoinColumn(name = "locker_number")
    private int lockerNumber;

    @Column(name = "receiving_date")
    private Date receivingDate;

    @Column(name = "shipping_date")
    private Date shippingDate;

    @Column(name = "delivery_date")
    private Date deliveryDate;

    @Column(name = "is_pickup", nullable = false)
    private int isPickup = 0;

    @Column(name = "temp_status", nullable = false)
    private int tempStatus;

}

