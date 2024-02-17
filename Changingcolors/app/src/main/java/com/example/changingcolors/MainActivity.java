package com.example.changingcolors;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
    private TextView a1 ;
    private TextView a2 ;
    private TextView a3 ;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a1 = findViewById(R.id.a1);
        a2 = findViewById(R.id.a2);
        a3 = findViewById(R.id.a3);
        Drawable c = a1.getBackground();
        Drawable c2 = a2.getBackground();
        Drawable c3 = a3.getBackground();
        int cnt = 1 ;

            a1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Drawable c = a1.getBackground();
                    a1.setBackground(a2.getBackground());
                    a2.setBackground(c);
                }
            });
            a2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Drawable c = a2.getBackground();
                    a2.setBackground(a3.getBackground());
                    a3.setBackground(c);
                }
            });
            a3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Drawable c = a3.getBackground();
                    a3.setBackground(a1.getBackground());
                    a1.setBackground(c);


                }

            });




    }
}