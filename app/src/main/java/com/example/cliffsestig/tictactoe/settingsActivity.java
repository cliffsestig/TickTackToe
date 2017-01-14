package com.example.cliffsestig.tictactoe;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class settingsActivity extends AppCompatActivity {

    private RadioButton radioButton;
    private Context con = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        final Level timer = new Level(con);
        final RadioGroup rb_group = (RadioGroup) findViewById(R.id.radiogroup);

        for(int i = 0; i < rb_group.getChildCount(); i ++)
        {
            RadioButton radioButton =  (RadioButton)rb_group.getChildAt(i);
            if (radioButton.getText().equals(timer.getTimer())){
                radioButton.setChecked(true);
            }
        }

        Button btn_save = (Button) findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(settingsActivity.this)
                        .setTitle("SAVE")
                        .setMessage("Do you really want to save the settings?")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {

                                int selectedId = rb_group.getCheckedRadioButtonId();
                                radioButton = (RadioButton) findViewById(selectedId);


                                timer.setTimer((String) radioButton.getText());
                            }
                        })
                        .setNegativeButton("NO", null).show();
            }
        });
    }
}