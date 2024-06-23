package aw.elio.appLibro2.dto;

public class LibroDTO {
    private String titulo;
    private String nombreAutor;
    private String lenguaje;
    private int descargas;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
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

    @Override
    public String toString() {
        String bloque= """ 
                ----------- Libro ------------
                Titulo: %s
                Autor:  %s
                Idioma: %s
                Descargas: %d
                ------------------------------
                """;
        return String.format(bloque,titulo,nombreAutor,lenguaje,descargas);
    }
}
