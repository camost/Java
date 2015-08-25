package Proyecto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author fran
 */
import java.io.Serializable;
import javax.swing.DefaultListModel;
public class Jugador implements Serializable{
    
    private String nombre, legajo;
    private int H1, H2, H3, H4;

    public Jugador(String nombre, int H1, int H2, int H3, int H4) {
        this.nombre = nombre;
        this.H1 = H1;
        this.H2 = H2;
        this.H3 = H3;
        this.H4 = H4;
    }
    
     public String toString(){
         return ""+this.nombre+" - "+this.H1+"-"+this.H2 +"-"+this.H3+"-"+this.H4;
     }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public int getH1() {
        return H1;
    }

    public void setH1(int H1) {
        this.H1 = H1;
    }

    public int getH2() {
        return H2;
    }

    public void setH2(int H2) {
        this.H2 = H2;
    }

    public int getH3() {
        return H3;
    }

    public void setH3(int H3) {
        this.H3 = H3;
    }

    public int getH4() {
        return H4;
    }

    public void setH4(int H4) {
        this.H4 = H4;
    }




    
    
    
    

    

}
