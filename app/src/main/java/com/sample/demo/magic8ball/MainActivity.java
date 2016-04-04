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

        RelativeLayout layout_main = new RelativeLayout(this);
        RelativeLayout layout_middle = new RelativeLayout(this);

        img_background = new ImageView(this);
        img_ball = new ImageView(this);
        txt_reply = new TextView(this);
        etxt_question = new EditText(this);
        btn_shake = new Button(this);

        RelativeLayout.LayoutParams param_main = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        layout_main.setBackgroundResource(R.drawable.background);

        RelativeLayout.LayoutParams param_img_ball = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        img_ball.setImageResource(R.drawable.circle1);
        layout_middle.addView(img_ball, param_img_ball);

        RelativeLayout.LayoutParams param_txt = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        param_txt.addRule(RelativeLayout.CENTER_VERTICAL);
        param_txt.addRule(RelativeLayout.CENTER_HORIZONTAL);
        txt_reply.setText(R.string.reply);
        layout_middle.addView(txt_reply, param_txt);

        RelativeLayout.LayoutParams param_etxt = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        param_etxt.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        param_etxt.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        param_etxt.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        etxt_question.setHint(R.string.question);
        etxt_question.setImeOptions(EditorInfo.IME_ACTION_GO);
        etxt_question.setInputType(EditorInfo.TYPE_CLASS_TEXT);
        layout_main.addView(etxt_question, param_etxt);

        RelativeLayout.LayoutParams param_btn = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, 80);
        param_btn.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        param_btn.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        param_btn.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        btn_shake.setText(R.string.shake);
        btn_shake.setBackgroundResource(R.drawable.shakebutton);
        layout_main.addView(btn_shake, param_btn);

        RelativeLayout.LayoutParams param_middle = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        param_middle.addRule(RelativeLayout.ABOVE, btn_shake.getId());
        param_middle.addRule(RelativeLayout.BELOW, etxt_question.getId());
        layout_main.addView(layout_middle);

        setContentView(layout_main, param_main);







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
