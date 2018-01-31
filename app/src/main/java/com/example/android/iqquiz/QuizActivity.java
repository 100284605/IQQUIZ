package com.example.android.iqquiz;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    int quantity = 0;
    int score;
    private RadioGroup radioButtonGroup1;
    private RadioGroup radioButton;
    RadioGroup group;
    private RadioButton radioButton3, option22;
    private CheckBox option1, option2, option3, option4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if (getSupportActionBar() != null)
            getSupportActionBar().hide();
        setContentView(R.layout.activity_quiz);

        radioButtonGroup1 = findViewById(R.id.radioButtonGroup1);
        radioButton = findViewById(R.id.radioButton);
        group = findViewById(R.id.group);
        radioButton3 = findViewById(R.id.radioButton3);
        option22 = findViewById(R.id.option22);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);

    }

    /**
     * This method is called when we click minus button.
     */
    public void decrement(View view) {
        if (quantity <= 1) {
            // Show an error message as a toast
            Toast.makeText(this, "Sorry Einstein, you cannot have less than 0 circles", Toast.LENGTH_SHORT).show();
            // Exit this method early because there's nothing left to do
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when we click plus button.
     */
    public void increment(View view) {

        if (quantity >= 13) {
            // Show an error message as a toast
            Toast.makeText(this, "Did you skip your math classes?", Toast.LENGTH_SHORT).show();
            // Exit this method early because there's nothing left to do
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = findViewById(R.id.title_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method is used when Submit button is clicked
     */
    public void calculateScore(View view) {

        score = 0;

        //** Calculate quiz 1

        if (radioButtonGroup1.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getApplicationContext(), "Please answer all questions before submitting your answers", Toast.LENGTH_SHORT).show();

        } else {
            score += 1;
        }

        //** Calculate quiz 2
        if (radioButton.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getApplicationContext(), "Please answer all questions before submitting your answers", Toast.LENGTH_SHORT).show();

        }
        if (radioButton3.isChecked()) {
            score += 1;
        }


        //** Calculate quiz 3
        if (quantity == 12) {
            score += 1;
        }

        //** Calculate quiz 4

        if (option1.isChecked() && option3.isChecked()) {
            score += 1;
        }


        //**Calculate quiz 5

        if (option22.isChecked()) {
            score += 1;
        }


        //** Start ResultsActivity
        Intent Quiz = getIntent();
        String playerName = Quiz.getStringExtra("player_name");
        Intent Results = new Intent(this, com.example.android.iqquiz.ResultsActivity.class);
        Results.putExtra("correct_answers", score);
        Results.putExtra("player_name", playerName);

        if (radioButtonGroup1.getCheckedRadioButtonId() == -1 || radioButton.getCheckedRadioButtonId() == -1 || group.getCheckedRadioButtonId() == -1 || !(option1.isChecked() || option2.isChecked() || option3.isChecked() || option4.isChecked())) {
            Toast.makeText(getApplicationContext(), "Please answer all questions before submitting your answers", Toast.LENGTH_SHORT).show();
        } else
            startActivity(Results);
    }
}








