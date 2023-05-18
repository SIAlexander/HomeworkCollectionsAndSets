package pro.sky.skyprohomeworkcollectionssets.service;

import org.springframework.stereotype.Service;
import pro.sky.skyprohomeworkcollectionssets.Employee;
import pro.sky.skyprohomeworkcollectionssets.exceptions.EmployeeAlreadyAddedException;
import pro.sky.skyprohomeworkcollectionssets.exceptions.EmployeeNotFoundException;
import pro.sky.skyprohomeworkcollectionssets.exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeServiceInterface {

    private final List<Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new ArrayList<>();
    }

    final int MAX_NUMBER_EMPLOYEE = 10;

    @Override
    public Collection<Employee> getListAllEmployee() {
        return Collections.unmodifiableCollection(employees);
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        } else if (employees.size() == MAX_NUMBER_EMPLOYEE) {
            throw new EmployeeStorageIsFullException();
        } else {
            employees.add(employee);
            return employee;
        }
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            employees.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }
}
