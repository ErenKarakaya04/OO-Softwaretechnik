package de.fhdw.company;


import de.fhdw.company.compositePattern.PersonnelUnit;

public class Main {
    public static void main(String[] args) {

        Department department = new Department("NOVA");
        Department subdepartment1 = new Department("BGHM");
        Department subdepartment2 = new Department("VBG");
        subdepartment1.add(new Employee("Eren", 1000));
        subdepartment1.add(new Employee("Oliver", 1000));
        subdepartment2.add(new Employee("Loki", 1000));
        subdepartment2.add(new Employee("Mikka", 1000));
        subdepartment2.add(new Employee("Leonard", 1000));
        department.add(subdepartment1);
        department.add(subdepartment2);

        DeparmentIterator iterator = department.createIterator();

        while(iterator.hasNext()){
             PersonnelUnit unit = iterator.next();
             System.out.println("Einheitname: " + unit.getName() + ", Einheitsgehalt: " + unit.getSalary());
        }
    }
}