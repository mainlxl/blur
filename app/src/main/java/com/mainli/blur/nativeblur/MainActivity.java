package com.mainli.blur.nativeblur;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mainli.blur.BitmapBlur;

/**
 * Created by mobimagic on 2017/12/5.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Bitmap mBitmap;
    private ImageView mImageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setBackgroundColor(0xffc7edcc);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        mImageView = new ImageView(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, 0, 1f);
        linearLayout.addView(mImageView, layoutParams);

        LinearLayout buttoLayout = new LinearLayout(this);
        buttoLayout.setOrientation(LinearLayout.HORIZONTAL);
        TextView child = new TextView(this);
        child.setText("强度:");
        child.setGravity(Gravity.CENTER);
        buttoLayout.addView(child, new LinearLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.MATCH_PARENT));
        for (int i = 0; i < 30; i += 5) {
            Button button = new Button(this);
            button.setTag(i);
            button.setText(i + "");
            button.setOnClickListener(this);
            buttoLayout.addView(button, new LinearLayout.LayoutParams(0, FrameLayout.LayoutParams.MATCH_PARENT, 1f));
        }
        linearLayout.addView(buttoLayout, new LinearLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT));
        setContentView(linearLayout);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.image);
        Log.d("Mainli", "-------------------------------------------------------------------------");
        Log.d("Mainli", "Bitmap(width x height):" + mBitmap.getWidth() + "x" + mBitmap.getHeight());
        Log.d("Mainli", "-------------------------------------------------------------------------");
        blur(10);
    }

    @Override
    public void onClick(View v) {
        Integer intensity = (Integer) v.getTag();
        blur(intensity);
    }

    private void blur(int intensity) {
        long startTime = System.currentTimeMillis();
        BitmapBlur.blur(mBitmap, intensity);
        Log.d("Mainli", "强度:" + intensity + " - 用时(毫秒):" + (System.currentTimeMillis() - startTime));
        mImageView.setImageBitmap(mBitmap);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.image);


    }
}
