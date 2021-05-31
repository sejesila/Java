package com.silas;

public class Main {

    public static void main(String[] args) {
      Employee employee[] = new Employee[3];
      employee[0] = new HourlyEmployee(2,"Silas","Seje",4000,58);
      employee[1] = new SalariedEmployee(1,"Joan","Atieno",45000);
      employee[2] = new CommissionedEmployee(4,"Dan","Max",0.5,57300,249800);

      for (int i =0;i<employee.length;i++){
          System.out.println(employee[i]);
      }
    }
}
