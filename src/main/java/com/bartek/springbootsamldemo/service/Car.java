package com.bartek.springbootsamldemo.service;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Car {
    private int id;
    private String make;
    private String model;
    private String year;
    private int count;
    private int price;

    public Car decrementCount() {
        if (this.count > 0) {
            this.count--;
        }

        return this;
    }
}
