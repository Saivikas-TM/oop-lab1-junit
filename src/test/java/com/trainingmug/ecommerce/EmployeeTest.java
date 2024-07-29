package com.trainingmug.ecommerce;

import com.trainingmug.ecommerce.Employee;
import com.trainingmug.ecommerce.Main;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;


public class EmployeeTest {
    @Test
    @Order(1)
    @DisplayName("Verify that the Employee class exists in the com.trainingmug.ecommerce package")
    public void testClassName() {

        String className = "com.trainingmug.ecommerce.Employee";

        try {
            Class.forName(className);
        } catch (ClassNotFoundException e) {
            fail("Class " + className + " not found");
        }
    }

    @Test
    @Order(2)
    @DisplayName("Check if Employee class has the required public fields")
    void TestVariableShouldBePresent(){
        try{
            Class<?> employeeClass = Class.forName("com.trainingmug.ecommerce.Employee");


            // Check if 'empId' field is public and of type 'long'
            assertFieldIsPublic(employeeClass, "empId", long.class);

            // Check if 'name' field is public and of type 'String'
            assertFieldIsPublic(employeeClass, "name", String.class);

            // Check if 'designation' field is public and of type 'String'
            assertFieldIsPublic(employeeClass, "designation", String.class);

            // Check if 'grossSalary' field is public and of type 'float'
            assertFieldIsPublic(employeeClass, "grossSalary", float.class);

            // Check if 'travellingAllowances' field is public and of type 'float'
            assertFieldIsPublic(employeeClass, "travellingAllowances", float.class);

            // Check if 'federalTax' field is public and of type 'float'
            assertFieldIsPublic(employeeClass, "federalTax", float.class);

            // Check if 'stateTax' field is public and of type 'float'
            assertFieldIsPublic(employeeClass, "stateTax", float.class);

        } catch (ClassNotFoundException e) {
            fail("class Employee not found");
        }
    }

    private void assertFieldIsPublic(Class<?> clazz, String fieldName, Class<?> expectedType) {
        try {
            Field field = clazz.getField(fieldName);
            assertTrue(field.getType().equals(expectedType),
                    "Field '" + fieldName + "' should be of type '" + expectedType.getSimpleName() + "'");
        } catch (NoSuchFieldException e) {
            fail("Field '" + fieldName + "' not found in class " + clazz.getSimpleName());
        } catch (SecurityException e) {
            fail("Security exception while accessing field '" + fieldName + "' in class " + clazz.getSimpleName());
        }
    }


    @Test
    @Order(3)
    @DisplayName("Should have Employee() no-arg constructor")
    public void testEmployeeConstructor() {
        String className = "com.trainingmug.ecommerce.Employee";
        try {
            Class<?> clazz = Class.forName(className);
            Constructor<?> noArgConstructor = clazz.getDeclaredConstructor();
            assertNotNull(noArgConstructor, "Employee() No-arg constructor should be present");
            assertTrue(Modifier.isPublic(noArgConstructor.getModifiers()), "No-arg constructor should be public");
        } catch (ClassNotFoundException e) {
            fail("Class " + className + " does not exist");
        } catch (NoSuchMethodException e) {
            fail("Employee() No-arg constructor not found in class " + className);
        }
    }


    @Test
    @Order(4)
    @DisplayName("Should Be Able To Create Employee Constructor And Initialize Properties")
    public void ShouldBeAbleToCreateEmployeeConstructorAndInitializeProperties(){
        Employee employee = new Employee();
        float delta = 0.01f;

        assertEquals(1111, employee.empId, "Employee Id Should be 1111");
        assertEquals("Andrew Fuller", employee.name, "Employee name should be Andrew Fuller");
        assertEquals("Senior Software Engineer", employee.designation, "Employee designation should be Senior Software Engineer");
        assertEquals(5208.33, employee.grossSalary,delta, "Employee grossSalary should be 5208.33");
        assertEquals(300.0, employee.travellingAllowances,delta, "Employee travellingAllowances should be 300.0f");
        assertEquals(611.86, employee.federalTax,delta, "Employee federalTax should be 611.86");
        assertEquals(359.24, employee.stateTax,delta, "Employee stateTax should be 359.24");
        assertEquals(15.3, employee.incrementPercentage,delta, "Employee incrementPercentage should be 15.3");
    }


