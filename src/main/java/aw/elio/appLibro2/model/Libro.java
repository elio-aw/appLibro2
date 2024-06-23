package aw.elio.appLibro2.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@JsonIgnoreProperties(ignoreUnknown = true)

@Entity
@Table(name = "libro")
public class Libro {

    //*************** ATRIBUTOS QUE QUIERO MOSTRRAR *********************
    private String titulo;
    private String nombreAutor;
    private String lenguaje;
    private int descargas;

    //******** ATRIBUTOS PARA GUARDAR RELACIONES EN BASE DE DATOS *******
            // relacion que indica que muchos a uno
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;
            // identificador en DB
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //********************************************************************


    //*********************** CONSTRUCTORES ******************************
           // constructor con parametros
    public Libro (DatosLibro datosLibro, Autor autor){
        this.titulo= datosLibro.title();
        this.nombreAutor= datosLibro.authors().get(0).name();
        this.lenguaje= datosLibro.languages().get(0);
        this.descargas= datosLibro.download_count();
        this.autor=autor;
    }
          // constructor vacio
    public Libro () {
    }
    //********************************************************************


    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public int getDescargas() {
        return descargas;
    }

    public void setDescargas(int descargas) {
        this.descargas = descargas;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "titulo= " + titulo +
                ", nombreAutor= " + nombreAutor +
                ", lenguaje= " + lenguaje +
                ", descargas= " + descargas;
    }
}

