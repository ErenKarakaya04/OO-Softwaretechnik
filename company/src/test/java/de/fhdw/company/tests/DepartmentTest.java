package de.fhdw.company.tests;

import de.fhdw.company.Department;
import de.fhdw.company.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class DepartmentTest {


    @Test
    void getSalary() {

        Department unit = new Department("NOVA");
        Department subunit1 = new Department("BGHM");
        Department subunit2 = new Department("VBG");
        subunit1.add(new Employee("Eren", 1000));
        subunit1.add(new Employee("Oliver", 1000));
        subunit2.add(new Employee("Loki", 1000));
        subunit2.add(new Employee("Mikka", 1000));
        subunit2.add(new Employee("Leonard", 1000));
        unit.add(subunit1);
        unit.add(subunit2);

        assertEquals(5000, unit.getSalary());
    }

    @Test
    void getName(){
        Department unit = new Department("NOVA");

        assertEquals("NOVA", unit.getName());
    }
}