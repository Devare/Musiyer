package mx.com.develop.musiyer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class ServiceMusic extends Service {
    private MediaPlayer player;
    static final int START = 3, PAUSE = 4;
    Boolean shouldPause = false;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "Servicio Creado", Toast.LENGTH_LONG).show();
        player = MediaPlayer.create(this, R.raw.android_oreo_presentacion);
        player.setLooping(true);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Servicio Detenido", Toast.LENGTH_LONG).show();
        player.stop();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Servicio Iniciado", Toast.LENGTH_LONG).show();
        try {
            int actionDefault = 0;
            int action = actionDefault;

            if (intent != null) {
                if (intent.hasExtra("action"))
                    action = intent.getIntExtra("action", actionDefault);
            }

            switch (action) {

                case START:
                    start();
                    break;
                case PAUSE:
                    pause();
                    break;
            }
        } catch (Exception e) { e.printStackTrace(); }
        return super.onStartCommand(intent, flags, startId);
    }

    private void start() {
        if (!player.isPlaying()) {
            player.setLooping(true);
            player.start();
        }
        shouldPause = false;
    }

    private void pause() {
        shouldPause = true;
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        if (shouldPause) {
                            player.pause();
                        }
                    }
                }, 100);
    }
}
