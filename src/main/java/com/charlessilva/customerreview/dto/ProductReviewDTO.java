package com.charlessilva.customerreview.dto;

import java.io.Serializable;

public class ProductReviewDTO implements Serializable
{
	private static final long serialVersionUID = 2081133482443965199L;

	private Long userId;
	public Long getUserId() { return this.userId; }
	public void setUserId(Long userId) { this.userId = userId; }

	private Long productId;
	public Long getProductId() { return this.productId; }
	public void setProductId(Long productId) { this.productId = productId; }
	
	private Double rating;
	public Double getRating() { return rating; }
	public void setRating(Double rating) { this.rating = rating; }

	private String headline;
	public String getHeadline() { return headline; }
	public void setHeadline(String headline) { this.headline = headline; }

	private String comment;
	public String getComment() { return comment; }
	public void setComment(String comment) { this.comment = comment; }
}
