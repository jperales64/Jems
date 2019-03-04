package com.example.jems;

import java.math.BigDecimal;

public class MaterialListLineItem {
    private Material material;
    private int qty;
    private BigDecimal totalCost;

    public MaterialListLineItem(Material material, int qty){
        this.material = material;
        this.qty = qty;
        this.totalCost = calcCost();
    }

    public BigDecimal getCostPerMateral(){
        return material.getCost();
    }

    public BigDecimal calcCost(){
        return (getCostPerMateral().multiply(new BigDecimal(qty)));
    }

    public String getName() {
        return material.getName();
    }

    public int getQty(){
        return this.qty;
    }
}
