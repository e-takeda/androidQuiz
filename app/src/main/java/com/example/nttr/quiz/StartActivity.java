package com.example.nttr.quiz;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton startButton ;
    TextView titleTextView ;
    TextView ButtonTextView ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        startButton = (ImageButton) findViewById(R.id.startButton);
        startButton.setOnClickListener(this);
        titleTextView = (TextView) findViewById(R.id.titleTextView);
        ButtonTextView = (TextView) findViewById(R.id.ButtonTextView);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "Condense.otf");

        //startButton.setTypeface(typeface);
        titleTextView.setTypeface(typeface);
        ButtonTextView.setTypeface(typeface);

    }

    //ボタンが押された時の処理
    @Override
    public void onClick(View view){
        //ここに遷移するための処理を追加する
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
