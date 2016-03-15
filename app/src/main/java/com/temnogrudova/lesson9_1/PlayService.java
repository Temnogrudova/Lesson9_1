package com.temnogrudova.lesson9_1;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class PlayService extends Service
{ 
    MediaPlayer mPlayer;
    @Override 
    public IBinder onBind(Intent intent) {
        return null; 
    } 

    @Override 
    public void onCreate() {
        Toast.makeText(this, "Служба создана",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Служба запущена",
                Toast.LENGTH_SHORT).show();
        play();
        return super.onStartCommand(intent, flags, startId);
    }

    private void play() {
        mPlayer = MediaPlayer.create(this, R.raw.mario);
        mPlayer.setLooping(false);
        mPlayer.start();
    }

    @Override
    public void onDestroy() 
	{ 
        Toast.makeText(this, "Служба остановлена", 
            Toast.LENGTH_SHORT).show(); 
        mPlayer.stop(); 
    }


}