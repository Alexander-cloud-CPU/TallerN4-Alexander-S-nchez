/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.censos;


import Controlador.Listas.DynamicList;
import Controlador.Dao.DaoImplement;
import Modelo.Censo;



/**
 *
 * @author Alexander
 */
public class CensoControl1 extends DaoImplement<Censo>{
     private DynamicList<Censo>listR=new DynamicList<>();
     private Censo censo;
     
     public CensoControl1(){
         super(Censo.class);
     }
    public DynamicList<Censo> getListR() {
        listR=all();
        return listR;
    }

    public void setListR(DynamicList<Censo> listR) {
        this.listR = listR;
    }

    public Censo getCenso() {
        if(censo==null)
            censo=new Censo();
            return censo;
        
        
    }


    public void setCenso(Censo censo) {
        this.censo = censo;
    }
//    public Boolean persit(){
//        censo.setId(all().getLength()+1);
//        
//        return persist(censo);
//    }
//    public static void main(String[]args){
//        CensoControl1 rc=new CensoControl1();
//        System.out.println(rc.all());
//        rc.getCasa().setDescripcion("Vivienda independiente");
//        rc.getCasa().setNombre_censo("Censo unifamiliar");
//        rc.persit();
//        rc.setCasa(null);
//        
//        rc.getCasa().setDescripcion("Comparten paredes laterales");
//        rc.getCasa().setNombre_censo("Censo adosada");
//        rc.persit();
//        rc.setCasa(null);
//        rc.getCasa().setDescripcion("Dos viviendas separadas");
//        rc.getCasa().setNombre_censo("Doplex");
//        rc.persit();
//        rc.setCasa(null);
//        rc.getCasa().setDescripcion("Tres viviendas separadas");
//        rc.getCasa().setNombre_censo("Triplex");
//        rc.persit();
//        rc.setCasa(null);
//         
//    }
}
