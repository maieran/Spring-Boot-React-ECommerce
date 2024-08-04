package com.ecommerce.Sportscenter.service;

import com.ecommerce.Sportscenter.model.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse getProductById(Integer productId);
    List<ProductResponse> getProducts();
}
