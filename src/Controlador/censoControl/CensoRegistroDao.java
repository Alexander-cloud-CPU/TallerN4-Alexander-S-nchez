/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.censoControl;

import Controlador.Dao.DaoImplement;
import Controlador.Listas.DynamicList;
import Modelo.CensoRegistro;

/**
 *
 * @author Alexander
 */
public class CensoRegistroDao extends DaoImplement<CensoRegistro> {

    private DynamicList<CensoRegistro> ListaCensos = new DynamicList<>();
    private CensoRegistro censos;
    
    public CensoRegistroDao(){
        super (CensoRegistro.class);
    }

    public DynamicList<CensoRegistro> getListaCensos() {
        ListaCensos = all();
        return ListaCensos;
    }

    public void setListaCensos(DynamicList<CensoRegistro> ListaCensos) {
        this.ListaCensos = ListaCensos;
    }

    public CensoRegistro getCensos() {
        if(censos == null){
            censos = new CensoRegistro();
        }
        return censos;
    }

    public void setCensos(CensoRegistro censos) {
        this.censos = censos;
    }
    
    public Boolean Persist(){
        censos.setId_censo(all().getLongitud()+1);
        return Persist(censos);
    }
}
