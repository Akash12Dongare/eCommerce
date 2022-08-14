/**
 * 
 */
package com.eCommerce.service;

import com.eCommerce.dto.ProductReqDTO;
import com.eCommerce.utils.GenericJsonBean;

/**
 * @author Akash.d
 *
 */
public interface ProductService {

	GenericJsonBean getProductList();

	GenericJsonBean bookProduct(ProductReqDTO dto, String username);

	GenericJsonBean checkProductStock(String productId);

	GenericJsonBean myOrders(String username);

}
