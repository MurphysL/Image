package com.example.lenovo.imagetext;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;

/**
 * ImageMatrixView
 *
 * @author: lenovo
 * @time: 2016/7/2 9:45
 */

public class ImageMatrixView extends View {

    private Bitmap mbitmap;
    private Matrix matrix;

    public ImageMatrixView(Context context) {
        super(context);
        init();
    }

    public ImageMatrixView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ImageMatrixView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        mbitmap = BitmapFactory.decodeResource(getResources() , R.mipmap.ic_launcher);
        setMatrix(new Matrix());
    }

    public void setMatrix(Matrix mmatrix){
        matrix = mmatrix;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(mbitmap , 0 , 0, null);
        canvas.drawBitmap(mbitmap , matrix , null);
    }


}
