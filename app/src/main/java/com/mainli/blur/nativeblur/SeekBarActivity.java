package com.mainli.blur.nativeblur;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public abstract class SeekBarActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(LinearLayout.VERTICAL);
        attachView(linearLayout2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, 0, 1f);
        linearLayout.addView(linearLayout2, layoutParams);
        SeekBar seekBar = addSeekBar(linearLayout);
        setContentView(linearLayout);
        onProgressChanged(seekBar, seekBar.getProgress(), false);
    }

    private SeekBar addSeekBar(LinearLayout linearLayout) {
        SeekBar seekBar = new SeekBar(this);
        seekBar.setMax(max());
        seekBar.setProgress(progress());
        seekBar.setOnSeekBarChangeListener(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        int dp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30F, getResources().getDisplayMetrics());
        layoutParams.leftMargin = dp;
        layoutParams.topMargin = dp;
        layoutParams.rightMargin = dp;
        layoutParams.bottomMargin = dp;
        linearLayout.addView(seekBar, layoutParams);
        return seekBar;
    }

    public int progress() {
        return max() >> 1;
    }

    public int max() {
        return 100;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    protected abstract void attachView(LinearLayout linearLayout2);
}
