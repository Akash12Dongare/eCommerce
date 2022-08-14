/**
 * 
 */
package com.eCommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eCommerce.model.StockMST;

/**
 * @author Akash.d
 *
 */
public interface StockRepository extends JpaRepository<StockMST, String> {

	List<StockMST> findAllByIsActive(String string);

	Optional<StockMST> findByProductIdAndIsActive(String productId, String isActive);

}
