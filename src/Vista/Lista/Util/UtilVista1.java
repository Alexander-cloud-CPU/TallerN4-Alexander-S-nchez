/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.Lista.Util;

import Controlador.censos.CensadorControl1;
import Modelo.Censador;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexander
 */
public class UtilVista1 {

    public static void cargarcomboRolesL(JComboBox cbx) throws Exception {
        CensadorControl1 rc= new CensadorControl1();
        cbx.removeAllItems();
         for (int i = 0; i < rc.getCensadores().getLongitud(); i++) {
            cbx.addItem(rc.getCensadores().getInfo(i).getApellido());
        }
    }
 
    public static String  obtenerRolControl(JComboBox cbx) {
        return (String) cbx.getSelectedItem();
    }
}
