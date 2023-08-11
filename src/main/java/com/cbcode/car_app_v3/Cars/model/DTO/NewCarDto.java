package com.cbcode.car_app_v3.Cars.model.DTO;

import com.cbcode.car_app_v3.Cars.model.Enums.ConditionType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

public class NewCarDto {
    private Long id;
    private String model;
    private String color;
    private String regNumber = null;
    private Integer keysNumber;
    private String chassisNumber;
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "Europe/London")
    @Temporal(TemporalType.DATE)
    private Date dateArrived;
    private String customerName;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ConditionType conditionType;

    public NewCarDto() {
    }

    public NewCarDto(String model, String color, Integer keysNumber, String chassisNumber,
                     Date dateArrived, String customerName, ConditionType conditionType, String regNumber) {
        this.model = model;
        this.color = color;
        this.keysNumber = keysNumber;
        this.chassisNumber = chassisNumber;
        this.dateArrived = dateArrived;
        this.customerName = customerName;
        this.conditionType = conditionType;
        this.regNumber = regNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getDateArrived() {
        return dateArrived;
    }

    public void setDateArrived(Date dateArrived) {
        this.dateArrived = dateArrived;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public ConditionType getConditionType() {
        return conditionType;
    }

    public void setConditionType(ConditionType conditionType) {
        this.conditionType = conditionType;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber.toUpperCase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NewCarDto newCarDto)) return false;
        return Objects.equals(getId(), newCarDto.getId())
                && Objects.equals(getModel(), newCarDto.getModel())
                && Objects.equals(getColor(), newCarDto.getColor())
                && Objects.equals(getKeysNumber(), newCarDto.getKeysNumber())
                && Objects.equals(getChassisNumber(), newCarDto.getChassisNumber())
                && Objects.equals(getDateArrived(), newCarDto.getDateArrived())
                && Objects.equals(getCustomerName(), newCarDto.getCustomerName())
                && getConditionType() == newCarDto.getConditionType()
                && Objects.equals(getRegNumber(), newCarDto.getRegNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getModel(), getColor(), getKeysNumber(), getChassisNumber(),
                getDateArrived(), getCustomerName(), getConditionType(), getRegNumber());
    }

    @Override
    public String toString() {
        return "NewCarDto{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", keysNumber=" + keysNumber +
                ", chassisNumber='" + chassisNumber + '\'' +
                ", dateArrived=" + dateArrived +
                ", customerName='" + customerName + '\'' +
                ", conditionType=" + conditionType +
                ", regNumber='" + regNumber + '\'' +
                '}';
    }
}

