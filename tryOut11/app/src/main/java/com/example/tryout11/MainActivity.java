package com.example.tryout11;

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
     int sum ;
    Button send ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the RadioButtons
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);

        // Initialize the Button
        send = findViewById(R.id.Send);

        // Create the Intent for MainActivity2
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);

        // Set the onClick listener
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum = 0;

                // Check the state of each RadioButton and calculate the score
                sum += checkQ(b1);
                sum += checkQ(b2);
                sum += checkQ(b3);
                sum += checkQ(b4);

                // Pass the calculated score to the next activity
                intent.putExtra("grade", sum);
                startActivity(intent);
            }
        });
    }

    // Method to check if a RadioButton is selected and assign score
    public static int checkQ(RadioButton r) {
        if (r.isChecked())
            return 25 ;
        return 0 ;
    }
}