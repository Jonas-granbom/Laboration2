package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

public class EmployeeRepositoryIT {

    BankService bankService = mock(BankService.class);

    EmplRepository employeeRepos = new EmplRepository(List.of(
            new Employee("1", 5000),
            new Employee("2", 6000),
            new Employee("3", 3000)));
    EmployeeManager employeeManager_ = new EmployeeManager(employeeRepos, bankService);

    @Test
    void payEmployees() {
        assertEquals(3, employeeManager_.payEmployees());
    }

    @Test
    void payEmployeesException() {
        doThrow(new RuntimeException()).when(bankService).pay("1", 5000);
        assertEquals(2, employeeManager_.payEmployees());
        Employee emp1 = employeeRepos.findAll().get(0);
        Employee emp2 = employeeRepos.findAll().get(1);
        assertFalse(emp1.isPaid());
        assertTrue(emp2.isPaid());
    }

    @Test
    void payReturnZero() {
        EmployeeManager employeeManager = new EmployeeManager(new EmplRepository(), bankService);
        assertEquals(0, employeeManager.payEmployees());
    }
}

