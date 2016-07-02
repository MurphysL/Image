package com.example.lenovo.imagetext;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

/**
 * PrimaryColor
 *
 * @author: lenovo
 * @time: 2016/6/7 21:39
 */

public class PrimaryColor extends Activity implements SeekBar.OnSeekBarChangeListener{

    private ImageView imageView;
    private SeekBar seekBar_hum , seekBar_saturation , seekBar_lum;

    private static final int MAX_VALUE = 255;
    private static final int MID_VALUE = 127;

    private float hum , saturation , lum;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.primary_color);
        bitmap = BitmapFactory.decodeResource(getResources() , R.drawable.p1);

        imageView = (ImageView) findViewById(R.id.imageView);
        seekBar_hum = (SeekBar) findViewById(R.id.hum);
        seekBar_saturation = (SeekBar) findViewById(R.id.saturation);
        seekBar_lum = (SeekBar) findViewById(R.id.lum);

        seekBar_hum.setOnSeekBarChangeListener(this);
        seekBar_saturation.setOnSeekBarChangeListener(this);
        seekBar_lum.setOnSeekBarChangeListener(this);

        seekBar_hum.setMax(MAX_VALUE);
        seekBar_saturation.setMax(MAX_VALUE);
        seekBar_lum.setMax(MAX_VALUE);
        seekBar_hum.setProgress(MID_VALUE);
        seekBar_saturation.setProgress(MID_VALUE);
        seekBar_lum.setProgress(MID_VALUE);

        imageView.setImageBitmap(bitmap);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        switch (seekBar.getId()){
            case R.id.hum:
                hum = (progress - MID_VALUE) * 1.0f / MID_VALUE * 180;
                break;
            case R.id.saturation:
                saturation = progress * 1.0f / MID_VALUE;
                break;
            case R.id.lum:
                lum = progress * 1.0f / MID_VALUE;
                break;
        }

        imageView.setImageBitmap(ImageHelper.handleImageEffect(bitmap , hum , saturation , lum));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
