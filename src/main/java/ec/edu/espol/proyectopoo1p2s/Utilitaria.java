/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo1p2s;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author crisp
 */
public class Utilitaria {
    public static ArrayList<Ficha> crearManoJugador(){
        ArrayList<Ficha> mano = new ArrayList<>();

        // Generar 5 fichas con números aleatorios del 1 al 6
        for (int i = 0; i < 5; i++){
            Random r1=new Random();
            int aleatorio1=r1.nextInt(6)+1;
            Random r2=new Random();
            int aleatorio2=r2.nextInt(6)+1;
            int lado1 = aleatorio1;
            int lado2 = aleatorio2;
            Ficha ficha = new Ficha(lado1, lado2);
            mano.add(ficha);
        }
        // Agregar una ficha comodín
        FichaComodin fichacod = new FichaComodin();
        mano.add(fichacod);
        return mano;
        
    }
    // ya corregi Cris
    // gracias Mar :D
}
