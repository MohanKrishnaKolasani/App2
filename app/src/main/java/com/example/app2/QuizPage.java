package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class QuizPage extends AppCompatActivity {

    TextView greet, question, scoreVal;
    Button next, quit;
    RadioGroup radioGroup;
    RadioButton op1, op2, op3, op4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page);

        greet = findViewById(R.id.whish);
        question = findViewById(R.id.question);
        scoreVal = findViewById(R.id.scorevalue);
        next = findViewById(R.id.next);
        quit = findViewById(R.id.quit);
        radioGroup = findViewById(R.id.radioGroup);
        op1 = findViewById(R.id.op1);
        op2 = findViewById(R.id.op2);
        op3 = findViewById(R.id.op3);
        op4 = findViewById(R.id.op4);

        String name;

        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("name");

        greet.setText("Hello" + name);



    }
}