package me.task.com.taskme.helper;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import me.task.com.taskme.models.JobPosts;

/**
 * Created by root on 12/1/17.
 */

public class JobsResult {
    @SerializedName("error")
    private Boolean error;

    @SerializedName("message")
    private String message;

    @SerializedName("job_posts")
    private List<JobPosts> jobPosts;

    public Boolean getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public List<JobPosts> getJobPosts() {
        return jobPosts;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setJobPosts(List<JobPosts> jobPosts) {
        this.jobPosts = jobPosts;
    }
}
