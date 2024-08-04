package com.ecommerce.Sportscenter.service;

import com.ecommerce.Sportscenter.entity.Brand;
import com.ecommerce.Sportscenter.model.BrandResponse;
import com.ecommerce.Sportscenter.repository.BrandRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<BrandResponse> getAllBrands() {
        log.info("Fetching all brands!");

        //fetch brands
        List<Brand> brands = brandRepository.findAll();

        //now stream operator to map with response (later for ui/react)
        List<BrandResponse> brandResponses = brands.stream()
                .map(this::converToBrandResponse)
                .collect(Collectors.toList());
        log.info("Fetched all brands and mapped to brandreponses");
        return brandResponses;
    }

    private BrandResponse converToBrandResponse(Brand brand) {
        return BrandResponse.builder()
                .id(brand.getId())
                .name(brand.getName())
                .build();
    }
}
