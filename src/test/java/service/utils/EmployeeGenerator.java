package service.utils;

import model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class EmployeeGenerator {

    public static final String FIRST_NAME = "Максим";
    public static final String LAST_NAME = "Заноза";
    public static final double SALARY = 70000;
    public static final int DEPARTMENT_ID = 1;

    public static final String FIRST_NAME_1 = "Никита";
    public static final String LAST_NAME_1 = "Жигулин";
    public static final double SALARY_1 = 55000;
    public static final int DEPARTMENT_ID_1 = 1;

    public static final String FIRST_NAME_2 = "Никита";
    public static final String LAST_NAME_2 = "Щепкин";
    public static final double SALARY_2 = 65000;
    public static final int DEPARTMENT_ID_2 = 1;

    public static final String FIRST_NAME_3 = "Иван";
    public static final String LAST_NAME_3 = "Кручинкин";
    public static final double SALARY_3 = 68000;
    public static final int DEPARTMENT_ID_3 = 1;

    public static final String FIRST_NAME_4 = "Илья";
    public static final String LAST_NAME_4 = "Мазанов";
    public static final double SALARY_4 = 57000;
    public static final int DEPARTMENT_ID_4 = 1;
    public static Employee getEmployee() {
        return new Employee(FIRST_NAME,LAST_NAME,SALARY,DEPARTMENT_ID);
    }

    public static Employee getEmployee_1() {
        return new Employee(FIRST_NAME_1,LAST_NAME_1,SALARY_1,DEPARTMENT_ID_1);
    }

    public static Employee getEmployee_2() {
        return new Employee(FIRST_NAME_2,LAST_NAME_2,SALARY_2,DEPARTMENT_ID_2);
    }

    public static Employee getEmployee_3() {
        return new Employee(FIRST_NAME_3,LAST_NAME_3,SALARY_3,DEPARTMENT_ID_3);
    }

    public static Employee getEmployee_4() {
        return new Employee(FIRST_NAME_3,LAST_NAME_3,SALARY_3,DEPARTMENT_ID_3);
    }

    public static List<Employee> getAllEmployee() {
        return Arrays.asList(getEmployee(), getEmployee_2(), getEmployee_3(), getEmployee_4());
    }
}
