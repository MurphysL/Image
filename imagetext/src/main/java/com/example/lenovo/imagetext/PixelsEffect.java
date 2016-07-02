package com.example.lenovo.imagetext;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * PixelsEffect
 *
 * @author: lenovo
 * @time: 2016/6/10 21:52
 */

public class PixelsEffect extends Activity{

    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;

    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pixelseffect_color);

        imageView1 = (ImageView) findViewById(R.id.mimageView1);
        imageView2 = (ImageView) findViewById(R.id.mimageView2);
        imageView3 = (ImageView) findViewById(R.id.mimageView3);
        imageView4 = (ImageView) findViewById(R.id.mimageView4);

        bitmap = BitmapFactory.decodeResource(getResources() , R.drawable.p3);

        imageView1.setImageBitmap(bitmap);
        imageView2.setImageBitmap(ImageHelper.handleImageNegative(bitmap));
        imageView3.setImageBitmap(ImageHelper.handleImageOldPhoto(bitmap));
        imageView4.setImageBitmap(ImageHelper.handleImageRlief(bitmap));

    }
}
