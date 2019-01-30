package com.wallaby.tender.controller;

import com.wallaby.tender.entity.Client;
import com.wallaby.tender.entity.Product;
import com.wallaby.tender.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
}
