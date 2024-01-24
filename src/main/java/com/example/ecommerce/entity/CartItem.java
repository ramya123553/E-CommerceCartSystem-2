package com.example.ecommerce.entity;

public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // Add a product to the cart
    public void addProduct(Product product) {
        if (this.product.getId().equals(product.getId())) {
            // Increment quantity if the product is already in the cart.
            this.quantity++;
        } else {
            // Add the product with quantity 1.
            this.product = product;
            this.quantity = 1;
        }
    }

    // Remove a product from the cart
    public void removeProduct() {
        if (this.quantity > 1) {
            // Decrease quantity if more than 1.
            this.quantity--;
        } else {
            // Remove the product if the quantity is 1.
            this.product = null;
            this.quantity = 0;
        }
    }

    // Update the quantity of a product in the cart
    public void updateProductQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        } else {
            // Remove the product if the quantity is 0 or less.
            this.product = null;
            this.quantity = 0;
        }
    }

    // Get the total price of items in the cart
    public double calculateTotalPrice() {
        return this.product.getPrice() * this.quantity;
    }

    // Get a summary of items in the cart
    public String getCartSummary() {
        return "You have " + this.quantity + " " + this.product.getName() + "s in your cart.";
    }

    // Get the product in the cart
    public Product getProduct() {
        return this.product;
    }

    // Get the quantity of the product in the cart
    public int getQuantity() {
        return this.quantity;
    }

    // Other methods as needed
}
