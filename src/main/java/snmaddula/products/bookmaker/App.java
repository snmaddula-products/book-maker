package snmaddula.products.bookmaker;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import snmaddula.products.bookmaker.service.AppService;

@SpringBootApplication
public class App {// extends JFrame {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	@Bean
	public CommandLineRunner runner(AppService appService) {
		return (args) -> {
			appService.process();
		};
	}

}
