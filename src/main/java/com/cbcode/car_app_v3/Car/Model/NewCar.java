package com.cbcode.car_app_v3.Car.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "new_cars")
public class NewCar extends Car{
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "Europe/London")
    @Temporal(TemporalType.DATE)
    private Date dateArrived;
    private boolean isNeededPolishMachine;
    private boolean isNeededPaintShop;
    private String valetComments;
    private String workshopComments;
}
