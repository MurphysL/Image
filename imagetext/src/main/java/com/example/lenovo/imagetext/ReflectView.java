package com.example.lenovo.imagetext;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/**
 * ReflectView
 *
 * @author: lenovo
 * @time: 2016/7/2 16:07
 */

public class ReflectView extends View {

    private Bitmap srcBitmap;
    private Bitmap refBitmap;
    private Paint paint;

    public ReflectView(Context context) {
        super(context);
        init();
    }

    public ReflectView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ReflectView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        srcBitmap = BitmapFactory.decodeResource(getResources() , R.drawable.p7);
        Matrix matrix = new Matrix();
        matrix.setScale(1 , -1);
        refBitmap = Bitmap.createBitmap(srcBitmap , 0 , 0 , srcBitmap.getWidth() , srcBitmap.getHeight() , matrix , true);

        paint = new Paint();
        paint.setShader(new LinearGradient(0 , srcBitmap.getHeight() , 0 ,
                srcBitmap.getHeight() * 1.5F , 0xcc000000 , 0x10000000 , Shader.TileMode.CLAMP));

        paint.setXfermode( new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.BLACK);
        canvas.drawBitmap(srcBitmap , 0 , 0 , null);
        canvas.drawBitmap(refBitmap , 0 , srcBitmap.getHeight() , null);
        canvas.drawRect(0 , srcBitmap.getHeight() , srcBitmap.getWidth() , srcBitmap.getHeight() * 2 , paint);
    }






















}
