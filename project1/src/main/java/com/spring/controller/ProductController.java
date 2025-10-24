package com.spring.controller;

import com.spring.model.Product;
import com.spring.model.Seller;
import com.spring.repository.ProductRepository;
import com.spring.repository.SellerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;
    private final SellerRepository sellerRepository;

    public ProductController(ProductRepository productRepository, SellerRepository sellerRepository) {
        this.productRepository = productRepository;
        this.sellerRepository = sellerRepository;
    }

    @GetMapping
    public String getProducts(Model model) {
        List<Product> products = productRepository.findAll();
        List<Seller> sellers = sellerRepository.findAll();
        model.addAttribute("products", products);
        model.addAttribute("sellers", sellers);
        model.addAttribute("product", new Product());
        return "products";
    }

@PostMapping("/add")
public String addProduct(@ModelAttribute("product") Product product, @RequestParam int sellerId) {
    Seller seller = sellerRepository.findById(sellerId).orElse(null);
    product.setSeller(seller);
    productRepository.save(product);
    return "redirect:/products";
}

@PostMapping("/update")
public String updateProduct(@ModelAttribute("product") Product product, @RequestParam int sellerId) {
    Seller seller = sellerRepository.findById(sellerId).orElse(null);
    product.setSeller(seller);
    productRepository.save(product);
    return "redirect:/products";
}

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        productRepository.deleteById(id);
        return "redirect:/products";
    }
}
