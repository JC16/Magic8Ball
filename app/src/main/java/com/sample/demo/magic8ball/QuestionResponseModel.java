package com.sample.demo.magic8ball;

import java.io.Serializable;

/**
 * Created by ChenYiTai on 4/18/16.
 */
public class QuestionResponseModel implements Serializable {
    private String question;
    private String response;
    private static final long serialVersionUID = 0L;


    public QuestionResponseModel(String question, String response) {
        this.question = question;
        this.response = response;
    }

    public String getQuestion(){
        return this.question;
    }

    public String getResponse(){
        return this.response;
    }
}
