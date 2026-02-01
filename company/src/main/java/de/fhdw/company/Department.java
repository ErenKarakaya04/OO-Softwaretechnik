package de.fhdw.company;

import de.fhdw.company.compositePattern.PersonnelUnit;

import java.util.ArrayList;
import java.util.List;

public class Department extends PersonnelUnit{

    private final List<PersonnelUnit> personnelUnits = new ArrayList<>();

    public Department(String name) {
        super(name);
    }

    @Override
    public void add(PersonnelUnit c) {
        personnelUnits.add(c);
    }

    @Override
    public void remove(PersonnelUnit c) {
        personnelUnits.remove(c);
    }

    @Override
    public PersonnelUnit getChild(int index) {
        return null;
    }

    @Override
    public int getSalary(){
        int sum = 0;
        for (PersonnelUnit p: personnelUnits){
            sum += p.getSalary();
        }
        return sum;
    }

    public DeparmentDirectIterator createIterator(){
        return new DeparmentDirectIterator(personnelUnits);
    }
    public List<PersonnelUnit> getPersonnelUnits() {
        return personnelUnits;
    }

}
