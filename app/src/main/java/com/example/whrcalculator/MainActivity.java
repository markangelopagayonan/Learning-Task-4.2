package com.example.whrcalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText edWaist,edHip;
    CardView calcu;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edWaist = findViewById(R.id.edWaist);
        edHip = findViewById(R.id.edHip);

        calcu = findViewById(R.id.calcu);
        ClickListener();
    }
    public void ClickListener(){
        calcu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String waist = edWaist.getText().toString();
                String hip = edHip.getText().toString();



                float ewaist = Float.parseFloat(waist);
                float ehip = Float.parseFloat(hip);



                float whrIndex = ewaist / ehip;

                switch ( whrchecker(whrIndex)) {
                    case 1: {
                        String whr = String.valueOf(whrIndex);
                        Intent High = new Intent(MainActivity.this, HighRisk.class);
                        High.putExtra("high", whr);
                        startActivity(High);
                        break;
                    }
                    case 2: {
                        String whr = String.valueOf(whrIndex);
                        Intent moderate = new Intent(MainActivity.this, ModerateRisk.class);
                        moderate.putExtra("moderate", whr);
                        startActivity(moderate);
                        break;
                    }
                    case 3: {
                        String whr = String.valueOf(whrIndex);
                        Intent low = new Intent(MainActivity.this, LowRisk.class);
                        low.putExtra("low", whr);
                        startActivity(low);
                        break;
                    }

                }
            }

            public int whrchecker (float whrIndex){
                if (whrIndex >= 1) {
                    return 1;
                } else if (whrIndex >= .96) {
                    return 2;
                } else {
                    return 3;
                }
            }

        });

    }
}


