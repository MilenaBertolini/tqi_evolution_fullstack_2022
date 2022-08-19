package API.Library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/books/sell").allowedOrigins("http://localhost:3000");
				registry.addMapping("/api/books/allBooks").allowedOrigins("http://localhost:3000");
				registry.addMapping("/api/books/insert").allowedOrigins("http://localhost:3000");
				registry.addMapping("/api/books").allowedOrigins("http://localhost:3000");
				registry.addMapping("/api/books/buy").allowedOrigins("http://localhost:3000");
				registry.addMapping("/api/books/allTransactions").allowedOrigins("http://localhost:3000");
				registry.addMapping("/api/books/allClients").allowedOrigins("http://localhost:3000");

			}
		};
	}


}
