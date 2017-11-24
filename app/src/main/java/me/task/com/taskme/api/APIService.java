package me.task.com.taskme.api;

import me.task.com.taskme.helper.ProfessionalResult;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by root on 11/17/17.
 */

public interface APIService {
    @FormUrlEncoded
    @POST("proffesional_register")
    Call<ProfessionalResult> registerProfessional(
            @Field("first_name") String first_name,
            @Field("last_name") String last_name,
            @Field("email") String email,
            @Field("password") String password);


    @FormUrlEncoded
    @POST("proffesional_login")
    Call<ProfessionalResult> loginProfessional(
            @Field("email") String email,
            @Field("password") String password
    );

}
