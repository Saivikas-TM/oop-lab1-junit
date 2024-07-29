package com.trainingmug.ecommerce;
public class Employee {


    // Static variables
//    public static String companyName;
//    public static String companyContactNo;
//    public static long employeeCount = 0;


    public static String companyName = "Training Mug";
    public static String companyContactNo = "9034568900";
    public static long employeeCount = 0;


    // Instance variables
          public long empId;
          public String name;
          public String designation;
          public float grossSalary;
          public float travellingAllowances;
          public float federalTax;
          public float stateTax;
          public float incrementPercentage;


          public Employee(){
              this.empId = 1111;
              this.name = "Andrew Fuller";
              this.designation = "Senior Software Engineer";
              this.grossSalary = 5208.33f;
              this.travellingAllowances = 300f;
              this.federalTax = 611.86f;
              this.stateTax =  359.24f;
              this.incrementPercentage = 15.3f;
          }


    public Employee(long empId,String name, String designation, float grossSalary,float travellingAllowances, float federalTax, float stateTax, float incrementPercentage){

              this.empId = empId;
              this.name = name;
              this.designation = designation;
              this.grossSalary = grossSalary;
              this.travellingAllowances = travellingAllowances;
              this.federalTax = federalTax;
              this.stateTax = stateTax;
              this.incrementPercentage = incrementPercentage;

    }


    // Method to increase grossSalary by a given percentage
    public void incrementSalary(float percentage) {
        float incrementAmount = this.grossSalary * percentage / 100;
        this.grossSalary += incrementAmount;
    }

    // Method to display all property values
    public void displayProfile() {
        System.out.println("Employee ID: " + this.empId);
        System.out.println("Name: " + this.name);
        System.out.println("Designation: " + this.designation);
        System.out.println("Gross Salary: " + this.grossSalary);
        System.out.println("Travelling Allowances: " + this.travellingAllowances);
        System.out.println("Federal Tax: " + this.federalTax);
        System.out.println("State Tax: " + this.stateTax);
        System.out.println("Net Salary Increment Percentage: " + this.incrementPercentage);
    }

    // Static method to display company details
    public static void displayCompanyInfo() {
        System.out.println("Company Name: " + companyName);
        System.out.println("Company Contact No: " + companyContactNo);
        System.out.println("Employee Count: " + employeeCount);
    }

}
