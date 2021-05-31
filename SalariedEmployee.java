package com.silas;

public class SalariedEmployee extends Employee{
    private double baseSalary;

    public SalariedEmployee(){
        super();
    };

    public SalariedEmployee(int employeeId, String firstName,String lastName,double salary){
        super(employeeId,firstName,lastName);
        this.baseSalary=salary;
    }
    public void setBaseSalary(double salary){
        this.baseSalary=salary;
    }


    public double calculateSalary(){
        return baseSalary;
    }

    @Override
    public String toString(){
        return   super.toString()+
                String.format("%-20s %.2f%n","Salary: " ,calculateSalary());
    }
}
