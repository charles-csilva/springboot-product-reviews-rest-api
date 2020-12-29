# Product Reviews - REST API
A sample application that uses:
- Java 11
- Maven
- SpringBoot
- H2 database

# Execution

## Via Docker
```$ docker-compose up```

## Via Maven
```$ mvn spring-boot:run```

# Usage
## Creating a new user
POST localhost:8080/users \
{
    "name": "user name"
}

## Creating a new product
POST localhost:8080/products \
{
    "name": "product name"
}

## Creating a new review
POST localhost:8080/product-reviews \
{\
    "userId": 1,\
    "productId": 2,\
    "rating": 9.5,\
	"headline": "Great!",\
	"comment": "This is a really good product!"\
}

## Querying reviews
GET localhost:8080/product-reviews?productId={productId}\
&ratingFrom={min}&ratingTo={max} (optional)

## Removing reviews
DELETE localhost:8080/product-reviews/{reviewId}