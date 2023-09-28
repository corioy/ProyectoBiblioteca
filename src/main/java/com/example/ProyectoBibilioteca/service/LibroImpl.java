package com.example.ProyectoBibilioteca.service;

import com.example.ProyectoBibilioteca.dto.LibroDto;
import com.example.ProyectoBibilioteca.mapper.MapperLibro;
import com.example.ProyectoBibilioteca.model.Libro;
import com.example.ProyectoBibilioteca.repository.LibroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LibroImpl  implements LibroI{

    private final LibroRepository libroRepository;
    @Override
    public List<LibroDto> findAllLibros() {
        List<LibroDto> listaLibros =   libroRepository.findAll().stream()
                                             .map(MapperLibro::toDto)
                                             .collect(Collectors.toList());
        return listaLibros;


    }

    @Override
    public String saveLibro(LibroDto librodto) {
        Libro libroEntity = MapperLibro.toEntity(librodto);
        libroRepository.save(libroEntity);

        return "Libro guardado exitosamente";
    }

    @Override
    public LibroDto findLibro(String title) {
        Libro libroEntity = libroRepository.findByTitle(title);
        LibroDto libroDto = MapperLibro.toDto(libroEntity);
        return libroDto;
    }

    @Override
    public String updateLibro(Long id, LibroDto libroDto) {

        Libro libro = libroRepository.findById(id).orElseThrow();

        libro.setTitle(libroDto.getTitle());
        libro.setGenre(libroDto.getGenre());
        libro.setPublishDate(libroDto.getPublishDate());
        libro.setAutores(libroDto.getAutores());

        libroRepository.save(libro);

        return  "libro: "+ libro.getTitle() +" fue actualizado correctamente";

    }

    @Override
    public String deleteLibro(Long id) {
        libroRepository.deleteById(id);
        return "el libro: " + id + " fue eliminado";
    }
}
