package com.example.tt1;



import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends Activity {
    RadioButton b1 ;
    RadioButton b2 ;
    RadioButton b3 ;
    RadioButton b4 ;
    static int sum ;
    Button send ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(MainActivity.this , MainActivity2.class) ;
        intent.putExtra("grade" , sum) ;
        send = findViewById(R.id.Send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        checkQ(b1);
        checkQ(b2);
        checkQ(b3);
        checkQ(b4);

    }
    public static void checkQ (RadioButton r){
        if(r.isChecked())
            sum+= 25 ;

    }
}