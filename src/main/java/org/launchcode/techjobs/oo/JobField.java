package org.launchcode.techjobs.oo;

import java.util.Objects;

public abstract class JobField {
    //In JobField, declare each of the common fields.
    private int id;
    private static int nextId = 1;
    private String value;

    //Which constructors are the same in ALL FOUR classes?
    //Code the constructors.
    public JobField() {
        id = nextId;
        nextId++;
    }

    public JobField(String value) {
        this();
        this.value = value;
    }

    //What getters and setters do ALL of the classes share?
    //Use Generate to create the appropriate getters and setters.

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    //Which custom methods are identical in ALL of the classes?
    //Add in the custom methods.

    @Override
    public String toString() {
        return value;
    }

    //Finally, to prevent the creation of a JobField object, make this class abstract
}
