/**
 * 
 */
package com.eCommerce.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eCommerce.dto.ProductReqDTO;
import com.eCommerce.model.StockMST;
import com.eCommerce.model.StockTRN;
import com.eCommerce.repository.StockRepository;
import com.eCommerce.repository.StockTRNRepository;

/**
 * @author Akash.d
 *
 */
@Repository
public class ProductDaoImpl implements ProductDao {

	@PersistenceContext
	EntityManager em;

	@Autowired
	private StockRepository stockRepo;

	@Autowired
	private StockTRNRepository stockTnrRepo;

	Query query;

	String m_strQuery;

	@Override
	public List<StockMST> getProductList() {
		return stockRepo.findAllByIsActive("Y");
	}

	@Override
	public Optional<StockMST> getProductDetails(String productId) {
		return stockRepo.findByProductIdAndIsActive(productId, "Y");
	}

	@Override
	public Integer updateStockDetails(ProductReqDTO dto, double quantity, String username) {
		Integer order_no = em.merge(new StockTRN(dto.getProductId(), username, dto.getQuntity())).getPkId();
		m_strQuery = "update stock_mst set quantity=" + quantity + " where product_id='" + dto.getProductId() + "'";
		query = em.createNativeQuery(m_strQuery);
		query.executeUpdate();
		return order_no;
	}

	@Override
	public Optional<List<StockTRN>> myOrders(String username) {
		return stockTnrRepo.findAllByUserId(username);
	}

}
