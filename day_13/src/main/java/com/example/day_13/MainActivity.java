package com.example.day_13;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends BesaACtivit {

    private Button but;

    @Override
    protected void intView() {
        but = find(R.id.but);
    }

    @Override
    protected void intDate() {
               but.setText("点击");
               but.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Toast.makeText(MainActivity.this,"点击",Toast.LENGTH_SHORT).show();
                   }
               });
    }

    @Override
    protected int initlayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onClick(View v) {

    }
}
