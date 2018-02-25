package com.example.android.amaliaintansafura_1202150248_modul3;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class SplashScreen extends AppCompatActivity {

    private static int splashInterval = 3000; //timer jangka wktu splashscreen

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() { //menjalankan splashscreen
                //untuk pindah ke halaman login saat splashscreen selesai
                Intent a = new Intent(SplashScreen.this, login_activity.class);
                startActivity(a); //ekseskusi splashscreen

                this.finish();
            }
            //untuk activity selesai
            private void finish() {

            }
            //timer/waktu disaat splashscreen selesai
        }, splashInterval);
    }
    ;
    }
