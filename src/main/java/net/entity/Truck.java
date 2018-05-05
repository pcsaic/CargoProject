package net.entity;

import javax.persistence.*;

@Entity
@Table (name="truck")

public class Truck {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "number", nullable = false)
    private String number;
    @Column(name = "driver")
    private String driver;
    @Column(name = "tonnage", nullable = false)
    private double tonnage;
    @Column (name = "status", nullable = false)
    private String status;
    @Column(name = "point", nullable = false)
    private String point;
    @Column(name = "`order`")
    private String order;

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public String getNumber() {

        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getDriver() {
        return driver;
    }
    public void setDriver(String driver) {
        this.driver = driver;
    }
    public double getTonnage() {
        return tonnage;
    }
    public void setTonnage(double tonnage) {
        this.tonnage = tonnage;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getPoint() {
        return point;
    }
    public void setPoint(String point) {
        this.point = point;
    }
    public String getOrder() {
        return order;
    }
    public void setOrder(String order) {
        this.order = order;
    }
}
