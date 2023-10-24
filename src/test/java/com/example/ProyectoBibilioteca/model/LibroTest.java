package com.example.ProyectoBibilioteca.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class LibroTest {
    Set<Autor> autores = new HashSet<>();

     Libro libro = new Libro(1L, "titulo", LocalDate.now(),"genre", autores );

    @Test
    void getIdTest(){

       assertEquals(1L, libro.getId());
       assertNotNull(libro.getId());
    }

    @Test
    void getTitleTest() {
        assertEquals("titulo", libro.getTitle());
        assertNotNull(libro.getTitle());
    }

    @Test
    void getPublishDateTest() {
        assertEquals(LocalDate.now(), libro.getPublishDate());
        assertNotNull(libro.getPublishDate());
    }

    @Test
    void getGenreTest() {
        assertEquals("genre", libro.getGenre());
    }

    @Test
    void getAutoresTest() {
        assertEquals(autores, libro.getAutores());
    }

    @Test
    void setIdTest() {
        libro.setId(2L);
        assertEquals(2L, libro.getId());
    }

    @Test
    void setTitleTest() {
        libro.setTitle("Harry Potter");
        assertEquals("Harry Potter", libro.getTitle());
    }

    @Test
    void setPublishDateTest() {
        LocalDate publishedDate = LocalDate.of(2023, 4, 9);
        libro.setPublishDate(publishedDate);
        assertEquals(publishedDate, libro.getPublishDate());
    }

    @Test
    void setGenreTest() {
        libro.setGenre("ciencia ficción");
        assertEquals("ciencia ficción", libro.getGenre());
    }

    @Test
    void setAutoresTest() {
        Set<Autor> newAutor = new HashSet<>();
        libro.setAutores(newAutor);
        assertEquals(newAutor, libro.getAutores());
    }
}