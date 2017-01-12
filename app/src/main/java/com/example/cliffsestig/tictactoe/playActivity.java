package com.example.cliffsestig.tictactoe;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class playActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        Intent i = getIntent();
        char player1 = getIntent("player1");
        ArrayList imgView = new ArrayList();
        ImageView img  = (ImageView) findViewById(R.id.imageView);
        ImageView img1 = (ImageView) findViewById(R.id.imageView2);
        ImageView img2 = (ImageView) findViewById(R.id.imageView3);
        ImageView img3 = (ImageView) findViewById(R.id.imageView4);
        ImageView img4 = (ImageView) findViewById(R.id.imageView5);
        ImageView img5 = (ImageView) findViewById(R.id.imageView6);
        ImageView img6 = (ImageView) findViewById(R.id.imageView7);
        ImageView img7 = (ImageView) findViewById(R.id.imageView8);
        ImageView img8 = (ImageView) findViewById(R.id.imageView9);

        imgView.add(img); imgView.add(img1); imgView.add(img2); imgView.add(img3); imgView.add(img4); imgView.add(img5); imgView.add(img6); imgView.add(img7); imgView.add(img8);

        for (int i = 0; i < imgView.size(); i++) {
            ImageView image = (ImageView) imgView.get(i);
            final int j = i;
            final ImageView imgV = image;
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("Onclick", "View" + j);
                    imgV.setImageResource(R.drawable.circle);
                }

            });
        }
    }
}
