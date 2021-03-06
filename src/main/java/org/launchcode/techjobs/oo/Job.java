package org.launchcode.techjobs.oo;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency){
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


//    public String getJobString (Job job) throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
//        return String.format("\nID: %d\n" +
//                        "Name: %s\n" +
//                        "Employer: %s\n" +
//                        "Location: %s\n" +
//                        "Position Type: %s\n" +
//                        "Core Competency: %s\n", getJobId(job), getJobFieldString(job, "name", true), getJobFieldString(job, "employer", true), getJobFieldString(job, "location", true),
//                getJobFieldString(job, "positionType", true), getJobFieldString(job, "coreCompetency", true));
//    }

    public String toString() {
        if (name == "" && employer.getValue() == "" && location.getValue() == "" &&
                positionType.getValue() == "" && coreCompetency.getValue() == "") {
            return "Oops! This job doesn't seem to exist";
        }
        if (getName() == "") {
            setName("Data not available");
        }
        if (employer.getValue() == "") {
            employer.setValue("Data not available");
        }
        if (location.getValue() == "") {
            location.setValue("Data not available");
        }
        if (positionType.getValue() == "") {
            positionType.setValue("Data not available");
        }
        if (coreCompetency.getValue() == "") {
            coreCompetency.setValue("Data not available");
        }
        return String.format("\nID: %d\n" +
                        "Name: %s\n" +
                        "Employer: %s\n" +
                        "Location: %s\n" +
                        "Position Type: %s\n" +
                        "Core Competency: %s\n", id, name, employer.toString(), location.toString(),
                positionType.toString(), coreCompetency.toString());
    }
}
