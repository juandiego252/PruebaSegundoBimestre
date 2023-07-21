package personas;

import java.io.Serializable;

public class persona implements Serializable {
    private String codigo;
    private String cedula;
    private String nombres;
    private String apellidos;
    private String zodiaco;
    private String anio;
    private String mes;
    private String dia;
    private boolean rojo;
    private boolean verde;
    private boolean ninguno;
    private boolean sicasado;
    private boolean nocasado;

    public persona(String codigo, String cedula, String nombres, String apellidos, String zodiaco, String anio, String mes, String dia, boolean rojo,
                   boolean verde, boolean ninguno, boolean sicasado, boolean nocasado) {
        this.codigo = codigo;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.zodiaco = zodiaco;
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
        this.rojo = rojo;
        this.verde = verde;
        this.ninguno = ninguno;
        this.sicasado = sicasado;
        this.nocasado = nocasado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getZodiaco() {
        return zodiaco;
    }

    public void setZodiaco(String zodiaco) {
        this.zodiaco = zodiaco;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public boolean isRojo() {
        return rojo;
    }

    public void setRojo(boolean rojo) {
        this.rojo = rojo;
    }

    public boolean isVerde() {
        return verde;
    }

    public void setVerde(boolean verde) {
        this.verde = verde;
    }

    public boolean isNinguno() {
        return ninguno;
    }

    public void setNinguno(boolean ninguno) {
        this.ninguno = ninguno;
    }

    public boolean isSicasado() {
        return sicasado;
    }

    public void setSicasado(boolean sicasado) {
        this.sicasado = sicasado;
    }

    public boolean isNocasado() {
        return nocasado;
    }

    public void setNocasado(boolean nocasado) {
        this.nocasado = nocasado;
    }

}
