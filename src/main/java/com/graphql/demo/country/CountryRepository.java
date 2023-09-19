/**
 * 
 */
package com.graphql.demo.country;

import org.springframework.data.repository.ListCrudRepository;

/**
 * @author Gbenga
 *
 */
public interface CountryRepository extends ListCrudRepository<Country,Integer> {
}
