package me.task.com.taskme.activitities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import me.task.com.taskme.R;
import me.task.com.taskme.helper.SharedPrefManager;

public class MainHireActivity extends AppCompatActivity implements View.OnClickListener{

    //    declare the variables
    private Button buttonSignIn, buttonSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_hire);

        //if user is already logged in open the home activity
        if (SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, NavigationActivity.class));
        }

//        initialize the variables with inputs
        buttonSignIn = (Button) findViewById(R.id.buttonSignIn);
        buttonSignUp = (Button) findViewById(R.id.buttonSignUp);

//        buttonSignIn.setOnClickListener(this);
//        buttonSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
//        check if button clicked is sign in
        if (view == buttonSignIn) {
//            finish and invoke the sign in activity
            finish();
            startActivity(new Intent(this, SignInActivity.class));

        }
//        check if button clicked is sign up
        else if (view == buttonSignUp) {
//            finish and invoke the sign up activity
            finish();
            startActivity(new Intent(this, SignUpActivity.class));

        }
    }
}

