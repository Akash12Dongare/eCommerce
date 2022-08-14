/**
 * 
 */
package com.eCommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eCommerce.constance.Constants;
import com.eCommerce.dao.ProductDao;
import com.eCommerce.dto.ProductReqDTO;
import com.eCommerce.dto.UserStockDTO;
import com.eCommerce.model.StockMST;
import com.eCommerce.model.StockTRN;
import com.eCommerce.utils.GenericJsonBean;

/**
 * @author Akash.d
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public GenericJsonBean getProductList() {
		GenericJsonBean response = null;
		try {
			List<StockMST> stockes = productDao.getProductList();
			response = GenericJsonBean.createJsonString(Constants.SUCCESS, Constants.SUCCESS, stockes);

		} catch (Exception e) {
			response = GenericJsonBean.createJsonString(Constants.ERROR, e.getMessage(), "");
			e.printStackTrace();
		}
		return response;
	}

	@Transactional
	@Override
	public GenericJsonBean bookProduct(ProductReqDTO dto, String username) {
		GenericJsonBean response = null;
		try {
			Optional<StockMST> stock = productDao.getProductDetails(dto.getProductId());
			if (stock.isPresent()) {
				if (stock.get().getQuantity() > dto.getQuntity()) {
					Integer order_no = productDao.updateStockDetails(dto,
							(stock.get().getQuantity() - dto.getQuntity()), username);
					response = GenericJsonBean.createJsonString(Constants.SUCCESS,
							"Order created successfully. Generated order no : " + order_no, "");
				} else
					response = GenericJsonBean.createJsonString(Constants.ERROR,
							"Product quntity exceed . Available quantity : " + stock.get().getQuantity(), "");

			} else
				response = GenericJsonBean.createJsonString(Constants.ERROR, "Product is not available.", "");

		} catch (Exception e) {
			response = GenericJsonBean.createJsonString(Constants.ERROR, e.getMessage(), "");
			e.printStackTrace();
		}

		return response;
	}

	@Override
	public GenericJsonBean checkProductStock(String productId) {
		GenericJsonBean response = null;
		try {
			Optional<StockMST> stock = productDao.getProductDetails(productId);
			if (stock.isPresent())
				response = GenericJsonBean.createJsonString(Constants.SUCCESS, Constants.SUCCESS, stock);
			else
				response = GenericJsonBean.createJsonString(Constants.ERROR, "Product is not available.", "");

		} catch (Exception e) {
			response = GenericJsonBean.createJsonString(Constants.ERROR, Constants.ERROR, "");
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public GenericJsonBean myOrders(String username) {
		GenericJsonBean response = null;
		try {
			Optional<List<StockTRN>> bookedStocks = productDao.myOrders(username);
			if (bookedStocks.isPresent()) {
				if (bookedStocks.get().size() > 0) {
					List<UserStockDTO> userStocks = new ArrayList<UserStockDTO>();
					for (StockTRN stock : bookedStocks.get())
						userStocks.add(new UserStockDTO(stock.getPkId(), stock.getUserId(), stock.getUser().getName(),
								stock.getProductId(), stock.getStock().getProductName(), stock.getBookQuntity(),
								stock.getCreatedOn()));
					response = GenericJsonBean.createJsonString(Constants.SUCCESS, Constants.SUCCESS, userStocks);
				} else
					response = GenericJsonBean.createJsonString(Constants.SUCCESS, "No Record.", "");

			} else
				response = GenericJsonBean.createJsonString(Constants.ERROR, Constants.ERROR, "");

		} catch (Exception e) {
			response = GenericJsonBean.createJsonString(Constants.ERROR, Constants.ERROR, "");
			e.printStackTrace();
		}
		return response;
	}

}
