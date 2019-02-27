package com.example.jems;

import android.os.Parcel;
import android.os.Parcelable;

import java.math.BigDecimal;

public class WorkProject implements Parcelable {
    String customerName;
    //List of employees working on projec
    String customerAddress;


    //Make sure to use Money api later for accurate money representation
    BigDecimal actualCost;
    BigDecimal displayCost;
    //Hours worked by each employee
    double hours;
    //Just like actualCost make sure to use money
    BigDecimal netProfit;
    //LaborCost`
    BigDecimal laborCost = new BigDecimal(0.00);
    //List of materials --Maybe create a MaterialsList class that provides fuctions for calculating material actualCost
    MaterialList materials = new MaterialList();
    double miles;
    BigDecimal costPerMile = new BigDecimal("2.00");
    /**
     * Constructor
     */
    public WorkProject(double hours, double miles, String customerName, String address){

        this.hours = hours;
        this.miles = miles;
        //This should be changed to actual laborCost, or make laborCost a project wide constant
        this.laborCost = this.laborCost.add(new BigDecimal(15 * hours));

        this.materials = materials;
        this.customerName = customerName;
        this.customerAddress = address;
        this.actualCost = calcCost();
       this.netProfit = this.actualCost.subtract(new BigDecimal(this.materials.getCost()));

    }


    /**
     * for make a work projecxt to test
     *
     */
    public WorkProject(){

        this.hours = 12;
        this.miles = 50;
        this.customerName = "BOOOOOOM";
        this.customerAddress = "123 Main St.";
        this.actualCost = calcCost();

    }

    private BigDecimal calcCost() {
        BigDecimal cost = this.laborCost.add((new BigDecimal(this.materials.getCost())).add( costPerMile.multiply(new BigDecimal(miles))));
        return cost;
    }

    public WorkProject(Parcel in){


        this.hours = in.readDouble();
        this.miles = in.readDouble();
        this.customerName = in.readString();
        this.customerAddress = in.readString();
        this.actualCost = (BigDecimal) in.readSerializable();


    }

    public static final Creator<WorkProject> CREATOR = new Creator<WorkProject>() {
        @Override
        public WorkProject createFromParcel(Parcel in) {
            return new WorkProject(in);
        }

        @Override
        public WorkProject[] newArray(int size) {
            return new WorkProject[size];
        }
    };


    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public BigDecimal getActualCost() {
        return actualCost;
    }

    public void setActualCost(BigDecimal actualCost) {
        this.actualCost = actualCost;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(float hours) {
        this.hours = hours;
    }

    public BigDecimal getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(BigDecimal netProfit) {
        this.netProfit = netProfit;
    }

    public BigDecimal getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(BigDecimal laborCost) {
        this.laborCost = laborCost;
    }

    public MaterialList getMaterials() {
        return materials;
    }

    public void setMaterials(MaterialList materials) {
        this.materials = materials;
    }

    public double getMiles() {
        return miles;
    }

    public void setMiles(float miles) {
        this.miles = miles;
    }

    public BigDecimal getCostPerMile() {
        return costPerMile;
    }

    public void setCostPerMile(BigDecimal costPerMile) {
        this.costPerMile = costPerMile;
    }

    public String getCustomerName(){
        return customerName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {


        dest.writeDouble(hours);

        dest.writeDouble(miles);


        dest.writeString(customerName);

        dest.writeString(customerAddress);

        dest.writeSerializable(actualCost);

    }

    public void setCustName(String name) {
        this.customerName = name;
    }


}