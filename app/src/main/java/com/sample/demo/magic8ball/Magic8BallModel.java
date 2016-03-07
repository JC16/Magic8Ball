package com.sample.demo.magic8ball;


import java.util.ArrayList;
import java.util.Random;

/**
 * Created by ChenYiTai on 3/7/16.
 */
public class Magic8BallModel extends Object {

    private ArrayList<String>initialResponseArray;
    private ArrayList<String>responseArray;

    Magic8BallModel()
    {
        initialResponseArray = new ArrayList<>();

        initialResponseArray.add("YES");
        initialResponseArray.add("NO");
        initialResponseArray.add("Maybe");
        initialResponseArray.add("Maybe not");
        initialResponseArray.add("I don't know");
        initialResponseArray.add("Don't ask me");
        initialResponseArray.add("No idea");

        responseArray = new ArrayList<>();

        responseArray.addAll(initialResponseArray);


    }

    Magic8BallModel(ArrayList<String>extraResponse)
    {
        initialResponseArray = new ArrayList<>();

        initialResponseArray.add("YES");
        initialResponseArray.add("NO");
        initialResponseArray.add("Maybe");
        initialResponseArray.add("Maybe not");
        initialResponseArray.add("I don't know");
        initialResponseArray.add("Don't ask me");
        initialResponseArray.add("No idea");

        initialResponseArray.addAll(extraResponse);

        responseArray = new ArrayList<>();

        responseArray.addAll(initialResponseArray);

    }

    public void askQuestion(String question)
    {
        System.out.println(question);

        Random rand = new Random();

        int n = rand.nextInt(responseArray.size());

        System.out.println(responseArray.get(n));
    }

}