    @Test
    @Order(5)
    @DisplayName("Should create Employee All Args Constructor")
    public void testEmployeeAllArgsConstructor() {
        String className = "com.trainingmug.ecommerce.Employee";
        try {
            Class<?> clazz = Class.forName(className);
            Constructor<?> constructor = clazz.getConstructor(long.class, String.class, String.class, float.class, float.class, float.class, float.class,float.class);

            // Check if the constructor is public
            assertNotNull(constructor, "Employee All Args Constructor should be present");
            assertTrue(Modifier.isPublic(constructor.getModifiers()), "Constructor should be public");
        } catch (ClassNotFoundException e) {
            fail("Class " + className + " does not exist");
        } catch (NoSuchMethodException e) {
            fail("Employee All Args Constructor is not found in class  " + className);
        }
    }



    @Test
    @Order(6)
    @DisplayName("Should be able to create Employee Arg Constructor and initialize the properties")
    public void shouldBeAbleToCreateEmployeeArgConstructorAndInitializeProperties() {
        float delta = 0.01f;
        Employee employee = new Employee(111,"Andrew Fuller","Senior Software Engineer",5208.33f,300.0f,611.86f,359.24f,15.3f);
        assertEquals(111, employee.empId, "Id value should be 111");
        assertEquals("Andrew Fuller", employee.name, "Name should be Andrew Fuller");
        assertEquals("Senior Software Engineer", employee.designation, "Department should be Senior Software Engineer");
        assertEquals(5208.33, employee.grossSalary, delta,"Gross Salary should be 5208.33");
        assertEquals(300.0, employee.travellingAllowances, delta,"Gross Salary should be 5208.33");
        assertEquals(611.86, employee.federalTax, delta, "TravellingAllowances should be 300.0");
        assertEquals(359.24, employee.stateTax, delta,"StateTax should be 611.86");
        assertEquals(15.3, employee.incrementPercentage,delta, "Increment Percentage should be 15.3");
    }


    @Test
    @Order(7)
    @DisplayName("Test method IncrementSalary Should be present")
    public void testIncrementSalaryMethodExists() {
        try {
            Employee.class.getMethod("incrementSalary", float.class);
        } catch (NoSuchMethodException e) {
            fail("Method incrementSalary(long) should be present in Employee class");
        }
    }

