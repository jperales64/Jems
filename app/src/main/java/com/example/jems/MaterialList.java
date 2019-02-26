package com.example.jems;

import java.util.ArrayList;

public class MaterialList {
    ArrayList<Material> materials;
    float cost;
    public MaterialList(ArrayList<Material> materials){
        this.materials = materials;
        this.cost = this.calcCost();
    }

    //for texsting
    public  MaterialList(){
        this.cost = 13.46f;
    }
    private float calcCost() {
        float cost = 0;
        for (int i = 0; i < this.materials.size(); i++){
            cost += this.materials.get(i).getCost();
        }
        return cost;
    }

    public ArrayList<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(ArrayList<Material> materials) {
        this.materials = materials;
    }

    public float getCost() {
        return cost;
    }


}
