package com.example.mathgame;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;
import java.util.TreeMap;

public class MainActivity extends Activity {
    private TextView num1;

    private TextView num2;
    private TextView rn1;

    private TextView rn2;
    private TextView rn3;
    TextView sol1 ;

    private TextView rn4;
    private Button btn;
    private TextView opPl;
    private TextView opMi;
    private TextView opMul;
    private TextView opDi;
    private TextView op;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = findViewById(R.id.num1);
                sol1 =findViewById(R.id.sol1);
                num2 = findViewById(R.id.num2);
                rn1 = findViewById(R.id.rn1);
                rn2 = findViewById(R.id.rn2);
                rn3 = findViewById(R.id.rn3);
                rn4= findViewById(R.id.rn4);
                opDi = findViewById(R.id.op_di);
                opMul = findViewById(R.id.op_mul);
                opMi = findViewById(R.id.op_mi);
                opPl = findViewById(R.id.op_pl);
                op = findViewById(R.id.op);
                int num3 = (int)(Math.random()*51);
                int num0 = (int)(Math.random()*51);
                if(num3>num0 ){
                    num1.setText(num3 + "");
                    num2.setText(num0 + "");

                }else
                    num1.setText(num0 + "");
                num2.setText(num3 + "");
                sol1.setText("");

                TextView[] arr1 = {opPl,opMi,opMul,opDi};
                op.setText(arr1[(int)(Math.floor(Math.random()*arr1.length))].getText());
                TextView[]  arr = {rn1, rn2, rn3, rn4};




                TextView  a = arr[(int) Math.floor(Math.random() * arr.length)] ;

                for(int i =0 ;i<arr.length ; i++){

                    if(op.getText().equals("+")) {
                        a.setText(Integer.parseInt(num1.getText().toString())+Integer.parseInt(num2.getText().toString())+"");
                        if(a!=arr[i]) {
                            arr[i].setText((int) (Math.random() * 101) + "");
                        }
                    }
                    if(op.getText().equals("-")) {
                        a.setText(Integer.parseInt(num1.getText().toString())-Integer.parseInt(num2.getText().toString())+"");
                        if(a!=arr[i]) {
                            arr[i].setText((int) (Math.random() * 51) + "");
                        }
                    }
                    if(op.getText().equals("X")) {
                        a.setText(Integer.parseInt(num1.getText().toString())*Integer.parseInt(num2.getText().toString())+"");
                        if(a!=arr[i]) {
                            arr[i].setText((int) (Math.random() * 2501) + "");
                        }
                    }
                    if(op.getText().equals("/")) {
                        a.setText(Integer.parseInt(num1.getText().toString())/Integer.parseInt(num2.getText().toString())+"");
                        if(a!=arr[i]) {
                            arr[i].setText((int) (Math.random() * 51) + "");
                        }
                    }
                }
                rn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (rn1.getText().equals(a.getText())) {
                            sol1.setText("Correct");
                            sol1.setTextColor(getResources().getColor(android.R.color.holo_green_dark)); // Green color for correct
                        } else {
                            sol1.setText("Incorrect");
                            sol1.setTextColor(getResources().getColor(android.R.color.holo_red_dark)); // Red color for incorrect
                        }
                    }
                });

                rn2.setOnClickListener(new View.OnClickListener() {
                    @SuppressLint("SuspiciousIndentation")
                    @Override
                    public void onClick(View view) {
                        if (rn2.getText().equals(a.getText())) {
                            sol1.setText("Correct");
                            sol1.setTextColor(getResources().getColor(android.R.color.holo_green_dark)); // Green color for correct
                        } else {
                            sol1.setText("Incorrect");
                            sol1.setTextColor(getResources().getColor(android.R.color.holo_red_dark)); // Red color for incorrect
                        }
                    }
                });

                rn3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (rn3.getText().equals(a.getText())) {
                            sol1.setText("Correct");
                            sol1.setTextColor(getResources().getColor(android.R.color.holo_green_dark)); // Green color for correct
                        } else {
                            sol1.setText("Incorrect");
                            sol1.setTextColor(getResources().getColor(android.R.color.holo_red_dark)); // Red color for incorrect
                        }
                    }
                });

                rn4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (rn4.getText().equals(a.getText())) {
                            sol1.setText("Correct");
                            sol1.setTextColor(getResources().getColor(android.R.color.holo_green_dark)); // Green color for correct
                        } else {
                            sol1.setText("Incorrect");
                            sol1.setTextColor(getResources().getColor(android.R.color.holo_red_dark)); // Red color for incorrect
                        }
                    }
                });
            }

        });


    }

}

