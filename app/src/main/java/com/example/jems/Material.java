package com.example.jems;

import com.example.jems.materials.MaterialType;

class Material {

    String name;
    Float cost;     //Change to money api
    MaterialType materialType;

    public Material(String name, MaterialType materialType, Float cost){
        this.name = name;
        this.materialType = materialType;
        this.cost = cost;
    }

    public Material(String name, Float cost){
        this.name = name;
        this.materialType = MaterialType.Misc.EMPTY;
        this.cost = cost;
        System.out.println(MaterialType.Siding.BRICK);
    }

    public Float getCost() {
        return 13.34f;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    @Override
    public String toString(){
        return name + "\t" + materialType.label() + "\t" + cost;
    }
}
