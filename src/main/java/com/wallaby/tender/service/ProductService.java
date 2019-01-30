package com.wallaby.tender.service;

import com.wallaby.tender.entity.Photo;
import com.wallaby.tender.entity.Product;
import com.wallaby.tender.repository.ClientReposirory;
import com.wallaby.tender.repository.PhotoRepository;
import com.wallaby.tender.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ClientReposirory clientReposirory;

    @Autowired
    private PhotoRepository photoRepository;

    public Product addProduct(Product product){
        if (clientReposirory.existsById(product.getClient().getId())){
            return productRepository.save(product);
        }
        return null;
    }

    public Photo addPhoto(MultipartFile image, Long productId){
        if (productRepository.existsById(productId)){
            Photo photo = saveFile(image);
            if (photo != null){
                Product product = new Product();
                product.setId(productId);
                photo.setProduct(product);
                return photoRepository.save(photo);
            }
        }        return null;
    }

    private Photo saveFile(MultipartFile file){
        try {
            byte[] bytes = file.getBytes();
            BufferedOutputStream stream =
                    new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
            stream.write(bytes);
            stream.close();
            Photo photo = new Photo();
            photo.setPhoto(file.getName());
            return photo;
        } catch (Exception e) {
            return null;
        }
    }
}
