package com.example.nctiengh.game;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;

public class GamePanel extends SurfaceView  implements SurfaceHolder.Callback{
    MediaPlayer mp = MediaPlayer.create(getContext(),R.raw.cham);
    MediaPlayer mp1 = MediaPlayer.create(getContext(),R.raw.chet);
    private MainThreed threed; // khai bao bien threed
    Element myelement;
    Quanlyhinhnen background;
    ArrayList<Bullet> bullets= new ArrayList<Bullet>();
    ArrayList<Enemies> enemies= new ArrayList<Enemies>();
    ArrayList<Enemies_1> enemies_1= new ArrayList<Enemies_1>();
    int thoigiankethu=0; // thoi gian ra ke thu, q0 sẽ ra
    Enemies motkethu;
    int thoigiannapdan=0;
  int diem=0;
  int mang=20;
  boolean m2=false;
  boolean m1=true;
  //  Bullet moviendan;
   // Bitmap bitmap;
  //  int mX; // toa do X khi cham tay
  //  int mY; //toa do Y khi cham tay
    public GamePanel(Context context){
        super(context);

       getHolder().addCallback(this);
       threed= new MainThreed(getHolder(),this); // khoi tao bien
       setFocusable(true);
       background = new Quanlyhinhnen(this.getResources());
     //  moviendan= new Bullet(getResources(),0,0,R.drawable.qua);
     //  bitmap=BitmapFactory.decodeResource(this.getResources(), R.mipmap.ic_launcher);
    }
    public void  doDrawEnemies(Canvas canvas)
    {
        if(thoigiankethu>=10)
        {
            thoigiankethu=0;
            Enemies motkethu= new Enemies(getResources(),canvas.getWidth(),canvas.getHeight());
            enemies.add(motkethu);
        }
        for(int i=0;i<enemies.size();i++)
            enemies.get(i).doDraw(canvas);
        for (int i=0;i<enemies.size();i++)
            if(enemies.get(i).y<0)
                enemies.remove(i);
        Log.d("vien dan","so vien:"+ enemies.size());
    }
    public void  doDrawEnemies1(Canvas canvas)
    {
        if(thoigiankethu>=10)
        {
            thoigiankethu=0;
            Enemies_1 motkethu= new Enemies_1(getResources(),canvas.getWidth(),canvas.getHeight());
            enemies_1.add(motkethu);
        }
        for(int i=0;i<enemies_1.size();i++)
            enemies_1.get(i).doDraw(canvas);
        for (int i=0;i<enemies_1.size();i++)
            if(enemies_1.get(i).y<0)
                enemies_1.remove(i);
        Log.d("vien dan","so vien:"+ enemies_1.size());
    }
    public void doDrawBullet(Canvas canvas)
    {
        Paint p= new Paint();
        p.setColor(Color.WHITE);
        p.setTextSize(20);
       // canvas.drawText("nap dan:"+thoigiannapdan,20,20,p);
        canvas.drawRect(20,50,thoigiannapdan*10,70,p);
        if(thoigiannapdan >=10)
        {
            thoigiannapdan=0;
            Bullet moviendan= new Bullet(getResources(),myelement.mX,myelement.mY+95,R.drawable.qua);
            bullets.add(moviendan);
            Log.d("vien đạn","So vien"+bullets.size());

        }
        for (int i=0; i<bullets.size();i++)
        {
            bullets.get(i).doDraw(canvas);

        }
        for (int i=0; i<bullets.size();i++)
        {
            if(bullets.get(i).x > canvas.getWidth())
                    bullets.remove(i);
        }
    }
    @Override
    protected  void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawColor(Color.BLACK);
        background.doDrawRunning(canvas);// chạm vào vẽ và mất những hình còn lại
       // canvas.drawBitmap(bitmap, mX,mY,null);
        background.doDrawRunning(canvas);
        thoigiannapdan++;
        thoigiankethu++;
        if(myelement!=null)
        {
            myelement.doDraw(canvas);
         //   moviendan.doDraw(canvas);
            this.doDrawBullet(canvas);
            //this.doDrawBullet(canvas);
            if(m2)
            {
                this.doDrawEnemies1(canvas);
                xetvacham_1(canvas);
                xetvacham1_1(canvas);
            }
            if(m1)
            {
                this.doDrawEnemies(canvas);
                xetvacham(canvas);
                xetvacham1(canvas);
            }


        }

    }
    public void  surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3){

    }
    public  void  surfaceCreated(SurfaceHolder arg0){

        threed.setRunning(true);
        threed.start();
// gán trang thai va cho threed chay
    }
    public  void surfaceDestroyed(SurfaceHolder arg0){

        if(threed.isAlive()) // kiem tra xem con song hay ko
            threed.setRunning(false);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){

     //   mX=(int)event.getX();
    //    mY=(int)event.getY();
        if (myelement==null) {
            myelement= new Element(getResources(),(int)event.getX(),(int)event.getY());
            Log.d("abc","Khoi tao dau tien");
            return  true;
        }
        else {
            myelement.mX=(int)event.getX()-myelement.bitmap.getWidth()/2;
            myelement.mY=(int)event.getY()-myelement.bitmap.getHeight()/2;
        }
       if(event.getAction()==MotionEvent.ACTION_DOWN)
       {
           myelement.mX=(int)event.getX()-myelement.bitmap.getWidth()/2;
           myelement.mY=(int)event.getY()-myelement.bitmap.getHeight()/2;
           Log.d("abv","Down");
       }
        if(event.getAction()==MotionEvent.ACTION_UP)
        {
            myelement.mX=(int)event.getX()-myelement.bitmap.getWidth()/2;
            myelement.mY=(int)event.getY()-myelement.bitmap.getHeight()/2;
            Log.d("abv","Up");
        }
        if(event.getAction()==MotionEvent.ACTION_MOVE)
        {
            myelement.mX=(int)event.getX()-myelement.bitmap.getWidth()/2;
            myelement.mY=(int)event.getY()-myelement.bitmap.getHeight()/2;
            Log.d("abv","Move");
        }
        return true;
    }
    public boolean vc_b_e(Bullet bullet,Enemies enemies)
    {
        float nuarong_b=(float)bullet.getWidth()/2;
        int nuacao_b=bullet.getHeight()/2;
        float nuarong_e=(float)enemies.getWidth()/2;
        int nuacao_e=enemies.getHeight()/2;

        // khoang cách 2 tam theo x

        int kc_ht_x=Math.abs(bullet.gettamX()-enemies.gettamX());
        // khoang cách 2 tam theo y

        int kc_ht_y=Math.abs(bullet.gettamY()-enemies.gettamY());
        if(kc_ht_x<=nuarong_b+nuarong_e && kc_ht_y<=nuacao_b+nuacao_e)
            return  true;
        else
            return false;
    }

    public void xetvacham(Canvas canvas)
    {
        try{
            Paint p= new Paint();
            p.setColor(Color.WHITE);
            p.setTextSize(25);

            for(int i=0;i<bullets.size();i++)
                for (int j=0; j<enemies.size();j++) {
                    if (vc_b_e(bullets.get(i), enemies.get(j)) == true) {
                         bullets.remove(i);
                        enemies.remove(j);
                        diem++;
                        mp.start();

                        if(diem >=100)
                        {
                            m2=true;
                            m1=false;
                        }


                    }
                }
              canvas.drawText("Số quà nhận được: "+diem,20,20,p);
        }catch (Exception e)
        {
            Log.d("loi",e.toString());
        }
    }

    public boolean kiemtra(Element element,Enemies enemies)
    {
        float nuarong_b=(float)element.getWidth()/2;
        int nuacao_b=element.getHeight()/2;
        float nuarong_e=(float)enemies.getWidth()/2;
        int nuacao_e=enemies.getHeight()/2;

        // khoang cách 2 tam theo x

        int kc_ht_x=Math.abs(element.gettamX()-enemies.gettamX());
        // khoang cách 2 tam theo y

        int kc_ht_y=Math.abs(element.gettamY()-enemies.gettamY());
        if(kc_ht_x<=nuarong_b+nuarong_e && kc_ht_y<=nuacao_b+nuacao_e)
            return  true;
        else
            return false;
    }

    public void xetvacham1(Canvas canvas)
    {
        try{
            Paint p= new Paint();
            p.setColor(Color.WHITE);
            p.setTextSize(25);

            for(int i=0;i<enemies_1.size();i++)
                    if (kiemtra(myelement, enemies.get(i)) == true) {
                       enemies.remove(i);
                        mang=mang-1;
                       mp1.start();

                    }
            canvas.drawText("Số lần chơi: "+mang,20,50,p);
            if(mang==0)
            {
                threed.setRunning(false);

            }

        }catch (Exception e)
        {
            Log.d("loi",e.toString());
        }
    }

    // màn 2

    public boolean vc_b_c1(Bullet bullet,Enemies_1 enemies)
    {
        float nuarong_b=(float)bullet.getWidth()/2;
        int nuacao_b=bullet.getHeight()/2;
        float nuarong_e=(float)enemies.getWidth()/2;
        int nuacao_e=enemies.getHeight()/2;

        // khoang cách 2 tam theo x

        int kc_ht_x=Math.abs(bullet.gettamX()-enemies.gettamX());
        // khoang cách 2 tam theo y

        int kc_ht_y=Math.abs(bullet.gettamY()-enemies.gettamY());
        if(kc_ht_x<=nuarong_b+nuarong_e && kc_ht_y<=nuacao_b+nuacao_e)
            return  true;
        else
            return false;
    }

    public void xetvacham_1(Canvas canvas)
    {
        try{
            Paint p= new Paint();
            p.setColor(Color.WHITE);
            p.setTextSize(25);

            for(int i=0;i<bullets.size();i++)
                for (int j=0; j<enemies_1.size();j++) {
                    if (vc_b_c1(bullets.get(i), enemies_1.get(j)) == true) {
                        bullets.remove(i);
                        enemies_1.remove(j);
                        diem++;
                        mp.start();

                    }
                }
            canvas.drawText("Số quà nhận được: "+diem,20,20,p);
        }catch (Exception e)
        {
            Log.d("loi",e.toString());
        }
    }


    public boolean kiemtra1(Element element,Enemies_1 enemies)
    {
        float nuarong_b=(float)element.getWidth()/2;
        int nuacao_b=element.getHeight()/2;
        float nuarong_e=(float)enemies.getWidth()/2;
        int nuacao_e=enemies.getHeight()/2;

        // khoang cách 2 tam theo x

        int kc_ht_x=Math.abs(element.gettamX()-enemies.gettamX());
        // khoang cách 2 tam theo y

        int kc_ht_y=Math.abs(element.gettamY()-enemies.gettamY());
        if(kc_ht_x<=nuarong_b+nuarong_e && kc_ht_y<=nuacao_b+nuacao_e)
            return  true;
        else
            return false;
    }

    public void xetvacham1_1(Canvas canvas)
    {
        try{
            Paint p= new Paint();
            p.setColor(Color.WHITE);
            p.setTextSize(25);

            for(int i=0;i<enemies_1.size();i++)
                if (kiemtra1(myelement, enemies_1.get(i)) == true) {
                    enemies_1.remove(i);
                    mang=mang-1;
                    mp1.start();

                }
            canvas.drawText("Số lần chơi: "+mang,20,50,p);
            if(mang==0)
            {
                threed.setRunning(false);

            }

        }catch (Exception e)
        {
            Log.d("loi",e.toString());
        }
    }


}
