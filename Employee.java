package com.silas;

public abstract class Employee {
    private int employeeId;
    private String firstName;
    private  String lastName;

    //empty constructor
    public Employee()
    {
    }
    //parametized constructor
    public Employee(int employeeId,String firstName,String lastName){
        this.employeeId=employeeId;
        this.firstName=firstName;
        this.lastName=lastName;
    }

    //getters
    public  int getEmployeeId(){ return employeeId; }
    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}

    //setters
    public void setEmployeeId(int id) {
        this.employeeId=id;
    }
    public void setFirstName(String name){
        this.firstName = name;
    }
    public void setLastName(String name){
        this.lastName=name;
    }

    //abstract method
    public abstract double calculateSalary();

    @Override
    public String toString(){
      return   String.format("%-20s %d%n","Employee ID:",employeeId) +
      String.format("%-20s %s%n","Employee Name", firstName + " " +lastName);

    }
}
