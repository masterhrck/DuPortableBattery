package com.example.martin.duportablebatteries;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class displayData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle extras = getIntent().getExtras();
        String id = extras.getString("id");
        String percent = extras.getString("percent");
        String state = extras.getString("state");
        String posX = extras.getString("posX");
        String posY = extras.getString("posY");
        String time = extras.getString("time");



        TextView textId = (TextView) this.findViewById(R.id.textId);
        TextView textPercent = (TextView) this.findViewById(R.id.textPercent);
        TextView textState = (TextView) this.findViewById(R.id.textState);
        TextView textTime = (TextView) this.findViewById(R.id.textTime);

        textId.setText(id);
        textPercent.setText(percent);
        textState.setText(state);
        textTime.setText(time);

    }

}
