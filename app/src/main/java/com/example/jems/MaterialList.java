package com.example.jems;

import java.math.BigDecimal;
import java.util.ArrayList;

public class MaterialList {
    ArrayList<MaterialListLineItem> materials = new ArrayList<>();
    BigDecimal cost;
    public MaterialList(ArrayList<MaterialListLineItem> materials){
        this.materials = materials;
        this.cost = this.calcCost();
    }

    //for textsting
    public  MaterialList(){

    }
    private BigDecimal calcCost() {
        BigDecimal cost = new BigDecimal(0);
        for (int i = 0; i < this.materials.size(); i++){
            cost.add(this.materials.get(i).calcCost());
        }
        return cost;
    }

    public ArrayList<MaterialListLineItem> getMaterials() {
        return materials;
    }

    public void setMaterials(ArrayList<MaterialListLineItem> materials) {
        this.materials = materials;
    }

    public BigDecimal getCost() {
        return cost;
    }


    public MaterialListLineItem get(int position) {
        return materials.get(position);
    }

    public int size() {
        return materials.size();
    }

    public void add(MaterialListLineItem mat) {
        this.materials.add(mat);
    }
}
