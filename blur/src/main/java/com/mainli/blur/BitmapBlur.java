package com.mainli.blur;

import android.graphics.Bitmap;
import android.support.annotation.Keep;

/**
 * Created by mobimagic on 2017/12/5.
 */
@Keep
public class BitmapBlur {
    static{
        System.loadLibrary("blur-lib");
    }
    public native static Bitmap blur(Bitmap bimap, float intensity);
}
