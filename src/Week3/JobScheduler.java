package Week3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;

public class JobScheduler {
    private final Map<String, Job> jobMap = new HashMap<>();
    private final Map<String, Long> jobEndTime = new HashMap<>();
    private final Map<String, String> resourceAllocation = new HashMap<>();
    private final PriorityBlockingQueue<Job> readyJobs = new PriorityBlockingQueue<>();
    private long currentTime = 0;


    //Add the job
    public void addJobs(List<Job> jobs) {
        for (Job job : jobs) {
            jobMap.put(job.jobName, job);
            if (job.dependencies.isEmpty()) {
                readyJobs.add(job);
            }
        }
    }

    //run Schedule

    public void runScheduler() {
        while (!readyJobs.isEmpty()) {
            Job job = readyJobs.poll();

            if (canAllocateResources(job) && allDependenciesFinished(job)) {
                allocateResources(job);
                job.startTime = currentTime;
                System.out.println("Job " + job.jobName + " started at " + job.startTime + "s using resources " + job.requiredResources);

                // Simulate job execution
                try {
                    Thread.sleep(job.executionTime * 1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                currentTime += job.executionTime;
                jobEndTime.put(job.jobName, currentTime);
                System.out.println("Job " + job.jobName + " finished at " + currentTime + "s");

                releaseResources(job);
                checkDependencies(job);
            } else {
                readyJobs.add(job);
            }
        }

    }
    private void checkDependencies(Job job) {
        for (Job dependentJob : jobMap.values()) {
            if (dependentJob.dependencies.contains(job.jobName) && allDependenciesFinished(dependentJob)) {
                readyJobs.add(dependentJob);
            }
        }
    }

    private boolean canAllocateResources(Job job) {
        for (String resource : job.requiredResources) {
            if (resourceAllocation.containsKey(resource)) {
                return false;
            }
        }
        return true;
    }

    private void allocateResources(Job job) {
        for (String resource : job.requiredResources) {
            resourceAllocation.put(resource, job.jobName);
        }
    }

    private void releaseResources(Job job) {
        for (String resource : job.requiredResources) {
            resourceAllocation.remove(resource);
        }
    }

    private boolean allDependenciesFinished(Job job) {
        for (String dep : job.dependencies) {
            if (!jobEndTime.containsKey(dep)) {
                return false;
            }
        }
        return true;
    }
}
