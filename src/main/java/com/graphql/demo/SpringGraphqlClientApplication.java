package com.graphql.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.graphql.demo.country.Country;
import com.graphql.demo.country.CountryRepository;
import com.graphql.demo.country.CountryService;

import reactor.core.publisher.Mono;

/**
 * 
 * @author Gbenga
 *
 */
@SpringBootApplication
public class SpringGraphqlClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringGraphqlClientApplication.class, args);
	}

	@Bean 
	CommandLineRunner commandLineRunner(CountryService service, CountryRepository repository) {
		return args -> {
			Mono<List<Country>> countries = service.getCountries();
			countries.subscribe(repository::saveAll);
		};
	}
}
