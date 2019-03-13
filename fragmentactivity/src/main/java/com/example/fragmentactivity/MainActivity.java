package com.example.fragmentactivity;

import android.app.Fragment;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        打印
        Log.i("info", "Activity——onCraste");
        setContentView(R.layout.activity_main);
        android.support.v4.app.Fragment fragment = new AFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.frag, fragment).commit();

    }

    //Activity的生命周期
    @Override
//
    protected void onStart() {
        super.onStart();
        Log.i("info", "onActivityt——onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("info", "onActivityt——onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("info", "Activity--onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("info", "Activity--onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("info", "Activity--onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("info", "Activity--onDestroy()");
    }

    //    Fragment的生命周期
    public static class AFragment extends android.support.v4.app.Fragment {
        @Override
        public void onAttach(Context context) {
            super.onAttach(context);
            Log.i("info", "Fragment--onAttach()");
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Log.i("info", "Fragment--onCreate()");
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            Log.i("info", "Fragment--onCreateView()");
            return super.onCreateView(inflater, container, savedInstanceState);

        }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            Log.i("info", "Fragment--onActivityCreated()");
        }

        @Override
        public void onStart() {
            super.onStart();
            Log.i("info", "Fragment--onStart()");
        }

        @Override
        public void onResume() {
            super.onResume();
            Log.i("info", "Fragment——onResume");
        }

        @Override
        public void onPause() {
            super.onPause();
            Log.i("info", "Fragment——onPause");

        }

        @Override
        public void onStop() {
            super.onStop();
            Log.i("info", "Fragment——onStop");
        }

        @Override
        public void onDestroyView() {
            super.onDestroyView();
            Log.i("info", "Fragment——onDestroyView");
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            Log.i("info", "Fragment——onDestroy");
        }

        @Override
        public void onDetach() {
            super.onDetach();
            Log.i("info", "Fragment——onDetach");
        }
    }
}

