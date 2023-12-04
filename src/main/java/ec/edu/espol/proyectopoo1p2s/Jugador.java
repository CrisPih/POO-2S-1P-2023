/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo1p2s;

import java.util.ArrayList;

/**
 *
 * @author crisp
 */
//mar was here
public class Jugador {
    
    private String nombre;
    private ArrayList<Ficha> mano;
    
    public Jugador(String nombre,ArrayList<Ficha> mano){
        this.nombre=nombre;
        this.mano=mano;
        
    }
    public Ficha getFicha(int i){
        
        if(i>=0 && i<this.mano.size()){
            return this.mano.get(i);
        }
        else
        {
            return null;
        }
    }

    public ArrayList<Ficha> getMano() {
        return mano;
    }
  
    public String getNombre() {
        return nombre;
    }
    public void removerFicha(Ficha f){
        this.mano.remove(f);
    }
    public void imprimirMano(){   
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.mano.size(); i++) {
            Ficha fichi = this.mano.get(i);
            sb.append(fichi);
            if (i < this.mano.size() - 1) {
                sb.append(" - ");
            }
        }
    System.out.println(sb.toString());
    }
}
