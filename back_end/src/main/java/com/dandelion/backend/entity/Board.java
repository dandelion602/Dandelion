package com.dandelion.backend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;


@Getter
@Setter
@Entity
public class Board {

    public Board() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;

    @Column(name = "title")
    private String title;

    @Column(name = "contents", length = 1000)
    private String contents;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new Date();

    @Column(name = "modifyDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyDate = new Date();

    @Column(name = "view")
    private int view;

    @Column(name = "tempStatus")
    private int tempStatus;

    @Column(name = "price")
    private int price;

    @OneToMany
    @JoinColumn(name = "boardNumber")
    public Collection<Image> images;

}
