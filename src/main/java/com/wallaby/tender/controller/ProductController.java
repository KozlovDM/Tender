package com.wallaby.tender.controller;

import com.wallaby.tender.entity.Client;
import com.wallaby.tender.entity.Product;
import com.wallaby.tender.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public Product addProductPhoto(@RequestParam MultipartFile photo, @RequestParam("name") String name,
                                 @RequestParam String description, @RequestParam String price, @RequestParam String id){
        if (photo.isEmpty() || name.isEmpty()){
            return null;
        }
        Product newProduct = new Product();
        Client newClient = new Client();
        newClient.setId(Long.parseLong(id));
        newProduct.setClient(newClient);
        newProduct.setDescription(description);
        newProduct.setName(name);
        newProduct.setPrice(Double.valueOf(price));
        Product product = productService.addProduct(newProduct);
        if (productService.addPhoto(photo, product.getId()) != null){
            return product;
        }
        return null;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/productSearch")
    public List<Product> getProductByName(String name){
        return productService.getProductByName(name);
    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable String id){
        return productService.getProduct(Long.parseLong(id));
    }
}
