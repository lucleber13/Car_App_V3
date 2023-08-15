package com.cbcode.car_app_v3.Cars.model.DTO;

import com.cbcode.car_app_v3.Cars.model.Enums.ConditionType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

public class CarDto {
    private Long carId;
    private String model;
    private String color;
    private String customerName;
    @Column(unique = true)
    private String regNumber;
    @Column(nullable = false, unique = true)
    private String chassisNumber;
    private Integer keysNumber;
    private Integer mileage;
    private Boolean isSold;
    @Column(nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "Europe/London")
    @Temporal(TemporalType.DATE)
    private Date dateArrived;
    @Column(nullable = true)
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "Europe/London")
    @Temporal(TemporalType.DATE)
    private Date dateRequired;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ConditionType conditionType;

    public CarDto() {
    }

    public CarDto(String model, String color, String customerName, String regNumber, String chassisNumber,
                  Integer keysNumber, Integer mileage, Boolean isSold, Boolean isNeedPainting, Boolean isNeedService,
                  Boolean isNeedCleaning, Boolean isNeedMot, Date dateArrived, Date dateRequired, ConditionType conditionType) {
        this.model = model;
        this.color = color;
        this.customerName = customerName;
        this.regNumber = regNumber;
        this.chassisNumber = chassisNumber;
        this.keysNumber = keysNumber;
        this.mileage = mileage;
        this.isSold = isSold;
        this.dateArrived = dateArrived;
        this.dateRequired = dateRequired;
        this.conditionType = conditionType;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public Integer getKeysNumber() {
        return keysNumber;
    }

    public void setKeysNumber(Integer keysNumber) {
        this.keysNumber = keysNumber;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Boolean getSold() {
        return isSold;
    }

    public void setSold(Boolean sold) {
        isSold = sold;
    }

    public Date getDateArrived() {
        return dateArrived;
    }

    public void setDateArrived(Date dateArrived) {
        this.dateArrived = dateArrived;
    }

    public Date getDateRequired() {
        return dateRequired;
    }

    public void setDateRequired(Date dateRequired) {
        this.dateRequired = dateRequired;
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
        if (!(o instanceof CarDto carDto)) return false;
        return Objects.equals(getCarId(), carDto.getCarId())
                && Objects.equals(getModel(), carDto.getModel())
                && Objects.equals(getColor(), carDto.getColor())
                && Objects.equals(getCustomerName(), carDto.getCustomerName())
                && Objects.equals(getRegNumber(), carDto.getRegNumber())
                && Objects.equals(getChassisNumber(), carDto.getChassisNumber())
                && Objects.equals(getKeysNumber(), carDto.getKeysNumber())
                && Objects.equals(getMileage(), carDto.getMileage())
                && Objects.equals(isSold, carDto.isSold)
                && Objects.equals(getDateArrived(), carDto.getDateArrived())
                && Objects.equals(getDateRequired(), carDto.getDateRequired())
                && getConditionType() == carDto.getConditionType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCarId(), getModel(), getColor(), getCustomerName(), getRegNumber(),
                getChassisNumber(), getKeysNumber(), getMileage(), isSold, getDateArrived(), getDateRequired(), getConditionType());
    }

    @Override
    public String toString() {
        return "CarDto{" +
                "carId=" + carId +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", customerName='" + customerName + '\'' +
                ", regNumber='" + regNumber + '\'' +
                ", chassisNumber='" + chassisNumber + '\'' +
                ", keysNumber=" + keysNumber +
                ", mileage=" + mileage +
                ", isSold=" + isSold +
                ", dateArrived=" + dateArrived +
                ", dateRequired=" + dateRequired +
                ", conditionType=" + conditionType +
                '}';
    }
}
