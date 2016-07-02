package com.example.lenovo.imagetext;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;

/**
 * ImageHelper
 *
 * @author: lenovo
 * @time: 2016/6/7 21:39
 */

public class ImageHelper {

    public static Bitmap handleImageEffect(Bitmap bitmap , float hum , float saturation , float lum){
        Bitmap bm = Bitmap.createBitmap(bitmap.getWidth() , bitmap.getHeight() , Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bm);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        ColorMatrix humMatrix = new ColorMatrix();
        humMatrix.setRotate(0 , hum);
        humMatrix.setRotate(1 , hum);
        humMatrix.setRotate(2 , hum);

        ColorMatrix saturationMatrix = new ColorMatrix();
        saturationMatrix.setSaturation(saturation);

        ColorMatrix lumMatrix = new ColorMatrix();
        lumMatrix.setScale(lum , lum , lum ,1);

        ColorMatrix imageMatrix = new ColorMatrix();
        imageMatrix.postConcat(humMatrix);
        imageMatrix.postConcat(saturationMatrix);
        imageMatrix.postConcat(lumMatrix);

        paint.setColorFilter(new ColorMatrixColorFilter(imageMatrix));

        canvas.drawBitmap(bitmap , 0 , 0 , paint);

        return bm;
    }

    public static Bitmap handleImageNegative(Bitmap bitmap){

        int weight = bitmap.getWidth();
        int height = bitmap.getHeight();
        int color , r , g , b , a;

        Bitmap bm = Bitmap.createBitmap(weight , height , Bitmap.Config.ARGB_8888);

        int[] old_pixels = new int[weight * height];
        int[] new_pixels = new int[weight * height];
        bitmap.getPixels(old_pixels , 0 ,weight ,0 , 0 , weight , height);

        for (int i = 0; i < weight * height; i++) {
            color = old_pixels[i];
            r = Color.red(color);
            g = Color.green(color);
            b = Color.blue(color);
            a = Color.alpha(color);

            r = 255 - r;
            g = 255 - g;
            b = 255 - b;

            if(r > 255){
                r = 255;
            }else if(r < 0){
                r = 0;
            }
            if(g > 255){
                g = 255;
            }else if(g < 0){
                g = 0;
            }
            if(b > 255){
                b = 255;
            }else if(b < 0){
                b = 0;
            }

            new_pixels[i] = Color.argb(a , r , g , b);
        }

        bm.setPixels(new_pixels ,0 ,weight ,0 , 0 , weight , height);

        return bm;

    }

    public static Bitmap handleImageOldPhoto(Bitmap bitmap){

        int weight = bitmap.getWidth();
        int height = bitmap.getHeight();
        int color , r , g , b , a , r1 , g1 , b1;

        Bitmap bm = Bitmap.createBitmap(weight , height , Bitmap.Config.ARGB_8888);

        int[] old_pixels = new int[weight * height];
        int[] new_pixels = new int[weight * height];
        bitmap.getPixels(old_pixels , 0 ,weight ,0 , 0 , weight , height);

        for (int i = 0; i < weight * height; i++) {
            color = old_pixels[i];
            r = Color.red(color);
            g = Color.green(color);
            b = Color.blue(color);
            a = Color.alpha(color);

            r1 = (int)(0.393 * r + 0.769 * g + 0.189 * b);
            g1 = (int)(0.349 * r + 0.686 * g + 0.168 * b);
            b1 = (int)(0.272 * r + 0.534 * g + 0.131 * b);

            if(r1 > 255){
                r1 = 255;
            }else if(r1 < 0){
                r1 = 0;
            }
            if(g1 > 255){
                g1 = 255;
            }else if(g1 < 0){
                g1 = 0;
            }
            if(b1 > 255){
                b1 = 255;
            }else if(b1 < 0){
                b1 = 0;
            }

            new_pixels[i] = Color.argb(a , r1 , g1 , b1);
        }

        bm.setPixels(new_pixels ,0 ,weight ,0 , 0 , weight , height);

        return bm;

    }

    public static Bitmap handleImageRlief(Bitmap bitmap){

        int weight = bitmap.getWidth();
        int height = bitmap.getHeight();
        int color = 0 , colorBefore = 0;
        int r , g , b , a , r1 , g1 , b1;

        Bitmap bm = Bitmap.createBitmap(weight , height , Bitmap.Config.ARGB_8888);

        int[] old_pixels = new int[weight * height];
        int[] new_pixels = new int[weight * height];
        bitmap.getPixels(old_pixels , 0 ,weight ,0 , 0 , weight , height);

        //需要使用前一个点
        for (int i = 1; i < weight * height; i++) {
            colorBefore = old_pixels[i - 1];
            r = Color.red(colorBefore);
            g = Color.green(colorBefore);
            b = Color.blue(colorBefore);
            a = Color.alpha(colorBefore);

            color = old_pixels[i];
            r1 = Color.red(color);
            g1 = Color.green(color);
            b1 = Color.blue(color);

            r = (r - r1 + 127);
            g = (g - g1 + 127);
            b = (b - b1 + 127);

            if(r1 > 255){
                r1 = 255;
            }else if(r1 < 0){
                r1 = 0;
            }
            if(g1 > 255){
                g1 = 255;
            }else if(g1 < 0){
                g1 = 0;
            }
            if(b1 > 255){
                b1 = 255;
            }else if(b1 < 0){
                b1 = 0;
            }

            new_pixels[i] = Color.argb(a , r , g , b);
        }

        bm.setPixels(new_pixels ,0 ,weight ,0 , 0 , weight , height);

        return bm;

    }


}
