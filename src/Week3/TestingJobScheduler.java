package Week3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestingJobScheduler {
    public static void main(String[] args) {
        List<Job> Jobs = Arrays.asList(
                new Job("Job1", 4, Arrays.asList("CPU"),Collections.emptyList(),3),
                new Job("Job2", 2, Arrays.asList("GPU"),Collections.emptyList(),2),
                new Job("Job3", 3, Arrays.asList("CPU","GPU"),Collections.emptyList(),4),
                new Job("Job4", 1, Arrays.asList("CPU"),Arrays.asList("Job1"),1),
                new Job("Job5", 3, Arrays.asList("GPU"),Arrays.asList("Job2"),3),
                new Job("Job6", 2, Arrays.asList("GPU","CPU"),Arrays.asList("Job4"),2)

        );

        JobScheduler sec = new JobScheduler();
        sec.addJobs(Jobs);
        sec.runScheduler();
    }
}
