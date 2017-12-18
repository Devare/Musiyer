package mx.com.develop.musiyer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageButton ibtn_iniciar_servicio,ibtn_detener_servicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarComponentesUI();
        iniciarSetOnClickLictener();
    }

    private void inicializarComponentesUI() {
        ibtn_iniciar_servicio=(ImageButton) findViewById(R.id.ibtn_iniciar_servicio);
        ibtn_detener_servicio=(ImageButton) findViewById(R.id.ibtn_detener_servicio);
    }

    private void iniciarSetOnClickLictener() {
        ibtn_iniciar_servicio.setOnClickListener(this);
        ibtn_detener_servicio.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ibtn_iniciar_servicio:
                iniciarServicio();
                break;
            case  R.id.ibtn_detener_servicio:
                detenerServicio();
                break;
        }
    }

    private void iniciarServicio() {
        startService(new Intent(this, ServiceMusic.class).putExtra("action", ServiceMusic.START));
    }

    private void detenerServicio() {
        stopService(new Intent(this, ServiceMusic.class));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Intent i = new Intent(this, ServiceMusic.class);
        i.putExtra("action", ServiceMusic.PAUSE);
        startService(i);
    }

    @Override
    protected void onDestroy() {
        detenerServicio();
        super.onDestroy();
    }
}
