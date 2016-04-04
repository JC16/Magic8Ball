package com.sample.demo.magic8ball;


import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by ChenYiTai on 3/7/16.
 */
public class Magic8BallModel extends Object {

    private ArrayList<String>initialResponseArray;
    private ArrayList<String>responseArray;


    private String description;
    private String debugDescription;

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

        StringBuffer sb = new StringBuffer();

        sb.append(Character.toChars(127467));
        sb.append(Character.toChars(127479));

        System.out.print(sb);

        initialResponseArray.addAll(extraResponse);

        responseArray = new ArrayList<>();

        responseArray.addAll(initialResponseArray);

    }

    public void askQuestion(String question)
    {
        Log.d("MainActivity",question);

        //System.out.println(question);

        Random rand = new Random();

        int n = rand.nextInt(responseArray.size());

        //System.out.println(responseArray.get(n));

        Log.d("MainActivity", responseArray.get(n));

    }

    public void print()
    {
        description = "";

        for(int i=0; i<responseArray.size(); i++)
        {
            description += responseArray.get(i);
        }

        Log.d("MainActivity", description);

    }

    public void debugprint()
    {
        debugDescription = "Debug: ";

        for(int i=0; i<responseArray.size(); i++)
        {
            debugDescription += responseArray.get(i);
        }

        Log.d("MainActivity", debugDescription);
    }

    public String response()
    {

        Random rand = new Random();

        int n = rand.nextInt(responseArray.size());

        return responseArray.get(n);
    }


}
