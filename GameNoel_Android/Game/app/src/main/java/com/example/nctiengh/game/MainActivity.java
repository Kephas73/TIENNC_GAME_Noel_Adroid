package com.example.nctiengh.game;

import android.graphics.Canvas;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

   MediaPlayer mp;
   GamePanel p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // cua so ko co thanh tieu de
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // full man hinh
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
       // tao doi tuong
       // GamePanel d= new GamePanel(this);
       // setContentView(d);

            mp = MediaPlayer.create(MainActivity.this,R.raw.nhac_nen);

            mp.setLooping(true);
            mp.setVolume(100, 100);
            mp.start();


       /* mp = MediaPlayer.create(MainActivity.this,R.raw.);
        mp.setLooping(true);
        mp.setVolume(100, 100);
        mp.start();*/
        setContentView(R.layout.activity_main);
    }
    public void Mogame(View view)
    {
        GamePanel d= new GamePanel(this);
        setContentView(d);

    }
    protected void onDestroy(){
        super.onDestroy();
        Log.d("looptest","huy threed");
    }
    @Override
    protected void onPause(){
        super.onPause();
        mp.release();
        finish();
    }
}
