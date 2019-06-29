package com.example.nctiengh.game;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;

public class Bullet {
    int x;
    int y;
    Bitmap bitmap;
    int tocdo=20;
    public Bullet(Resources res, int x, int y)
    {
        this. x=x;
        this. y=y;
        bitmap=BitmapFactory. decodeResource(res,R.drawable.qua);
    }
    public Bullet(Resources res, int x, int y, int hinh)
    {
        this. x=x;
        this. y=y;
        bitmap=BitmapFactory.decodeResource(res, hinh);
    }
    public void doDraw(Canvas canvas)
    {
        canvas.drawBitmap(bitmap, x, y, null);
        x+=tocdo;
    }
    public void setXY(int x, int y)
    {
        this. x=x;
        this. y=y;
    }
    public void setTocDo(int x)
    {
        this. tocdo=x;
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
