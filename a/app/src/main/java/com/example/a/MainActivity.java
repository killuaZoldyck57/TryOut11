package com.example.a;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    private Button sortBtn ;
    private EditText a1 ;
    private EditText a3 ;
    private EditText a6 ;
    private EditText a5 ;
    private EditText a4 ;
    private EditText a2 ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sortBtn = findViewById(R.id.sort_btn);
        sortBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int[] s = new int[6];
                a1= findViewById(R.id.a1);
                a2= findViewById(R.id.a2);
                a3= findViewById(R.id.a3);
                a4= findViewById(R.id.a4);
                a6= findViewById(R.id.a6);
                a5= findViewById(R.id.a5);
                s[0]= Integer.parseInt(a1.getText().toString());
                s[1]= Integer.parseInt(a2.getText().toString());
                s[2]= Integer.parseInt(a3.getText().toString());
                s[3]= Integer.parseInt(a4.getText().toString());
                s[4]= Integer.parseInt(a5.getText().toString());
                s[5]= Integer.parseInt(a6.getText().toString());
                bubbleSort(s);
                a1.setText(s[0]+"");
                a2.setText(s[1]+"");
                a3.setText(s[2]+"");
                a4.setText(s[3]+"");
                a5.setText(s[4]+"");
                a6.setText(s[5]+"");

            }
        });
    }
    public  void bubbleSort(int[]arr){
        int n = arr.length;
        int temp = 0;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(arr[j-1] > arr[j]){
                    //swap elements
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }

            }
        }
    }
}