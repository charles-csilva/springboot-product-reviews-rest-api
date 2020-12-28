package com.charlessilva.customerreview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.charlessilva.customerreview.CurseWordsHandler;
import com.charlessilva.customerreview.dao.ProductDao;
import com.charlessilva.customerreview.dao.UserDao;
import com.charlessilva.customerreview.exception.ProductNotFoundException;
import com.charlessilva.customerreview.exception.UserNotFoundException;
import com.charlessilva.customerreview.forms.CustomerReviewForm;
import com.charlessilva.customerreview.model.CustomerReviewModel;
import com.charlessilva.customerreview.model.ProductModel;
import com.charlessilva.customerreview.model.UserModel;
import com.charlessilva.customerreview.service.CustomerReviewService;

import java.util.List;

@RestController
@RequestMapping("reviews")
public class CustomerReviewController
{
	@Autowired
	private ProductDao productDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private CustomerReviewService customerReviewService;

	@GetMapping({ "" })
	public List<CustomerReviewModel> getReviews(
		@RequestParam final Long productId,
		@RequestParam(required = false) final Double ratingFrom,
		@RequestParam(required = false) final Double ratingTo)
	{
		final ProductModel product = productDao.findOne(productId);
		if (product == null)
		{
			throw new ProductNotFoundException(productId);
		}
		
		if(ratingFrom != null && ratingTo != null) {
			
			Double begin = ratingFrom < ratingTo ? ratingFrom : ratingTo;
			Double end = ratingFrom < ratingTo ? ratingTo : ratingFrom;
			
			return customerReviewService.getReviewsForProductAndRating(product, begin, end);
		}
		return customerReviewService.getReviewsForProduct(product);
	}

	@PostMapping({ "" })
	public ResponseEntity<CustomerReviewModel> createReview(
		@RequestBody final CustomerReviewForm customerReviewForm)
	{
		if(customerReviewForm.getRating() < 0
				|| CurseWordsHandler.containsCurseWords(customerReviewForm.getHeadline())
				|| CurseWordsHandler.containsCurseWords(customerReviewForm.getComment())) {
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		Long productId = customerReviewForm.getProductId();
		final ProductModel product = productDao.findOne(productId);
		if (product == null)
		{
			throw new ProductNotFoundException(productId);
		}

		Long userId = customerReviewForm.getUserId();
		final UserModel user = userDao.findOne(userId);
		if (user == null)
		{
			throw new UserNotFoundException(userId);
		}

		CustomerReviewModel reviewModel = customerReviewService
				.createCustomerReview(customerReviewForm.getRating(), customerReviewForm.getHeadline(),
						customerReviewForm.getComment(), product, user);
		return new ResponseEntity<CustomerReviewModel>(reviewModel, HttpStatus.OK);
	}

	@DeleteMapping({ "/{reviewId:\\d+}" })
	public void deleteReview(@PathVariable final Long reviewId)
	{
		customerReviewService.deleteCustomerReview(reviewId);
	}
}
