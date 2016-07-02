package com.example.lenovo.imagetext;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;

/**
 * ColorMatrix
 *
 * @author: lenovo
 * @time: 2016/6/10 20:23
 */

public class ColorMatrix extends Activity {

    private ImageView imageView;
    private GridLayout gridLayout;
    private Bitmap bitmap;
    private int mHeight;
    private int mWeight;

    private EditText[] editTexts = new EditText[20];
    private float[] mColorMatrix = new float[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.matrix_color);
        imageView = (ImageView) findViewById(R.id.imageView2);
        gridLayout = (GridLayout) findViewById(R.id.mgridLayout);
        bitmap = BitmapFactory.decodeResource(getResources() , R.drawable.p1);
        imageView.setImageBitmap(bitmap);

        gridLayout.post(new Runnable() {
            @Override
            public void run() {
                mHeight = gridLayout.getHeight();
                mWeight = gridLayout.getWidth();
                addEdt();
                initMatrix();
            }
        });
    }

    public void btn_Change(View v){
        getMatrix();
        setImageMatrix();
    }

    public void btn_Reset(View v){
        initMatrix();
        setImageMatrix();
    }

    private void addEdt(){
        for (int i = 0; i < 20; i++) {
            EditText editText = new EditText(ColorMatrix.this);
            editTexts[i] = editText;
            gridLayout.addView(editText , mWeight / 5 , mHeight / 4);
        }
    }

    private  void initMatrix(){
        for (int i = 0; i < 20; i++) {
            if(i % 6 == 0){
                editTexts[i].setText("1");
            }else{
                editTexts[i].setText("0");
            }
        }
    }

    private void getMatrix(){
        for (int i = 0; i < 20; i++) {
            mColorMatrix[i] = Float.parseFloat(editTexts[i].getText().toString());
        }
    }

    private void setImageMatrix(){
        Bitmap bitmap2 = Bitmap.createBitmap(bitmap.getWidth() , bitmap.getHeight() , Bitmap.Config.ARGB_8888);
        android.graphics.ColorMatrix colorMatrix = new android.graphics.ColorMatrix();
        colorMatrix.set(mColorMatrix);

        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap , 0 , 0 , paint);//?
        imageView.setImageBitmap(bitmap2);
    }

}
