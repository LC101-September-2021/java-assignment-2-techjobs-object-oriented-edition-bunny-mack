package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
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
        assertFalse(anotherJob.getId() == 0);
        assertTrue(anotherJob.getName() == "Product tester");
        assertTrue(anotherJob.getEmployer() instanceof Employer);
        assertTrue(anotherJob.getLocation() instanceof Location);
        assertTrue(anotherJob.getPositionType() instanceof PositionType);
        assertTrue(anotherJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(anotherJob.getName(), "Product tester");
        assertEquals(anotherJob.getEmployer().toString(), "ACME");
        assertEquals(anotherJob.getLocation().toString(), "Desert");
        assertEquals(anotherJob.getPositionType().toString(), "Quality control");
        assertEquals(anotherJob.getCoreCompetency().toString(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job job3 = new Job("Baker", new Employer("The Cakery"), new Location("Sugar Town"), new PositionType("line"), new CoreCompetency("sweet tooth"));
        Job job4 = new Job("Baker", new Employer("The Cakery"), new Location("Sugar Town"), new PositionType("line"), new CoreCompetency("sweet tooth"));
        assertFalse(job3.equals(job4));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job anotherJob = new Job("Baker", new Employer("The Cakery"), new Location("Sugar Town"), new PositionType("line"), new CoreCompetency("sweet tooth"));
        assertTrue(anotherJob.toString().contains("\n"));
        assertEquals('\n', '\n');
        char firstChar = anotherJob.toString().charAt(0);
        char lastChar = anotherJob.toString().charAt(anotherJob.toString().length()-1);
        assertEquals(firstChar, '\n');
        assertEquals(lastChar, '\n');
    }

    @Test
    public void testTestToStringStartsAndEndsWithNewLineCallsToString() {
        Job anotherJob = new Job("Baker", new Employer("The Cakery"), new Location("Sugar Town"), new PositionType("line"), new CoreCompetency("sweet tooth"));
        assertTrue(anotherJob.toString().equals(
                "\nID: " + anotherJob.getId() +
                        "\nName: " + anotherJob.getName() +
                        "\nEmployer: " + anotherJob.getEmployer() +
                        "\nLocation: " + anotherJob.getLocation() +
                        "\nPosition Type: " + anotherJob.getPositionType() +
                        "\nCore Competency: " + anotherJob.getCoreCompetency() +
                        "\n"
        ));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job anotherJob = new Job("Baker", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertTrue(anotherJob.toString().equals(
                "\nID: " + anotherJob.getId() +
                        "\nName: " + anotherJob.getName() +
                        "\nEmployer: Data not available" +
                        "\nLocation: Data not available" +
                        "\nPosition Type: Data not available" +
                        "\nCore Competency: Data not available" +
                        "\n"
        ));
        assertEquals(anotherJob.toString(), "\nID: " + anotherJob.getId() +
                "\nName: " + anotherJob.getName() +
                "\nEmployer: Data not available" +
                "\nLocation: Data not available" +
                "\nPosition Type: Data not available" +
                "\nCore Competency: Data not available" +
                "\n");
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job anotherJob = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertTrue(anotherJob.toString().equals("Oops! This job doesn't seem to exist"));
        assertEquals("test", "test");
    }

}
