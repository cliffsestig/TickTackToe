package com.example.cliffsestig.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class nameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);


        final EditText player1 = (EditText) findViewById(R.id.player1);
        final EditText player2 = (EditText) findViewById(R.id.player2);
        player1.getText();
        Button btn = (Button) findViewById(R.id.start_game);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((!player1.getText().toString().equals("") && !player2.getText().toString().equals("")) && !player1.getText().toString().equals(player2.getText().toString()) ){
                    Intent myIntent = new Intent(nameActivity.this, playActivity.class);
                    myIntent.putExtra("PlayerX", player1.getText().toString());
                    myIntent.putExtra("PlayerO", player2.getText().toString());
                    startActivity(myIntent);
                } else {
                    Toast.makeText(getApplicationContext(), "Please fill in both fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
