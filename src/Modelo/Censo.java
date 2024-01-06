/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Alexander
 */
public class Censo {

    private Integer id;
    private String nombre_censo;
    private String descripcion;

    public Censo(Integer id, String nombre_censo, String descripcion) {

        this.id = id;
        this.nombre_censo = nombre_censo;
        this.descripcion = descripcion;
    }

    public Censo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre_censo() {
        return nombre_censo;
    }

    public void setNombre_censo(String nombre_censo) {
        this.nombre_censo = nombre_censo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return nombre_censo;
    }

}
