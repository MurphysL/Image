package com.example.lenovo.imagetext;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn_PixelsEffect(View view){
        startActivity(new Intent(this , PixelsEffect.class));
    }

    public void btn_PrimaryColor(View view){
        startActivity(new Intent(this , PrimaryColor.class));
    }

    public void btn_ColorMatrix(View view){
        startActivity(new Intent(this , ColorMatrix.class));
    }

    public void btn_ImageMatrix(View view){
        startActivity(new Intent(this , ImageMatrix.class));
    }

    public void btn_Xfermode(View v){
        startActivity(new Intent(this , RoundRectXfermodeTest.class));
    }

    public void btn_Reflect(View v){
        startActivity(new Intent(this , ReflectText.class));
    }

    public void btn_Mesh(View v){
        startActivity(new Intent(this , MeshText.class));
    }
}
