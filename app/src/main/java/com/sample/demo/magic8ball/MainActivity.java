package com.sample.demo.magic8ball;

import android.content.Context;
import android.content.Intent;
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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

    private ArrayList<QuestionResponseModel> qrArray;

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

        ArrayList<QuestionResponseModel> loaded = loadQA();
        if (loaded != null) {
            this.qrArray = loaded;
        } else {
            this.qrArray = new ArrayList<QuestionResponseModel>();
        }


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

                    QuestionResponseModel qa = new QuestionResponseModel(question.getText().toString(), response.getText().toString());
                   //save question response
                    qrArray.add(qa);
                    saveQA(qrArray);


                    return true;
                }
                return false;
            }
        });


        shakeBtn.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
                intent.putExtra("historyArray", qrArray);
                startActivity(intent);

            }
        });

    }

    public ArrayList<QuestionResponseModel> loadQA(){
        try {
            FileInputStream fis = openFileInput("qrHistory.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<QuestionResponseModel> o = (ArrayList<QuestionResponseModel>)ois.readObject();
            return o;
        } catch (Exception ex) {
            //Log.v("Question Response History Load", ex.getMessage());
            ex.printStackTrace();
        }return null;


    }
        public void saveQA(ArrayList<QuestionResponseModel> qrArray) {
        try {

            String f = "qrHistory.bin";
            //String string =
            FileOutputStream fos = openFileOutput(f, Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos); //Select where you wish to save the file...
            oos.writeObject(qrArray); // write the class as an 'object'
            oos.flush(); // flush the stream to insure all of the information was written to 'qrHistory.bin'
            oos.close();// close the stream
        } catch (Exception ex) {
            //Log.v("Question Response History Save", ex.getMessage());
            ex.printStackTrace();
        }
    }

}
