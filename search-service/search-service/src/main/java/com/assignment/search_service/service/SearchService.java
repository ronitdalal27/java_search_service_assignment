package com.assignment.search_service.service;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.assignment.search_service.dto.ProductDTO;

@Service
public class SearchService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String INVENTORY_URL = "http://localhost:8081/api/products";

    public List<String> getProductNamesUnder50() {

        ProductDTO[] products = restTemplate.getForObject(INVENTORY_URL, ProductDTO[].class);

        return Arrays.stream(products)
                .filter(p -> p.getPrice() < 50)
                .map(ProductDTO::getName)
                .sorted()
                .toList();
    }
}
