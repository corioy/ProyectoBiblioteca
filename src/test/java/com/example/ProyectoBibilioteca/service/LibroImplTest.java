package com.example.ProyectoBibilioteca.service;

import com.example.ProyectoBibilioteca.dto.LibroDto;
import com.example.ProyectoBibilioteca.mapper.MapperInfoReducida;
import com.example.ProyectoBibilioteca.mapper.MapperLibro;
import com.example.ProyectoBibilioteca.model.Autor;
import com.example.ProyectoBibilioteca.model.Libro;
import com.example.ProyectoBibilioteca.repository.LibroRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@SpringBootTest
class LibroImplTest {
    @InjectMocks
    private LibroImpl libroService;
    @Mock
    private LibroRepository libroRepository;
    @Test
    void findAllLibrosTest() {
        Libro libro1 = mock(Libro.class);
        Libro libro = mock(Libro.class);

        when(libroRepository.findAll()).thenReturn(Arrays.asList(libro1, libro));

        List<LibroDto>  result =  libroService.findAllLibros();
        assertEquals(2, result.size());
        assertNotNull(result);

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
        Libro libro = mock(Libro.class);
        LibroDto libroDto = mock(LibroDto.class);
        when(libroRepository.save(libro)).thenReturn(libro);
        String result = libroService.saveLibro(libroDto);

        assertNotNull(result);

    }

    @Test
    void findLibroTest() {
        Libro libro = mock(Libro.class);
        libro.setTitle("titulo");

        when(libroRepository.findByTitle("titulo")).thenReturn(libro);

        LibroDto result = libroService.findLibro("titulo");

        assertNotNull(result);
        assertEquals(result.getTitle(), libro.getTitle());


    }

    @Test
    void updateLibroTest() {

        Libro  libro = mock(Libro.class);
        libro.setId(1L);
        libro.setTitle("titulo");

         when(libroRepository.findById(anyLong())).thenReturn(Optional.ofNullable(libro));

         libro.setTitle("TituloDos");
         libro.setGenre("genero");

          when(libroRepository.save(libro)).thenReturn(libro);

         LibroDto libroDto = mock(LibroDto.class);
         String result = libroService.updateLibro(1L, libroDto);

         assertNotNull(result);
        assertEquals( "libro: "+ libro.getTitle() +" fue actualizado correctamente", result);


    }

    @Test
    void deleteLibroTest() {
         String retorno = "el libro: " + 1L + " fue eliminado";
         doNothing().when(libroRepository).deleteById(1L);

         String result = libroService.deleteLibro(1L);

         assertNotNull(result);
         assertEquals(result, retorno);

    }

    @Test
    void filterLibrosTest() {
        Libro libro1 = new Libro();
        libro1.setPublishDate(LocalDate.of(2023,1,3));

        List<Libro> libro  = new ArrayList<>();
        libro.add(libro1);

        when(libroRepository.findAll()).thenReturn(libro);

        List<Libro> libroList = libroService.filterLibros(LocalDate.of(2023,1,3));

        assertNotNull(libroList);
       assertEquals(libroList.get(0), libro.get(0));
    }
}