package com.example.ProyectoBibilioteca.service;

import com.example.ProyectoBibilioteca.dto.LibroDto;
import com.example.ProyectoBibilioteca.mapper.MapperInfoReducida;
import com.example.ProyectoBibilioteca.mapper.MapperLibro;
import com.example.ProyectoBibilioteca.model.Autor;
import com.example.ProyectoBibilioteca.model.Libro;
import com.example.ProyectoBibilioteca.repository.LibroRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class LibroImplTest {
    @Autowired
    private LibroImpl libroService;
    @MockBean
    private LibroRepository libroRepository;
    @Test
    void findAllLibrosTest() {

        List<LibroDto> listaLibrosDos =  libroRepository.findAll().stream()
                .map(MapperLibro::toDto)
                .collect(Collectors.toList());

        List<LibroDto>  result =  libroService.findAllLibros();
        assertEquals(listaLibrosDos, result);

    }

    @Test
    void findAllInfoReducidaTest() {

        List<LibroDto> listaLibros =   libroRepository.findAll().stream()
                .map(MapperInfoReducida::toDto)
                .collect(Collectors.toList());

        List<LibroDto> resultado = libroService.findAllInfoReducida();
        assertEquals(listaLibros, resultado);
    }

    @Test
    void saveLibroTest() {
    }

    @Test
    void findLibroTest() {
    }

    @Test
    void updateLibroTest() {
    }

    @Test
    void deleteLibroTest() {
    }

    @Test
    void filterLibrosTest() {
    }
}