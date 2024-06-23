package aw.elio.appLibro2.dto;

import java.util.List;

public class AutorDTO {
    private String nombre;
    private int fechaMuerte;
    private int fechaNacimiento;
    private List<LibroDTO> libros;

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

    public List<LibroDTO> getLibros() {
        return libros;
    }

    public void setLibros(List<LibroDTO> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        List<String> obras = libros.stream().map(LibroDTO::getTitulo).toList();
        String obrasFormateadas = String.join(", ", obras);
        String bloque= """ 
                ----------- Autor ------------
                Nombre: %s
                Fecha de Nacimiento:  %d
                Fecha de Muerte: %d
                Obras Escritas: %s
                ------------------------------
                """;
        return String.format(bloque,nombre,fechaNacimiento,fechaMuerte,obrasFormateadas);
    }
}
