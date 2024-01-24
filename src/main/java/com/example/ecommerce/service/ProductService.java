package com.example.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ecommerce.entity.CartItem;
import com.example.ecommerce.entity.Product;

@Service
public interface ProductService {
	void addProductToCart(Product product);
	void updateProductQuantity(Product product, int quantity);
	List<Product> getAllProducts();
	Product getProductById(Long productId);
	List<CartItem> getCartItems();
	double calculateTotalBill();
	void removeProductFromCart(Product product);

}
