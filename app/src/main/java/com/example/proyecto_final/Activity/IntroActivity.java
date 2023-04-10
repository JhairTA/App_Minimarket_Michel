package com.example.proyecto_final.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;
import com.example.proyecto_final.R;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TimerTask tarea=new TimerTask() {
            @Override
            public void run() {
                Intent intent=new Intent(IntroActivity.this, Login.class);
                startActivity(intent);
                finish();
            }
        };

        Timer tiempo =new Timer();
        tiempo.schedule(tarea, 3000);
    }
}