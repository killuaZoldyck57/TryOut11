package com.example.try111;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends Activity {
    LinearLayout linearLayout;
    Button sendBtn;
    Exam exam;
    int totalScore = 0;  // Variable to store total marks

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buildExam();
        linearLayout = findViewById(R.id.examLinearLayout);

        List<Question> questions = exam.getQuestionList();
        for (int i = 0; i < questions.size(); i++) {
            linearLayout.addView(createQuestion(questions.get(i), i));
        }

        sendBtn = new Button(this);
        sendBtn.setText("Submit");
        sendBtn.setTextSize(20);
        linearLayout.addView(sendBtn);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalScore = 0;  // Reset score before checking answers
                for (int i = 0; i < linearLayout.getChildCount(); i++) {
                    View view = linearLayout.getChildAt(i);
                    if (view instanceof LinearLayout) {
                        RadioGroup rg = (RadioGroup) ((LinearLayout) view).getChildAt(1);
                        int selectedId = rg.getCheckedRadioButtonId();

                        Question question = exam.getQuestionList().get(i);
                        int correctAnswerIndex = question.getCurrectAnswer();  // Fixed method name

                        if (selectedId != -1) {  // If any option is selected
                            RadioButton selectedRadioButton = (RadioButton) findViewById(selectedId);
                            int selectedIndex = rg.indexOfChild(selectedRadioButton);

                            // Check if the selected answer is correct
                            if (selectedIndex == correctAnswerIndex - 1) {  // Adjusting to 0-based index
                                totalScore += 25;
                            }
                        }
                    }
                }

                // Pass the totalScore to MainActivity2 using an Intent
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("totalScore", totalScore);  // Correct use of putExtra
                startActivity(intent);
            }
        });
    }

    public void buildExam() {
        exam = new Exam();
        Question q = new Question("Q1: Where would you be if you were standing on the Spanish Steps?", "Tokyo", "Paris", "Madrid", "Rome", 4);
        exam.add(q);
        q = new Question("Q2: Which country has the most islands?", "Sweden", "Italy", "Russia", "United Kingdom", 1);
        exam.add(q);
        q = new Question("Q3: How many stars are on the Chinese flag?", "15", "10", "5", "2", 3);
        exam.add(q);
        q = new Question("Q4: In what country is the Chernobyl nuclear plant located?", "Russia", "Ukraine", "Spain", "India", 2);
        exam.add(q);
    }

    public LinearLayout createQuestion(Question q, int index) {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setBackgroundColor(0xFFCED8DD);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(50, 40, 50, 0);
        linearLayout.setLayoutParams(layoutParams);

        linearLayout.setOrientation(LinearLayout.VERTICAL);
        TextView tv = new TextView(this);
        tv.setTextSize(15);
        tv.setText(q.getQuestion());
        linearLayout.addView(tv);

        RadioGroup rg = new RadioGroup(this);
        rg.setOrientation(LinearLayout.VERTICAL);

        RadioButton rb = new RadioButton(this);
        rb.setText(q.getOption1());
        rb.setTextSize(20);
        rg.addView(rb);

        RadioButton rb1 = new RadioButton(this);
        rb1.setText(q.getOption2());
        rb1.setTextSize(20);
        rg.addView(rb1);

        RadioButton rb2 = new RadioButton(this);
        rb2.setText(q.getOption3());
        rb2.setTextSize(20);
        rg.addView(rb2);

        RadioButton rb3 = new RadioButton(this);
        rb3.setText(q.getOption4());
        rb3.setTextSize(20);
        rg.addView(rb3);

        rg.setLayoutParams(layoutParams);
        linearLayout.addView(rg);

        return linearLayout;
    }
}
