package com.cbcode.car_app_v3.Cars.model;

import com.cbcode.car_app_v3.Cars.model.Enums.ConditionType;
import com.cbcode.car_app_v3.Cars.model.Enums.SoldOrStock;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "cars")
@SequenceGenerator(name = "seq_cars", initialValue = 1, allocationSize = 1, sequenceName = "seq_cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cars")
    private Long carId;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private String color;
    @Column(nullable = true)
    private String customerName;
    @Column(unique = true)
    private String regNumber;
    @Column(nullable = false, unique = true)
    private String chassisNumber;
    @Column(nullable = false)
    private Integer keysNumber;
    @Column(nullable = true)
    private Integer mileage;
    private Boolean isSold = false;
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

    public Car() {
    }

    public Car(String model, String color, String customerName, String regNumber, String chassisNumber, Boolean isSold,
               Integer keysNumber, Integer mileage, Date dateArrived, Date dateRequired, ConditionType conditionType) {
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
    public static CarBuilder builder() {
        return new CarBuilder();
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

    public Boolean getIsSold() {
        return isSold;
    }

    public void setIsSold(Boolean isSold) {
        this.isSold = isSold;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;
        return Objects.equals(getCarId(), car.getCarId())
                && Objects.equals(getModel(), car.getModel())
                && Objects.equals(getColor(), car.getColor())
                && Objects.equals(getCustomerName(), car.getCustomerName())
                && Objects.equals(getRegNumber(), car.getRegNumber())
                && Objects.equals(getChassisNumber(), car.getChassisNumber())
                && Objects.equals(getKeysNumber(), car.getKeysNumber())
                && Objects.equals(getMileage(), car.getMileage())
                && Objects.equals(getIsSold(), car.getIsSold())
                && Objects.equals(getDateArrived(), car.getDateArrived())
                && Objects.equals(getDateRequired(), car.getDateRequired())
                && getConditionType() == car.getConditionType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCarId(), getModel(), getColor(), getCustomerName(), getRegNumber(), getChassisNumber(), getKeysNumber(),
                getMileage(), getDateArrived(), getDateRequired(), getConditionType(), getIsSold());
    }

    @Override
    public String toString() {
        return "Car{" +
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
