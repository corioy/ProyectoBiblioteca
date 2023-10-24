package com.example.ProyectoBibilioteca.prueba;

import java.io.*;

public class Jugador implements Serializable {

    private String nombre;
    private Integer puntación;
    private Integer nivel;

  public Jugador(){

  }

    public Jugador(String nombre, Integer puntación, Integer nivel) {
        this.nombre = nombre;
        this.puntación = puntación;
        this.nivel = nivel;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPuntación() {
        return puntación;
    }

    public void setPuntación(Integer puntación) {
        this.puntación = puntación;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public static void guardarEstado(Jugador jugador, String archivo) {
        try (
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo))) {
            out.writeObject(jugador);
            System.out.println("Estado del jugador guardado en " + archivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Jugador cargarEstado(String archivo) {
        Jugador jugador = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
            jugador = (Jugador) in.readObject();
            System.out.println("Estado del jugador cargado desde " + archivo);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return jugador;
    }

}
