package com.john.busquery.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.john.busquery.R;


public class StartActivity extends AppCompatActivity {

    private Handler handler = new Handler();
    private static final long delayMillis = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
                startActivity(new Intent(StartActivity.this, MainActivity.class));
            }
        }, delayMillis);
    }
}
