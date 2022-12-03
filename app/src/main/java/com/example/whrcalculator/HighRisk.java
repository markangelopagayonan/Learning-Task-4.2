package com.example.whrcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HighRisk extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.high_risk);
        final TextView textViewToChange = (TextView) findViewById(R.id.highriskvalue);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("highrisk");
            textViewToChange.setText(value);
        }
        Button btn = findViewById(R.id.backbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mainactivity = new Intent(HighRisk.this, MainActivity.class);
                startActivity(mainactivity);
            }
        });
    }
}
