package com.cbcode.car_app_v3.Cars.model.DTO;

import com.cbcode.car_app_v3.Cars.model.Enums.ConditionType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

public class UsedCarDto {
    private Long id;
    private String brand;
    private String model;
    private String color;
    private Integer keysNumber;
    private String chassisNumber;
    @Column(nullable = false)
    private String regNumber;
    private Integer mileage;
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "Europe/London")
    @Temporal(TemporalType.DATE)
    private Date dateArrived;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ConditionType conditionType;

    public UsedCarDto() {
    }

    public UsedCarDto(String brand, String model, String color, Integer keysNumber, String chassisNumber,
                      String regNumber, Integer mileage, Date dateArrived, ConditionType conditionType) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.keysNumber = keysNumber;
        this.chassisNumber = chassisNumber;
        this.regNumber = regNumber;
        this.mileage = mileage;
        this.dateArrived = dateArrived;
        this.conditionType = conditionType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Integer getKeysNumber() {
        return keysNumber;
    }

    public void setKeysNumber(Integer keysNumber) {
        this.keysNumber = keysNumber;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber.toUpperCase();
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Date getDateArrived() {
        return dateArrived;
    }

    public void setDateArrived(Date dateArrived) {
        this.dateArrived = dateArrived;
    }

    public ConditionType getConditionType() {
        return conditionType;
    }

    public void setConditionType(ConditionType conditionType) {
        this.conditionType = conditionType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsedCarDto that)) return false;
        return Objects.equals(getId(), that.getId())
                && Objects.equals(getBrand(), that.getBrand())
                && Objects.equals(getModel(), that.getModel())
                && Objects.equals(getColor(), that.getColor())
                && Objects.equals(getKeysNumber(), that.getKeysNumber())
                && Objects.equals(getChassisNumber(), that.getChassisNumber())
                && Objects.equals(getRegNumber(), that.getRegNumber())
                && Objects.equals(getMileage(), that.getMileage())
                && Objects.equals(getDateArrived(), that.getDateArrived())
                && getConditionType() == that.getConditionType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBrand(), getModel(), getColor(), getKeysNumber(), getChassisNumber(),
                getRegNumber(), getMileage(), getDateArrived(), getConditionType());
    }

    @Override
    public String toString() {
        return "UsedCarDto{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", keysNumber=" + keysNumber +
                ", chassisNumber='" + chassisNumber + '\'' +
                ", regNumber='" + regNumber + '\'' +
                ", mileage=" + mileage +
                ", dateArrived=" + dateArrived +
                ", conditionType=" + conditionType +
                '}';
    }
}
