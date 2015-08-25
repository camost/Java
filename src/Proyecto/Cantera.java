/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

//TODO: despues de un save, modifique o delete, cargar en archivo y actualiza la memoria.
/**
 *
 * @author kaajavi
 */
public abstract class Cantera implements Serializable{
    //Array de alumono
    
    public static ArrayList<Jugador> jugadores = new ArrayList();
    
    
    ArrayList<ArrayList<Equipo>> meter = new ArrayList<ArrayList<Equipo>>();
    
    
    //Jugador[] jugadores = new Jugador[];
    private static final String archivo = "jugador.txt";
    private static FileInputStream fis = null;
    private static ObjectInputStream ois = null;
    private static FileOutputStream fos = null;
    private static ObjectOutputStream oos = null;
    
    public static ArrayList<Jugador> getJugadores(){
        return jugadores;
    }
    
    public static void addJugador(Jugador jugador){
        jugadores.add(jugador);
        save();
        load();
    }
    
    public static Jugador getJugador(int ordenJugador){        
        return jugadores.get(ordenJugador);
    }

    
    public static int getCantidadDeJugadores(){
        return jugadores.size();
    }

    
    
    public static String save() {
        String ret = "Carga exitosa";
        boolean flag = true;
        String fileTmp = "tmpFile.db";
        //Se carga el array en un archivo temporal
        try {
            fos = new FileOutputStream(fileTmp);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(jugadores);
            

        } catch (FileNotFoundException ex) {
            flag = false;
            ret = "No se encuentra el archivo";
            return ret;
        } catch (IOException ex) {
            flag = false;
            ret = "Error al guardar el archivo";
            return ret;
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                    oos = null;
                }
                if (fos != null) {
                    fos.close();
                    fos = null;
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar archivo");
            }
        }
        //Si todo salió bien, se borra el archivo db actual 
        //y lo reemplaza por tmpFile.db
        File fdel = new File(archivo);
        File ftmp = new File(fileTmp);
        if (fdel.exists()) {
            if (fdel.delete()) {
                ftmp.renameTo(new File(archivo));
            }
        } else {
            ftmp.renameTo(new File(archivo));
        }


        return ret;

    }

    /*
     * Devuelve un arraylist con las ventas en disco
     */
    public static void load() {
        
        System.out.println("Intentando levantar la lista");
        try {
            fis = new FileInputStream(archivo);
            ois = new ObjectInputStream(fis);

            while (true) {
                jugadores = (ArrayList<Jugador>) ois.readObject();             
            }

        }catch (EOFException e1) {
            //END OF FILE!
            System.out.println("Sale");
        } catch (Exception e2) {
            System.out.println("Error!!!" + e2);
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                    ois = null;
                }
                if (fis != null) {
                    fis.close();
                    fis = null;
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar archivo");
            }
        }
        
        
    }

}









