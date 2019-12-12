package com.mainli.blur;

import android.graphics.Bitmap;
import android.support.annotation.Keep;

/**
 * Created by mobimagic on 2017/12/5.
 */
@Keep
public class BitmapBlur {

    public interface LibLoader {
        void loadLibrary(String libName);
    }


    private static boolean isLoadSo = false;

    private native static Bitmap blur(Bitmap bimap, float intensity);

    public static Bitmap blurBitmap(Bitmap bimap, float intensity, LibLoader libLoader) {
        if (!isLoadSo) {
            if (libLoader == null) {
                System.loadLibrary("blur-lib");
            } else {
                libLoader.loadLibrary("blur-lib");
            }
            isLoadSo = true;
        }
        return blur(bimap, intensity);
    }

    public static Bitmap blurBitmap(Bitmap bimap, float intensity) {
        return blurBitmap(bimap, intensity, null);
    }
}
