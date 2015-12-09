package com.haydar.rrv;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    RoundRhombusImageView roundRhombusImageView;
    RoundRhombusImageView roundRhombusImageViewa;
    RoundRhombusImageView roundRhombusImageViewb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        roundRhombusImageView = (RoundRhombusImageView) findViewById(R.id.img);
        roundRhombusImageView.setImageBitmap(roundRhombusImageView.processImage(roundRhombusImageView.scanBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.img))));
        roundRhombusImageViewa = (RoundRhombusImageView) findViewById(R.id.imga);
        roundRhombusImageViewa.setImageBitmap(roundRhombusImageViewa.processImage(roundRhombusImageViewa.scanBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.img))));
        roundRhombusImageViewb = (RoundRhombusImageView) findViewById(R.id.imgb);
        roundRhombusImageViewb.setImageBitmap(roundRhombusImageViewb.processImage(roundRhombusImageViewb.scanBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.img))));
    }
}
