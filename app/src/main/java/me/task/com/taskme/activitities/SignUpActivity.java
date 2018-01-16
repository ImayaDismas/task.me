package me.task.com.taskme.activitities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import me.task.com.taskme.R;
import me.task.com.taskme.api.APIService;
import me.task.com.taskme.api.APIUrl;
import me.task.com.taskme.helper.ProfessionalResult;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{

//    declare the variables to be used in this class
    private EditText editTextFirstName, editTextLastName, editTextEmail, editTextPassword, editTextConfirmPassword;
    private Button buttonSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
//        initialize all the inputs from the gui
        editTextFirstName = (EditText) findViewById(R.id.txtName);
        editTextLastName = (EditText) findViewById(R.id.txtLast);
        editTextEmail = (EditText) findViewById(R.id.txtEmail);
        editTextPassword = (EditText) findViewById(R.id.txtPassword);
        editTextConfirmPassword = (EditText) findViewById(R.id.txtCPassword);

        buttonSignUp = (Button) findViewById(R.id.signup);

        buttonSignUp.setOnClickListener(this);
    }

//    the sign up method implementation
    private void userSignUp() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Signing Up...");
        progressDialog.show();

//        convert the input variables to string
        String first_name = editTextFirstName.getText().toString().trim();
        String last_name = editTextLastName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String confirm_password = editTextConfirmPassword.getText().toString().trim();

//        initialize the retrofit builder
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

//        initialize the retrofit service
        APIService service = retrofit.create(APIService.class);

//        initiate a call to the service using the service created
        Call<ProfessionalResult> call = service.registerProfessional(first_name, last_name, email, password);
        call.enqueue(new Callback<ProfessionalResult>() {
            @Override
            public void onResponse(Call<ProfessionalResult> call, Response<ProfessionalResult> response) {
                progressDialog.dismiss();
//                check if the error is false or true
                if (!response.body().getError()) {
                    finish();
                    Log.e("Response", String.valueOf(response.body().getProfessional().getEmail()));
//                    display the success message in a toast
                    Toast.makeText(getApplicationContext(), String.valueOf(response.body().getMessage()), Toast.LENGTH_LONG).show();
//                    invoke the sign in activity on a succesful registration
                    startActivity(new Intent(getApplicationContext(), SignInActivity.class));
                } else {
//                    if encountered an error, display the error on a toast
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
//        if the button clicked is signup
        if (view == buttonSignUp) {
            userSignUp();
        }
    }
}
