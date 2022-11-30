package com.example.mockito_hw.model;

public class Employee {
    private static int counter;
    private final String firstName;
    private final String lastName;
    private final int department;
    private final int salary;
    private final int id;


    public Employee(String firstName, String lastName, int department, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
        this.id = counter++;
    }

    public static int getCounter() {
        return counter;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getDepartment() {
        return this.department;
    }

    public int getSalary() {
        return this.salary;
    }

    public int getId() {
        return this.id;
    }

    public String toString() {
        return "Employee{firstName='" + this.firstName + "', lastName='" + this.lastName + "', department=" + this.department + ", salary=" + this.salary + ", id=" + this.id + "}";
    }
}
