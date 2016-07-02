package com.example.lenovo.imagetext;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

/**
 * RoundRectXfermodeView
 *
 * @author: lenovo
 * @time: 2016/7/2 15:07
 */

public class RoundRectXfermodeView extends View {

    private Bitmap bitmap;
    private Bitmap mOut;
    private Paint paint;

    public RoundRectXfermodeView(Context context) {
        super(context);
        init();
    }

    public RoundRectXfermodeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RoundRectXfermodeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        setLayerType(LAYER_TYPE_SOFTWARE , null);
        bitmap = BitmapFactory.decodeResource(getResources() , R.drawable.p1);
        mOut = Bitmap.createBitmap( bitmap.getWidth() , bitmap.getHeight() , Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(mOut);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        //canvas.drawRoundRect(0 , 0 , bitmap.getWidth() , bitmap.getHeight() ,100 , 100 , paint);
        canvas.drawCircle(bitmap.getWidth() / 2 , bitmap.getHeight() / 2 , bitmap.getHeight() / 2 , paint);

        paint.setXfermode( new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap , 0 , 0 ,paint);
        paint.setXfermode(null);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(mOut , 0 , 0 ,null);
    }
}
