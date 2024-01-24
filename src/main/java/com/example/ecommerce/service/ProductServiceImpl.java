package com.example.ecommerce.service;

import com.example.ecommerce.entity.CartItem;
import com.example.ecommerce.entity.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private List<Product> products = new ArrayList<>();
    private List<CartItem> cartItems = new ArrayList<>();

    @Override
    public void addProductToCart(Product product) {
        CartItem existingCartItem = findCartItem(product);

        if (existingCartItem != null) {
            // Product is already in the cart; increment quantity.
            existingCartItem.addProduct(product);
        } else {
            // Product is not in the cart; add it with quantity 1.
            cartItems.add(new CartItem(product, 1));
        }
    }

    @Override
    public void updateProductQuantity(Product product, int quantity) {
        CartItem existingCartItem = findCartItem(product);

        if (existingCartItem != null) {
            // Update the quantity.
            existingCartItem.updateProductQuantity(quantity);
        } else {
            throw new IllegalArgumentException("Product not found in the cart");
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return products; // Replace with actual logic to retrieve products from a database or other source.
    }

    @Override
    public Product getProductById(Long productId) {
        // Replace with actual logic to retrieve a product by ID from a database or other source.
        return products.stream()
                .filter(product -> product.getId().equals(productId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<CartItem> getCartItems() {
        return cartItems;
    }

    @Override
    public double calculateTotalBill() {
        return cartItems.stream()
                .mapToDouble(CartItem::calculateTotalPrice)
                .sum();
    }

    @Override
    public void removeProductFromCart(Product product) {
        cartItems.removeIf(cartItem -> cartItem.getProduct().getId().equals(product.getId()));
    }

    // Helper method to find a cart item based on the product.
    private CartItem findCartItem(Product productToFind) {
        for (CartItem cartItem : cartItems) {
            if (cartItem.getProduct().getId().equals(productToFind.getId())) {
                return cartItem;
            }
        }
        return null;
    }
}
