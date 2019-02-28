package com.example.jems;

import com.example.jems.materials.MaterialType;
import java.math.BigDecimal;
class Material {

    String name;
    BigDecimal cost;     //Change to money api
    MaterialType materialType;

    public Material(String name, MaterialType materialType, BigDecimal cost){
        this.name = name;
        this.materialType = materialType;
        this.cost = cost;
    }

    public Material(String name, BigDecimal cost){
        this.name = name;
        this.materialType = MaterialType.Misc.EMPTY;
        this.cost = cost;
        System.out.println(MaterialType.Siding.BRICK);
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
    @Override
    public String toString(){
        return name + "\t" + materialType.label() + "\t" + cost;

    
}
