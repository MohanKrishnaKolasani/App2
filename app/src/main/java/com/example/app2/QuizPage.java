package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.util.ArrayList;

public class QuizPage extends AppCompatActivity {

    TextView greet, question, scoreVal;
    Button next, quit;
    RadioGroup radioGroup;
    RadioButton op1, op2, op3, op4;
    int i = 0, score = 0, wrg = 0;

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

        ArrayList<Question> questions = new ArrayList<>();
        questions.add(new Question("Which method can be defined only once in a program?","main method", "finalize method","main method","static method","private method"));
        questions.add(new Question("Which keyword is used by method to refer to the current object that invoked it?", "this", "import","this","catch","abstract"));
        questions.add(new Question("Which of these access specifiers can be used for an interface?", "public", "public","protected","private","All of the mentioned"));
        questions.add(new Question("Which of the following is correct way of importing an entire package \"pkg\"?", "import pkg.*", "Import pkg.","import pkg.*","Import pkg.*","import pkg."));
        questions.add(new Question("What is the return type of Constructors?", "None of the mentioned", "int","float","void","None of the mentioned"));

        nextQuestion(questions);

        greet.setText("Hello " + name);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean flag = false;

                if( i < questions.size() ) {

                    if (op1.isChecked()) {
                        if (op1.getText().toString().equals(questions.get(i).getCrtOption())) {
                            Toast.makeText(QuizPage.this, "Correct", Toast.LENGTH_SHORT).show();
                            score = score + 1;
                            scoreVal.setText(Integer.toString(score));
                            nextQuestion(questions);
                            flag = true;
                            i = i + 1;
                        } else {
                            Toast.makeText(QuizPage.this, "Wrong", Toast.LENGTH_SHORT).show();
                            nextQuestion(questions);
                            wrg = wrg + 1;
                            flag = true;
                            i = i + 1;
                        }
                    } else if (op2.isChecked()) {
                        if (op2.getText().toString().equals(questions.get(i).getCrtOption())) {
                            Toast.makeText(QuizPage.this, "Correct", Toast.LENGTH_SHORT).show();
                            score = score + 1;
                            scoreVal.setText(Integer.toString(score));
                            nextQuestion(questions);
                            flag = true;
                            i = i + 1;
                        } else {
                            Toast.makeText(QuizPage.this, "Wrong", Toast.LENGTH_SHORT).show();
                            nextQuestion(questions);
                            wrg = wrg + 1;
                            flag = true;
                            i = i + 1;
                        }
                    } else if (op3.isChecked()) {
                        if (op3.getText().toString().equals(questions.get(i).getCrtOption())) {
                            Toast.makeText(QuizPage.this, "Correct", Toast.LENGTH_SHORT).show();
                            score = score + 1;
                            scoreVal.setText(Integer.toString(score));
                            nextQuestion(questions);
                            flag = true;
                            i = i + 1;
                        } else {
                            Toast.makeText(QuizPage.this, "Wrong", Toast.LENGTH_SHORT).show();
                            nextQuestion(questions);
                            flag = true;
                            wrg = wrg + 1;
                            i = i + 1;
                        }
                    } else if (op4.isChecked()) {
                        if (op4.getText().toString().equals(questions.get(i).getCrtOption())) {
                            Toast.makeText(QuizPage.this, "Correct", Toast.LENGTH_SHORT).show();
                            score = score + 1;
                            scoreVal.setText(Integer.toString(score));
                            nextQuestion(questions);
                            flag = true;
                            i = i + 1;
                        } else {
                            Toast.makeText(QuizPage.this, "Wrong", Toast.LENGTH_SHORT).show();
                            nextQuestion(questions);
                            wrg = wrg + 1;
                            flag = true;
                            i = i + 1;
                        }
                    }

                    if (flag) {
                        if(i < questions.size()) {
                            nextQuestion(questions);
                            radioGroup.clearCheck();
                        }else{
                            nextActivity();
                        }
                    } else
                        Toast.makeText(QuizPage.this, "No option selected", Toast.LENGTH_SHORT).show();
                }else {
                    nextActivity();
                }
            }
        });

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QuizPage.this, "Quiting", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(QuizPage.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void nextQuestion(ArrayList<Question> arrayList){
        Question ques = arrayList.get(i);
        question.setText(ques.getQuestion());
        op1.setText(ques.getOp1());
        op2.setText(ques.getOp2());
        op3.setText(ques.getOp3());
        op4.setText(ques.getOp4());
    }

    public void nextActivity(){
        Intent intent = new Intent(QuizPage.this, ResultScreen.class);
        intent.putExtra("crt", scoreVal.getText().toString());
        intent.putExtra("wrg", Integer.toString(wrg));
        startActivity(intent);
    }
}