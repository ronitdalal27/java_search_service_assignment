package com.assignment.inventory_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.assignment.inventory_service.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
