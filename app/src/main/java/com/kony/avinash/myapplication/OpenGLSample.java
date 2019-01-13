package com.kony.avinash.myapplication;

import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class OpenGLSample extends AppCompatActivity {

        private GLSurfaceView myGLView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_glsample);
        myGLView = new MyGLSurfaceView(this);
        setContentView(myGLView);
    }
}
