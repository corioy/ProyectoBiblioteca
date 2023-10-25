package com.example.ProyectoBibilioteca.controller;

import com.example.ProyectoBibilioteca.dto.LibroDto;
import com.example.ProyectoBibilioteca.service.LibroImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@WebMvcTest(LibroController.class)
class LibroControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private LibroImpl libroService;
    @Test
    void findAllLibros() throws Exception {

        LibroDto libroDto = mock(LibroDto.class);
        LibroDto libroDto2 = mock(LibroDto.class);

        List<LibroDto> libroDtoList = new ArrayList<>();

        libroDtoList.add(libroDto);
        libroDtoList.add(libroDto2);

        when(libroService.findAllLibros()).thenReturn(libroDtoList);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/libros/findAll")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful()
                );
    }

    @Test
    void saveLibrosTest() throws Exception {
        LibroDto libroDto = mock(LibroDto.class);
        when(libroService.saveLibro(libroDto)).thenReturn(anyString());

        mockMvc.perform(MockMvcRequestBuilders.post("/libros/save")
                .content("{\"title\":\"Titulo Uno\", \"publishDate\":\"2023-10-25\", \"genre\":\"Género Ejemplo\", \"autores\":[{\"nombre\":\"Autor Uno\"}, {\"nombre\":\"Autor Dos\"}]}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
             ;


    }

    @Test
    void filterLibros() {
    }
}