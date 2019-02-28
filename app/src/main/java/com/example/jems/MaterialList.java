package com.example.jems;

import java.math.BigDecimal;
import java.util.ArrayList;

public class MaterialList {
    ArrayList<Material> materials;
    BigDecimal cost;
    public MaterialList(ArrayList<Material> materials){
        this.materials = materials;
        this.cost = this.calcCost();
    }

    //for textsting
    public  MaterialList(){

    }
    private BigDecimal calcCost() {
        BigDecimal cost = new BigDecimal(0);
        for (int i = 0; i < this.materials.size(); i++){
            cost.add(this.materials.get(i).getCost());
        }
        return cost;
    }

    public ArrayList<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(ArrayList<Material> materials) {
        this.materials = materials;
    }

    public BigDecimal getCost() {
        return cost;
    }


}
