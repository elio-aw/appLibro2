package aw.elio.appLibro2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)

@Entity
@Table(name = "autor")
public class Autor {


    //************************* ATRIBUTOS ********************************
    private String nombre;
    private int fechaMuerte;
    private int fechaNacimiento;

    //******** ATRIBUTOS PARA GUARDAR RELACIONES EN BASE DE DATOS ********
    // Atributo identificador en DB
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Atributo de relacion "uno a muchos"
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Libro> libros = new ArrayList<>();
    //********************************************************************

    //*********************** CONSTRUCTORES ******************************
    // constructor con parametros
    public Autor (DatosLibro datosLibro){
        this.nombre= datosLibro.authors().get(0).name();
        this.fechaMuerte=  datosLibro.authors().get(0).death_year();
        this.fechaNacimiento=  datosLibro.authors().get(0).birth_year();
    }
    // constructor vacio
    public Autor () {
    }
    //********************************************************************

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFechaMuerte() {
        return fechaMuerte;
    }

    public void setFechaMuerte(int fechaMuerte) {
        this.fechaMuerte = fechaMuerte;
    }

    public int getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(int fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        libros.forEach(e->e.setAutor(this));
        this.libros = libros;
    }
    //este metodo primero agrega el libro a la lista de relacion
    //luego setea el libro agregado con el autor que se esta ejecutando
    //este metodo.
    public void agregarLibro(Libro libro) {
        libros.add(libro); libro.setAutor(this);}

    @Override
    public String toString() {
        return
                "nombre= " + nombre +
                ", fechaMuerte= " + fechaMuerte +
                ", fechaNacimiento= " + fechaNacimiento;
    }
}
