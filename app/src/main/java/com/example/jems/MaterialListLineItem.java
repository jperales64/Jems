package com.example.jems;

import java.math.BigDecimal;

public class MaterialListLineItem {
    private Material material;
    private int qty;

    MaterialListLineItem(Material material, int qty){
        this.material = material;
        this.qty = qty;
        BigDecimal totalCost = calcCost();
    }

    BigDecimal getCostPerMateral(){
        return material.getCost();
    }

    BigDecimal calcCost(){
        return (getCostPerMateral().multiply(new BigDecimal(qty)));
    }

    public String getName() {
        return material.getName();
    }

    int getQty(){
        return this.qty;
    }
}
