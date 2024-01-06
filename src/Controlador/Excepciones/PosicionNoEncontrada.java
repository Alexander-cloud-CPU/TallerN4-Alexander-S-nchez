/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Excepciones;

/**
 *
 * @author Alexander
 */
public class PosicionNoEncontrada extends Exception{
    
    public PosicionNoEncontrada(String msg){
        super(msg);
        
    }
    
    public PosicionNoEncontrada(){
        super("La posición esta fuera de los límites");
    }
    
}
