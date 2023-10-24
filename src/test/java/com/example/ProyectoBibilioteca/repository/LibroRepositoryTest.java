package com.example.ProyectoBibilioteca.repository;

import com.example.ProyectoBibilioteca.model.Autor;
import com.example.ProyectoBibilioteca.model.Libro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class LibroRepositoryTest {
    @Autowired
    private LibroRepository libroRepository;

    @Test
    void findByTitleTest() {
        Set<Autor> autores = new HashSet<>();
        Libro libro = new Libro(1L, "titulo", LocalDate.now(),"genre", autores );
        libroRepository.save(libro);
        Libro libroEncontrado = libroRepository.findByTitle("titulo");
        assertEquals(libro.getTitle(), libroEncontrado.getTitle());
    }
}