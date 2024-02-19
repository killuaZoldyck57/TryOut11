package com.example.quadraticsolver;



import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    private Button solveBtn ;
    private EditText a ;
    private EditText b ;
    private EditText c ;
    private TextView sol1 ;
    private TextView sol2 ;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        solveBtn = findViewById(R.id.btn);
        solveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = findViewById(R.id.a);
                b = findViewById(R.id.b);
                c = findViewById(R.id.c);
                sol1 = findViewById(R.id.sol1);
                sol2 = findViewById(R.id.sol2);
                int a1 = Integer.parseInt(a.getText().toString());
                int b1 = Integer.parseInt(b.getText().toString());
                int c1 = Integer.parseInt(c.getText().toString());
                double x1  =0 ;
                double x2 = 0 ;
                if((Math.pow(b1 ,2)-4*a1*c1)<0) {
                    sol1.setText("No Solutions");
                    sol2.setText("");
                }
                else{
                    x1 = ((-b1 + (Math.sqrt(Math.pow(b1 ,2)-4*a1*c1)))/(2*a1) );
                    x2 =  ((-b1 - (Math.sqrt(Math.pow(b1 ,2)-4*a1*c1)))/(2*a1) );
                    if(x1==x2)
                        sol1.setText("x1: "+x1);
                    else {
                        sol1.setText( "x1: "+x1 + "");
                        sol2.setText("x2: "+x2 + "");
                    }
                }


            }
        });
    }
}