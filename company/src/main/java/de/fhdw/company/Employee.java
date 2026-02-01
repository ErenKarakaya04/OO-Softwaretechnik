package de.fhdw.company;

import de.fhdw.company.compositePattern.PersonnelUnit;

public class Employee extends PersonnelUnit {

    private final int salary;

    public Employee(String name, int salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public int getSalary(){
        return salary;
    }

    @Override
    public void add(PersonnelUnit c) {

    }

    @Override
    public void remove(PersonnelUnit c) {

    }

    @Override
    public PersonnelUnit getChild(int index) {
        return null;
    }
}
