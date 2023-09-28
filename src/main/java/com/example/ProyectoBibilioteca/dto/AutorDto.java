package com.example.ProyectoBibilioteca.dto;

import com.example.ProyectoBibilioteca.model.Libro;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AutorDto {
    private String name;
    private String surname;

    private Set<Libro> libros;
}
