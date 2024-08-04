package com.ecommerce.Sportscenter.service;

import com.ecommerce.Sportscenter.entity.Product;
import com.ecommerce.Sportscenter.model.ProductResponse;
import com.ecommerce.Sportscenter.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public ProductResponse getProductById(Integer productId) {
        log.info("Fetch product by unique Id: {}", productId);
        Product product = productRepository.findById(productId).
                orElseThrow(() -> new RuntimeException("Product doesn't exist"));

        //now convert the Product to ProductResponse
        ProductResponse productResponse = convertToProductResponse(product);
        log.info("Fetched Product by Product Id: {}", productId);
        return productResponse;
    }

    @Override
    public List<ProductResponse> getProducts() {
        log.info("Fetching products!");

        //fetching from db
        List<Product> products = productRepository.findAll();

        List<ProductResponse> productResponses = products.stream()
                .map(this::convertToProductResponse)
                .collect(Collectors.toList());
        log.info("Fetched All Products!");
        return productResponses;
    }


    private ProductResponse convertToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .pictureUrl(product.getPictureUrl())
                .productBrand(product.getBrand().getName())
                .productType(product.getType().getName())
                .build();
    }
}
