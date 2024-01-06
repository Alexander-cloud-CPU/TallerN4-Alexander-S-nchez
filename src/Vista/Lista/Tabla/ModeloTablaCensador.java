/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.Lista.Tabla;

import Controlador.Listas.DynamicList;
import Modelo.Censador;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Alexander
 */
public class ModeloTablaCensador  extends AbstractTableModel {
    private DynamicList<Censador> censadores ;

    public DynamicList<Censador> getCensadores() {
        return censadores ;
    }

    public void setCensadores(DynamicList<Censador> censadores ) {
        this.censadores  = censadores ;
    }

    
     public ModeloTablaCensador() {
        this.censadores =new DynamicList<>();
    }
    @Override
    public int getRowCount(){
        return censadores .getLongitud();
        
    }
    @Override
    public int getColumnCount() {
       // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       return 5;
    }
    @Override
    public String getValueAt(int i,int i1){
        // i=fila 1=columna
        try {
            Censador p = censadores .getInfo(i);
        switch(i1){
            case 0: return (p !=null) ? p.getNombre():" ";   //modelos ternarios
            case 1: return (p !=null) ? p.getApellido():" ";
            case 2: return (p !=null) ? p.getEdad():" ";
            case 3: return (p !=null) ? p.getCedula():" ";
            case 4: return (p !=null) ? p.getNumero():" ";
            default:
                return null;
        }
         } catch (Exception e) {
        }
        return null;
    }
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nombre";
            case 1:
                return "Apellido";
            case 2:
                return "Edad";
            case 3:
                return "Cedula";
            case 4:
                return "Numero"; 
            default:
                return null;

        }
    }
}
