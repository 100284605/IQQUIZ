package com.example.android.iqquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RatingBar;
import android.widget.Toast;

public class ResultsActivity extends AppCompatActivity {

    int correctAnswers;
    String playerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if (getSupportActionBar() != null)
            getSupportActionBar().hide();
        setContentView(R.layout.activity_results);

        //** Star rating of score and display a Toast with the number of correct answers
        Intent Results = getIntent();
        correctAnswers = Results.getIntExtra("correct_answers", 0);
        playerName = Results.getStringExtra("player_name");
        RatingBar stars = findViewById(R.id.stars);
        stars.setRating(correctAnswers);
        Toast.makeText(this, getString(R.string.scoreMessage) + String.valueOf(correctAnswers) + " points", Toast.LENGTH_SHORT).show();
    }

    //** Share the results with other apps
    public void shareResults (View view) {
        String scoreMessage = getString(R.string.scoreMessage) + String.valueOf(correctAnswers);
        Intent shareScore = new Intent(Intent.ACTION_SEND);
        shareScore.setType("text/plain");
        shareScore.putExtra(Intent.EXTRA_TEXT, scoreMessage);
        // Create intent to show the chooser dialog for sharing to other apps
        Intent chooser = Intent.createChooser(shareScore, scoreMessage);
        startActivity(chooser);
    }

}
