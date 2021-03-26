package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeManagerTest {
    @Test
    void employeeIsPaid() {
        EmployeeRepository employeeRepository_ = new TestEmployeeRepository();
        BankService bankService_ = new TestBankService();

        EmployeeManager employeemanager = new EmployeeManager(employeeRepository_, bankService_);

        var actual = employeemanager.payEmployees();

        assertEquals(3, actual);

    }

    @Test
    void employeeIsPaidWithMock() {
        EmployeeRepository employeeRepository_ = mock(TestEmployeeRepository.class);
        when(employeeRepository_.findAll()).thenReturn(List.of(
                new Employee("1", 5000),
                new Employee("2", 6000),
                new Employee("3", 3000)));

        BankService bankService_ = mock(TestBankService.class);

        EmployeeManager employeemanager = new EmployeeManager(employeeRepository_, bankService_);

        var actual = employeemanager.payEmployees();

        assertEquals(3, actual);

    }


    @Test
    void runtimeExceptionTest() {

        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
        Employee testEmployee = new Employee("4", 3500);
        when(employeeRepository.findAll()).thenReturn(List.of(testEmployee,
                new Employee("1", 5000),
                new Employee("2", 6000),
                new Employee("3", 3000)));
        BankService bankService = mock(BankService.class);
        doThrow(new RuntimeException()).when(bankService).pay("3", 3000);
        EmployeeManager emp = new EmployeeManager(employeeRepository, bankService);
        emp.payEmployees();

        assertTrue(testEmployee.isPaid());
    }

    @Test
    void employeePaidCatchesException() {
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
        when(employeeRepository.findAll()).thenReturn(List.of(
                new Employee("1", 5000),
                new Employee("2", 6000),
                new Employee("3", 3000)));
        BankService bankService = mock(BankService.class);
        doThrow(new RuntimeException()).when(bankService).pay("2", 6000);
        EmployeeManager emp = new EmployeeManager(employeeRepository, bankService);
        assertEquals(2, emp.payEmployees());
    }


}