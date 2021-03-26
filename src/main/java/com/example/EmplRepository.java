package com.example;

import java.util.ArrayList;
import java.util.List;

public class EmplRepository implements EmployeeRepository {

    List<Employee> listOfEmployees = new ArrayList<>();


    EmplRepository() {
    }

    EmplRepository(List<Employee> listOfEmployees) {
        this.listOfEmployees = listOfEmployees;


    }


    @Override
    public List<Employee> findAll() {
        return listOfEmployees;
    }

    @Override
    public Employee save(Employee employee) {
        listOfEmployees.stream()
                .filter(emp -> emp.getId().equals(employee.getId()))
                .findFirst().ifPresent(employeeToDelete -> listOfEmployees.remove(employeeToDelete));
        listOfEmployees.add(employee);

        return listOfEmployees.get(listOfEmployees.indexOf(employee));
    }
}
