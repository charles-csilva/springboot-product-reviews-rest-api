package com.charlessilva.customerreview.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.charlessilva.customerreview.model.ProductModel;

public interface ProductDao extends JpaRepository<ProductModel, Long> {
}
