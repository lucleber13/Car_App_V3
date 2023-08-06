package com.cbcode.car_app_v3.Car.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "used_cars")
@PrimaryKeyJoinColumn(name = "id")
public class UsedCar extends Car{
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "Europe/London")
    @Temporal(TemporalType.DATE)
    private Date dateArrived;
    private boolean isNeededPolishMachine;
    private boolean isNeededPaintShop;
    private String valetComments;
    private String workshopComments;

    public UsedCar() {

    }
    public UsedCar(long id, String brand, String model, String color, String regNumber, String chassisNumber,
                   int keysNumber, Date dateArrived, boolean isNeededPolishMachine, boolean isNeededPaintShop,
                   String valetComments, String workshopComments) {
        super(id, brand, model, color, regNumber, chassisNumber, keysNumber);
        this.dateArrived = dateArrived;
        this.isNeededPolishMachine = isNeededPolishMachine;
        this.isNeededPaintShop = isNeededPaintShop;
        this.valetComments = valetComments;
        this.workshopComments = workshopComments;
    }

    public Date getDateArrived() {
        return dateArrived;
    }

    public void setDateArrived(Date dateArrived) {
        this.dateArrived = dateArrived;
    }

    public boolean isNeededPolishMachine() {
        return isNeededPolishMachine;
    }

    public void setNeededPolishMachine(boolean neededPolishMachine) {
        isNeededPolishMachine = neededPolishMachine;
    }

    public boolean isNeededPaintShop() {
        return isNeededPaintShop;
    }

    public void setNeededPaintShop(boolean neededPaintShop) {
        isNeededPaintShop = neededPaintShop;
    }

    public String getValetComments() {
        return valetComments;
    }

    public void setValetComments(String valetComments) {
        this.valetComments = valetComments;
    }

    public String getWorkshopComments() {
        return workshopComments;
    }

    public void setWorkshopComments(String workshopComments) {
        this.workshopComments = workshopComments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsedCar usedCar)) return false;
        if (!super.equals(o)) return false;
        return isNeededPolishMachine() == usedCar.isNeededPolishMachine()
                && isNeededPaintShop() == usedCar.isNeededPaintShop()
                && Objects.equals(getDateArrived(), usedCar.getDateArrived())
                && Objects.equals(getValetComments(), usedCar.getValetComments())
                && Objects.equals(getWorkshopComments(), usedCar.getWorkshopComments());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getDateArrived(), isNeededPolishMachine(), isNeededPaintShop(),
                getValetComments(), getWorkshopComments());
    }

    @Override
    public String toString() {
        return "UsedCar{" +
                "dateArrived=" + dateArrived +
                ", isNeededPolishMachine=" + isNeededPolishMachine +
                ", isNeededPaintShop=" + isNeededPaintShop +
                ", valetComments='" + valetComments + '\'' +
                ", workshopComments='" + workshopComments + '\'' +
                '}';
    }
}
