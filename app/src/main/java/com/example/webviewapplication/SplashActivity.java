package com.example.webviewapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {
    ProgressBar progressBar;
    int progress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        progressBar=findViewById(R.id.splashProgress);
        getSupportActionBar().hide();
        Thread splashThread = new Thread(){

            @Override
            public void run() {
            for( progress=20;progress<=100;progress+=20){
                try {
                    sleep(500);
                    progressBar.setProgress(progress);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(progress==100){
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    finish();
                }
            }

            }
        };
        splashThread.start();

    }
    }
