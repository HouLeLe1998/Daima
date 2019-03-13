package com.example.shiday_01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ZhuCeActivity extends AppCompatActivity {

    private Button but1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu_ce);
        but1 = findViewById(R.id.but1);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ZhuCeActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
