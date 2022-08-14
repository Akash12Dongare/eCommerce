/**
 * 
 */
package com.eCommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eCommerce.model.StockTRN;

/**
 * @author Akash.d
 *
 */
public interface StockTRNRepository extends JpaRepository<StockTRN, Integer> {

	Optional<List<StockTRN>> findAllByUserId(String username);

}
