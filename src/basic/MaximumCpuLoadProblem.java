package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://algorithms.tutorialhorizon.com/maximum-cpu-load-problem
 *
 */
public class MaximumCpuLoadProblem {

  static class Job {

    private int startTime;
    private int endTime;
    private int load;

    public Job(int startTime, int endTime, int load) {
      this.startTime = startTime;
      this.endTime = endTime;
      this.load = load;
    }

    public int getStartTime() {
      return startTime;
    }

    public int getEndTime() {
      return endTime;
    }

    public int getLoad() {
      return load;
    }

    @Override
    public String toString() {
      return "Job [startTime=" + startTime + ", endTime=" + endTime + ", load=" + load + "]";
    }
  }

  private static void findMaxLoad(List<Job> jobList) {

    System.out.println("Given Jobs: " + jobList.toString());

    Job[] jobs = jobList.toArray(new Job[0]);
    Job[] arrStart = Arrays.copyOf(jobs, jobs.length);
    Job[] arrEnd = Arrays.copyOf(jobs, jobs.length);

    Arrays.sort(arrStart, Comparator.comparingInt(o -> o.startTime));
    Arrays.sort(arrEnd, Comparator.comparingInt(o -> o.endTime));

    int x = 0, y = 0;
    int maxLoadTime = 0;
    int maxLoad = 0, currentLoad = 0;
    while (x < arrStart.length && y < arrEnd.length) {
      if (arrStart[x].startTime <= arrEnd[y].endTime) {
        currentLoad += arrStart[x].getLoad();
        if (currentLoad > maxLoad) {
          maxLoadTime = arrStart[x].startTime;
          maxLoad = currentLoad;
        }
        x++;
      } else {
        currentLoad -= arrEnd[y].getLoad();
        y++;
      }
    }

    System.out.println("maxLoad: " + maxLoad + " at time:" + maxLoadTime);
  }

  public static void main(String[] args) {

    List<Job> jobList = new ArrayList<>();
    jobList.add(new Job(2, 4, 5));
    jobList.add(new Job(0, 6, 7));
    jobList.add(new Job(5, 10, 6));
    jobList.add(new Job(0, 3, 10));

    findMaxLoad(jobList);
  }

}
