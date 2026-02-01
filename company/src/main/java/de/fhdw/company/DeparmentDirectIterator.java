package de.fhdw.company;

import de.fhdw.company.compositePattern.PersonnelUnit;

import java.util.ArrayList;
import java.util.List;

public class DeparmentDirectIterator implements DeparmentIterator{

    private List<PersonnelUnit> personnelUnits = new ArrayList<>();
    private int currentIndex = 0;

    public DeparmentDirectIterator(List<PersonnelUnit> personnelUnits){
        this.personnelUnits = personnelUnits;
    }

    @Override
    public PersonnelUnit next() {
        return personnelUnits.get(currentIndex++);
    }

    @Override
    public boolean hasNext() {
        return currentIndex < personnelUnits.size();
    }
}
