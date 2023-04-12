package org.example.homework.sixth.secondtask;

public abstract class Employee implements Employable{

    protected String employeePosition;

    public void setEmployeePosition(String position){
        employeePosition = position;
    }

    public String getEmployeePosition(){
        return employeePosition;
    }

     public void printInfo(){
         System.out.println("Position: " + employeePosition);
     };
}
