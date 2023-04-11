package org.example.homework.sixth.secondtask;

public class Worker extends Employee{
    @Override
    public void setEmployeePosition(String position) {
        employeePosition = position;
    }

    @Override
    public String getEmployeePosition() {
        return employeePosition;
    }
}
