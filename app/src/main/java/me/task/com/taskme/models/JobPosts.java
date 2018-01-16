package me.task.com.taskme.models;

import java.util.ArrayList;

/**
 * Created by root on 12/1/17.
 */

public class JobPosts {
    private ArrayList<JobPost> jobs;

    public JobPosts() {

    }

    public ArrayList<JobPost> getJobPosts() {
        return jobs;
    }

    public void setJobs(ArrayList<JobPost> jobs) {
        this.jobs = jobs;
    }
}
