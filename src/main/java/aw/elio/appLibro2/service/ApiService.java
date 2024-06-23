package aw.elio.appLibro2.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ApiService {
    public static String from(String url){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url)).build();
        HttpResponse<String> response=null;
        try {
            response=client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        }catch (
                IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return  response.body();
    }

    public static String obtenerJsonDeBusqueda(){
        var URL_BASE = "https://gutendex.com/books/?search=";
        var teclado = new Scanner(System.in);
        var nombreLibro = teclado.nextLine().replace(" ", "%20");
        return ApiService.from(URL_BASE + nombreLibro);
    }
}
