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
 * @author crispYmarlo
 */
public class JuegoPoo {
     public static boolean existeComodin(ArrayList<Ficha> manoJugador) {
        for (Ficha ficha : manoJugador) {
            if (ficha instanceof FichaComodin) {
                return true; 
            }
        }
        return false; 
    }
     
     public static boolean terminar(ArrayList<Ficha> Mano,Juego juego){
        for(Ficha ficha:Mano){
            if(ficha.getLado2() == juego.obtenerValorInicioLinea()){
                    return false;
            }
            else if(ficha.getLado1() == juego.obtenerValorFinLinea()){
                return false;
            }
        }
        return true;
    }
     
    public static void cargarUserVsUser(Juego juego){
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        System.out.println("Ingrese el nombre del jugador 1: ");
        String jugador1 = sc.next();                         //nombre de jugador 1
        System.out.println("Ingrese el nombre del jugador 2: ");
        String jugador2 =sc.next() ; 
        juego.agregarJugador(jugador1);
        juego.agregarJugador(jugador2);
        Jugador ju1= juego.getJugadores().get(0);
        Jugador ju2 = juego.getJugadores().get(1);
        boolean fin = false;
        
        do{    
            System.out.print("\nTurno de " + ju1.getNombre() + ": Mano -> ");
            ju1.imprimirMano();
            System.out.print("Linea de Juego -> ");
            juego.mostrarLinea();
            if(!JuegoPoo.existeComodin(ju1.getMano())){
                if(JuegoPoo.terminar(ju1.getMano(), juego)){
                    System.out.println("Perdio "+ju1.getNombre()+", no tiene fichas usables");
                    System.out.println("El ganador es: "+ ju2.getNombre());
                    fin = true;
                    break;
                }
            }
            System.out.println("Indice de ficha para jugar (0 es el primero): ");
            int userpos = Integer.parseInt(sc.next());        
            while(userpos<0 || userpos > 6){
                System.out.println("Ingrese numeros que esten dentro del rango");
                userpos = Integer.parseInt(sc.next());        
            }
            while(userpos>ju1.getMano().size()-1){
                System.out.println("Ingrese numeros que esten dentro del rango");
                userpos = Integer.parseInt(sc.next());        
            }
                //Validacion    
            while(!juego.agregarFichaLinea(ju1.getFicha(userpos), ju1)){
                System.out.println(ju1.getFicha(userpos)+" No puede jugar esta ficha, intentalo de nuevo");
                System.out.print("Indice de ficha para jugar (0 es el primero): ");
                userpos = Integer.parseInt(sc.next());          
            }
            System.out.println("Movimiento Valido");
            System.out.print("Nueva Linea de Juego -> ");
            juego.mostrarLinea();
                //Juego con el humano            
            System.out.print("\nTurno de " + ju2.getNombre() + ": Mano -> ");
            ju2.imprimirMano();
            System.out.print("Linea de Juego -> ");
            juego.mostrarLinea();
            if(!JuegoPoo.existeComodin(ju2.getMano())){
                if(JuegoPoo.terminar(ju2.getMano(), juego)){
                    System.out.println("Perdio "+ju2.getNombre()+", no tiene fichas usables");
                    System.out.println("El ganador es: "+ ju1.getNombre());
                    fin = true;
                    break;
                }
            }
            System.out.println("Indice de ficha para jugar (0 es el primero): ");
            userpos = Integer.parseInt(sc.next());        
            while(userpos<0 || userpos > 6){
                System.out.println("Ingrese numeros que esten dentro del rango");
                userpos = Integer.parseInt(sc.next());            
            }
            while(userpos>ju2.getMano().size()-1){
                System.out.println("Ingrese numeros que esten dentro del rango");
                userpos = Integer.parseInt(sc.next());        
            }
                //Validacion
                
            while(!juego.agregarFichaLinea(ju2.getFicha(userpos), ju2)){
                System.out.println(ju2.getFicha(userpos)+" No puede jugar esta ficha, intentalo denuevo");
                System.out.print("Indice de ficha para jugar (0 es el primero): ");
                userpos = Integer.parseInt(sc.next());             
                }
            System.out.println("Movimiento Valido");
            System.out.print("Nueva Linea de Juego -> ");
            juego.mostrarLinea();            
            if(ju2.getMano().isEmpty()){
                System.out.println("Gano "+ju2.getNombre());
                fin = true;
                break;                        
            }        
            else{           
                if(ju1.getMano().isEmpty()){
                    System.out.println("Gano "+ju1.getNombre());
                    fin = true;
                    break;                  
                }
            }        
        }while(fin == false);
        System.out.println("GAME OVER");
    }
     
