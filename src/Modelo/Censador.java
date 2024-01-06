/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Alexander
 */
public class Censador {

    private Integer id;
    private String nombre;
    private String apellido;
    private String cedula;
    private String numero;

    private String edad;

    public Censador(String nombre, String apellido, String cedula, String numero, Integer id, String edad) {
        this.nombre = null;
        this.apellido = null;
        this.cedula = null;
        this.numero = null;
        this.id = null;
        this.edad = null;
    }

    public Censador() {

    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Boolean compare(Censador p, String field, Integer type) {
        switch (type) {
            case 0:
                if (field.equalsIgnoreCase("nombre")) {
                    return nombre.compareTo(p.getNombre()) < 0;
                } else if (field.equalsIgnoreCase("apellido")) {
                    return apellido.compareTo(p.getApellido()) < 0;
                } else if (field.equalsIgnoreCase("edad")) {
                    return edad.compareTo(p.getEdad()) < 0;
                }
            case 1:
                if (field.equalsIgnoreCase("nombre")) {
                    return nombre.compareTo(p.getNombre()) > 0;
                } else if (field.equalsIgnoreCase("apellido")) {
                    return apellido.compareTo(p.getApellido()) > 0;
                } else if (field.equalsIgnoreCase("edad")) {
                    return edad.compareTo(p.getEdad()) > 0;
                }
            default:
                throw new AssertionError();

        }
    }

    @Override
    public String toString() {
        return "Censador{" + "nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + '}';
    }

}
