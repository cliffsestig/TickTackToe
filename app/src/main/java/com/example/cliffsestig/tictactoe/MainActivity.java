package com.example.cliffsestig.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

import static android.R.attr.button;
import static com.example.cliffsestig.tictactoe.R.styleable.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RunAnimation();

        Button btn_play = (Button) findViewById(R.id.btn_play);
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GameController gController = new GameController();

                Intent myIntent = new Intent(MainActivity.this, playActivity.class);
                myIntent.putExtra("player1", gController.player1.getPlayerId());
                myIntent.putExtra("player2", gController.player2.getPlayerId());
                startActivity(myIntent);

            }
        });

        Button btn_about = (Button) findViewById(R.id.btn_about);
        btn_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, aboutActivity.class);
                startActivity(myIntent);

            }
        });

        Button btn_settings = (Button) findViewById(R.id.btn_settings);
        btn_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, settingsActivity.class);
                startActivity(myIntent);
            }
        });
        Button btn_score = (Button) findViewById(R.id.btn_score);
        btn_score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, highscoreActivity.class);
                startActivity(myIntent);
            }
        });
    }
    private void RunAnimation()
    {
        TextView tv = (TextView) findViewById(R.id.txt_title);
        TranslateAnimation cloud_moving = new TranslateAnimation(
                Animation.ABSOLUTE, 200,
                Animation.ABSOLUTE, 10,
                Animation.ABSOLUTE, 0,
                Animation.ABSOLUTE, 0
        );

        cloud_moving.setDuration(2000);
        cloud_moving.setFillAfter(true);
        cloud_moving.setStartOffset(1000);
        cloud_moving.setRepeatCount(Animation.INFINITE);
        cloud_moving.setRepeatMode(Animation.REVERSE);
        tv.startAnimation(cloud_moving);
    }

}
