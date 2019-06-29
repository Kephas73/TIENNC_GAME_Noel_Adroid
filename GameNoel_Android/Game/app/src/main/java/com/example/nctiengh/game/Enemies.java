package com.example.nctiengh.game;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;

import java.util.Random;

public class Enemies {
    int x;
    int y;
    Bitmap bitmap;
    int []tocdo={5,6,8};
    int []tocdo1={10,15,16,17};

    int []manhinh1={
            R.drawable.dan_chuong, R.drawable.dan_tuanloc, R.drawable.dan_nguoituyet,R.drawable.dan_caythong };
    int []manghinh={
    R.drawable.dan_chuong, R.drawable.dan_tuanloc, R.drawable.dan_nguoituyet};

    int e_nngnhien;

    public Enemies(Resources res, int rong_cv, int cao_cv)
    {
        Random rand= new Random();
        e_nngnhien=rand.nextInt(3);
        Log.d("nn","" +e_nngnhien);
        this.x=rong_cv;// x tu phia
        int a=0 + (int)(Math.random()*(cao_cv-0)+1);
        this.y=a;
        bitmap=BitmapFactory.decodeResource(res,manghinh[e_nngnhien]);
    }
    public Enemies(Resources res, int x, int y, int hinh)
    {
        this.x=x;
        this.y=y;
        bitmap=BitmapFactory.decodeResource(res, hinh);
    }
    public void  doDraw(Canvas canvas)
    {
        canvas.drawBitmap(bitmap,x,y,null);
        x-=tocdo[e_nngnhien];// tru vi chay phai sang trai
    }
    public void  setXY(int x, int y)
    {
        this.x=x;
        this.y=y;
    }
    public int getWidth()
    {
        return bitmap.getWidth();
    }
    public int getHeight()
    {
        return bitmap.getHeight();
    }
    public int gettamX()
    {
        return x+(bitmap.getWidth()/2);
    }
    public int gettamY()
    {
        return y+(bitmap.getHeight()/2);
    }

}

