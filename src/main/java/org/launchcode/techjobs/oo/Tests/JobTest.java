package org.launchcode.techjobs.oo.Tests;

import org.junit.Test;
import org.launchcode.techjobs.oo.*;

import java.util.concurrent.locks.Lock;

import static org.junit.Assert.*;

public class JobTest {

    @Test
    public void testSettingJobId() {
        Job job1 = new Job("Engineer", new Employer("Centene"), new Location("St. Louis"), new PositionType("Web Dev"), new CoreCompetency("Technology"));
        Job job2 = new Job("QA Rep", new Employer("Target"), new Location("Chicago"), new PositionType("Sales"), new CoreCompetency("Customer Service"));
        assertTrue((job1.getId()+1) == job2.getId());
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
        Job job3 = new Job("Baker", new Employer("The Cakery"), new Location("Sugar Town"), new PositionType("line"), new CoreCompetency("sweet tooth"));
        Job job4 = new Job("Baker", new Employer("The Cakery"), new Location("Sugar Town"), new PositionType("line"), new CoreCompetency("sweet tooth"));
        assertFalse(job3.equals(job4));
    }

    @Test
    public void testToString1() {
        Job anotherJob = new Job("Baker", new Employer("The Cakery"), new Location("Sugar Town"), new PositionType("line"), new CoreCompetency("sweet tooth"));
        assertTrue(anotherJob.toString().contains("\n"));
    }

    @Test
    public void testToString2() {
        Job anotherJob = new Job("Baker", new Employer("The Cakery"), new Location("Sugar Town"), new PositionType("line"), new CoreCompetency("sweet tooth"));
        assertTrue(anotherJob.toString().equals(
                "\n ID: " + anotherJob.getId() +
                "\n Name: " + anotherJob.getName() +
                "\n Employer: " + anotherJob.getEmployer() +
                "\n Location: " + anotherJob.getLocation() +
                "\n Position Type: " + anotherJob.getPositionType() +
                "\n Core Competency: " + anotherJob.getCoreCompetency() +
                "\n"
                ));
    }

    @Test
    public void testToString3() {
        Job anotherJob = new Job("Baker", new Employer(), new Location(), new PositionType(), new CoreCompetency());
        assertTrue(anotherJob.toString().equals(
                "\n ID: " + anotherJob.getId() +
                "\n Name: " + anotherJob.getName() +
                "\n Employer: Data not available" +
                "\n Location: Data not available" +
                "\n Position Type: Data not available" +
                "\n Core Competency: Data not available" +
                "\n"
        ));
    }

    @Test
    public void testToString4() {
        Job anotherJob = new Job("", new Employer(), new Location(), new PositionType(), new CoreCompetency());
        assertTrue(anotherJob.toString().equals("Oops! This job doesn't seem to exist"));
    }


}
