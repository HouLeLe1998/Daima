package com.example.Frag;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.bace.BaseFragment;
import com.example.day_12_02.R;

public class Frag_01 extends BaseFragment {

    private Button button;

    @Override
    public int initLayout() {
        return R.layout.frag_01;
    }

    @Override
    public void initDate() {
          button.setText("点我");
          button.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Toast.makeText(getActivity(),"好的",Toast.LENGTH_SHORT).show();
              }
          });
    }

    @Override
    protected void initView() {
        button = fivs(R.id.but9);

    }
}
