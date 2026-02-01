package de.fhdw.company;

import de.fhdw.company.compositePattern.PersonnelUnit;

public interface DeparmentIterator {

    PersonnelUnit next();
    boolean hasNext();
}
