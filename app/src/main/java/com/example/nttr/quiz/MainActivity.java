package com.example.nttr.quiz;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


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





    // ① 変数の宣言
    TextView countTextView;
    TextView contentTextView;
    // Buttonの配列
    // ボタンを3つセットで管理したいので、配列で宣言します。
    Button[] optionButtons;


    // 現在の問題番号
    int questionNumber;
    // 獲得したポイント数
    int point;
    // Listという、配列よりもデータを追加しやすい型を使います。
    List<Quiz> quizList;

    ImageView contentImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ② 初期化処理

        // Viewの関連付けを行います
        countTextView = findViewById(R.id.countTextView);
        contentTextView = findViewById(R.id.contentTextView);
        contentImageView = findViewById(R.id.contentImageView);
        contentImageView.setImageResource(R.drawable.nasu);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "Condense.otf");

        countTextView.setTypeface(typeface);
        contentTextView.setTypeface(typeface);

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

        imageView1.setVisibility(View.INVISIBLE);
        imageView2.setVisibility(View.INVISIBLE);
        imageView3.setVisibility(View.INVISIBLE);
        imageView4.setVisibility(View.INVISIBLE);
        imageView5.setVisibility(View.INVISIBLE);
        imageView6.setVisibility(View.INVISIBLE);
        imageView7.setVisibility(View.INVISIBLE);
        imageView8.setVisibility(View.INVISIBLE);
        imageView9.setVisibility(View.INVISIBLE);
        imageView10.setVisibility(View.INVISIBLE);




        // 配列を初期化します
        // 今回、ボタンは3つなので、3の大きさの配列を用意します
        optionButtons = new Button[3];
        optionButtons[0] = findViewById(R.id.optionButton1);
        optionButtons[1] = findViewById(R.id.optionButton2);
        optionButtons[2] = findViewById(R.id.optionButton3);
        for(Button button : optionButtons) {
            // レイアウトではなくコードからonClickを設定します
            // setOnClickListenerに、thisを入れて呼び出します
            button.setOnClickListener(this);
        }

        // Quizを1から始めるのでリセットする
        resetQuiz();
    }

    void createQuizList() {
        Quiz quiz1 = new Quiz("英語でありがとうは？", "カムーン", "サンキュー", "メルシー", "サンキュー", "image1");
        Quiz quiz2 = new Quiz("日本語でありがとうは？", "サンキュー", "アリガトウ", "シュクラン", "アリガトウ", "image2");
        Quiz quiz3 = new Quiz("アイヌ語でありがとうは？", "ニフェーデービル", "イヤイライケレ", "テシェキュラ", "イヤイライケレ", "image3");
        Quiz quiz4 = new Quiz("中国語でありがとうは？", "シエシェ", "ニーハオ", "タック", "シエシェ", "image4");
        Quiz quiz5 = new Quiz("韓国語でありがとうは？", "カムサハムニダ", "シエシェ", "カムーン", "カムサハムニダ", "image5");
        Quiz quiz6 = new Quiz("タイ語でありがとうは？", "ナンドゥリ", "オークン", "コープンカ～", "コープンカ～", "image6");
        Quiz quiz7 = new Quiz("ベトナム語でありがとうは？", "カムーン", "メルシー", "バイラルラー", "カムーン", "image7");
        Quiz quiz8 = new Quiz("インドネシア語でありがとうは？", "ドンノバッド", "コープンカ～", "トゥリマカシー", "トゥリマカシー", "image8");
        Quiz quiz9 = new Quiz("ヒンディー語でありがとうは？", "カムーン", "ダンニャバードー", "グラツィエ", "ダンニャバードー", "image9");
        Quiz quiz10 = new Quiz("アラビア語でありがとうは？", "シュクラン", "ダンニャバード", "サラマット", "シュクラン", "image10");
        Quiz quiz11 = new Quiz("トルコ語でありがとうは？", "テシェキュラ", "イヤイライケレ", "ダンク・ユー", "テシェキュラ", "image11");
        Quiz quiz12 = new Quiz("ロシア語でありがとうは？", "ドンノバッド", "カムーン", "スパシーバ", "スパシーバ", "image12");
        Quiz quiz13 = new Quiz("イタリア語でありがとうは？", "カムサハムニダ", "グラツィエ", "オブリガードー", "グラツィエ", "image13");
        Quiz quiz14 = new Quiz("フランス語でありがとうは？", "メルシー", "ダンケ", "シュクラン", "メルシー", "image14");
        Quiz quiz15 = new Quiz("スペイン語でありがとうは？", "カムーン", "グラスィアス", "グラツィエ", "グラスィアス", "image15");
        Quiz quiz16 = new Quiz("ポルトガル語でありがとうは？", "オブリガードー", "ダンケ", "イヤイライケレ", "オブリガードー", "image16");
        Quiz quiz17 = new Quiz("フィンランド語でありがとうは？", "シエシェ", "カムーン", "キートス", "キートス", "image17");
        Quiz quiz18 = new Quiz("スワヒリ語でありがとうは？", "カムサハムニダ", "ドンノバッド", "アサンテ", "アサンテ", "image18");
        Quiz quiz19 = new Quiz("オランダ語でありがとうは？", "メルシー", "ダンク・ユー", "コープンカ～", "ダンク・ユー", "image19");
        Quiz quiz20 = new Quiz("スウェーデン語でありがとうは？", "タック", "グラスィアス", "スパシーバ", "タック", "image20");
        Quiz quiz21 = new Quiz("タガログ語でありがとうは？", "オブリガードー", "サラマット", "トゥリマカシー", "サラマット", "image21");
        Quiz quiz22 = new Quiz("琉球語でありがとうは？", "ニフェーデービル", "サラマット", "トゥリマカシー", "ニフェーデービル", "image22");
        // Listを実装したArrayListというものを使います
        quizList = new ArrayList<>();

        quizList.add(quiz1);
        quizList.add(quiz2);
        quizList.add(quiz3);
        quizList.add(quiz4);
        quizList.add(quiz5);
        quizList.add(quiz6);
        quizList.add(quiz7);
        quizList.add(quiz8);
        quizList.add(quiz9);
        quizList.add(quiz10);
        quizList.add(quiz11);
        quizList.add(quiz12);
        quizList.add(quiz13);
        quizList.add(quiz14);
        quizList.add(quiz15);
        quizList.add(quiz16);
        quizList.add(quiz17);
        quizList.add(quiz18);
        quizList.add(quiz19);
        quizList.add(quiz20);
        quizList.add(quiz21);
        quizList.add(quiz22);

        // Listの中身をシャッフルします
        Collections.shuffle(quizList);
    }
    // ④ クイズを表示します
    void showQuiz() {
        countTextView.setText((questionNumber + 1) + "問目");
        // 表示する問題をリストから取得します。
        // 配列では[番号]でしたが、リストでは get(番号)で取得します。配列と同じく0からスタートです。
        Quiz quiz = quizList.get(questionNumber);
        contentTextView.setText(quiz.content);
        optionButtons[0].setText(quiz.option1);
        optionButtons[1].setText(quiz.option2);
        optionButtons[2].setText(quiz.option3);

        int imageId = getResources().getIdentifier(quiz.image, "drawable", getPackageName());
        Log.d("image",quiz.image);

        contentImageView.setImageResource(imageId);

        if (point == 1 ){
            imageView1.setVisibility(View.VISIBLE);
        } else if (point == 2){
            imageView2.setVisibility(View.VISIBLE);
        } else if (point == 3){
            imageView3.setVisibility(View.VISIBLE);
        } else if (point == 4){
            imageView4.setVisibility(View.VISIBLE);
        } else if (point == 5){
            imageView5.setVisibility(View.VISIBLE);
        } else if (point == 6){
            imageView6.setVisibility(View.VISIBLE);
        } else if (point == 7){
            imageView7.setVisibility(View.VISIBLE);
        } else if (point == 8){
            imageView8.setVisibility(View.VISIBLE);
        } else if (point == 9){
            imageView9.setVisibility(View.VISIBLE);
        } else if (point == 10){
            imageView10.setVisibility(View.VISIBLE);
        }



    }
    // ⑤ クイズのリセット
    void resetQuiz() {
        questionNumber = 0;
        point = 0;
        createQuizList();
        showQuiz();
    }
    // ⑥ クイズのアップデート
    void updateQuiz() {
        questionNumber++;
        if (questionNumber < 10) {
            showQuiz();
        } else {
            // 全ての問題を解いてしまったので、結果を表示します。
            // 結果表示にはDialogを使います。
//            AlertDialog.Builder builder = new AlertDialog.Builder(this);
//            builder.setTitle("結果");
//            builder.setMessage(quizList.size() + "問中、" + point + "問正解でした。");
//            builder.setPositiveButton("リトライ", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    // もう一度クイズをやり直す
//                    resetQuiz();
//                }
//            });
//            builder.show();

            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("point", point);
            startActivity(intent);


        }
    }


    // ⑦ setOnClickListerを呼び出したViewをクリックした時に呼び出されるメソッド
    @Override
    public void onClick(View view) {
        // 引数のViewには、押されたViewが入っています。
        // Buttonが押された時しかよばれないので、キャストといって型を示してあげます。
        Button clickedButton = (Button) view;
        Quiz quiz = quizList.get(questionNumber);
        // ボタンの文字と、答えが同じかチェックします。
        if (TextUtils.equals(clickedButton.getText(), quiz.answer)) {
            // 正解の場合だけ1ポイント加算します。
            point++;
            Toast.makeText(this, "正解!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, quiz.answer+"だよ!", Toast.LENGTH_SHORT).show();
        }
        // 次の問題にアップデートします。
        updateQuiz();
    }








}
