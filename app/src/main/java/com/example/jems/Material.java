package com.example.jems;

import java.math.BigDecimal;

class Material {
    //Change to money api
    private String name;
    private BigDecimal cost;

    public Material(String name, BigDecimal cost){
        this.cost = cost;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getName(){
        return this.name;
    }
}
