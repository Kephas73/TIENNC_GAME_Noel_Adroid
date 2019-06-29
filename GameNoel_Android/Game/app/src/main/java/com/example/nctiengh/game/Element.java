package com.example.nctiengh.game;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class Element {

    Bitmap bitmap; // hình ảnh
    int mX; // toa do x
    int mY; // toa do Y

    public Element(Resources res, int x, int y)
    {
        bitmap = BitmapFactory.decodeResource(res, R.drawable.noel);
        mX=x-bitmap.getWidth()/2;
        mY=y-bitmap.getHeight()/2;
    }
    public Element(Resources res, int x, int y, int idHinh)
    {
        bitmap=BitmapFactory.decodeResource(res,idHinh);
        mX=x-bitmap.getWidth()/2;
        mY=y-bitmap.getHeight()/2;
    }
    public  void doDraw(Canvas canvas)
    {
        canvas.drawBitmap(bitmap,mX,mY,null);
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
        return mX+(bitmap.getWidth()/2);
    }
    public int gettamY()
    {
        return mY+(bitmap.getHeight()/2);
    }
}
