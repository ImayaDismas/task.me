package me.task.com.taskme.models;

/**
 * Created by root on 12/1/17.
 */

public class JobPost {
    int client_id, job_post_id;
    String apartment_name, contact_cell_no, house_no, location, job_date, job_time, job_category, createdAt;


    public JobPost(int client_id, int job_post_id, String apartment_name, String contact_cell_no, String house_no, String location, String job_date, String job_time, String job_category, String createdAt)
    {
        this.client_id = client_id;
        this.job_post_id = job_post_id;
        this.apartment_name = apartment_name;
        this.contact_cell_no = contact_cell_no;
        this.house_no = house_no;
        this.location = location;
        this.job_date = job_date;
        this.job_time = job_time;
        this.job_category = job_category;
        this.createdAt = createdAt;
    }
    public int getClient_id() {
        return client_id;
    }

    public int getJob_post_id() {
        return job_post_id;
    }

    public String getApartment_name() {
        return apartment_name;
    }

    public String getContact_cell_no() {
        return contact_cell_no;
    }

    public String getHouse_no() {
        return house_no;
    }

    public String getLocation() {
        return location;
    }

    public String getJob_date() {
        return job_date;
    }

    public String getJob_time() {
        return job_time;
    }

    public String getJob_category() {
        return job_category;
    }

    public String getCreatedAt() {
        return createdAt;
    }

}
