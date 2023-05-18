package pro.sky.skyprohomeworkcollectionssets.service;

import pro.sky.skyprohomeworkcollectionssets.Employee;

import java.util.Collection;

public interface EmployeeServiceInterface {
    Collection<Employee> getListAllEmployee();

    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);
}
