package com.example.lenovo.imagetext;

import android.graphics.Matrix;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.Toast;

/**
 * ImageMatrix
 *
 * @author: lenovo
 * @time: 2016/7/2 9:43
 */

public class ImageMatrix extends AppCompatActivity{

    private GridLayout mGridLayout;
    private ImageMatrixView imageMatrixView;

    private int mWidth;
    private int mHight;
    private EditText[] editTexts = new EditText[9];
    private float[] mImageMatrix = new float[9];
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_matrix);
        mGridLayout = (GridLayout) findViewById(R.id.mgridLayout2);
        imageMatrixView = (ImageMatrixView) findViewById(R.id.imageMatrixView);

        mGridLayout.post(new Runnable() {
            @Override
            public void run() {
                mWidth = mGridLayout.getWidth();
                mHight = mGridLayout.getHeight();
                addEdt();
                initMatrix();
            }
        });
    }

    private void initMatrix(){
        for (int i = 0 ;i < 9 ;i ++){
            if(i % 4 == 0){
                editTexts[i].setText(String.valueOf(1));
            }else{
                editTexts[i].setText(String.valueOf(0));
            }
        }
    }

    private void addEdt(){
        for(int i = 0 ;i < 9 ;i ++){
            EditText editText = new EditText(ImageMatrix.this);
            editText.setGravity(Gravity.CENTER);
            editTexts[i] = editText;
            mGridLayout.addView(editText , mWidth/3 , mHight/3);
        }
    }

    private void getMatrix(){
        for (int i = 0; i < 9; i++) {
            mImageMatrix[i] = Float.parseFloat(editTexts[i].getText().toString());
        }
    }

    public void btn_Change2(View v){
        Toast.makeText(this , "WHATFUCK" , Toast.LENGTH_LONG).show();
        getMatrix();
        Matrix matrix = new Matrix();
        matrix.setValues(mImageMatrix);
        imageMatrixView.setMatrix(matrix);
        imageMatrixView.invalidate();
    }


    public void btn_Reset2(View v){
        initMatrix();
        getMatrix();
        Matrix matrix = new Matrix();
        matrix.setValues(mImageMatrix);
        imageMatrixView.setMatrix(matrix);
        imageMatrixView.invalidate();
    }





}
