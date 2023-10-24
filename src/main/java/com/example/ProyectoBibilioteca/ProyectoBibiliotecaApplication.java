package com.example.ProyectoBibilioteca;

import com.example.ProyectoBibilioteca.prueba.Jugador;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.example.ProyectoBibilioteca.prueba.Jugador.cargarEstado;
import static com.example.ProyectoBibilioteca.prueba.Jugador.guardarEstado;


@SpringBootApplication
public class ProyectoBibiliotecaApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProyectoBibiliotecaApplication.class, args);
	}



}
