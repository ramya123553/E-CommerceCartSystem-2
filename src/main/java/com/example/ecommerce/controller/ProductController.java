package com.example.ecommerce.controller;

import com.example.ecommerce.entity.CartItem;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ecommerce")
public class ProductController {

    private final ProductService productService;
    private static final String REDIRECT_PRODUCTS = "redirect:/ecommerce/products";
    private static final String REDIRECT_CART = "redirect:/ecommerce/cart";

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/index")
    public String showIndex() {
        return "index";
    }

    @GetMapping("/products")
    public String showProductList(Model model) {
        List<Product> productList = productService.getAllProducts();
        model.addAttribute("productList", productList);
        return "productList";
    }

    @PostMapping("/cart/add")
    public String addToCart(@RequestParam Long productId) {
        Product product = productService.getProductById(productId);
        productService.addProductToCart(product);
        return REDIRECT_PRODUCTS;
    }

    @GetMapping("/cart")
    public String showShoppingCart(Model model) {
        List<CartItem> cartItems = productService.getCartItems();
        double totalBill = productService.calculateTotalBill();
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("totalItems", cartItems.size());
        model.addAttribute("totalBill", totalBill);
        return "shoppingCart";
    }

    @PostMapping("/cart/update")
    public String updateCartItemQuantity(@RequestParam Long productId, @RequestParam int quantity) {
        Product product = productService.getProductById(productId);
        productService.updateProductQuantity(product, quantity);
        return REDIRECT_CART;
    }

    @PostMapping("/cart/remove")
    public String removeCartItem(@RequestParam Long productId) {
        Product product = productService.getProductById(productId);
        productService.removeProductFromCart(product);
        return REDIRECT_CART;
    }

    @GetMapping("/total-bill")
    public String showTotalBill(Model model) {
        double totalBill = productService.calculateTotalBill();
        model.addAttribute("totalBill", totalBill);
        return "totalBill";
    }
}
