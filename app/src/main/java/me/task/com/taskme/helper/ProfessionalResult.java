package me.task.com.taskme.helper;

import com.google.gson.annotations.SerializedName;

import me.task.com.taskme.models.Professional;

/**
 * Created by root on 11/15/17.
 */

public class ProfessionalResult {
    @SerializedName("error")
    private Boolean error;

    @SerializedName("message")
    private String message;

    @SerializedName("professional")
    private Professional professional;

    public ProfessionalResult(Boolean error, String message, Professional professional) {
        this.error = error;
        this.message = message;
        this.professional = professional;
    }

    public Boolean getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public Professional getProfessional() {
        return professional;
    }
}
