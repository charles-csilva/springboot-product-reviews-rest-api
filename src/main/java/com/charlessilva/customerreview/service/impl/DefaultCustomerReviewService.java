package com.charlessilva.customerreview.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.charlessilva.customerreview.dao.CustomerReviewDao;
import com.charlessilva.customerreview.model.CustomerReviewModel;
import com.charlessilva.customerreview.model.ProductModel;
import com.charlessilva.customerreview.model.UserModel;
import com.charlessilva.customerreview.service.CustomerReviewService;
import com.charlessilva.customerreview.util.ServicesUtil;


@Component
public class DefaultCustomerReviewService implements CustomerReviewService
{
	private CustomerReviewDao customerReviewDao;

	@Autowired
	public DefaultCustomerReviewService(CustomerReviewDao customerReviewDao)
	{
		this.customerReviewDao = customerReviewDao;
	}

	@Override
	public CustomerReviewModel createCustomerReview(final Double rating, final String headline, final String comment,
			final ProductModel product, final UserModel user)
	{
		final CustomerReviewModel review = new CustomerReviewModel();
		review.setRating(rating);
		review.setHeadline(headline);
		review.setComment(comment);
		review.setProduct(product);
		review.setUser(user);
		customerReviewDao.save(review);
		return review;
	}

	@Override
	public void updateCustomerReview(final CustomerReviewModel review, UserModel user, ProductModel product)
	{
		customerReviewDao.save(review);
	}

	@Override
	public List<CustomerReviewModel> getReviewsForProduct(final ProductModel product)
	{
		ServicesUtil.validateParameterNotNullStandardMessage("product", product);
		return customerReviewDao.getAllReviews(product);
	}

	@Override
	public Double getAverageRating(final ProductModel product)
	{
		return customerReviewDao.getAverageRating(product);
	}

	@Override
	public Integer getNumberOfReviews(final ProductModel product)
	{
		return customerReviewDao.getNumberOfReviews(product);
	}
	
	@Override
	public List<CustomerReviewModel> getReviewsForProductAndRating(ProductModel product, Double ratingBegin, Double ratingEnd)
	{
		return customerReviewDao.getReviewsForProductAndRating(product, ratingBegin, ratingEnd);
	}

	@Override
	public void deleteCustomerReview(final Long id)
	{
		customerReviewDao.deleteReview(id);
	}
}
