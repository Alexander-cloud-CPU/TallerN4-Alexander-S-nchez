/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.censos;

import Controlador.Dao.DaoImplement;
import Controlador.Listas.DynamicList;
import Controlador.Utiles.utiles;
import Modelo.Censador;
import Modelo.CensoRegistro;
import java.lang.reflect.Field;
import java.util.EmptyStackException;

/**
 *
 * @author Alexander
 */
public class CensadorControl1 extends DaoImplement<Censador> {

    private DynamicList<Censador> listR = new DynamicList<>();
    private Censador censador;

    public CensadorControl1() {
        super(Censador.class);
    }

    public DynamicList<Censador> getCensadores() {
        return listR = all();
    }

    public void setListR(DynamicList<Censador> listR) {
        this.listR = listR;
    }

    public Censador getCensador() {
        if (censador == null) {
            censador = new Censador();
        }
        return censador;

    }

    public void setCensador(Censador censador) {
        this.censador = censador;
    }


    public DynamicList<Censador> ordenar(DynamicList<Censador> lista, Integer tipo, String field) throws Exception, Exception {
        Field attribute = utiles.getField(Censador.class, field);
        Integer n = lista.getLongitud();
        Censador[] censadores = lista.toArray();
        if (attribute != null) {
            for (int i = 0; i < n; i++) {
                int k = i;
                Censador t = censadores[i];
                for (int j = i + 1; j < n; j++) {
                    if (censadores[j].compare(t, field, tipo)) {
                        t = censadores[j];
                        k = j;
                    }
                }
                censadores[k] = censadores[i];
                censadores[i] = t;
            }
        } else {
            throw new Exception("No existe el criterio de busqueda");
        }
        return lista.toList(censadores);
    }

    public DynamicList<Censador> buscarPorCriterio(String texto, DynamicList<Censador> censador, String criterio, boolean usarBusquedaBinaria) {
        if (usarBusquedaBinaria) {
            return buscarPorCriterioBinario(texto, censador, criterio);
        } else {
            return buscarPorCriterioLineal(texto, censador, criterio);
        }
    }

    private String obtenerValorPorCriterio(Censador censador, String criterio) {
        switch (criterio.toLowerCase()) {
            case "apellido":
                return censador.getApellido().toLowerCase();
            case "nombre":
                return censador.getNombre().toLowerCase();
            case "edad":
                return String.valueOf(censador.getEdad());
            default:
                throw new IllegalArgumentException("Criterio no válido");
        }
    }

    public DynamicList<Censador> buscarPorCriterioLineal(String texto, DynamicList<Censador> censador, String criterio) {
        DynamicList<Censador> lista = new DynamicList<>();

        try {
            Censador[] aux = ordenar(censador, 0, criterio).toArray();

            for (Censador p : aux) {
                String valor = obtenerValorPorCriterio(p, criterio).toLowerCase();
                if (valor.contains(texto.toLowerCase())) {
                    lista.Agregar(p);
                }
            }
        } catch (Exception e) {
            System.err.println("Error en buscar" + e.getMessage());
        }

        return lista;
    }

    public DynamicList<Censador> buscarPorCriterioBinario(String texto, DynamicList<Censador> censador, String criterio) {
        DynamicList<Censador> lista = new DynamicList<>();

        try {
            Censador[] aux = ordenar(censador, 0, criterio).toArray();

            int index = busquedaBinaria(aux, texto, criterio);

           
            if (index >= 0) {
                
                for (int i = index - 1; i >= 0; i--) {
                    if (obtenerValorPorCriterio(aux[i], criterio).toLowerCase().contains(texto.toLowerCase())) {
                        lista.Agregar(aux[i]);
                    } else {
                        break;  
                    }
                }

                
                lista.Agregar(aux[index]);

               
                for (int i = index + 1; i < aux.length; i++) {
                    if (obtenerValorPorCriterio(aux[i], criterio).toLowerCase().contains(texto.toLowerCase())) {
                        lista.Agregar(aux[i]);
                    } else {
                        break; 
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error en buscar" + e.getMessage());
        }

        return lista;
    }

    private int busquedaBinaria(Censador[] array, String texto, String criterio) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            String midValue = obtenerValorPorCriterio(array[mid], criterio).toLowerCase();

            if (midValue.compareTo(texto.toLowerCase()) == 0) {
                return mid;  
            } else if (midValue.compareTo(texto.toLowerCase()) < 0) {
                left = mid + 1;  
            } else {
                right = mid - 1;  
            }
        }

        return -1;  
    }

}
