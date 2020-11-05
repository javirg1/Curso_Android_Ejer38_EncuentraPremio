package com.example.ejer38_encuentrapremio;


import android.util.Log;


import java.util.Random;

public class JGamePrize {

    /***********************************************************************************************
     Atributos de la clase
     **********************************************************************************************/

    String TAG = "Ejer_38";
    private String imagenFile;
    private int num;
    private int[] numeros;
    private String msg;

    /***********************************************************************************************
     Propiedades de la clase
     **********************************************************************************************/

    public String getImagenAleatoria() {
        return imagenFile;
    }

    public String getMensaje() {
        return msg;
    }

    /***********************************************************************************************
     Constructor de la clase
     **********************************************************************************************/

    // Creamos un array ordenado con números que se corresponden con el nº de cada archivo imagen
    // Después desordenamos el array (ver la función)

    public JGamePrize() {
        numeros = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
        numeros = RandomizeArray(numeros);
    }

    /***********************************************************************************************
     Funciones de la clase
     **********************************************************************************************/

    // --------------------------------------------------------------------------------------------
    // imagenAleatoria() - Generamos un nº aleatorio y lo "convertimos" en una imagen
    // --------------------------------------------------------------------------------------------

    public String imagenAleatoria(String tag) {
        int posicion_casilla_clicada = Integer.parseInt(tag);
        num = numeros[posicion_casilla_clicada];
        //Log.e(TAG, "class - numImagen: " + num);
        imagenFile = "dibujo_" + num;
        return imagenFile;
    }

    // --------------------------------------------------------------------------------------------
    // isFinPartida() - Generamos un mensaje cuando sale el 7 o la calavera
    // --------------------------------------------------------------------------------------------

    public Boolean isFinPartida(){
        boolean fin=false;
        if (num == 7) {
            msg = "Has ganado!!";
            fin=true;
        }
        if (num == 8) {
            msg = "Has perdido!!";
            fin=true;
        }
        return fin;
    }

    // --------------------------------------------------------------------------------------------
    // RandomizeArray() - Desordena (barajea) el array creado por el constructor para que las
    // imágenes no salgan siempre en la misma casilla
    // --------------------------------------------------------------------------------------------

    private int[] RandomizeArray(int[] array) {
        Random rgen = new Random(); // Random number generator
        for (int i = 0; i < array.length; i++) {
            int randomPosition = rgen.nextInt(array.length);
            int temp = array[i];
            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }
        return array;
    }
}
