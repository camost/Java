package Proyecto;

/** 
* 
* @ author Chino 
*/ 

import java.awt.Graphics; 
import javax.swing.ImageIcon; 


public class fondoGrafico extends javax.swing.JPanel { 
    
    public fondoGrafico(){
        this.setSize(750, 466); 
        } 
    public void paintComponent(Graphics g){ 
        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/Imagenes/field.png" ) ) ; 

        g.drawImage(imagenFondo.getImage(),0,0,750, 466, null); 
        setOpaque(false); 
        super.paintComponent(g); 
} 

}