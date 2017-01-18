package com.example.cliffsestig.tictactoe;

import android.content.Intent;
import android.media.Image;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.id.input;

public class playActivity extends AppCompatActivity {
public TextView txt_time;
    private final GameController gControl = new GameController();
    private CountDownTimer count;
    private int turnCounter = 0;
    private ArrayList<String> players;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        Intent intent = getIntent();

        String playerX = intent.getStringExtra("PlayerX");
        String playerO = intent.getStringExtra("PlayerO");


        gControl.createPlayers(playerX, playerO);

        txt_time = (TextView) findViewById(R.id.txt_time);

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

        for (int c = 0; c < imgView.size(); c++) {
            ImageView image = (ImageView) imgView.get(c);
            final int j = c;
            final ImageView imgV = image;

            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String turn = gControl.checkTurn();
                    turnCounter++;
                    boolean gs = gControl.checkGameState(j, turn);
                    if (turn == "player1") {
                        imgV.setImageResource(R.drawable.circle);
                    } else {
                        imgV.setImageResource(R.drawable.x);
                    }

                    if (gs || turnCounter == 9){
                        ArrayList<String> players = gControl.getPlayersName();
                        players.get(0);
                        Log.d("Players",players.get(0));
                        Intent intent = new Intent(playActivity.this, endGameActivity.class);
                        intent.putExtra("Result", gControl.getResult());
                        intent.putExtra("PlayerX", players.get(0));
                        intent.putExtra("PlayerO", players.get(1));
                        startActivity(intent);
                    }

                    timer(gControl);
                    imgV.setOnClickListener(null);

                }

            });
            timer(gControl);
        }
    }
    public void timer(final GameController gcont)
    {
        if (count != null) {
            count.cancel();
        }
        Level lv = new Level(getApplicationContext());
        int time = Integer.parseInt(lv.getTimer().replace(" sec", ""));
        time = (time + 1) * 1000;

       count = new CountDownTimer(time, 1000) {
            public void onTick(final long millisUntilFinished) {
                    txt_time.setText(millisUntilFinished / 1000 + "");
            }
            public void onFinish() {

                txt_time.setText("0");
                String win;
                if(gcont.checkTurn().equals("player1")){win = gcont.getPlayersName().get(1); }
                else{win = gcont.getPlayersName().get(0);}

                Intent intent = new Intent(playActivity.this, endGameActivity.class);
                intent.putExtra("Result", win);
                intent.putExtra("PlayerX", gcont.getPlayersName().get(0));
                intent.putExtra("PlayerO", gcont.getPlayersName().get(1));
                startActivity(intent);
            }
        };
        count.start();
        if (gControl.getWinner() || turnCounter == 9){
            count.cancel();
            Log.d("Cancel", "aub");
        }
    }
}
