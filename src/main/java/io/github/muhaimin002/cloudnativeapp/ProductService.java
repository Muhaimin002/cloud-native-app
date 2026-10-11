package io.github.muhaimin002.cloudnativeapp;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final List<Product> products = List.of(
            new Product("p-100", "Annual Subscription", new BigDecimal("120.00")),
            new Product("p-200", "Support Plan", new BigDecimal("45.50")),
            new Product("p-300", "Training Voucher", new BigDecimal("15.00")));

    public List<Product> findAll() {
        return products;
    }

    public Optional<Product> findById(String id) {
        return products.stream().filter(p -> p.id().equals(id)).findFirst();
    }
}
