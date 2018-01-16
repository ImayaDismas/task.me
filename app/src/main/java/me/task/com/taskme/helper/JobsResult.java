package me.task.com.taskme.helper;

import com.google.gson.annotations.SerializedName;

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
    private JobPosts jobPosts;

    public JobsResult(Boolean error, String message, JobPosts jobPosts) {
        this.error = error;
        this.message = message;
        this.jobPosts = jobPosts;
    }

    public JobsResult(Boolean error, String message) {
        this.error = error;
        this.message = message;
    }

    public Boolean getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public JobPosts getJobPosts() {
        return jobPosts;
    }
}
