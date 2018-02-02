package me.task.com.taskme.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by root on 2/2/18.
 */
public class JobPosts {
    @SerializedName("job_post_id")
    private Integer job_post_id;
    @SerializedName("client_id")
    private Integer client_id;
    @SerializedName("location")
    private String location;
    @SerializedName("apartment_name")
    private String apartment_name;
    @SerializedName("house_no")
    private String house_no;
    @SerializedName("contact_cell_no")
    private String contact_cell_no;
    @SerializedName("job_date")
    private String job_date;
    @SerializedName("job_time")
    private String job_time;
    @SerializedName("job_category")
    private String job_category;
    @SerializedName("proff_id")
    private Integer proff_id;
    @SerializedName("created_at")
    private String created_at;

    public JobPosts(Integer job_post_id, Integer client_id, String location, String apartment_name, String house_no, String contact_cell_no, String job_date, String job_time, String job_category, Integer proff_id, String created_at)
    {
        this.job_post_id = job_post_id;
        this.client_id = client_id;
        this.location = location;
        this.apartment_name = apartment_name;
        this.house_no = house_no;
        this.contact_cell_no = contact_cell_no;
        this.job_date = job_date;
        this.job_time = job_time;
        this.job_category = job_category;
        this.proff_id = proff_id;
        this.created_at = created_at;
    }

    public Integer getJob_post_id() {
        return job_post_id;
    }

    public Integer getClient_id() {
        return client_id;
    }

    public String getLocation() {
        return location;
    }

    public String getApartment_name() {
        return apartment_name;
    }

    public String getHouse_no() {
        return house_no;
    }

    public Integer getProff_id() {
        return proff_id;
    }

    public String getContact_cell_no() {
        return contact_cell_no;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getJob_category() {
        return job_category;
    }

    public String getJob_date() {
        return job_date;
    }

    public String getJob_time() {
        return job_time;
    }

    public void setApartment_name(String apartment_name) {
        this.apartment_name = apartment_name;
    }

    public void setClient_id(Integer client_id) {
        this.client_id = client_id;
    }

    public void setContact_cell_no(String contact_cell_no) {
        this.contact_cell_no = contact_cell_no;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setHouse_no(String house_no) {
        this.house_no = house_no;
    }

    public void setJob_category(String job_category) {
        this.job_category = job_category;
    }

    public void setJob_date(String job_date) {
        this.job_date = job_date;
    }

    public void setJob_post_id(Integer job_post_id) {
        this.job_post_id = job_post_id;
    }

    public void setJob_time(String job_time) {
        this.job_time = job_time;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setProff_id(Integer proff_id) {
        this.proff_id = proff_id;
    }
}
