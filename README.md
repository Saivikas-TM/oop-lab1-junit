## Object-Oriented Programming Java Lab
### Objectives
1. Understand and create a new class in Java.
2. Creating objects and accessing them in a class.
3. Creating and invoking methods in Java
4. Create constructors.
5. Create instances using argument and no-argument constructors.
6. Create static variables and methods.
7. Invoking static methods.
### Tasks
1. Create a new Java class named `Employee` in the `/src/main/java` package with the following properties:
   - empId : `long`
   - name : `String`
   - designation : `String`
   - grossSalary : `float`
   - travellingAllowances : `float`
   - federalTax : `float`
   - stateTax : `float`

2. Create a no-argument constructor for Employee class to initialize the instance variables.

3. Create an all-argument constructor for Employee class to initialize the
   instance variables.

4. Create a method in Employee class to increase the `grossSalary` by the given percentage as follows:
    ```java
   public void incrementSalary(long percentage) {}
    ```
   
5. Create a method in `Employee` class to display all the property values as follows:
    ```java
   public void displayProfile() {}
    ```
6. Add the following static variables in Employee class:
    - companyName : `String`
    - companyContactNo : `String`
    - employeeCount : `long`
   
7. Create a method in `Main` class that creates an object of `Employee` class and
   initializes the properties with the given values and then returns the object:
   ```java
   public Employee createEmployee(long empId, String name, String designation, float grossSalary, float travellingAllowances, float federalTax, float stateTax) {}
   ```
   
8. Each time the `createEmployee` method is invoked, the `employeeCount` should be incremented by 1.

9. Create a static method in `Employee` class to display the company details as follows:
   ```java
   public static void displayCompanyInfo() {}
   ```