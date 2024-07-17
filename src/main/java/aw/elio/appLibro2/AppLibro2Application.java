package aw.elio.appLibro2;

import aw.elio.appLibro2.principal.AppConsola;
import aw.elio.appLibro2.service.AutorService;
import aw.elio.appLibro2.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppLibro2Application implements CommandLineRunner {

	@Autowired
	private AutorService autorService;
	@Autowired
	private LibroService libroService;

	public static void main(String[] args) {
		SpringApplication.run(AppLibro2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		AppConsola principal = new AppConsola(autorService, libroService);
		principal.mostrarMenu();
	}
}
