package com.example.appff;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends Activity {
    private TextView num1;

    private TextView num2;
    private TextView rn1;

    private TextView rn2;
    private TextView rn3;
    TextView sol1 ;
    private TextView rn4;
    private Button btn;


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
                num1.setText((int) (Math.random()*50)+"");
                num2.setText((int)(Math.random()*50)+"");
                TextView[] arr = {rn1,rn2,rn3,rn4};
                sol1.setText("");

                TextView  a = arr[(int) Math.floor(Math.random() * arr.length)] ;
                a.setText(Integer.parseInt(num1.getText().toString())+Integer.parseInt(num2.getText().toString())+"");
                for(int i =0 ;i<arr.length ; i++){
                    if(a!=arr[i])
                        arr[i].setText((int)(Math.random()*50)+"");
                }
                rn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(rn1.getText().equals(a.getText()))
                            sol1.setText("correct");
                        else
                            sol1.setText("Incorrect");
                    }
                });
                rn2.setOnClickListener(new View.OnClickListener() {
                    @SuppressLint("SuspiciousIndentation")
                    @Override
                    public void onClick(View view) {
                        if(rn2.getText().equals(a.getText()))
                        sol1.setText("correct");
                        else
                        sol1.setText("Incorrect");
                    }
                });
                rn3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(rn3.getText().equals(a.getText()))
                            sol1.setText("correct");
                        else
                            sol1.setText("Incorrect");
                    }
                });
                rn4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(rn4.getText().equals(a.getText()))
                            sol1.setText("correct");
                        else
                            sol1.setText("Incorrect");

                    }
                });
            }

        });


    }
}