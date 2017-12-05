package com.mainli.blur;

import android.graphics.Bitmap;

/**
 * Created by mobimagic on 2017/12/5.
 */

public class BitmapBlur {
    static{
        System.loadLibrary("blur-lib");
    }
    public native static Bitmap blur(Bitmap bimap, float intensity);
}
