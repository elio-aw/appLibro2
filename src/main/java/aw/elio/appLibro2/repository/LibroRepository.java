package aw.elio.appLibro2.repository;

import aw.elio.appLibro2.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LibroRepository extends JpaRepository <Libro, Long> {

    Libro findByTitulo(String nombre);

    @Query("SELECT l FROM Libro l WHERE l.lenguaje = :idiomaSeleccionado")
    List<Libro> librosPorIdiomaSeleccinado(String idiomaSeleccionado);
}
