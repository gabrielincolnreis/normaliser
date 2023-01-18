import normaliser.Normaliser;
import normaliser.NormaliserImpl;

import java.util.Arrays;
import java.util.List;

public class NormaliserApplication {

    public static void main(String[] args) {

        List<String> jobList = Arrays.asList("Software engineer", "Accountant", "Quantity surveyor", "Architect");

        Normaliser normaliser = new NormaliserImpl();
        normaliser.setJobList(jobList);

        String normalisedTitle  = normaliser.normalise(String.join(" ", args));
        System.out.println(normalisedTitle);
    }
}