    public static void cargarJuegoUser(Juego juego){
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        System.out.println("EL PRIMER JUGADOR ES EL USUARIO ");
        System.out.println("Ingrese el nombre del jugador: ");
        String jugador2 = sc.next();                         //nombre de jugador 1
        System.out.println("EL SEGUNDO JUGADOR ES LA MAQUINA ");
        String jugador1 = "Robot" ;                   //nombre de jugador 2
                                // se agregan jugadores
        juego.agregarJugador(jugador1);
        juego.agregarJugador(jugador2);
        Jugador ju1= juego.getJugadores().get(0);
        Jugador ju2 = juego.getJugadores().get(1);
        boolean fin = false;
        do{
            System.out.print("\nTurno de " + ju2.getNombre() + ": Mano -> ");
            ju2.imprimirMano();
            System.out.print("Linea de Juego -> ");
            juego.mostrarLinea();
            if(!JuegoPoo.existeComodin(ju2.getMano())){
                if(JuegoPoo.terminar(ju2.getMano(), juego)){
                    System.out.println("Perdio "+ju2.getNombre()+", no tiene fichas usables");
                    System.out.println("El ganador es: "+ ju1.getNombre());
                    fin = true;
                    break;
                }
            }
            System.out.println("Indice de ficha para jugar (0 es el primero): ");
            int userpos = Integer.parseInt(sc.next());               
            while(userpos<0 || userpos > 6){
                System.out.println("Ingrese numeros que esten dentro del rango");
                userpos = Integer.parseInt(sc.next());        
            }
            while(userpos>ju2.getMano().size()-1){
                System.out.println("Ingrese numeros que esten dentro del rango");
                userpos = Integer.parseInt(sc.next());
                    
            }
                //Validacion            
            while(!juego.agregarFichaLinea(ju2.getFicha(userpos), ju2)){
                System.out.println(ju2.getFicha(userpos)+" No puede jugar esta ficha, intentalo de nuevo");
                System.out.print("Indice de ficha para jugar (0 es el primero): ");
                userpos = Integer.parseInt(sc.next());           
            }
            System.out.println("Movimiento Valido");
            System.out.print("Nueva Linea de Juego -> ");
            juego.mostrarLinea();                 
            System.out.print("\nTurno de " + juego.getJugadores().get(0).getNombre() + ": Mano -> ");
            ju1.imprimirMano();
            System.out.print("Linea de Juego -> ");
            juego.mostrarLinea();
            if(!JuegoPoo.existeComodin(ju1.getMano())){
                if(JuegoPoo.terminar(ju1.getMano(), juego)){
                    System.out.println("Perdio "+ju1.getNombre()+", no tiene fichas jugables");
                    System.out.println("El ganador es: "+ ju2.getNombre());
                    fin = true;
                    break;
                }
            }
            juego.agregarFichaLineaMaquina();
            System.out.print("Nueva Linea de Juego -> ");
            juego.mostrarLinea();
            if(ju2.getMano().isEmpty()){
                System.out.println("Gano "+ju2.getNombre());
                fin = true;
                break;                        
            }
                    
            else{
                if(ju1.getMano().isEmpty()){
                    System.out.println("Gano "+ju1.getNombre());
                    fin = true;       
                    break;   
                }
            }         
        }while(fin == false);
        System.out.println("GAME OVER"); 
    }
     
