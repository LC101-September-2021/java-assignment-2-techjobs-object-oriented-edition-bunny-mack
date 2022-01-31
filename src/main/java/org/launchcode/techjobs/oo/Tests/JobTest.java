package org.launchcode.techjobs.oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs.oo.*;

import java.util.concurrent.locks.Lock;

import static org.junit.Assert.*;

public class JobTest {

    Job testJob1;
    Job testJob2;
    @Before
    public void createJobObjects() {
        Job testJob1 = new Job("Engineer", new Employer("Centene"), new Location("St. Louis"), new PositionType("Web Dev"), new CoreCompetency("Technology"));
        Job testJob2 = new Job("QA Rep", new Employer("Target"), new Location("Chicago"), new PositionType("Sales"), new CoreCompetency("Customer Service"));
    }


    @Test
    public void testSettingJobId() {
        assertTrue((testJob1.getId()+1) == testJob2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job anotherJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(anotherJob instanceof Job);
        assertTrue(anotherJob.getId() == 3);
        assertTrue(anotherJob.getName() == "Product tester");
        assertTrue(anotherJob.getEmployer() instanceof Employer);
        assertTrue(anotherJob.getLocation() instanceof Location);
        assertTrue(anotherJob.getPositionType() instanceof PositionType);
        assertTrue(anotherJob.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        Job job4 = new Job("Baker", new Employer("The Cakery"), new Location("Sugar Town"), new PositionType("line"), new CoreCompetency("sweet tooth"));
        Job job5 = new Job("Baker", new Employer("The Cakery"), new Location("Sugar Town"), new PositionType("line"), new CoreCompetency("sweet tooth"));
        assertFalse(job4.equals(job5));
    }


}
