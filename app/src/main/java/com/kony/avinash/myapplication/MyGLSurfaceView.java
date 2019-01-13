package com.kony.avinash.myapplication;

import android.content.Context;
import android.opengl.GLSurfaceView;

class MyGLSurfaceView extends GLSurfaceView {
    private final MyGLRenderer mRenderer;

    public MyGLSurfaceView(Context context) {
        super(context);
        setEGLContextClientVersion(2);

        mRenderer = new MyGLRenderer();

        // Set the Renderer for drawing on the GLSurfaceView
        setRenderer(mRenderer);

    }
}
