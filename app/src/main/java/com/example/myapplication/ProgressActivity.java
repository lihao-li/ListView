package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

public class ProgressActivity extends Activity implements Runnable {
    private ProgressBar progress;
    Handler h = new Handler();
    private int max=100,current,step;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aaa);
        progress = (ProgressBar) findViewById(R.id.progressBar2);
        progress.setMax(max);
        progress.setProgress(0);
        step = max/10;
        h.post(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void run() {
        current = progress.getProgress();
        progress.setProgress(current+step);
        h.postDelayed(this, 1000);
    }

}