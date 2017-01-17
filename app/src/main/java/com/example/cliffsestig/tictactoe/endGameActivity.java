package com.example.cliffsestig.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class endGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);
        Intent intent = getIntent();

        String result = intent.getStringExtra("Result");
        TextView txt = (TextView) findViewById(R.id.textView);
        final String playerX = intent.getStringExtra("PlayerX");
        final String playerO = intent.getStringExtra("PlayerO");
        txt.setText(result);

        Button btn = (Button) findViewById(R.id.btn_play);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(endGameActivity.this, playActivity.class);
                myIntent.putExtra("PlayerX", playerX);
                myIntent.putExtra("PlayerO", playerO);
                startActivity(myIntent);
            }
        });
    }
}
