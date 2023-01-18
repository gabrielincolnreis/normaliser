package normaliser;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NormaliserImplTest {

    Normaliser normaliserImpl = new NormaliserImpl();
    List<String> jobList = Arrays.asList("Software engineer", "Accountant", "Quantity surveyor", "Architect");

    @Test
    @DisplayName("Checking if the function is inserting in the list")
    void setJobList() {
        normaliserImpl.setJobList(jobList);
        assertEquals("Accountant",jobList.get(1));
    }

    @Test
    @DisplayName("Checking the Normalize function")
    public void normalise() {
        normaliserImpl.setJobList(jobList);
        String normalisedTitle = normaliserImpl.normalise("Java engineer");
        assertEquals("Software engineer", normalisedTitle);
    }

    @Test
    @DisplayName("Checking list integrity")
    void getJobList() {
        normaliserImpl.setJobList(jobList);
        assertEquals("Accountant",normaliserImpl.getJobList().get(1));
    }
}