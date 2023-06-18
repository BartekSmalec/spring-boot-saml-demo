package com.bartek.springbootsamldemo.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
@Scope("singleton")
public class CarOnlineService {
    private int index = 0;

    private List<Car> cars = new ArrayList<>();

    @PostConstruct
    private void  init(){
        addCar(new Car(0,"Honda","Accord","2017", 17,15000));
        addCar(new Car(0,"Honda","Accord","2020", 20,29000));
        addCar(new Car(0,"Honda","Accord","2018", 18,17000));

        addCar(new Car(0,"Toyota","Camry","2018", 10,18000));
        addCar(new Car(0,"Toyota","Camry","2020", 20,22000));

        addCar(new Car(0,"Tesla","Model S","2020", 3,10000));
        addCar(new Car(0,"Tesla","Model Y","2021", 10,6000));
    }


    public synchronized List<Car> listCars(){
        return new ArrayList<>(cars);
    }
    public synchronized void addCar(Car car){
        this.index++;
        car.setId(this.index);
        cars.add(car);
    }

    public synchronized Car buyCar(int id){
        return this.cars.stream()
                .filter(car -> car.getId() == id && car.getCount() > 0)
                .findFirst()
                .orElseThrow()
                .decrementCount();
    }


}
