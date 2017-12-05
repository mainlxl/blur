package com.mainli.blur.nativeblur;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.mainli.blur.BitmapBlur;

/**
 * Created by mobimagic on 2017/12/5.
 */

public class MainActivity extends AppCompatActivity implements Handler.Callback {

    private ImageView mImageView;


    private Handler mHandler = new Handler(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = findViewById(R.id.image_blur);
        ImageView imageView = findViewById(R.id.image_blur1);
        imageView.setImageBitmap(BitmapBlur.blur(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher), 5));
        new Thread() {
            @Override
            public void run() {
                super.run();
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.mainli1);
                bitmap = BitmapBlur.blur(bitmap, 20);
                mHandler.sendMessage(mHandler.obtainMessage(99, bitmap));
                bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.mainli2);
                bitmap = BitmapBlur.blur(bitmap, 20);
                mHandler.sendMessage(mHandler.obtainMessage(99, bitmap));
                bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.mainli3);
                bitmap = BitmapBlur.blur(bitmap, 20);
                mHandler.sendMessage(mHandler.obtainMessage(99, bitmap));
            }
        }.start();
    }


    @Override
    public boolean handleMessage(Message msg) {
        mImageView.setImageBitmap((Bitmap) msg.obj);
        return false;
    }
}
