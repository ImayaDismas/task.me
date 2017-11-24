package me.task.com.taskme.activitities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import me.task.com.taskme.R;
import me.task.com.taskme.api.APIService;
import me.task.com.taskme.api.APIUrl;
import me.task.com.taskme.helper.ProfessionalResult;
import me.task.com.taskme.helper.SharedPrefManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

//    declare the variables for the inputs
    private EditText editTextEmail, editTextPassword;
    private Button buttonSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

//        initialize the input variables
        editTextEmail = (EditText) findViewById(R.id.txtLogEmail);
        editTextPassword = (EditText) findViewById(R.id.txtLogPass);

        buttonSignIn = (Button) findViewById(R.id.signin);

        buttonSignIn.setOnClickListener(this);
    }

    private void userSignIn() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
//        start the progress dialog
        progressDialog.setMessage("Signing In...");
        progressDialog.show();
//        convert the input variables to string
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

//        initialze the retrofit builder
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

//        initialize the api servive created
        APIService service = retrofit.create(APIService.class);

//        initiate a call to the service using the service created
        Call<ProfessionalResult> call = service.loginProfessional(email, password);
        call.enqueue(new Callback<ProfessionalResult>() {
            @Override
            public void onResponse(Call<ProfessionalResult> call, Response<ProfessionalResult> response) {
                progressDialog.dismiss();
//                check if error is true or false
                if (!response.body().getError()) {
//                    display the message if the post is successful
                    Toast.makeText(getApplicationContext(), String.valueOf(response.body().getMessage()), Toast.LENGTH_LONG).show();
//                    save the email, name and api key in the shared preferences
                    SharedPrefManager.getInstance(getApplicationContext()).professionalLogin(response.body().getProfessional());
//                    finish this and invoke the home activity if successful
                    finish();
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                } else {
                    Toast.makeText(getApplicationContext(), String.valueOf(response.body().getMessage()), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ProfessionalResult> call, Throwable t) {
//                if server URL is unreacheable display the error message on the toast
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
//        check if the button clicked is sign in
        if (view == buttonSignIn) {
            userSignIn();
        }
    }
}
