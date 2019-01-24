package com.wallaby.tender.repository;

import com.wallaby.tender.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
