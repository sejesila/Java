package com.silas;

import java.util.SplittableRandom;

public class CommissionedEmployee extends Employee {
    private double commissionRate;
    private double baseSalary;
    private double totalSales;

    public CommissionedEmployee(){
        super();
    }
    public CommissionedEmployee(int employeeId, String firstName,String lastName,double rate,double salary, double sales){
        super(employeeId,firstName,lastName);
        this.baseSalary=salary;
        this.commissionRate =rate;
        this.totalSales =sales;
    }
    public double getCommissionRate(){return commissionRate;}

    public double getBaseSalary() {
        return baseSalary;
    }

    public double getSales() {
        return totalSales;
    }

    public void setBaseSalary(double salary){
        this.baseSalary=salary;
    }
    public void setTotalSales(double sales){
        this.totalSales=sales;
    }
    public void setCommissionRate(double rate){
        this.commissionRate=rate;
    }
    public double calculateCommission(){
        return totalSales *     commissionRate;
    }
    public double calculateSalary(){
        return calculateCommission() + baseSalary;
    }

    @Override
    public String toString(){
        return   super.toString()+
                String.format("%-20s %.2f%n","Salary: " ,calculateSalary());
    }
}
