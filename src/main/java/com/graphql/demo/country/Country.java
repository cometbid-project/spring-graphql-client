/**
 * 
 */
package com.graphql.demo.country;

import org.springframework.data.annotation.Id;

/**
 * @author Gbenga
 *
 */
public record Country(@Id Integer id, String name, String emoji, String currency, String code, String capital) {
}
