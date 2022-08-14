/**
 * 
 */
package com.eCommerce.dao;

import java.util.List;
import java.util.Optional;

import com.eCommerce.dto.ProductReqDTO;
import com.eCommerce.model.StockMST;
import com.eCommerce.model.StockTRN;

/**
 * @author Akash.d
 *
 */
public interface ProductDao {

	List<StockMST> getProductList();

	Optional<StockMST> getProductDetails(String productId);

	Integer updateStockDetails(ProductReqDTO dto, double d, String username);

	Optional<List<StockTRN>> myOrders(String username);

}
