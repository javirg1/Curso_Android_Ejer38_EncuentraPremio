package com.example.ejer38_encuentrapremio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /***********************************************************************************************
     Funciones de la clase
     **********************************************************************************************/

    // --------------------------------------------------------------------------------------------
    // descubreCasilla() - Recoge el nombre del recurso drawable y lo convierte en el Id del recurso
    // --------------------------------------------------------------------------------------------

    private int descubreCasilla(String tag){
        juego.imagenAleatoria(tag);
        String nombreImagen = juego.getImagenAleatoria();
        int resId = getResources().getIdentifier(nombreImagen, "drawable", getPackageName());
        return resId;
    }

    // --------------------------------------------------------------------------------------------
    // deshabilitarCasillas()
    // --------------------------------------------------------------------------------------------

    private void deshabilitarCasillas(){
        img0.setEnabled(false);
        img1.setEnabled(false);
        img2.setEnabled(false);
        img3.setEnabled(false);
        img4.setEnabled(false);
        img5.setEnabled(false);
        img6.setEnabled(false);
        img7.setEnabled(false);
        img8.setEnabled(false);
    }

    // --------------------------------------------------------------------------------------------
    // nuevaPartida()
    // --------------------------------------------------------------------------------------------

    private void nuevaPartida(){

        juego=new JGamePrize();

        tvResultado.setText("");
        img0.setImageResource(R.drawable.interrogacion);
        img1.setImageResource(R.drawable.interrogacion);
        img2.setImageResource(R.drawable.interrogacion);
        img3.setImageResource(R.drawable.interrogacion);
        img4.setImageResource(R.drawable.interrogacion);
        img5.setImageResource(R.drawable.interrogacion);
        img6.setImageResource(R.drawable.interrogacion);
        img7.setImageResource(R.drawable.interrogacion);
        img8.setImageResource(R.drawable.interrogacion);

        img0.setEnabled(true);
        img1.setEnabled(true);
        img2.setEnabled(true);
        img3.setEnabled(true);
        img4.setEnabled(true);
        img5.setEnabled(true);
        img6.setEnabled(true);
        img7.setEnabled(true);
        img8.setEnabled(true);

    }

    /***********************************************************************************************
     Objetos de la clase
     **********************************************************************************************/

    private String TAG = "Ejer_38";

    private JGamePrize juego;
    private TextView tvResultado;

    private ImageView img0;
    private ImageView img1;
    private ImageView img2;
    private ImageView img3;
    private ImageView img4;
    private ImageView img5;
    private ImageView img6;
    private ImageView img7;
    private ImageView img8;

    /***********************************************************************************************
     onCreate
     **********************************************************************************************/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instanciamos el objeto de la clase JGamePrize
        juego=new JGamePrize();


        // Enlazamos con la activity
        img0 = findViewById(R.id.img0);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        img5 = findViewById(R.id.img5);
        img6 = findViewById(R.id.img6);
        img7 = findViewById(R.id.img7);
        img8 = findViewById(R.id.img8);

        tvResultado = findViewById(R.id.tvResultado);

        Button btnNuevaPartida = findViewById(R.id.btnNuevaPartida);

        // Registramos el evento click, de forma global:
        img0.setOnClickListener(MainActivity.this);
        img1.setOnClickListener(MainActivity.this);
        img2.setOnClickListener(MainActivity.this);
        img3.setOnClickListener(MainActivity.this);
        img4.setOnClickListener(MainActivity.this);
        img5.setOnClickListener(MainActivity.this);
        img6.setOnClickListener(MainActivity.this);
        img7.setOnClickListener(MainActivity.this);
        img8.setOnClickListener(MainActivity.this);

        btnNuevaPartida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nuevaPartida();
            }
        });

    }

    /***********************************************************************************************
     onClick - Evento click en cada ImageView
     **********************************************************************************************/

    @Override
    public void onClick(View view) {
        ImageView imgClickada = (ImageView) view;
        int resId=descubreCasilla(imgClickada.getTag().toString());
        imgClickada.setImageResource(resId);
        int num=juego.getNumeroImagen();
        Log.e(TAG, "MainActivity - onClick - getNumeroImagen: "+ num);
        if (juego.getNumeroImagen()==7 || juego.getNumeroImagen()==8){
            String mensaje = String.format(getString(R.string.msg_resultado),juego.resultado());
            tvResultado.setText(mensaje);
            deshabilitarCasillas();
        }

    }



}