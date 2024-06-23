package aw.elio.appLibro2.service;

import aw.elio.appLibro2.model.Libro;
import aw.elio.appLibro2.dto.LibroDTO;
import aw.elio.appLibro2.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Service
public class LibroService {
    @Autowired
    LibroRepository libroRepository;

    // ******************* CASE 2 **********************
    @Transactional
    public void mostrarListaDeLibrosDTO(){
        MsjService.librosBuscados();
        obetenerListaDeLibrosDTO().forEach(System.out::println);
    }
    // ******************* CASE 5 **********************
    public void librosPorIdioma() {
        MsjService.idiomasDisponibles();
        listarIdiomasDisponibles();
        MsjService.seleccioneIdioma();
        var teclado = new Scanner(System.in);
        var idiomaSeleccionado = teclado.nextLine();
        List<LibroDTO> libros = libroRepository
                .librosPorIdiomaSeleccinado(idiomaSeleccionado)
                .stream().map(this::convertirEnLibroDTO).toList();
        if (libros.isEmpty()) {
            MsjService.sinCoincidenciaPorIdioma();
        }
        else {
            MsjService.encontradoPorIdioma();
            libros.forEach(System.out::println);
        }
    }

    private void listarIdiomasDisponibles() {
        List<String> idiomas = obetenerListaDeLibrosDTO().stream()
                .map(LibroDTO::getLenguaje).distinct().toList();
        idiomas.forEach(i-> System.out.println("--> "+i));
    }

    private List<LibroDTO> obetenerListaDeLibrosDTO() {
        return libroRepository.findAll().stream()
                .map(this::convertirEnLibroDTO).collect(Collectors.toList());
    }
    private LibroDTO convertirEnLibroDTO(Libro libro) {
        var libroDTO = new LibroDTO();
        libroDTO.setTitulo(libro.getTitulo());
        libroDTO.setNombreAutor(libro.getNombreAutor());
        libroDTO.setLenguaje(libro.getLenguaje());
        libroDTO.setDescargas(libro.getDescargas());
        return libroDTO;
    }
}
