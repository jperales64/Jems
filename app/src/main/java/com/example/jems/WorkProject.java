package com.example.jems;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

import java.math.BigDecimal;
import java.util.ArrayList;

@Entity(tableName = "project")
public class WorkProject implements Parcelable {
    @PrimaryKey(autoGenerate = true)

    private int id;

    @ColumnInfo(name = "project_name")
    private String projectName;

//    @ColumnInfo(name = "first_name")
//    private String customerFirstName;
//
//    @ColumnInfo(name = "last_name")
//    private String customerLastName;
//
//    @ColumnInfo(name = "customer_Address")
//    private String customerAddress;
    @ColumnInfo(name = "customer_id")
    private int customerID;

    @Ignore
    private BigDecimal actualCost;

    @Ignore
    private BigDecimal displayCost = new BigDecimal("2.00");

    @ColumnInfo(name = "project_cost")
    private String displayCostStr;

    //Hours worked by each employee
    @Ignore
    private double hoursWorkedOnProject;

    @ColumnInfo(name = "hours")
    private String hoursWorkedOnProjectStr;

    //Just like actualCost make sure to use money
    @Ignore
    private BigDecimal netProfit = new BigDecimal("2.00");
    @ColumnInfo(name = "profit")
    private String netProfitStr;

    //LaborCost
    @Ignore
    private BigDecimal laborCost = new BigDecimal(0.00);
    @ColumnInfo(name = "labor_cost")
    private String laborCostStr = laborCost.toString();
    //List of materials --Maybe create a MaterialsList class that provides fuctions for calculating material actualCost
    @Ignore
    private
    MaterialList materialsList = new MaterialList();

    @Ignore
    private
    MaterialListLineItem lineItem = new MaterialListLineItem(new Material("wood", new BigDecimal(12.50)), 12);

    @Ignore
    private
    double miles;
    @ColumnInfo(name = "miles")
    private String milesStr;

    @Ignore
    private
    BigDecimal costPerMile = new BigDecimal("2.00");

    //test stuff
    @Ignore
    private
    Material wood = new Material("Wood", new BigDecimal(12.50));
    @Ignore
    private
    ArrayList<Material> materials = new ArrayList<>();

    /**
     * Constructor
     */
    public WorkProject(double hoursWorkedOnProject, double miles, String customerFirstName, String customerLastName, String address) {
        ArrayList<MaterialListLineItem> lineItems = new ArrayList<>();
        lineItems.add(lineItem);
        this.hoursWorkedOnProject = hoursWorkedOnProject;
        this.hoursWorkedOnProjectStr = String.valueOf(hoursWorkedOnProject);
        this.miles = miles;
        this.milesStr = String.valueOf(miles);

        this.laborCost = this.laborCost.add(new BigDecimal(15 * hoursWorkedOnProject));
        this.laborCostStr = laborCost.toString();
        materials.add(wood);
        this.materialsList = new MaterialList(lineItems);
        this.actualCost = calcCost();
        this.netProfit = this.actualCost.subtract((this.materialsList.getCost()));
        this.netProfitStr = netProfit.toString();
    }


    /**
     * for make a work projecxt to test
     */
    public WorkProject() {

        this.hoursWorkedOnProject = 12;
        this.miles = 50;
        this.customerID = 1;
        this.actualCost = calcCost();

    }

    public WorkProject(int custId){
        this.customerID = custId;
    }

    public WorkProject(Parcel in) {

        this.id = in.readInt();
        this.projectName = in.readString();
        this.hoursWorkedOnProject = in.readDouble();
        this.miles = in.readDouble();
        this.actualCost = (BigDecimal) in.readSerializable();
        this.customerID = in.readInt();


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




    BigDecimal getActualCost() {
        return actualCost;
    }

    public void setActualCost(BigDecimal actualCost) {
        this.actualCost = actualCost;
    }

    public double getHoursWorkedOnProject() {
        return hoursWorkedOnProject;
    }

    public void setHoursWorkedOnProject(float hoursWorkedOnProject) {
        this.hoursWorkedOnProject = hoursWorkedOnProject;
    }

    public BigDecimal getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(BigDecimal netProfit) {
        this.netProfit = netProfit;
    }

    private BigDecimal getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(BigDecimal laborCost) {
        this.laborCost = laborCost;
    }

    public MaterialList getMaterials() {
        return materialsList;
    }

    public void setMaterials(MaterialList materials) {
        this.materialsList = materials;
    }

    double getMiles() {
        return miles;
    }

    public void setMiles(float miles) {
        this.miles = miles;
    }

    private BigDecimal getCostPerMile() {
        return costPerMile;
    }

    public void setCostPerMile(BigDecimal costPerMile) {
        this.costPerMile = costPerMile;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(id);

        dest.writeString(projectName);

        dest.writeDouble(hoursWorkedOnProject);

        dest.writeDouble(miles);

        dest.writeSerializable(actualCost);

        dest.writeInt(customerID);

    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    void setDisplayCostStr(String filler) {
        this.displayCostStr = this.displayCost.toString();
    }

    String getDisplayCostStr() {
        return this.displayCostStr;
    }

    void setNetProfitStr(String filler) {
        this.netProfitStr = this.netProfit.toString();
    }

    String getNetProfitStr() {
        return this.netProfitStr;
    }

    void setLaborCostStr(String filler) {
        this.laborCostStr = this.laborCost.toString();
    }

    String getLaborCostStr() {
        return this.laborCostStr;
    }

    void setHoursWorkedOnProjectStr(String filler) {
        this.hoursWorkedOnProjectStr = String.valueOf(hoursWorkedOnProject);
    }

    String getHoursWorkedOnProjectStr() {
        return this.hoursWorkedOnProjectStr;
    }

    void setMilesStr(String filler) {
        this.milesStr = String.valueOf(miles);
    }

    String getMilesStr() {
        return this.milesStr;
    }


    private BigDecimal calcCost() {
        BigDecimal labor = this.getLaborCost();

        //BigDecimal matCost = this.getMaterials().getCost();
        BigDecimal costPerMi = getCostPerMile();
        BigDecimal milesBD = new BigDecimal(this.getMiles());
        //BigDecimal cost = this.getLaborCost().add(((this.getMaterials().getCost())).add( getCostPerMile().multiply(new BigDecimal(this.getMiles()))));
        BigDecimal cost = new BigDecimal(0.00);
        cost.add(labor).add(costPerMi).add(milesBD);
        return cost;
    }

    int getCustomerID() {
        return customerID;
    }
    void setCustomerID(int id){
        this.customerID = id;
    }
}