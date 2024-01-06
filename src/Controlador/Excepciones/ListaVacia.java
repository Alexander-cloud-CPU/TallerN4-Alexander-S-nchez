/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Excepciones;

/**
 *
 * @author Alexander
 */
public class ListaVacia extends Exception{
    
    public ListaVacia(){
        
    }
    
    public ListaVacia(String msg) {
        super(msg);
    }
}
