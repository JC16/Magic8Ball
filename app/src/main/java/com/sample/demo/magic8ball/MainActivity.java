package com.sample.demo.magic8ball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.print("Chen Yi Tai");

        double age = 20;

        System.out.print(String.format("%.2f", age));

        String myName = "Chen Yi Tai";

        System.out.print(myName);

        ArrayList<String> extraResponse = new ArrayList<>();

        extraResponse.add("Go find the answer by yourselve");
        extraResponse.add("Pay me 10 dollars for the answer");

        Magic8BallModel mymodel = new Magic8BallModel(extraResponse);

        mymodel.askQuestion("Will I get full marks for this lab");

    }
}
