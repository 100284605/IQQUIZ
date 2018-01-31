package com.example.android.iqquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if (getSupportActionBar() != null)
            getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
    }
    //** This method start the Quiz activity and pass the player name to other activities

    public void sendMessage(View view) {
        EditText name = findViewById(R.id.name_field);
        String playerName = name.getText().toString();
        if (TextUtils.isEmpty(name.getText())) {
            /**
             *   You can Toast a message here that the Username is Empty
             **/
            Toast.makeText(this, "We really want to know your name", Toast.LENGTH_SHORT).show();
            name.setError("Your name is required!");
        } else {
            Toast.makeText(this, "Good luck " + playerName, Toast.LENGTH_SHORT).show();
            Intent Quiz = new Intent(this, QuizActivity.class);
            startActivity(Quiz);
        }


    }
}
