package max.go.cameratest;

import android.graphics.Bitmap;
import android.graphics.Color;

class Monochrome {
    public static Bitmap makeMonochrome(Bitmap bitmap){
        Bitmap bt = bitmap;
        for (int x = 0; x < bitmap.getWidth(); x++) {
            for (int y = 0; y < bitmap.getHeight(); y++) {
                int p = bt.getPixel(x, y);
                int f = (Color.red(p) + Color.green(p) + Color.blue(p))/3;
                bt.setPixel(x, y, f);
            }
        }
        return bt;
    }
}
