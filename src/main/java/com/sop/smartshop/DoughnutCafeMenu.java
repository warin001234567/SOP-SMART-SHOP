package com.sop.smartshop;

public class DoughnutCafeMenu {
    private String name;
    private String detail;
    private Doughnut[] doughnut;
    private Tea[] tea;
    private double price;
    public DoughnutCafeMenu(String name, String detail, Doughnut[] doughnut, Tea[] tea, double price){
        this.name = name;
        this.detail = detail;
        this.doughnut = doughnut;
        this.tea = tea;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getDetail() {
        return detail;
    }

    public String getName() {
        return name;
    }

    public Tea[] getTea() {
        return tea;
    }

    public Doughnut[] getDoughnut() {
        return doughnut;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setDoughnut(Doughnut[] doughnut) {
        this.doughnut = doughnut;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTea(Tea[] tea) {
        this.tea = tea;
    }
}
