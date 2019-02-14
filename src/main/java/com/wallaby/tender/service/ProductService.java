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
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ClientReposirory clientReposirory;

    @Autowired
    private PhotoRepository photoRepository;

    public Product addProduct(Product product) {
        if (clientReposirory.existsById(product.getClient().getId())) {
            return productRepository.save(product);
        }
        return null;
    }

    public Photo addPhoto(MultipartFile image, Long productId) {
        if (productRepository.existsById(productId)) {
            List<Photo> photos = new ArrayList<>();
            Photo photo = saveFile(image);
            if (photo != null) {
                Product product = productRepository.findById(productId).orElse(null);
                Photo save = photoRepository.save(photo);
                photos.add(save);
                assert product != null;
                product.setPhotos(photos);
                productRepository.save(product);
                return save;
            }
        }
        return null;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProductByName(String name) {
        return productRepository.findByName(name);
    }

    public Product getProduct(long id){
        return productRepository.findById(id).orElse(null);
    }


    private Photo saveFile(MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();
            BufferedOutputStream stream =
                    new BufferedOutputStream(new FileOutputStream(new File("C:/Users/user/IdeaProjects/tender/src/main/resources/static/image/" + file.getOriginalFilename())));
            stream.write(bytes);
            stream.close();
            Photo photo = new Photo();
            photo.setPhoto("/image/" + file.getOriginalFilename());
            return photo;
        } catch (Exception e) {
            return null;
        }
    }
}
