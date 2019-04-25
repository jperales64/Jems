package com.example.jems;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "employees_on_job")
public class EmployeesOnJob {
    @ColumnInfo(name = "emp_on_job_id")
    @PrimaryKey(autoGenerate = true)
    private int empOnJobId;
    @ColumnInfo(name = "project_id")
    private int projectId;

    @ColumnInfo(name = "employee_id")
    private int employeeId;

    public EmployeesOnJob(int projectId, int employeeId){
        this.projectId = projectId;
        this.employeeId = employeeId;
    }


    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getEmpOnJobId() {
        return empOnJobId;
    }

    public void setEmpOnJobId(int empOnJobId) {
        this.empOnJobId = empOnJobId;
    }
}
