package com.example.jems;

class Employee   {
    String name;

    //Change this to hash table using projectId as key
    int hours = 0;
    public Employee(String name){
        this.name = name;
    }

    //test Constructor
    public Employee(){
        this.name = "El Jeffe";
        this.hours = 40;
    }

    public String getName(){
        return this.name;
    }

    public int getHours(){ return this.hours;}

    public void updateHours(int additonalHoursWorked){
        this.hours += additonalHoursWorked;
    }

}
