package com.example.nttr.quiz;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {


    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView imageView10;

    Button backButton;
    TextView textView2;
    TextView textView;
    //ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(this);

        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);


        Typeface typeface = Typeface.createFromAsset(getAssets(), "Condense.otf");

        textView.setTypeface(typeface);
        textView2.setTypeface(typeface);

        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        imageView5 = (ImageView) findViewById(R.id.imageView5);
        imageView6 = (ImageView) findViewById(R.id.imageView6);
        imageView7 = (ImageView) findViewById(R.id.imageView7);
        imageView8 = (ImageView) findViewById(R.id.imageView8);
        imageView9 = (ImageView) findViewById(R.id.imageView9);
        imageView10 = (ImageView) findViewById(R.id.imageView10);





        //imageView = (ImageView) findViewById(R.id.imageView);


        // インテントを取得
        Intent intent = getIntent();
        // インテントに保存されたデータを取得
        int data = intent.getIntExtra("point",0);
        String dataString = String.valueOf(data);
        Log.d("data",dataString);


        if (data == 0 ) {

            textView2.setText("残念");
            textView.setText("全問不正解");
        } else if (data == 1 ) {
            textView2.setText("残念");
            textView.setText("10問中" + dataString + "問正解");
            imageView1.setImageResource(R.drawable.heartonline);
        } else if (data == 2 ) {
            textView2.setText("残念");
            textView.setText("10問中" + dataString + "問正解");
            imageView1.setImageResource(R.drawable.heartonline);
            imageView2.setImageResource(R.drawable.heartonline);
        } else if (data == 3 ) {
            textView2.setText("残念");
            textView.setText("10問中" + dataString + "問正解");
            imageView1.setImageResource(R.drawable.heartonline);
            imageView2.setImageResource(R.drawable.heartonline);
            imageView3.setImageResource(R.drawable.heartonline);
        } else if (data == 4) {
            textView2.setText("残念");
            textView.setText("10問中" + dataString + "問正解");
            imageView1.setImageResource(R.drawable.heartonline);
            imageView2.setImageResource(R.drawable.heartonline);
            imageView3.setImageResource(R.drawable.heartonline);
            imageView4.setImageResource(R.drawable.heartonline);
        } else if (data ==  5) {
            textView2.setText("まあまあ!");
            textView.setText("10問中" + dataString + "問正解！！");
            imageView1.setImageResource(R.drawable.heartonline);
            imageView2.setImageResource(R.drawable.heartonline);
            imageView3.setImageResource(R.drawable.heartonline);
            imageView4.setImageResource(R.drawable.heartonline);
            imageView5.setImageResource(R.drawable.heartonline);
        } else if (data ==  6) {
            textView2.setText("まあまあ!");
            textView.setText("10問中" + dataString + "問正解！！");
            imageView1.setImageResource(R.drawable.heartonline);
            imageView2.setImageResource(R.drawable.heartonline);
            imageView3.setImageResource(R.drawable.heartonline);
            imageView4.setImageResource(R.drawable.heartonline);
            imageView5.setImageResource(R.drawable.heartonline);
            imageView6.setImageResource(R.drawable.heartonline);
        } else if (data ==  7) {
            textView2.setText("もう少し!");
            textView.setText("10問中" + dataString + "問正解！！");
            imageView1.setImageResource(R.drawable.heartonline);
            imageView2.setImageResource(R.drawable.heartonline);
            imageView3.setImageResource(R.drawable.heartonline);
            imageView4.setImageResource(R.drawable.heartonline);
            imageView5.setImageResource(R.drawable.heartonline);
            imageView6.setImageResource(R.drawable.heartonline);
            imageView7.setImageResource(R.drawable.heartonline);
        } else if (data ==  8) {
            textView2.setText("もう少し!");
            textView.setText("10問中" + dataString + "問正解！！");
            imageView1.setImageResource(R.drawable.heartonline);
            imageView2.setImageResource(R.drawable.heartonline);
            imageView3.setImageResource(R.drawable.heartonline);
            imageView4.setImageResource(R.drawable.heartonline);
            imageView5.setImageResource(R.drawable.heartonline);
            imageView6.setImageResource(R.drawable.heartonline);
            imageView7.setImageResource(R.drawable.heartonline);
            imageView8.setImageResource(R.drawable.heartonline);
        } else if (data ==  9) {
            textView2.setText("惜しい!");
            textView.setText("10問中" + dataString + "問正解！！");
            imageView1.setImageResource(R.drawable.heartonline);
            imageView2.setImageResource(R.drawable.heartonline);
            imageView3.setImageResource(R.drawable.heartonline);
            imageView4.setImageResource(R.drawable.heartonline);
            imageView5.setImageResource(R.drawable.heartonline);
            imageView6.setImageResource(R.drawable.heartonline);
            imageView7.setImageResource(R.drawable.heartonline);
            imageView8.setImageResource(R.drawable.heartonline);
            imageView9.setImageResource(R.drawable.heartonline);
        } else if(data == 10) {
            textView2.setText("完璧");
            textView.setText("全問正解！！");
            imageView1.setImageResource(R.drawable.heartonline);
            imageView2.setImageResource(R.drawable.heartonline);
            imageView3.setImageResource(R.drawable.heartonline);
            imageView4.setImageResource(R.drawable.heartonline);
            imageView5.setImageResource(R.drawable.heartonline);
            imageView6.setImageResource(R.drawable.heartonline);
            imageView7.setImageResource(R.drawable.heartonline);
            imageView8.setImageResource(R.drawable.heartonline);
            imageView9.setImageResource(R.drawable.heartonline);
            imageView10.setImageResource(R.drawable.heartonline);
        }









    }

    @Override
    public void onClick(View view){
        //ここに遷移するための処理を追加する
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
    }






}
