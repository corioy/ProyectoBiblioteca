package com.example.ProyectoBibilioteca.mapper;

import com.example.ProyectoBibilioteca.dto.LibroDto;
import com.example.ProyectoBibilioteca.model.Libro;

public class MapperLibro {

    public static LibroDto toDto(Libro libro){
        LibroDto libroDto = new LibroDto();

        libroDto.setTitle(libro.getTitle());
        libroDto.setPublishDate(libro.getPublishDate());
        libroDto.setGenre(libro.getGenre());
        libroDto.setAutores(libro.getAutores());

        return libroDto;
    }

    public  static  Libro toEntity(LibroDto libroDto){
        Libro libro = new Libro();
        libro.setTitle(libroDto.getTitle());
        libro.setPublishDate(libroDto.getPublishDate());
        libro.setGenre(libroDto.getGenre());
        libro.setAutores(libroDto.getAutores());

        return libro;
    }
}
