package com.example.shapeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends Activity {

    private EditText radiusC ;
    private EditText xP;
    private EditText yP;
    private Button prntlst ;
    private Button add ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radiusC = findViewById(R.id.radius);
       yP= findViewById(R.id.y);
        xP = findViewById(R.id.x);

    }

}