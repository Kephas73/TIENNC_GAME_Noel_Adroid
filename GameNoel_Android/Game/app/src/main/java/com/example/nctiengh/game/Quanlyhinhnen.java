package com.example.nctiengh.game;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class Quanlyhinhnen {

    private int toadonen1_X=0;
    private int toadonen2_X=0;
    private Bitmap hinhnen1;
    private  Bitmap hinhnen2;

    public Quanlyhinhnen(Resources c)
    {
        hinhnen1=BitmapFactory.decodeResource(c,R.drawable.nen3);
        hinhnen2=BitmapFactory.decodeResource(c,R.drawable.nen3);
    }
    public void doDrawRunning(Canvas canvas){
        // giam toa do de dich chuyen cho nên1
        toadonen1_X=toadonen1_X-1;

        // giam toa do de dich chuyen cho nen 2
       toadonen2_X=toadonen2_X-4;

       // tinh do lech cho hhinh 2
        int toadonen1_phu_X=hinhnen1.getWidth() -(-toadonen1_X);

        // di chuyen het thi quay lại tu dau
        if(toadonen1_phu_X <=0){
            toadonen1_X=0;
            // chi vẽ một tấm

            canvas.drawBitmap(hinhnen1,0,0,null);
        }else {
            // ve 1 tấm lech va tam nuoi duoi theo
            canvas.drawBitmap(hinhnen1,toadonen1_X,0,null);
            canvas.drawBitmap(hinhnen1,toadonen1_phu_X,0,null);
        }
        int toadonen2_phu_X=hinhnen2.getWidth() -(-toadonen2_X);

        // di chuyen het thi quay lại tu dau
        if(toadonen2_phu_X <=0){
            toadonen2_X=0;
            // chi vẽ một tấm

            canvas.drawBitmap(hinhnen2,toadonen2_X,0,null);
        }else {
            // ve 1 tấm lech va tam nuoi duoi theo
            canvas.drawBitmap(hinhnen2,toadonen2_X,0,null);
            canvas.drawBitmap(hinhnen2,toadonen2_phu_X,0,null);
        }

    }

}
