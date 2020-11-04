package com.example.ejer38_encuentrapremio;


import android.util.Log;


import java.util.Random;

public class JGamePrize {
    String TAG = "Ejer_38";
    private String imagenFile;
    private int numImagen;
    private int num;
    private int[] numeros;


    /***********************************************************************************************
     Propiedades de la clase
     **********************************************************************************************/

    public String getImagenAleatoria() {
        return imagenFile;
    }

    public int getNumeroImagen() {
        return num;
    }


    /***********************************************************************************************
     Constructor de la clase
     **********************************************************************************************/

    // Creamos un array ordenado con números que se corresponden con el nº de cada archivo imagen
    // Después desordenamos el array (ver la función)

    public JGamePrize() {
        numeros= new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
        numeros=RandomizeArray(numeros);
    }

    /***********************************************************************************************
     Funciones de la clase
     **********************************************************************************************/

    // --------------------------------------------------------------------------------------------
    // imagenAleatoria() - Generamos un nº aleatorio y lo "convertimos" en una imagen
    // --------------------------------------------------------------------------------------------
    public String imagenAleatoria(String tag) {
        int posicion_casilla_clicada = Integer.parseInt(tag);
        int numImagen = numeros[posicion_casilla_clicada];
        num=numImagen;
        Log.e(TAG, "class - numImagen: "+ num);
        imagenFile = "dibujo_" + num;
        return imagenFile;
    }

    // --------------------------------------------------------------------------------------------
    // resultado() - Generamos un mensaje cuando sale el 7 o la calavera
    // --------------------------------------------------------------------------------------------
    public String resultado() {
        String msg = "";
        if (num == 7) {
            msg = "Has ganado!!";
        }
        if (num == 8) {
            msg = "Has perdido!!";
        }
        return msg;
    }

    // --------------------------------------------------------------------------------------------
    // RandomizeArray() - Desordena (barajea) el array creado por el constructor para que las
    // imágenes no salgan siempre en la misma casilla
    // --------------------------------------------------------------------------------------------

    public int[] RandomizeArray(int[] array) {
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
