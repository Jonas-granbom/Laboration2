package com.example;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmplRepositoryTest {

    EmplRepository employeeRepo = new EmplRepository();


    @Test
    void findAllEmptyTest() {
        var listOfEmployees = employeeRepo.findAll();
        assertEquals(0, listOfEmployees.size());
    }

    @Test
    void findAllReturnsList() {
        employeeRepo.save(new Employee("1", 5000));
        employeeRepo.save(new Employee("2", 6000));
        assertEquals(2, employeeRepo.findAll().size());
    }

    @Test
    void sameIdOverwritesTest() {
        employeeRepo.save(new Employee("1", 5000));
        employeeRepo.save(new Employee("1", 6000));
        assertEquals(1, employeeRepo.findAll().size());
        assertEquals("1", employeeRepo.findAll().get(0).getId());
        assertEquals(6000, employeeRepo.findAll().get(0).getSalary());
    }


    @Test
    void testingConstructorWithList() {
        Employee a = new Employee("1", 5000);
        Employee b = new Employee("2", 6000);
        Employee c = new Employee("3", 3000);
        EmplRepository empRepo2 = new EmplRepository(List.of(a, b, c));
        assertEquals(3, empRepo2.findAll().size());
        assertTrue(empRepo2.findAll().contains(a));
        assertTrue(empRepo2.findAll().contains(b));
        assertTrue(empRepo2.findAll().contains(c));
    }

    @Test
    void entryReturnsCorrect() {
        employeeRepo.save(new Employee("1", 5000));
        var empList = employeeRepo.findAll();
        assertEquals("1", empList.get(0).getId());
        assertEquals(5000, empList.get(0).getSalary());
    }


}


