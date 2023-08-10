package com.cbcode.car_app_v3.Cars.model.DTO;

import com.cbcode.car_app_v3.Cars.model.Enums.ConditionType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

public class CarsDto {
    private Long carId;
    private String brand;
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
    private Boolean isNeedPainting;
    private Boolean isNeedService;
    private Boolean isNeedCleaning;
    private Boolean isNeedMot;
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

    public CarsDto() {
    }

    public CarsDto(String brand, String model, String color, String customerName, String regNumber, String chassisNumber,
                   Integer keysNumber, Integer mileage, Boolean isSold, Boolean isNeedPainting, Boolean isNeedService,
                   Boolean isNeedCleaning, Boolean isNeedMot, Date dateArrived, Date dateRequired, ConditionType conditionType) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.customerName = customerName;
        this.regNumber = regNumber;
        this.chassisNumber = chassisNumber;
        this.keysNumber = keysNumber;
        this.mileage = mileage;
        this.isSold = isSold;
        this.isNeedPainting = isNeedPainting;
        this.isNeedService = isNeedService;
        this.isNeedCleaning = isNeedCleaning;
        this.isNeedMot = isNeedMot;
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

    public Boolean getNeedPainting() {
        return isNeedPainting;
    }

    public void setNeedPainting(Boolean needPainting) {
        isNeedPainting = needPainting;
    }

    public Boolean getNeedService() {
        return isNeedService;
    }

    public void setNeedService(Boolean needService) {
        isNeedService = needService;
    }

    public Boolean getNeedCleaning() {
        return isNeedCleaning;
    }

    public void setNeedCleaning(Boolean needCleaning) {
        isNeedCleaning = needCleaning;
    }

    public Boolean getNeedMot() {
        return isNeedMot;
    }

    public void setNeedMot(Boolean needMot) {
        isNeedMot = needMot;
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
        if (!(o instanceof CarsDto carsDto)) return false;
        return Objects.equals(getCarId(), carsDto.getCarId())
                && Objects.equals(getBrand(), carsDto.getBrand())
                && Objects.equals(getModel(), carsDto.getModel())
                && Objects.equals(getColor(), carsDto.getColor())
                && Objects.equals(getCustomerName(), carsDto.getCustomerName())
                && Objects.equals(getRegNumber(), carsDto.getRegNumber())
                && Objects.equals(getChassisNumber(), carsDto.getChassisNumber())
                && Objects.equals(getKeysNumber(), carsDto.getKeysNumber())
                && Objects.equals(getMileage(), carsDto.getMileage())
                && Objects.equals(isSold, carsDto.isSold)
                && Objects.equals(isNeedPainting, carsDto.isNeedPainting)
                && Objects.equals(isNeedService, carsDto.isNeedService)
                && Objects.equals(isNeedCleaning, carsDto.isNeedCleaning)
                && Objects.equals(isNeedMot, carsDto.isNeedMot)
                && Objects.equals(getDateArrived(), carsDto.getDateArrived())
                && Objects.equals(getDateRequired(), carsDto.getDateRequired())
                && getConditionType() == carsDto.getConditionType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCarId(), getBrand(), getModel(), getColor(), getCustomerName(), getRegNumber(),
                getChassisNumber(), getKeysNumber(), getMileage(), isSold, isNeedPainting, isNeedService,
                isNeedCleaning, isNeedMot, getDateArrived(), getDateRequired(), getConditionType());
    }

    @Override
    public String toString() {
        return "CarsDto{" +
                "carId=" + carId +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", customerName='" + customerName + '\'' +
                ", regNumber='" + regNumber + '\'' +
                ", chassisNumber='" + chassisNumber + '\'' +
                ", keysNumber=" + keysNumber +
                ", mileage=" + mileage +
                ", isSold=" + isSold +
                ", isNeedPainting=" + isNeedPainting +
                ", isNeedService=" + isNeedService +
                ", isNeedCleaning=" + isNeedCleaning +
                ", isNeedMot=" + isNeedMot +
                ", dateArrived=" + dateArrived +
                ", dateRequired=" + dateRequired +
                ", conditionType=" + conditionType +
                '}';
    }
}
