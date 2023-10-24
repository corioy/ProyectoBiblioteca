package com.example.ProyectoBibilioteca.mapper;

import com.example.ProyectoBibilioteca.dto.LibroDto;
import com.example.ProyectoBibilioteca.model.Libro;

public class MapperInfoReducida {

    public static LibroDto toDto(Libro libro){
        LibroDto libroDto = new LibroDto();

        libroDto.setTitle(libro.getTitle());
        libroDto.setPublishDate(libro.getPublishDate());


        return libroDto;
    }

    public  static  Libro toEntity(LibroDto libroDto){
        Libro libro = new Libro();
        libro.setTitle(libroDto.getTitle());
        libro.setPublishDate(libroDto.getPublishDate());

        return libro;
    }
}
