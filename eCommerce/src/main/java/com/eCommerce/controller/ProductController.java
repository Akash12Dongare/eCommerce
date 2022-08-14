/**
 * 
 */
package com.eCommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eCommerce.dto.ProductReqDTO;
import com.eCommerce.security_conf.UserPrincipal;
import com.eCommerce.service.ProductService;
import com.eCommerce.utils.GenericJsonBean;

/**
 * @author Akash.d
 *
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/product-module/")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping(value = "productList")
	public GenericJsonBean getProductList(@RequestHeader(name = "Authorization") String Bearer) {
		return productService.getProductList();
	}

	@PostMapping(value = "bookProduct")
	public GenericJsonBean bookProduct(@RequestHeader(name = "Authorization") String Bearer,
			@RequestBody ProductReqDTO dto) {
		UserPrincipal user = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return productService.bookProduct(dto, user.getUsername());
	}

	@GetMapping(value = "checkProductStock")
	public GenericJsonBean checkProductStock(@RequestHeader(name = "Authorization") String Bearer,
			@RequestParam String productId) {
		return productService.checkProductStock(productId);
	}

	@GetMapping(value = "myOrders")
	public GenericJsonBean myOrders(@RequestHeader(name = "Authorization") String Bearer) {
		UserPrincipal user = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return productService.myOrders(user.getUsername());
	}

}
