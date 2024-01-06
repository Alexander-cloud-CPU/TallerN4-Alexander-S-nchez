/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.Lista.Tabla;

import Controlador.Listas.DynamicList;
import Modelo.CensoRegistro;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Alexander
 */
public class ModeloTablaCenso extends AbstractTableModel  {
     private DynamicList<CensoRegistro> censos;

    public DynamicList<CensoRegistro> getCensos() {
        return censos;
    }

    public void setCensos(DynamicList<CensoRegistro> censos) {
        this.censos = censos;
    }
     public ModeloTablaCenso() {
        this.censos=new DynamicList<>();
    }
    @Override
    public int getRowCount(){
        return censos.getLongitud();
        
    }
    @Override
    public int getColumnCount() {
       // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       return 6;
    }
    @Override
    public String getValueAt(int i, int i1) {
        // i=fila 1=columna
        try {
            CensoRegistro p = censos.getInfo(i);

            switch (i1) {
                case 0:
                    return (p != null) ? p.getNombreCp() : " ";   //modelos ternarios
                case 1:
                    return (p != null) ? p.getEdad() : " ";
                case 2:
                    return (p != null) ? p.getEstadoCivil() : " ";
                case 3:
                    return (p != null) ? p.getFecha() : " ";
                case 4:
                    return (p != null) ? p.getMotivo_divorcio() : " ";
                case 5:
                    return (p != null) ? p.getCensador(): " ";
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
                return "Edad";
            case 2:
                return "Estado civil";
            case 3:
                return "Fecha";
            case 4:
                return "Motivo";
            case 5:
                return "Censador";

            default:
                return null;

        }
    }
    public int contarPersonasPorEstadoCivil(int columnaEstadoCivil, String estadoCivil) {
        int contador = 0;

        for (int fila = 0; fila < getRowCount(); fila++) {
            try {
                Object valorEstadoCivil = getValueAt(fila, columnaEstadoCivil);

                if (valorEstadoCivil instanceof String && ((String) valorEstadoCivil).equalsIgnoreCase(estadoCivil)) {
                    contador++;
                }
            } catch (Exception e) {
            }
        }

        return contador;
    }
}
