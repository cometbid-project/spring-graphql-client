/**
 * 
 */
package com.graphql.demo.country;

import java.util.List;

import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

/**
 * @author Gbenga
 *
 */
@Service 
public class CountryService {

    private final HttpGraphQlClient graphQlClient;

    public CountryService() {
        WebClient client = WebClient.builder()
                .baseUrl("https://countries.trevorblades.com")
                .build();
        
        graphQlClient = HttpGraphQlClient.builder(client).build();
    }

    public Mono<List<Country>> getCountries() {
        //language=GraphQL
        String document = """
        query {
            countries {
              name
              emoji
              currency
              code
              capital
            }
        }
        """;

        Mono<List<Country>> countries = graphQlClient.document(document)
                .retrieve("countries")
                .toEntityList(Country.class);

        return countries;
    }
}
