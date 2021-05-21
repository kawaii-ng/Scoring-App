package com.example.scoringapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // define component
    MyViewModel myViewModel;

    TextView titleA, titleB, txtScoreA, txtScoreB;
    Button btn_a1, btn_a2, btn_a3, btn_b1, btn_b2, btn_b3;
    ImageButton btn_redo, btn_reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find view by id
        myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);

        titleA = findViewById(R.id.textView_title_a);
        titleB = findViewById(R.id.textView_title_b);

        txtScoreA = findViewById(R.id.textView_score_a);
        txtScoreB = findViewById(R.id.textView_score_b);
        // initialize the score first
        txtScoreA.setText(String.valueOf(myViewModel.scoreA));
        txtScoreB.setText(String.valueOf(myViewModel.scoreB));

        btn_a1 = findViewById(R.id.btn_a1);
        btn_a2 = findViewById(R.id.btn_a2);
        btn_a3 = findViewById(R.id.btn_a3);

        btn_b1 = findViewById(R.id.btn_b1);
        btn_b2 = findViewById(R.id.btn_b2);
        btn_b3 = findViewById(R.id.btn_b3);

        btn_redo = findViewById(R.id.imgBtn_redo);
        btn_reset = findViewById(R.id.imgBtn_reset);

        // btn functions
        btn_a1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                myViewModel.scoreA+=1;
                txtScoreA.setText(String.valueOf(myViewModel.scoreA));
                myViewModel.state = "a1";

            }

        });

        btn_a2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                myViewModel.scoreA+=2;
                txtScoreA.setText(String.valueOf(myViewModel.scoreA));
                myViewModel.state = "a2";
            }

        });

        btn_a3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                myViewModel.scoreA+=3;
                txtScoreA.setText(String.valueOf(myViewModel.scoreA));
                myViewModel.state = "a3";
            }

        });

        btn_b1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                myViewModel.scoreB+=1;
                txtScoreB.setText(String.valueOf(myViewModel.scoreB));
                myViewModel.state = "b1";
            }
        });

        btn_b2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                myViewModel.scoreB+=2;
                txtScoreB.setText(String.valueOf(myViewModel.scoreB));
                myViewModel.state = "b2";
            }

        });

        btn_b3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                myViewModel.scoreB+=3;
                txtScoreB.setText(String.valueOf(myViewModel.scoreB));
                myViewModel.state = "b3";
            }

        });

        btn_reset.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                myViewModel.scoreA = 0;
                myViewModel.scoreB = 0;
                txtScoreA.setText(String.valueOf(myViewModel.scoreA));
                txtScoreB.setText(String.valueOf(myViewModel.scoreB));
                myViewModel.state = "00";
            }

        });

        btn_redo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                switch(myViewModel.state){

                    case "a1":
                        myViewModel.scoreA -= 1;
                        break;

                    case "a2":
                        myViewModel.scoreA -= 2;
                        break;

                    case "a3":
                        myViewModel.scoreA -= 3;
                        break;

                    case "b1":
                        myViewModel.scoreB -= 1;
                        break;

                    case "b2":
                        myViewModel.scoreB -= 2;
                        break;

                    case "b3":
                        myViewModel.scoreB -= 3;
                        break;

                    default:
                        break;

                }

                myViewModel.state = "00";
                txtScoreA.setText(String.valueOf(myViewModel.scoreA));
                txtScoreB.setText(String.valueOf(myViewModel.scoreB));

            }

        });

    }

}