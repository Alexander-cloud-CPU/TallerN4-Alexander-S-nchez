/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Modelo;

/**
 *
 * @author Alexander
 */
public class CensoRegistro {

    private Integer Id_censo;
    private String Edad;
    private String fecha;
    private String censador;
    private String motivo_divorcio;
    private String nombreCp;
    private String EstadoCivil;


    public CensoRegistro() {
    }

    public CensoRegistro(Integer Id_censo, String motivo_divorcio, String fecha, String nombreCp, String EstadoCivil, String Edad, String censador) {
        this.Id_censo = Id_censo;
        this.motivo_divorcio = motivo_divorcio;
        this.fecha = fecha;
        this.nombreCp = nombreCp;
        this.EstadoCivil = EstadoCivil;
        this.Edad = Edad;
        this.censador = censador;
    }

    public Integer getId_censo() {
        return Id_censo;
    }

    public void setId_censo(Integer Id_censo) {
        this.Id_censo = Id_censo;
    }

    public String getMotivo_divorcio() {
        return motivo_divorcio;
    }

    public void setMotivo_divorcio(String motivo_divorcio) {
        this.motivo_divorcio = motivo_divorcio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombreCp() {
        return nombreCp;
    }

    public void setNombreCp(String nombreCp) {
        this.nombreCp = nombreCp;
    }

    public String getEstadoCivil() {
        return EstadoCivil;
    }

    public void setEstadoCivil(String EstadoCivil) {
        this.EstadoCivil = EstadoCivil;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String Edad) {
        this.Edad = Edad;
    }

    public String getCensador() {
        return censador;
    }

    public void setCensador(String censador) {
        this.censador = censador;
    }

    public Boolean comparar(CensoRegistro c, String campo, Integer tipo) {
        switch (tipo) {
            case 0:
                return compararCampo(c, campo) < 0;
            case 1:
                return compararCampo(c, campo) > 0;
            default:
                throw new IllegalArgumentException("Tipo no válido");
        }
    }

    private int compararCampo(CensoRegistro c, String campo) {
        switch (campo.toLowerCase()) {
            case "nombre":
                return nombreCp.compareTo(c.getNombreCp());
            case "edad":
                return Edad.compareTo(c.getEdad());
            case "estado civil":
                return EstadoCivil.compareTo(c.getEstadoCivil());
            case "motivo":
                return motivo_divorcio.compareTo(c.getMotivo_divorcio());
            default:
                throw new IllegalArgumentException("Campo no válido para la comparación");
        }
    }

    @Override
    public String toString() {
        return "Censados{" + "Id_censo=" + Id_censo + ", motivo_divorcio=" + motivo_divorcio + ", fecha=" + fecha + ", nombreCp=" + nombreCp + ", EstadoCivil=" + EstadoCivil + ", Edad=" + Edad + ", censador=" + censador + '}';
    }

}
