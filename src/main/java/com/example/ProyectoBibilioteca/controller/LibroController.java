package com.example.ProyectoBibilioteca.controller;

import com.example.ProyectoBibilioteca.dto.LibroDto;
import com.example.ProyectoBibilioteca.model.Libro;
import com.example.ProyectoBibilioteca.service.LibroI;
import com.example.ProyectoBibilioteca.service.LibroImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/libros")
public class LibroController {
    private final LibroImpl libroService;


    @GetMapping("/findAll")
    public ResponseEntity<List<LibroDto>> findAllLibros(){
        List<LibroDto> lista =  libroService.findAllLibros();
        return new ResponseEntity<> (lista, HttpStatus.OK);
    }

    @PostMapping("/save")
    public  ResponseEntity<String> saveLibros(@RequestBody LibroDto librodto) {
     String mensaje =   libroService.saveLibro(librodto);
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }
@GetMapping
    public  ResponseEntity<List<Libro>> filterLibros(@RequestParam  LocalDate publishDate){
        List<Libro> lista =  libroService.filterLibros(publishDate);
        return new ResponseEntity<> (lista, HttpStatus.OK);

    }

}
