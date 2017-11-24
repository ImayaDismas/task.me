package me.task.com.taskme.models;

/**
 * Created by root on 11/17/17.
 */

public class Professional {

    private int proff_id;
    private String proff_name;
    private String api_key;
    private String email;
    private String cell_no;
    private String national_id;
    private String location;
    private String availability_status;
    private String image;
    private String first_name;
    private String last_name;
    private String gender;
    private String status;
    private String created_at;

    public Professional(int proff_id, String proff_name, String api_key, String email, String cell_no, String national_id, String location, String availability_status, String image, String first_name, String last_name, String gender, String status, String created_at)
    {
        this.proff_id = proff_id;
        this.proff_name = proff_name;
        this.api_key = api_key;
        this.email = email;
        this.cell_no = cell_no;
        this.national_id = national_id;
        this.location = location;
        this.availability_status = availability_status;
        this.image = image;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.status = status;
        this.created_at = created_at;
    }

    public Professional(int proff_id, String proff_name, String email, String api_key)
    {
        this.proff_id = proff_id;
        this.proff_name = proff_name;
        this.api_key = api_key;
        this.email = email;
    }
    public int getProff_id() {
        return proff_id;
    }

    public String getApi_key() {
        return api_key;
    }

    public String getAvailability_status() {
        return availability_status;
    }

    public String getCell_no() {
        return cell_no;
    }

    public String getEmail() {
        return email;
    }

    public String getImage() {
        return image;
    }

    public String getLocation() {
        return location;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getNational_id() {
        return national_id;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getProff_name() {
        return proff_name;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getGender() {
        return gender;
    }

    public String getStatus() {
        return status;
    }

}
