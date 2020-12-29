package com.charlessilva.customerreview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.charlessilva.customerreview.dao.ProductDao;
import com.charlessilva.customerreview.dto.ProductDTO;
import com.charlessilva.customerreview.model.ProductModel;


@RestController
public class ProductController
{
	@Autowired
	private ProductDao productDao;

	@PostMapping({ "products" })
	public ProductModel createProduct(@RequestBody final ProductDTO productDTO)
	{
		ProductModel product = new ProductModel();
		product.setName(productDTO.getName());
		productDao.save(product);
		return product;
	}
}
