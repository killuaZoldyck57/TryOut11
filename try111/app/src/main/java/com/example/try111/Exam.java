package com.example.try111;

import java.util.ArrayList;
import java.util.List;

public class Exam {
    private List<Question> lst;
    private int cnt;

    public Exam(){
        lst = new ArrayList<Question>();
        cnt = 0;
    }

    public void add(Question q){
        lst.add(q);
    }

    public List<Question> getQuestionList(){
        return lst;
    }

}