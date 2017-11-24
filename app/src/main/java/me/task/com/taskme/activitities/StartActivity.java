package me.task.com.taskme.activitities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import me.task.com.taskme.R;
import me.task.com.taskme.helper.SharedPrefManager;

public class StartActivity extends AppCompatActivity implements View.OnClickListener{

//    declare the variables for the inputs
    Button buttonClient, buttonProfessional;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        //if user is already logged in open the home activity
        if (SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, NavigationActivity.class));
        }

//        initialize the variables inputs
        buttonClient = (Button) findViewById(R.id.buttonClient);
        buttonProfessional = (Button) findViewById(R.id.buttonProffesional);

//        set on click listener on each button
        buttonClient.setOnClickListener(this);
        buttonProfessional.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
//        if button client has been clicked
        if (view == buttonClient)
        {
//            finish this and invoke the main activity
            finish();
            startActivity(new Intent(getApplicationContext(), MainHireActivity.class));
        }
//        if button professional has been clicked
        else if (view == buttonProfessional)
        {
//            finish this and start the main activity
            finish();
            startActivity(new Intent(getApplicationContext(), MainWorkActivity.class));
        }
    }
}
