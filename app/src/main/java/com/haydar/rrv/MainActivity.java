package com.haydar.rrv;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    RoundRhombusImageView roundRhombusImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        roundRhombusImageView = (RoundRhombusImageView) findViewById(R.id.img);
        roundRhombusImageView.setRound(50);
        roundRhombusImageView.setImageBitmap(roundRhombusImageView.processImage(BitmapFactory.decodeResource(getResources(), R.drawable.img)));
    }
}
