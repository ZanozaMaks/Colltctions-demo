package model;
import java.util.Objects;
import java.util.Random;
import java.util.function.ToIntFunction;

public class Employee {

    private final String firstName;
    private final String lastName;
    private final int department;
    private int salary;

    public Employee(String firstName, String lastName) {
        Random random = new Random();
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = random.nextInt(2) + 1;
        this.salary = random.nextInt(50000) + 5000;
    }

    public Employee(String firstName, String lastName, Integer department) {
        Random random = new Random();
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = random.nextInt(5) + 1;
        this.salary = random.nextInt(50000) + 5000;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public int getDepartment(){return department;}
    public int getSalary(){return salary;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}