    public static void cargarJuegoMaquina(Juego juego){
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        System.out.println("EL PRIMER JUGADOR ES UNA MAQUINA ");
        String jugador1 = "Robot";                         //nombre de jugador 1
        System.out.println("Ingrese el nombre del jugador: ");
        String jugador2 = sc.next();                           //nombre de jugador 2
        juego.agregarJugador(jugador1);                        // se agregan jugadores
        juego.agregarJugador(jugador2);
        //lanzar ficha maquina
        boolean fin = false;
        
        
        do{
            Jugador ju1= juego.getJugadores().get(0);
            Jugador ju2 = juego.getJugadores().get(1);
            System.out.print("\nTurno de " + juego.getJugadores().get(0).getNombre() + ": Mano -> ");
            ju1.imprimirMano();
            System.out.print("Linea de Juego -> ");
            juego.mostrarLinea();
            if(!JuegoPoo.existeComodin(ju1.getMano())){
                if(JuegoPoo.terminar(ju1.getMano(), juego)){
                    System.out.println("Perdio "+ju1.getNombre()+", no tiene fichas jugables");
                    System.out.println("El ganador es: "+ ju2.getNombre());
                    fin = true;
                    break;
                }
            }
            juego.agregarFichaLineaMaquina();
            System.out.print("Nueva Linea de Juego -> ");
            juego.mostrarLinea();
                
            //Juego con el humano 
            System.out.print("\nTurno de " + ju2.getNombre() + ": Mano -> ");
            ju2.imprimirMano();
            System.out.print("Linea de Juego -> ");
            juego.mostrarLinea();
            if(!JuegoPoo.existeComodin(ju2.getMano())){
                if(JuegoPoo.terminar(ju2.getMano(), juego)){
                    System.out.println("Perdio "+ju2.getNombre()+", no tiene fichas usables");
                    System.out.println("El ganador es: "+ ju1.getNombre());
                    fin = true;
                    break;
                }
            }
            System.out.println("Indice de ficha para jugar (0 es el primero): ");
            int userpos = Integer.parseInt(sc.next());
            while(userpos<0 || userpos > 6){
                System.out.println("Ingrese numeros que esten dentro del rango");
                userpos = Integer.parseInt(sc.next());
                    
            }
            while(userpos>ju2.getMano().size()-1){
                System.out.println("Ingrese numeros que esten dentro del rango");
                userpos = Integer.parseInt(sc.next());
                    
            }            
                //Validacion
                
            while(!juego.agregarFichaLinea(ju2.getFicha(userpos), ju2)){
                System.out.println(ju2.getFicha(userpos)+" No puede jugar esta ficha, intentalo de nuevo");
                System.out.print("Indice de ficha para jugar (0 es el primero): ");
                userpos = Integer.parseInt(sc.next());         
            }
            System.out.println("Movimiento Valido");
            System.out.print("Nueva Linea de Juego -> ");
            juego.mostrarLinea();        
            if(ju2.getMano().isEmpty()){
                System.out.println("Gano "+ju2.getNombre());
                fin = true;
                break;                 
            }
                
            else{                
                if(ju1.getMano().isEmpty()){
                    System.out.println("Gano "+ju1.getNombre());
                    fin = true;
                    break;                        
                }
            }        
        }while(fin == false);
        System.out.println("GAME OVER"); 
         
    }
    public static void main(String[] args) {
        
        Juego juego = new Juego();
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        System.out.println("Ingrese si quiere jugar contra una máquina (0) o contra un amigo (1): ");
        int opcion = sc.nextInt();
        while(opcion<0 || opcion>1){
           System.out.println("Ingrese si quiere jugar contra una máquina (0) o contra un amigo (1) \nIngrese una opcion valida: ");
           opcion = sc.nextInt();
        }
        if(opcion==0){
            Random cris = new Random();
            int mar = cris.nextInt(2);
            if(mar ==0)
            JuegoPoo.cargarJuegoMaquina(juego);
           else{
            JuegoPoo.cargarJuegoUser(juego);
            }
            
        }
        else{
            System.out.println("BIENVENIDO/A AL 1vs1 CON TU AMIGO/A");
            JuegoPoo.cargarUserVsUser(juego);
            
        }
    }
}
