package com.ecommerce.Sportscenter.service;

import com.ecommerce.Sportscenter.entity.Type;
import com.ecommerce.Sportscenter.model.TypeResponse;
import com.ecommerce.Sportscenter.repository.TypeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class TypeServiceImpl implements TypeService {
    private final TypeRepository typeRepository;

    public TypeServiceImpl(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public List<TypeResponse> getAllTypes() {
        log.info("Fetching all types!");

        //fetch types from db
        List<Type> types = typeRepository.findAll();

        //now stream operator to map with response (later for ui/react)
        List<TypeResponse> typeResponses = types.stream()
                .map(this::convertToTypeResponse)
                .collect(Collectors.toList());

        return typeResponses;
    }

    private TypeResponse convertToTypeResponse(Type type) {
        return TypeResponse.builder()
                .id(type.getId())
                .name(type.getName())
                .build();
    }
}
