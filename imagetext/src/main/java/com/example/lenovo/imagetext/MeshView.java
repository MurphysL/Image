package com.example.lenovo.imagetext;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * MeshView
 *
 * @author: lenovo
 * @time: 2016/7/2 17:20
 */

public class MeshView extends View {

    //格数
    private int HEIGHT = 200;
    private int WIDTH = 200;
    private int COUNT = (WIDTH + 1 ) * (HEIGHT + 1);
    private float[] verts = new float[COUNT * 2];
    private float[] orig = new float[COUNT * 2];
    private Bitmap bitmap;
    private float K = 0;

    public MeshView(Context context) {
        super(context);
        init();
    }

    public MeshView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MeshView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        int index = 0;
        bitmap = BitmapFactory.decodeResource(getResources() , R.drawable.p1);
        float height = bitmap.getHeight();
        float width = bitmap.getWidth();

        for(int i = 0 ;i < HEIGHT + 1 ; i ++){
            float fy = height * i / HEIGHT;
            for(int j = 0 ;j < WIDTH + 1 ;j ++){
                float fx = width * j / WIDTH;
                orig[index * 2 + 0] = verts[index * 2 + 0] = fx;
                orig[index * 2 + 1] = verts[index * 2 + 1] = fy + 200;
                index += 1;
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {

        for(int i = 0 ; i < HEIGHT + 1 ;i ++){
            for(int j = 0 ;j < WIDTH + 1 ; j ++){
                verts[(i*(WIDTH + 1) + j) * 2 + 0] += 0;
                float offsetY = (float)Math.sin((float)j / WIDTH * 2 * Math.PI +  K * 2 * Math.PI);
                verts[(i*(WIDTH + 1) + j) * 2 + 1] = orig[(i*(WIDTH + 1) + j) * 2 + 1] + offsetY * 50;
            }
        }
        K += 0.1F;

        canvas.drawBitmapMesh(bitmap , WIDTH , HEIGHT , verts , 0 , null , 0 , null);
        invalidate();//重绘
    }
}
