package aw.elio.appLibro2.principal;

import aw.elio.appLibro2.model.Datos;
import aw.elio.appLibro2.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

    //esta clase es la que uso para instanciar un metodo en la aplicacion principal
@Component
public class AppConsola {
        //autowired se usa para inyectar dependencias y dejar que spring gestione el
        //ciclo de vida de las instancias necesarias para el uso de los repositorios.
    @Autowired
    private AutorService autorService;
    @Autowired
    private LibroService libroService;

    public AppConsola(AutorService autorService, LibroService libroService) {
        this.autorService=autorService;
        this.libroService=libroService;
    }

    public void mostrarMenu(){
        final Scanner teclado = new Scanner(System.in);
        final String REGEX ="^[0-5]$";
        int userOption = -1;
        while (userOption !=0){
            MsjService.menuPrincipal();
            var userInput = teclado.nextLine();
            if (userInput.matches(REGEX)) {
                userOption=Integer.parseInt(userInput);
                switch (userOption) {
                    case 1: buscarLibro();break;
                    case 2: libroService.mostrarListaDeLibrosDTO();break;
                    case 3: autorService.mostrarListaDeAutorDTO();break;
                    case 4: autorService.encontrarAutorVivo(); break;
                    case 5: libroService.librosPorIdioma();break;
                    case 0: MsjService.salirDeApp();break;
                }
            }
            else{MsjService.userInputInvalido();}
        }
    }

    // ******************* CASE 1 **********************
    private void buscarLibro() {
        var convert = new ConvertirDatos();
        MsjService.queLibroBuscar();
        var json = ApiService.obtenerJsonDeBusqueda();
        var datos = convert.jsonToObject(json, Datos.class);
        if (datos.datoslibros().isEmpty()) {
            MsjService.consultaApiSinResultado();
        } else {
            autorService.guardaAutorLibro(datos.datoslibros().get(0));
        }
    }
}
