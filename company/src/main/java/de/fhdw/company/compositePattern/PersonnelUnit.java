package de.fhdw.company.compositePattern;

abstract public class PersonnelUnit {

    private final String name;

    public PersonnelUnit(String name){
        this.name = name;
    }

    abstract public void add(PersonnelUnit c);
    abstract public void remove(PersonnelUnit c);
    abstract public PersonnelUnit getChild(int index);
    abstract public int getSalary();
    public String getName() {
        return name;
    }
}
