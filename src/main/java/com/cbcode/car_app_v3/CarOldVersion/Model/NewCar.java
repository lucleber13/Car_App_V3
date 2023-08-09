package com.cbcode.car_app_v3.CarOldVersion.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@DiscriminatorValue("NEW")
//@PrimaryKeyJoinColumn(name = "carId")
//@Table(name = "new_cars")
public class NewCar extends Car{

    @Column(nullable = false, unique = true)
    private String chassisNumber;
    @Column(nullable = false)
    private Boolean isSold; // true if sold, false if in stock
    @Column(nullable = true)
    private String customerName;
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "Europe/London")
    @Temporal(TemporalType.DATE)
    private Date dateRequired;

    public NewCar() {
    }

    public NewCar(String brand, String model, String color, Integer keysNumber, String chassisNumber,
                  Boolean isSold, Date dateRequired, String customerName) {
        super(brand, model, color, keysNumber);
        this.chassisNumber = chassisNumber;
        this.isSold = isSold;
        this.customerName = customerName;
        this.dateRequired = dateRequired;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public Boolean getSold() {
        return isSold;
    }

    public void setSold(Boolean sold) {
        isSold = sold;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getDateRequired() {
        return dateRequired;
    }

    public void setDateRequired(Date dateRequired) {
        this.dateRequired = dateRequired;
    }
}
