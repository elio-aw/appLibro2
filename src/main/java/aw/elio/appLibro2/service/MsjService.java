package aw.elio.appLibro2.service;

public class MsjService {
    public static void revisarAnio(){
        System.out.println("""
                
                ***************************************
                ** Ingrese el año que desea revisar: **
                ***************************************
                """);
    }

    public static void autorNoEncontrado(){
        System.out.println("""
                    ******************************************************
                    ** No existen registros de autores vivos en ese año **
                    ******************************************************
                    """);
    }
    public static void autorEncontrado(){
        System.out.println("""
                    ***************************
                    ** Registro encontrado!! **
                    ***************************
                    """);
    }
    public static void entradaInvalida(){
        System.out.println("""
                    ***********************************************
                    * entrada invalida para este tipo de busqueda *
                    ***********************************************
                    """);
    }
    public static void menuPrincipal(){
        System.out.println("""
                    
                    
                    *********************** MI BIBLIOTECA ****************************
                    **                                                              **
                    **   1 - Buscar un libro en la API web y guardarlo en mi DB     **
                    **   2 - Listar libros registrados en mi DB                     **
                    **   3 - Mostrar autores registrados en mi DB                   **
                    **   4 - Listar Actores vivos en determinado año de mi DB       **
                    **   5 - Presentar libros segun un idioma determinado de la DB  **
                    **   0 - Salir                                                  **
                    **                                                              **
                    *********** ESCRIBA EL NRO DE LA OPCION DESEADA ******************
                    """);
    }
    public static void queLibroBuscar(){
        System.out.println("""
                    **********************************************************************
                    ** Escribe el libro que quieres buscar y agregar a tu base de datos **
                    **********************************************************************
                    """);
    }
    public static void userInputInvalido(){
        System.out.println("""
                ******************************************************************
                ** escriba un numero del 0 al 5 y luego presione la tecla ENTER **
                ******************************************************************
                """);
    }
    public static void consultaApiSinResultado(){
        System.out.println("""
                ************************************************************
                ** Lo siento, no encontre ningun resultado en la API para **
                **           la busqueda que esta realizando              **
                ************************************************************
                """);
    }
    public static void salirDeApp(){
        System.out.println("""
                ********************************************
                ** Gracias por usar nuestros servicios :) **
                **        Fin de la aplicación.           **
                ********************************************
                """);
    }
    public static void idiomasDisponibles(){
        System.out.println("""
                ***************************
                ** Iidiomas dsiponibles: **
                ***************************
                """);
    }
    public static void seleccioneIdioma(){
        System.out.println("""
                ***************************
                ** seleccione el idioma: **
                ***************************
                """);
    }
    public static void sinCoincidenciaPorIdioma(){
        System.out.println("""
                *****************************************
                ** no hallamos libros en ese idioma :( **
                *****************************************
                """);
    }
    public static void encontradoPorIdioma(){
        System.out.println("""
                    ******************************
                    *** Libros encontrados! :) ***
                    ******************************
                    """);
    }
    public static void librosBuscados(){
        System.out.println("""
                
                **********************************
                **** Lista de libros buscados ****
                **********************************
                """);
    }
    public static void autoresBuscados(){
        System.out.println("""
                
                *********************************
                *** Lista de autores buscados ***
                *********************************
                """);
    }
}
