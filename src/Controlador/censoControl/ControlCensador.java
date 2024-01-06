/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.censoControl;

import Controlador.Listas.DynamicList;
import Controlador.Dao.DaoImplement;
import Controlador.Utiles.utiles;
import Modelo.Censador;
import Modelo.CensoRegistro;
import java.lang.reflect.Field;
import java.util.EmptyStackException;

/**
 *
 * @author Alexander
 */
public class ControlCensador extends DaoImplement<Censador> {
      private DynamicList<Censador> censador;
    private Censador censador1;
     public ControlCensador() {
         super(Censador.class);
    }

    public DynamicList<Censador> getCensador() {
        censador=all();
        return censador;
    }

    public void setCensador(DynamicList<Censador> censador) {
        this.censador= censador;
    }

    public Censador getCensador1() {
        if (censador1 == null) {
            censador1 = new Censador();
        }
        return censador1;
    }

    public void setCensador1(Censador censador1) {
        this.censador1 = censador1;
    }
  
}
