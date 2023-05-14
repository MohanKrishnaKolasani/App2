package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultScreen extends AppCompatActivity {

    TextView crt, wrg, finalScore;
    Button restart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen);

        crt = findViewById(R.id.correct);
        wrg = findViewById(R.id.wrong);
        finalScore = findViewById(R.id.finalscore);
        restart = findViewById(R.id.restart);

        Bundle bundle = getIntent().getExtras();
        String cS = bundle.getString("crt");
        String wS = bundle.getString("wrg");

        crt.setText("Correct answers : " + cS);
        wrg.setText("Wrong answers : " + wS);
        finalScore.setText("Final score : "+ cS);

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultScreen.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}