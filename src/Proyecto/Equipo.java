/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;



import java.util.ArrayList;

/**
 *
 * @author camilo
 */
public class Equipo {

    String  nombreEquipo;
    ArrayList<Jugador> nombreArrayList;
// Añade el elemento al ArrayList

// Añade el elemento al ArrayLiest en la posición 'n'
//nombreArrayList.add(n, "Elemento 2");
// Devuelve el numero de elementos del ArrayList

    public Equipo(String nombreEquipo) {
        this.nombreEquipo=nombreEquipo;
    }

    public Equipo(String nomb,ArrayList<Jugador> equi) {
        this.nombreEquipo=nomb;
        this.nombreArrayList=equi;
    }

    public boolean addJugador(Jugador ju){
        try{
            this.nombreArrayList.add(ju);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public ArrayList<Jugador> getEquipo(){
        for (int i = 0; i < nombreArrayList.size(); i++) {
            if (nombreArrayList.get(i)== null){
                nombreArrayList.addAll(i,Cantera.getJugadores());
            //nombreArrayList.add(Cantera.getJugadores());
            }
            
            
        }
        return nombreArrayList;
    }
}

