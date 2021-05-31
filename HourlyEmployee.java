package com.silas;

public class HourlyEmployee extends Employee{

    private double hoursWorked;
    private double hourlyRate;

    public HourlyEmployee(){
        super();
    }

    //parametized constructor
    public HourlyEmployee(int employeeId,String firstName,String lastName,double hourlyRate,double hoursWorked){
        super(employeeId,firstName,lastName);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }
    public double getHoursWorked(){return hoursWorked;}
    public double getHourlyRate(){return hourlyRate;}

    public void setHoursWorked(double hours){
        this.hoursWorked = hours;
    }
    public void setHourlyRate(double rate){
        this.hourlyRate = rate;
    }

    public double calculateSalary(){
        double salary = 0;
        double overtime = 0;

        if (hoursWorked > 40){
            double hours  = hoursWorked-40;
            hoursWorked= 40;
            overtime = hours * ( hourlyRate * 1.5);
        }
        salary = hoursWorked * hourlyRate;
        salary += overtime;

        return salary;
    }

    @Override
    public String toString(){

        return super.toString()+
                String.format("%-20s %.2f%n","Salary: " ,calculateSalary());
    }
}
