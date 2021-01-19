package com.dandelion.backend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Image {

    public Image() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;

    @Column(name = "fileOriName")
    private String fileOriName;

    @Column(name = "fileName")
    private String fileName;

    @Column(name = "imageDir")
    private String imageDir;

    @Column(name = "size")
    private int size;

    @Column(name = "orderNumber")
    private int orderNumber;

    @Column(name = "format")
    private String format;

    @Column(name = "boardNumber")
    private int boardNumber;

}
