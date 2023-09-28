package com.example.ProyectoBibilioteca.dto;

import com.example.ProyectoBibilioteca.model.Autor;
import com.example.ProyectoBibilioteca.model.Libro;
import lombok.*;

import java.util.Date;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LibroDto {

     private String title;
     private Date publishDate;
     private String genre;
     private Set<Autor> autores;
}
