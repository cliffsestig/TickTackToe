package com.example.cliffsestig.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RunAnimation();
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
