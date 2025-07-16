package com.gearshift.carapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gearshift.carapi.model.Car;
import com.gearshift.carapi.model.CarCardList;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
public class CarService {
    private List<Car> carList;

    public CarService() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = getClass().getResourceAsStream("/car-data.json");
            CarCardList wrapper = mapper.readValue(is, CarCardList.class);
            this.carList = wrapper.getCarCard();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Car> getAllCars() {
        return carList;
    }

    public Car getCarById(int id) {
        return carList.stream()
                .filter(c -> c.id == id)
                .findFirst()
                .orElse(null);
    }
}
