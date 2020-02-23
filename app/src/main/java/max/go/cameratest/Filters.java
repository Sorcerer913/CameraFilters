package max.go.cameratest;

import android.graphics.Bitmap;
import android.widget.GridLayout;
import android.widget.ImageView;

import java.util.HashMap;
import java.util.LinkedList;

public class Filters implements GridImageViewGenerator {

    LinkedList<Filter> linkedList;

    @Override
    public void addImageView(GridLayout grd) {
        ImageView imageView = new ImageView(grd.getContext());
        grd.addView(imageView);

        //imageView.setLayoutParams(new GridLayout.LayoutParams());

    }

    private class Filter{

        int MIN_RULE = 0;
        int MAX_RULE = Integer.MAX_VALUE;

        /*public Bitmap getNewBitmap(Bitmap bitmap, int rule){



        }*/

    }

}
