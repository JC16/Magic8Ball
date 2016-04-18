package com.sample.demo.magic8ball;

import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView response;
    private EditText question;
    private Button shakeBtn;
    private ImageView circleView;
    private ImageView img_background = null;
    private ImageView img_ball = null;
    private TextView txt_reply = null;
    private EditText etxt_question = null;
    private Button btn_shake = null;

    protected AlphaAnimation fadeIn = new AlphaAnimation(0.2f , 1.0f ) ;


    private final int[] photos = {R.drawable.circle1, R.drawable.circle2
            , R.drawable.circle3, R.drawable.circle4
            , R.drawable.circle5, R.drawable.circle6};
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_background = new ImageView(this);
        img_ball = new ImageView(this);
        txt_reply = new TextView(this);
        etxt_question = new EditText(this);
        btn_shake = new Button(this);

        //System.out.print("Chen Yi Tai");
        Log.d("MainActivity", "Chen Yi Tai");

        double age = 20;

        Log.d("MainActivity", String.format("%.2f", age));

        System.out.print(String.format("%.2f", age));

        String myName = "Chen Yi Tai";

        System.out.print(myName);


        Log.d("MainActivity", myName);

        ArrayList<String> extraResponse = new ArrayList<>();

        extraResponse.add("Go find the answer by yourselve");
        extraResponse.add("Pay me 10 dollars for the answer");

        final Magic8BallModel mymodel = new Magic8BallModel(extraResponse);

        mymodel.askQuestion("Will I get full marks for this lab");

        mymodel.askQuestion("Will the Cronulla sharks receive a premiership this year");

        mymodel.askQuestion("Will I end up becoming a cat person when I get old");

        mymodel.print();

        mymodel.debugprint();


        response = (TextView) findViewById(R.id.Response);
        question = (EditText) findViewById(R.id.questionText);

        shakeBtn = (Button) findViewById(R.id.shakeBtn);
        circleView = (ImageView) findViewById(R.id.circleImg);

        question.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if((event.getAction() == KeyEvent.ACTION_DOWN)&& (keyCode == KeyEvent.KEYCODE_ENTER))
                {
                    Random rand = new Random();
                    int n = rand.nextInt(6);

                    fadeIn.setDuration(100);
                    fadeIn.setStartOffset(500);
                    fadeIn.setFillAfter(true);

                    response.startAnimation(fadeIn);
                    circleView.startAnimation(fadeIn);

                    response.setText(mymodel.response());

                    circleView.setImageResource(photos[n]);

                    return true;
                }
                return false;
            }
        });


        shakeBtn.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View view) {

                Random rand = new Random();
                int n = rand.nextInt(6);

                fadeIn.setDuration(100);
                fadeIn.setStartOffset(500);
                fadeIn.setFillAfter(true);

                response.startAnimation(fadeIn);
                circleView.startAnimation(fadeIn);


                response.setText(mymodel.response());

                circleView.setImageResource(photos[n]);

            }
        });

    }

}
