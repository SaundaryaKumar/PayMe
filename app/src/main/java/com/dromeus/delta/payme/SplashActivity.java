package com.dromeus.delta.payme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splashIntent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(splashIntent);
                finish();
            }
            }, 1000);

        }
    }

