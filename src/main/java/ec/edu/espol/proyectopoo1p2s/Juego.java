/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo1p2s;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author marlo
 */
// Cris estuvo aqui
public class Juego {
    
    private ArrayList<Ficha> lineaJuego;
    private ArrayList<Jugador> jugadores;
    
    public Juego(){
        this.jugadores=new ArrayList<>();
        this.lineaJuego=new ArrayList<>();
    }
    
    public void agregarJugador(String nombre){
        
        Jugador newjuga = new Jugador (nombre,Utilitaria.crearManoJugador());
        this.jugadores.add(newjuga);
        
    }
    public int obtenerValorInicioLinea(){
        return this.lineaJuego.get(0).getLado1();
    }
    
    public int obtenerValorFinLinea(){
        int pos = this.lineaJuego.size()-1;
        
        return this.lineaJuego.get(pos).getLado2();
        
       
    }
    
    public void mostrarLinea(){
        StringBuilder sb = new StringBuilder();
    
    for (int i = 0; i < this.lineaJuego.size(); i++) {
        Ficha fichi = this.lineaJuego.get(i);
        
        sb.append(fichi);
        
        if (i < this.lineaJuego.size() - 1) {
            sb.append('-');
        }
    }
    
    System.out.println(sb.toString());
        
    }

    public ArrayList<Ficha> getLineaJuego() {
        return lineaJuego;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }
    
    public boolean agregarFichaLinea(Ficha f, Jugador j){
        if(f instanceof FichaComodin){
            Scanner sc= new Scanner(System.in);
            sc.useDelimiter("\n");
            FichaComodin efecita= (FichaComodin)f;
            if(lineaJuego.isEmpty()){
                System.out.println("Ingrese un lado 1: ");
                int ladito1= sc.nextInt();
                while(ladito1 <1 && ladito1 >6){
                    System.out.println("Escribe un valor válido del lado 1");
                    ladito1= sc.nextInt();
                }
                efecita.setLado1(ladito1);
                System.out.println("Ingrese un lado 2: ");
                int ladito2= sc.nextInt();
                while(ladito2 <1 && ladito2>6){
                    System.out.println("Escribe un valor válido del lado 2");
                    ladito2= sc.nextInt();
                }                
                
                efecita.setLado2(ladito2);
                lineaJuego.add(efecita);
                j.removerFicha(efecita);
                return true;
            }    
            else{
                
                System.out.println("¿Donde quieres posicionar tu ficha? ¿Inicio o Fin?: ");
                String palabrita = sc.next();
                while (!palabrita.equals("Inicio") && !palabrita.equals("Fin")) {
                    System.out.println("Palabra no válida, ingrese Inicio o Fin: ");
                    palabrita = sc.next();
                }
                if (palabrita.equals("Inicio")) {
                    System.out.println("Escribe el valor del lado 1");
                    int laditito1 = sc.nextInt();
                    while (laditito1 < 1 || laditito1 > 6) {
                        System.out.println("Escribe un valor válido del lado 1");
                        laditito1 = sc.nextInt();
                    }
                    efecita.setLado1(laditito1);
                    lineaJuego.add(0, f);
                    j.removerFicha(efecita);
                    return true;
                }
                else if(palabrita.equals("Fin")){
                    System.out.println("Esribe el valor del lado2");
                    int laditito2= sc.nextInt();
                    while(laditito2 <1 && laditito2>6){
                        System.out.println("Escribe un valor válido del lado 1");
                        laditito2= sc.nextInt();
                    }                    
                    efecita.setLado2(laditito2);
                    lineaJuego.add(lineaJuego.size()-1,f); 
                    j.removerFicha(efecita);
                    return true;    
                }     
            } 
        }    
        
        else{
            if(lineaJuego.isEmpty()){
                lineaJuego.add(f);
                j.removerFicha(f);
                return true;
            }
            
            else{
                if(f.getLado2()==this.obtenerValorInicioLinea()){
                    lineaJuego.add(0, f);
                    j.removerFicha(f);
                    return true;
                    }
                    
                else if(f.getLado1()==this.obtenerValorFinLinea()){
                    lineaJuego.add(lineaJuego.size()-1, f);
                    j.removerFicha(f);
                    return true;

                    }
                
                return false;    
                   
                }
                
        }
        
        return false;
    }
    //corregido ;)
    public boolean agregarFichaLineaMaquina(){
        Jugador ju = this.jugadores.get(0);
        if(lineaJuego.isEmpty()){
            Ficha efecita = this.jugadores.get(0).getMano().get(0);
            this.lineaJuego.add(efecita);
            ju.removerFicha(efecita);
            return true;
        }  
        
        else{
            int poder= 0;
            for(Ficha fi : ju.getMano()){
                if(fi.getLado1()== this.obtenerValorFinLinea()){
                    this.lineaJuego.add(this.lineaJuego.size()-1, fi);
                    ju.removerFicha(fi);
                    poder=1;
                    return true;
                    
                }
                else if(fi.getLado2()==this.obtenerValorInicioLinea()){
                    this.lineaJuego.add(0, fi);
                    ju.removerFicha(fi);
                    poder=1;
                    return true;   
                }
            }
     
            if(poder==0){
                Ficha comodin =ju.getFicha(ju.getMano().size()-1);
                FichaComodin efecita = (FichaComodin)comodin;
                
                Random randi = new Random();
                int ran = randi.nextInt(2);
            
                if(ran==0){
                    Random nuevito = new Random();
                    int cris= nuevito.nextInt(1,7);
                    efecita.setLado1(cris);
                    this.lineaJuego.add(0, efecita);
                    ju.removerFicha(comodin);
                    return true;
                }
                else{
                    Random nuevito = new Random();
                    int cris= nuevito.nextInt(1,7);
                    efecita.setLado2(cris);
                    this.lineaJuego.add(this.lineaJuego.size()-1, efecita);
                    ju.removerFicha(comodin);
                    return true;
                    
                }       
            }   
            return false;
        }
    }
}   
