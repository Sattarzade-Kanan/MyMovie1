package com.example.MyMovie.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    private String name;
    private String title;
    private Double tickedPrice;

    public MovieEntity(Integer id, String name, String title, Double tickedPrice) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.tickedPrice = tickedPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getTickedPrice() {
        return tickedPrice;
    }

    public void setTickedPrice(Double tickedPrice) {
        this.tickedPrice = tickedPrice;
    }
}
