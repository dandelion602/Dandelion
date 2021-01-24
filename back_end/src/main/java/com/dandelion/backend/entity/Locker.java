package com.dandelion.backend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Table(name = "locker")
@Entity
public class Locker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;

    @JoinColumn(name = "loc_number")
    private int locNumber;

    @Column(name = "size", nullable = false)
    private int size;

    @Column(name = "is_use", nullable = false)
    private int isUse;

//    @JoinColumn(name = "board_number", nullable = false)
    @Column(name = "board_number")
    private int boardNumber = 1;

    @Column(name = "password", length = 50)
    private String password;

    @Column(name = "input_date")
    private Date inputDate;

    @OneToMany(mappedBy = "lockerNumber", targetEntity = Deal.class)
    private List<Deal> deals = new ArrayList<>();
}
