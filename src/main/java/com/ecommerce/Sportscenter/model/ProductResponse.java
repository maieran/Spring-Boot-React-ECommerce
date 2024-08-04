package com.ecommerce.Sportscenter.model;

import com.ecommerce.Sportscenter.entity.Brand;
import com.ecommerce.Sportscenter.entity.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private Integer id;
    private String name;
    private String description;
    private Long price;
    private String pictureUrl;
    private Brand brand;
    private Type type;
}
