package dev.example.demo;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import dev.example.demo.run.Location;
import dev.example.demo.run.Run;
import foo.bar.WelcomeMessgae;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		log.info("Starting DemoApplication xo");
		var welcomeMessgae = new WelcomeMessgae();
		System.out.println(welcomeMessgae.getWelcomeMessage());
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			Run run = new Run(1, "efew", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 3, Location.INDOOR);
			log.info("Runing: " + run);
		};
	}

}
