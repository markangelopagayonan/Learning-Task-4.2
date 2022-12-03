package com.example.whrcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ModerateRisk extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moderate_risk);
        final TextView textViewToChange = (TextView) findViewById(R.id.normalvalue);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("normal");
            textViewToChange.setText(value);
        }
        Button btn = findViewById(R.id.backbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mainactivity = new Intent(ModerateRisk.this, MainActivity.class);
                startActivity(mainactivity);
            }
        });
    }
}

