package aw.elio.appLibro2.service;

import aw.elio.appLibro2.dto.AutorDTO;
import aw.elio.appLibro2.dto.LibroDTO;
import aw.elio.appLibro2.model.*;
import aw.elio.appLibro2.repository.AutorRepository;
import aw.elio.appLibro2.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Service
@Transactional
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private LibroRepository libroRepository;

    // ******************* CASE 3 **********************
    public void mostrarListaDeAutorDTO(){
        MsjService.autoresBuscados();
        obtenerTodosLosAutoresDTO().forEach(System.out::println);
    }

    // ******************* CASE 4 **********************
    public void encontrarAutorVivo(){
        List<String> autoresPorFecha = obtenerTodosLosAutoresDTO().stream()
                .map(autorDTO -> String.format("(%d - %d) %s"
                        ,autorDTO.getFechaNacimiento(),autorDTO.getFechaMuerte()
                        ,autorDTO.getNombre())).toList();
        autoresPorFecha.forEach(System.out::println);
        MsjService.revisarAnio();
        String validar = "^-?\\d{1,4}$";
        Scanner teclado = new Scanner(System.in);
        String anio = teclado.nextLine();
        if (anio.matches(validar)) {
            int anioValido = Integer.parseInt(anio);
            List<Autor> autorList = autorRepository.autoresVivos(anioValido);
            List<AutorDTO> autorDTOList= autorList.stream().map(this::convertirEnDTO).toList();
            if (autorDTOList.isEmpty()) {
                MsjService.autorNoEncontrado();
            }else {
                MsjService.autorEncontrado();
                autorDTOList.forEach(System.out::println);
            }
        } else {MsjService.entradaInvalida();}
    }

    @Transactional
    public void guardaAutorLibro(DatosLibro datosLibro){
        //asignamos los valores del registro en la DB que coincidan con el nombre
        //del autor proporcionado por la API en "datosLibro"
        Autor autor = autorRepository.findByNombre(datosLibro.authors().get(0).name());
        // si la asignacion se consigue entonces queda iniciado con esos valores
        // pero si queda en null por falta de coicidencia entonces se crea un nuevo
        // registro en la DB
        if (autor == null){
            autor = new Autor(datosLibro);}
        // asignamos los valores del registro en la DB que coincidan con el titulo
        // del libro proporcionado por la API en "datosLibro"
            Libro libro = libroRepository.findByTitulo(datosLibro.title());
        // si la asignacion se consigue entonces queda iniciado con esos valores
        // pero si queda en null por falta de coicidencia entonces se crea un nuevo
        // registro en la DB
        if (libro == null){
            libro = new Libro(datosLibro, autor);
            //ademas de crear un nuevo registro de libro, lo agregamos a la lista
            // de libros del autor
            autor.agregarLibro(libro);
        }
        autorRepository.save(autor);
    }


    //tomo una entidad autor y la convierto a clase DTO
    private AutorDTO convertirEnDTO(Autor autor) {
        var autorDTO = new AutorDTO();
        //utilizando los valores de la entidad para setear las propiedades del DTO
        autorDTO.setNombre(autor.getNombre());
        autorDTO.setFechaNacimiento(autor.getFechaNacimiento());
        autorDTO.setFechaMuerte(autor.getFechaMuerte());

        //antes de setear la propiedad lista de libroDTO del DTO necesito convertir
        //la lista de Libros que me proporciona el metodo get de la entidad autor
        List<LibroDTO> librosDTO = autor.getLibros().stream()
                .map(libro -> {
                    LibroDTO libroDTO = new LibroDTO();
                    libroDTO.setTitulo(libro.getTitulo());
                    libroDTO.setNombreAutor(libro.getNombreAutor());
                    libroDTO.setLenguaje(libro.getLenguaje());
                    libroDTO.setDescargas(libro.getDescargas());
                    return libroDTO;}).collect(Collectors.toList());
        //ahora si puedo setear la propiedad con una lista de objetos libroDTO
        autorDTO.setLibros(librosDTO);
        // finalmente retorno un ubjeto DTO con todas sus propiedades cargadas
        // que puedo usar para la capa de presentacion
        return autorDTO;
    }
    private List<AutorDTO> obtenerTodosLosAutoresDTO(){
        return autorRepository.findAll().stream()
                .map(this::convertirEnDTO).toList();
    }
}
