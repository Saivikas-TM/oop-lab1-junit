package com.trainingmug.ecommerce;

public class Main {

    public static void main(String[] args) {

        Employee defaultEmployee = new Employee();
        Employee.employeeCount++;
        defaultEmployee.incrementSalary(defaultEmployee.incrementPercentage);
        defaultEmployee.displayProfile();
        System.out.println();

        Employee customEmployee = new Employee(1234, "Jane Doe", "Project Manager", 6000.00f, 350.0f, 700.0f, 400.0f, 10.0f);
        Employee.employeeCount++;
        customEmployee.incrementSalary(customEmployee.incrementPercentage);
        customEmployee.displayProfile();
        System.out.println();

        Employee.displayCompanyInfo();
    }
}
