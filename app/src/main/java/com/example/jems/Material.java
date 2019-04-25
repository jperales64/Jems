package com.example.jems;

import android.support.annotation.NonNull;

import com.example.jems.materials.MaterialType;
import java.math.BigDecimal;
class Material {

    private String name;
    private BigDecimal cost;     //Change to money api
    private MaterialType materialType;

    public Material(String name, MaterialType materialType, BigDecimal cost) {
        this.name = name;
        this.materialType = materialType;
        this.cost = cost;
    }

     Material(String name, BigDecimal cost) {
        this.name = name;
        this.materialType = MaterialType.Misc.EMPTY;
        this.cost = cost;
        System.out.println(MaterialType.Siding.BRICK);
    }

     BigDecimal getCost() {
        return cost;

    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getName() {
        return this.name;

    }

    @NonNull
    @Override
    public String toString() {
        return name + "\t" + materialType.label() + "\t" + cost;

    }
}
