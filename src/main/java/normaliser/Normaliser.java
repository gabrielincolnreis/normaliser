package normaliser;

import java.util.List;

public interface Normaliser {

    void setJobList(List<String> jobList);
    List<String> getJobList();
    String normalise(String s);

}
