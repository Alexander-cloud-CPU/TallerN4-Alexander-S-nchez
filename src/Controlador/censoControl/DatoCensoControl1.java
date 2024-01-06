/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.censoControl;

import Controlador.Listas.DynamicList;
import Controlador.Dao.DaoImplement;
import Modelo.CensoRegistro;
import java.lang.reflect.Field;
import java.util.EmptyStackException;
import Controlador.Utiles.utiles;
/**
 *
 * @author Alexander
 */
public class DatoCensoControl1 extends DaoImplement<CensoRegistro> {
      private DynamicList<CensoRegistro> censo;
    private CensoRegistro censo1;
     public DatoCensoControl1() {
        super(CensoRegistro.class);
    }

    public DynamicList<CensoRegistro> getCensos() {
        censo=all();
        return censo;
    }

    public void setCensos(DynamicList<CensoRegistro> censo) {
        this.censo = censo;
    }

    public CensoRegistro getCensos1() {
        if (censo1 == null) {
            censo1 = new CensoRegistro();
        }
        return censo1;
    }

    public void setCensos1(CensoRegistro censo1) {
        this.censo1 = censo1;
    }
//    public Boolean persist(){
//        censo1.setId_censo(all().getLength()+ 1);
//        return persist(censo1);
//    }
//   

   

}

