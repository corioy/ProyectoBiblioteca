package com.example.ProyectoBibilioteca.model;

import java.io.Serializable;

public class Mensaje implements Serializable {

    private String nombre;
    private Integer id;
    private String mensaje;


    public Mensaje(String nombre, Integer id, String mensaje) {
        this.nombre = nombre;
        this.id = id;
        this.mensaje = mensaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
