package com.example.app_ep;

import com.google.gson.annotations.SerializedName;

public class Empresa {
    @SerializedName("IdEmpresa")
    private int idEmpresa;

    @SerializedName("Nombre")
    private String nombre;

    @SerializedName("Telefonos") // El nombre raro que viene de tu API
    private String telefono;

    @SerializedName("Domicilio")
    private String domicilio;

    @SerializedName("Observaciones")
    private String observaciones;

    @SerializedName("Contacto")
    private String contacto;

    @SerializedName("Abreviatura")
    private String abreviatura;

    public Empresa(int idEmpresa, String nombre, String telefono, String domicilio,
                   String observaciones, String contacto, String abreviatura){
        this.idEmpresa = idEmpresa;
        this.nombre = nombre;
        this.telefono = telefono;
        this.domicilio = domicilio;
        this.observaciones = observaciones;
        this.contacto = contacto;
        this.abreviatura = abreviatura;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }
}
