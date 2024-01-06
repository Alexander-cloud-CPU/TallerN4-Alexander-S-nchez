/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Utiles;

import Controlador.Excepciones.ListaVacia;
import Controlador.Excepciones.PosicionNoEncontrada;
import Controlador.Listas.DynamicList;
import Modelo.CensoRegistro;
import java.lang.reflect.Field;

/**
 *
 * @author Alexander
 */
   public class utiles {
    public static Field getField(Class clazz, String attrubute){
        Field field = null;
//        Field[] fields = clazz.getFields();
        for (Field f : clazz.getSuperclass().getDeclaredFields()) {
            System.out.println(f.getName() + " " + f.getType().getName());
            if (f.getName().equalsIgnoreCase(attrubute)) {
                field = f;
                break;
            }
        }
        for (Field f : clazz.getDeclaredFields()) {
            System.out.println(f.getName() + " " + f.getType().getName());
            if (f.getName().equalsIgnoreCase(attrubute)) {
                field = f;
                break;
            }
        }
        return field;
    }
    
    public static DynamicList<CensoRegistro> QuickSort(DynamicList<CensoRegistro>  listaPersonas, Integer Orden, String Campo) throws ListaVacia, PosicionNoEncontrada {
        if (listaPersonas == null || listaPersonas.getLongitud() <= 1) {
            return listaPersonas;
        }
        quicksortRecursivo(listaPersonas, 0, listaPersonas.getLongitud() - 1, Orden, Campo);
        return listaPersonas;
    }

    private static void quicksortRecursivo(DynamicList<CensoRegistro> listaPersonas, int inicio, int fin, Integer orden, String Campo) throws ListaVacia, PosicionNoEncontrada {
        if (inicio < fin) {
            int indiceParticion = Particionar(listaPersonas, inicio, fin, orden, Campo);
            quicksortRecursivo(listaPersonas, inicio, indiceParticion - 1, orden, Campo);
            quicksortRecursivo(listaPersonas, indiceParticion + 1, fin, orden, Campo);
        }
    }

    private static int Particionar(DynamicList<CensoRegistro>  listaPersonas, int inicio, int fin, Integer orden, String Campo) throws ListaVacia, PosicionNoEncontrada {
        CensoRegistro pivote = listaPersonas.getInfo(fin);
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (pivote.comparar(listaPersonas.getInfo(j), Campo, orden)) {
                i++;
                Intercambiar(listaPersonas, i, j);
            }
        }
        Intercambiar(listaPersonas, i + 1, fin);
        return i + 1;
    }

    private static void Intercambiar(DynamicList<CensoRegistro>  listaPersonas, int i, int j) throws ListaVacia, PosicionNoEncontrada {
        CensoRegistro ayuda = listaPersonas.getInfo(i);
        listaPersonas.modificarPosicion(listaPersonas.getInfo(j), i);
        listaPersonas.modificarPosicion(ayuda, j);
    }
    
    public static DynamicList<CensoRegistro>  BusquedaBinaria(DynamicList<CensoRegistro>  lista, String query, String field) throws ListaVacia, PosicionNoEncontrada {
        DynamicList<CensoRegistro>  listaOrdenada = QuickSort(lista, 1, field);
        DynamicList<CensoRegistro> resultado = new DynamicList<>();

        boolean encontrado = false;
        int inicio = 0;
        int fin = listaOrdenada.getLongitud() - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            CensoRegistro Mitad = listaOrdenada.getInfo(medio);
            Field campo = getField(CensoRegistro.class, field);

            try {
                campo.setAccessible(true);
                Object valorMedioObj = campo.get(Mitad);
                String valorMedio = (valorMedioObj != null) ? valorMedioObj.toString() : "";

                if (valorMedio.toLowerCase().contains(query.trim().toLowerCase())) {
                    encontrado = true;
                    resultado.AgregarFinal(Mitad);
                    int j = medio - 1;
                    while (j >= 0) {
                        CensoRegistro personaAnterior = listaOrdenada.getInfo(j);
                        Object valorAnteriorObj = campo.get(personaAnterior);
                        String valorAnterior = (valorAnteriorObj != null) ? valorAnteriorObj.toString() : "";

                        if (valorAnterior.toLowerCase().contains(query.trim().toLowerCase())) {
                            resultado.AgregarFinal(personaAnterior);
                            j--;
                        } 
                        else {
                            break;
                        }
                    }
                    int i = medio + 1;
                    while (i < listaOrdenada.getLongitud()) {
                        CensoRegistro personaSiguiente = listaOrdenada.getInfo(i);
                        Object valorSiguienteObj = campo.get(personaSiguiente);
                        String valorSiguiente = (valorSiguienteObj != null) ? valorSiguienteObj.toString() : "";

                        if (valorSiguiente.toLowerCase().contains(query.trim().toLowerCase())) {
                            resultado.AgregarFinal(personaSiguiente);
                            i++;
                        } 
                        else {
                            break;
                        }
                    }
                    break;
                } 
                else {
                    String valorQuery = query;
                    if (valorMedio.compareToIgnoreCase(valorQuery) > 0) {
                        fin = medio - 1;
                    } 
                    else {
                        inicio = medio + 1;
                    }
                }
            } 
            catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return resultado;
    }

    public static DynamicList<CensoRegistro>  BusquedaLineal(DynamicList<CensoRegistro>  lista, String query, String field) throws ListaVacia, PosicionNoEncontrada {
        DynamicList<CensoRegistro>  result = new DynamicList<>();
        Integer ultimaPosicionOcupada = lista.getLongitud();

        for (int i = 0; i < ultimaPosicionOcupada; i++) {
            CensoRegistro persona = lista.getInfo(i);
            Field campo = getField(CensoRegistro.class, field);

            try {
                campo.setAccessible(true);
                Object valorObj = campo.get(persona);
                String valor = (valorObj != null) ? valorObj.toString() : "";
                if (valor.toLowerCase().startsWith(query.trim().toLowerCase())) {
                    result.AgregarFinal(persona);
                }
            } 
            catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    
}


