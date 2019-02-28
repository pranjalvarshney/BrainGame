package com.braingame;

import android.annotation.SuppressLint;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MediumLevel extends AppCompatActivity {

    Button btn_ready, btn_answer0, btn_answer1,btn_answer2, btn_answer3, btn_answer4, btn_answer5, btn_play_again;
    TextView tv_question , tv_answer_state, tv_timer, tv_score;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    int locationofcorrectanswer;
    int score = 0;
    int noofquestions=0;
    RelativeLayout rellay0,rellay1,rellay2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medium_level);

        tv_answer_state = findViewById(R.id.tv_answer_state);
        tv_timer = findViewById(R.id.tv_timer);
        tv_score = findViewById(R.id.tv_score);

        rellay0 = findViewById(R.id.rellay0);
        rellay1 = findViewById(R.id.rellay1);
        rellay2 = findViewById(R.id.rellay2);

        btn_answer0 = findViewById(R.id.btn_answer0);
        btn_answer1 = findViewById(R.id.btn_answer1);
        btn_answer2 = findViewById(R.id.btn_answer2);
        btn_answer3 = findViewById(R.id.btn_answer3);
        btn_answer4 = findViewById(R.id.btn_answer4);
        btn_answer5 = findViewById(R.id.btn_answer5);

        btn_play_again = findViewById(R.id.btn_play_again);
        tv_question = findViewById(R.id.tv_question);



        btn_ready = findViewById(R.id.btn_ready);
        btn_ready.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readyBtnclick();
            }
        });


        btn_play_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAgain();
                rellay0.setVisibility(View.VISIBLE);
                btn_play_again.setVisibility(View.INVISIBLE);
            }
        });


    }
    void readyBtnclick(){
        playAgain();
        btn_ready.setVisibility(View.INVISIBLE);
        rellay0.setVisibility(View.VISIBLE);
    }
    @SuppressLint("SetTextI18n")
    public void chooseAnswer(View view){

        //checking whether btn is working or not //  Log.i("Tag",(String)view.getTag());

        if(view.getTag().toString().equals(Integer.toString(locationofcorrectanswer))){
            // Log.i("answer","correct");

            score++;
            tv_answer_state.setText("Correct!");
        }
        else{
            tv_answer_state.setText("Wrong!");
        }

        noofquestions++;
        tv_score.setText(Integer.toString(score)+"/"+Integer.toString(noofquestions));
        generateQuestions();
    }
    @SuppressLint("SetTextI18n")
    public void generateQuestions(){
        Random random = new Random();

        int a = random.nextInt(101);
        int b = random.nextInt(101);


        tv_question.setText(a + " + " + b);

        locationofcorrectanswer = random.nextInt(6);

        answers.clear();

        int incorrectanswer;

        for (int i=0 ; i<6; i++){

            if(i == locationofcorrectanswer){
                answers.add(a+b);
            }
            else{

                incorrectanswer = random.nextInt(201);
                while (incorrectanswer == a+b){
                    incorrectanswer = random.nextInt(201);
                }
                answers.add(incorrectanswer);
            }
        }
        btn_answer0.setText(Integer.toString(answers.get(0)));
        btn_answer1.setText(Integer.toString(answers.get(1)));
        btn_answer2.setText(Integer.toString(answers.get(2)));
        btn_answer3.setText(Integer.toString(answers.get(3)));
        btn_answer4.setText(Integer.toString(answers.get(4)));
        btn_answer5.setText(Integer.toString(answers.get(5)));
    }

    @SuppressLint("SetTextI18n")
    public void playAgain(){

        score = 0;
        noofquestions = 0;
        tv_answer_state.setText("");
        tv_score.setText("0/0");
        tv_timer.setText("60s");
        rellay2.setVisibility(View.VISIBLE);
        generateQuestions();

        new CountDownTimer(61000, 1000) {
            @SuppressLint("SetTextI18n")
            @Override
            public void onTick(long millisUntilFinished) {

                tv_timer.setText(String.valueOf(millisUntilFinished/1000)+ "s");

            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onFinish() {

                rellay2.setVisibility(View.GONE);
                btn_play_again.setVisibility(View.VISIBLE);
                tv_timer.setText("0s");
                tv_answer_state.setText("Your Score : "+Integer.toString(score)+"/"+Integer.toString(noofquestions));

            }
        }.start();
    }
}

