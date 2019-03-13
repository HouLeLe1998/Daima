package com.example.shiday_01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button but1;
    private Button but2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        but1 = findViewById(R.id.but1);
        but2 = findViewById(R.id.but2);
                  but1.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View v){
                          Intent intent = new Intent(MainActivity.this,ShowActivity.class);
                          startActivity(intent);
                      }
                  });
                  but2.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View v) {
                          Intent intent = new Intent(MainActivity.this,ZhuCeActivity.class);
                          startActivity(intent);
                      }
                  });
    }
}
