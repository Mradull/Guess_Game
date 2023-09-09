package com.example.guessgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView textView1;
    EditText editText;
    String guessednumber;
    Integer desiredValue;
    ImageButton imageButton,imageButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = findViewById(R.id.textView1);
        editText = findViewById(R.id.editText);
        imageButton=findViewById(R.id.imageButton);
        imageButton1=findViewById(R.id.imageButton2);

        textView1.setText("Please Enter Your Guess");
        Random r = new Random();
        int low = 1, high = 100;

        int num = r.nextInt(high - low) + low;
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                guessednumber= editText.getText().toString();
                 desiredValue = Integer.parseInt(guessednumber);
                    if (num == desiredValue) // Checking the Guessed Number Matches the Random Number
                    {
                        textView1.setText("Right guess :)");
                        editText.setText("");
                       // System.out.println("Right guess :)");
                       // System.out.println("Your Score is:" + " " + i);

                    } else if (desiredValue > num) {
                        textView1.setText("Make a Smaller Guess!!");
                        editText.setText("");
                        //System.out.println("Make a Smaller Guess!!");
                    } else {
                        textView1.setText("Make a Higger Guess!!");
                        editText.setText("");
                       // System.out.println("Make a Higger Guess!!");
                    }
                }
        });
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });

    }
    void reset(){
        Random r = new Random();
        int low = 1, high = 100;

        int num = r.nextInt(high - low) + low;
        textView1.setText("Please Enter Your Guess");
        editText.setText(" ");
    }
}