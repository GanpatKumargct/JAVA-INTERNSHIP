package Week3;

import java.util.List;

public class Job implements Comparable <Job>{

    String jobName;
    int executionTime;
    List<String> requiredResources;
    List<String> dependencies;
    int importance;
    long startTime;


    public Job(String jobName, int executionTime, List<String> requiredResources,
               List<String> dependencies, int importance) {
        this.jobName = jobName;
        this.executionTime = executionTime;
        this.requiredResources = requiredResources;
        this.dependencies = dependencies;
        this.importance = importance;

    }



    @Override
    public int compareTo(Job o) {
        return Integer.compare(o.importance, this.importance);
    }
}
