package com.mainli.blur.nativeblur;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by mobimagic on 2017/12/5.
 */

public class MainActivity extends AppCompatActivity implements Handler.Callback {

    private ImageView mImageView;

    {
        System.loadLibrary("blur-lib");
    }

    private Handler mHandler = new Handler(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = findViewById(R.id.image_blur);
        ImageView imageView = findViewById(R.id.image_blur1);
        imageView.setImageBitmap(blurBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher), 5));
        new Thread() {
            @Override
            public void run() {
                super.run();
                Bitmap bitmap = blurBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.mainli1), 5);
                mHandler.sendMessage(mHandler.obtainMessage(99, bitmap));
                bitmap = blurBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.mainli2), 5);
                mHandler.sendMessage(mHandler.obtainMessage(99, bitmap));
                bitmap = blurBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.mainli3), 5);
                mHandler.sendMessage(mHandler.obtainMessage(99, bitmap));
            }
        }.start();
    }

    public native Bitmap blurBitmap(Bitmap bimap, float intensity);

    @Override
    public boolean handleMessage(Message msg) {
        mImageView.setImageBitmap((Bitmap) msg.obj);
        return false;
    }
}