    @Test
    @Order(8)
    @DisplayName("Test IncrementSalary method parameter Should be present")
    public void testIncrementSalaryMethodParameters() {
        try {
            Class<?> employeeClass = Class.forName("com.trainingmug.ecommerce.Employee");
            Method method = employeeClass.getMethod("incrementSalary", float.class);
            Parameter[] parameters = method.getParameters();
            assertEquals(1, parameters.length, "Method incrementSalary should take exactly one parameter");
            assertEquals(float.class, parameters[0].getType(), "Parameter type should be long");
        } catch (NoSuchMethodException e) {
            fail("Method incrementSalary(long) should be present in Employee class");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Order(9)
    @DisplayName("Test IncrementSalary Logic should incremented gross salary")
    public void testIncrementSalaryLogic() {
        Employee employee = new Employee();
        float delta = 0.01f;
        float initialSalary = employee.grossSalary;
        long percentage = 15;
        employee.incrementSalary(percentage);
        float expectedSalary = initialSalary + (initialSalary * percentage / 100);
        assertEquals(expectedSalary, employee.grossSalary, delta, "The grossSalary should be incremented correctly");
    }



    @Test
    @Order(10)
    @DisplayName("Should have displayProfile() method")
    public void testDisplayProfileMethodPresence() {
        try {
            Class<?> clazz = Class.forName("com.trainingmug.ecommerce.Employee");
            assertNotNull(clazz.getDeclaredMethod("displayProfile"), "displayProfile() method should be present");
        } catch (ClassNotFoundException e) {
            fail("Class com.trainingmug.ecommerce.Employee does not exist");
        } catch (NoSuchMethodException e) {
            fail("displayProfile() method is not found in class com.trainingmug.ecommerce.Employee");
        }
    }


    @Test
    @Order(11)
    @DisplayName("Should display correct profile information")
    public void testDisplayProfileMethodContent() {
        // Create an instance of Employee
        Employee employee = new Employee();

        // Capture the output of displayProfile() method
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Call the displayProfile method
        employee.displayProfile();

        // Restore the original System.out
        System.setOut(originalOut);

        // Expected output
        String expectedOutput =
                "Employee ID: 1111\n" +
                        "Name: Andrew Fuller\n" +
                        "Designation: Senior Software Engineer\n" +
                        "Gross Salary: 5208.33\n" +
                        "Travelling Allowances: 300.0\n" +
                        "Federal Tax: 611.86\n" +
                        "State Tax: 359.24\n" +
                        "Net Salary Increment Percentage: 15.3\n";

        // Convert the expected and actual outputs to line-by-line comparison
        Scanner expectedScanner = new Scanner(expectedOutput);
        Scanner actualScanner = new Scanner(outputStream.toString());

        while (expectedScanner.hasNextLine() && actualScanner.hasNextLine()) {
            String expectedLine = expectedScanner.nextLine();
            String actualLine = actualScanner.nextLine();
            assertEquals(expectedLine, actualLine, "Profile information should be correctly displayed");
        }

        // Ensure that both outputs have been fully consumed
        assertFalse(expectedScanner.hasNextLine(), "Expected output has more lines than actual output");
        assertFalse(actualScanner.hasNextLine(), "Actual output has more lines than expected output");
    }



    @Test
    @Order(12)
    @DisplayName("Should have static variable companyName")
    public void testStaticVariableCompanyName() {
        try {
            Class<?> clazz = Class.forName("com.trainingmug.ecommerce.Employee");
            Field field = clazz.getDeclaredField("companyName");
            assertNotNull(field, "Static variable companyName should be present");
            assertTrue(Modifier.isStatic(field.getModifiers()), "Variable companyName should be static");
        } catch (ClassNotFoundException e) {
            fail("Class com.trainingmug.ecommerce.Employee does not exist");
        } catch (NoSuchFieldException e) {
            fail("Static variable companyName is not found in class com.trainingmug.ecommerce.Employee");
        }
    }

    @Test
    @Order(13)
    @DisplayName("Should have static variable companyContactNo")
    public void testStaticVariableCompanyContactNo() {
        try {
            Class<?> clazz = Class.forName("com.trainingmug.ecommerce.Employee");
            Field field = clazz.getDeclaredField("companyContactNo");
            assertNotNull(field, "Static variable companyContactNo should be present");
            assertTrue(Modifier.isStatic(field.getModifiers()), "Variable companyContactNo should be static");
        } catch (ClassNotFoundException e) {
            fail("Class com.trainingmug.ecommerce.Employee does not exist");
        } catch (NoSuchFieldException e) {
            fail("Static variable companyContactNo is not found in class com.trainingmug.ecommerce.Employee");
        }
    }

   @Test
   @Order(14)
   @DisplayName("Should have static variable Employee count")
   public void testStaticVariableCompanyEmployeeCount(){
        try {
            Class<?> clazz = Class.forName("com.trainingmug.ecommerce.Employee");
            Field field = clazz.getDeclaredField("employeeCount");
            assertNotNull(field,"Static variable employeeCount should be present");
            assertTrue(Modifier.isStatic(field.getModifiers()), "Variable employeeCount should be static");
        }catch (ClassNotFoundException e){
            fail("Class com.trainingmug.ecommerce.Employee does not exist");
        } catch (NoSuchFieldException e) {
            fail("Static variable employeeCount is not found in class com.trainingmug.ecommerce.Employee");
        }
   }


    @Test
    @Order(15)
    @DisplayName("Should create the displayCompanyInfo method in Employee class with the appropriate signature")
    void testDisplayCompanyInfoMethodSignature() {
        try {
            Class<?> employeeClass = Class.forName("com.trainingmug.ecommerce.Employee");
            Method method = employeeClass.getDeclaredMethod("displayCompanyInfo");

            assertTrue(Modifier.isPublic(method.getModifiers()), "Method displayCompanyInfo should be public");
            assertTrue(Modifier.isStatic(method.getModifiers()), "Method displayCompanyInfo should be static");
            assertEquals(void.class, method.getReturnType(), "Method displayCompanyInfo should return void");
            assertEquals(0, method.getParameterCount(), "Method displayCompanyInfo should take no arguments");

        } catch (ClassNotFoundException e) {
            fail("Class Employee should be present, but it was not found");
        } catch (NoSuchMethodException e) {
            fail("Method displayCompanyInfo should be present in the Employee class");
        }
    }

    @Test
    @Order(16)
    @DisplayName("Should print the correct company information when displayCompanyInfo is called")
    void testDisplayCompanyInfoOutput() {
        try {
            Class<?> employeeClass = Class.forName("com.trainingmug.ecommerce.Employee");

            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            PrintStream originalOut = System.out;
            System.setOut(new PrintStream(outContent));

            Method method = employeeClass.getDeclaredMethod("displayCompanyInfo");
            method.invoke(null);

            System.setOut(originalOut);

            String expectedOutput = "Company Name: Training Mug" + System.lineSeparator() +
                    "Company Contact No: 9034568900" + System.lineSeparator() +
                    "Employee Count: 0"+ System.lineSeparator() ;

            assertEquals(expectedOutput, outContent.toString(), "The displayCompanyInfo method should print the correct output");

        } catch (Exception e) {
            fail("Exception occurred while testing displayCompanyInfo method: " + e.getMessage());
        }
    }



}
