package aw.elio.appLibro2.repository;

import aw.elio.appLibro2.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    Autor findByNombre(String nombre);

    @Query("SELECT a FROM Autor a WHERE a.fechaNacimiento <= :fecha AND a.fechaMuerte >= :fecha")
    List<Autor> autoresVivos(int fecha);
}
