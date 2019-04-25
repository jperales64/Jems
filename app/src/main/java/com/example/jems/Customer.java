package com.example.jems;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;


@Entity(tableName = "customer")
public class Customer implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "first_name")
    private String firstName;

    @ColumnInfo(name = "last_name")
    private String lastName;

    @ColumnInfo(name = "address")
    private String custAddress;

    @ColumnInfo(name = "tele")
    private String custTele;

    public Customer(){
        this.firstName = "";
        this.lastName = "";
        this.custAddress = "";
        this.custTele = "";
    }

    public Customer(String firstName, String lastName, String custAddress, String custTele){
        this.firstName = firstName;
        this.lastName = lastName;
        this.custAddress = custAddress;
        this.custTele = custTele;
    }

    public static final Creator<Customer> CREATOR = new Creator<Customer>() {
        @Override
        public Customer createFromParcel(Parcel in) {
            return new Customer(in);
        }

        @Override
        public Customer[] newArray(int size) {
            return new Customer[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    void setFirstName(String firstName) {
        this.firstName = firstName;
    }

     String getLastName() {
        return lastName;
    }

     void setLastName(String lastName) {
        this.lastName = lastName;
    }

     String getCustAddress() {
        return custAddress;
    }

     void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

     String getCustTele(){
        return custTele;
    }

     void setCustTele(String tele){
        this.custTele = tele;
    }

    @Override
    public int describeContents() {
        return 0;
    }
    public Customer(Parcel in){
        this.id = in.readInt();
        this.firstName = in.readString();
        this.lastName = in.readString();
        this.custAddress = in.readString();
        this.custTele = in.readString();

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(custAddress);
        dest.writeString(custTele);

    }
}
