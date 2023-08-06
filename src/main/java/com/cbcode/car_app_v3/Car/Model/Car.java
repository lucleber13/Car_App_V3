package com.cbcode.car_app_v3.Car.Model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name = "car_seq", sequenceName = "car_seq", initialValue = 1, allocationSize = 1)
public abstract class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_seq")
    private long id;
    @Column(nullable = false)
    private String brand;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private String color;
    @Column(nullable = false, unique = true)
    private String regNumber;
    private String chassisNumber;
    @Column(nullable = false)
    private int keysNumber;

    public Car() {
    }

    public Car(long id, String brand, String model, String color, String regNumber, String chassisNumber,
               int keysNumber) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.regNumber = regNumber;
        this.chassisNumber = chassisNumber;
        this.keysNumber = keysNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public int getKeysNumber() {
        return keysNumber;
    }

    public void setKeysNumber(int keysNumber) {
        this.keysNumber = keysNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;
        return getId() == car.getId()
                && getKeysNumber() == car.getKeysNumber()
                && Objects.equals(getBrand(), car.getBrand())
                && Objects.equals(getModel(), car.getModel())
                && Objects.equals(getColor(), car.getColor())
                && Objects.equals(getRegNumber(), car.getRegNumber())
                && Objects.equals(getChassisNumber(), car.getChassisNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBrand(), getModel(), getColor(), getRegNumber(),
                getChassisNumber(), getKeysNumber());
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", regNumber='" + regNumber + '\'' +
                ", chassisNumber='" + chassisNumber + '\'' +
                ", keysNumber=" + keysNumber +
                '}';
    }
}
