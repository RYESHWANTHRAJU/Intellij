package com.a2z.demo.model;

public class Bike {
    private Integer id;
    private String model;
    private String company;
    private String cubiccentimeter;
    private double mileage;
    private Integer price;

    public Bike(Integer id, String model, String company, String cubiccentimeter, double mileage, Integer price) {
        this.id = id;
        this.model = model;
        this.company = company;
        this.cubiccentimeter = cubiccentimeter;
        this.mileage = mileage;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCubiccentimeter() {
        return cubiccentimeter;
    }

    public void setCubiccentimeter(String cubiccentimeter) {
        this.cubiccentimeter = cubiccentimeter;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String   toString() {
        return "Bike{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", company='" + company + '\'' +
                ", cubiccentimeter='" + cubiccentimeter + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                '}';
    }
}
