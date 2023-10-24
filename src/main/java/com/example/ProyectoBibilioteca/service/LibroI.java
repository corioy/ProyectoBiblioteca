package com.example.ProyectoBibilioteca.service;

import com.example.ProyectoBibilioteca.dto.LibroDto;
import com.example.ProyectoBibilioteca.model.Libro;

import java.util.List;

public interface LibroI {

   List<LibroDto> findAllLibros();
   String saveLibro(LibroDto librodto);
   LibroDto findLibro(String title);
   String updateLibro(Long id, LibroDto libroDto);
   String deleteLibro(Long id);

   List<LibroDto> findAllInfoReducida();

}
