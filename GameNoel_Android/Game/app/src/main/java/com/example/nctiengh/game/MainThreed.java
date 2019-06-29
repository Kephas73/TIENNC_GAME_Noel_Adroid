package com.example.nctiengh.game;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;

public class MainThreed  extends Thread{

    private SurfaceHolder surfaceholder;
    private GamePanel gamepanel;
    private boolean running;

    public MainThreed(SurfaceHolder surfaceholder, GamePanel gamepanel)
    {
        this.surfaceholder=surfaceholder;
        this.gamepanel=gamepanel;
    }
    public void setRunning(boolean r){
        running=r;
    }

    @SuppressLint("WrongCall")
    @Override
    public void run(){

        long dem=0L;
        super.run();
        Canvas canvas=null;


        while (running)
        {
           canvas=surfaceholder.lockCanvas();

           if (canvas!=null)
           {
              gamepanel.onDraw(canvas);
               surfaceholder.unlockCanvasAndPost(canvas);
           }

            Log.d("testloop","loop" + (dem++));

        }
    }
}
