package com.example.webapp.mapper;

import com.example.webapp.domain.Product;
import com.example.webapp.dto.ProductDto;
import com.example.webapp.dto.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ProductResponseMapper {
    ProductResponse productToProductResponse(Product product);
    Product productDtoToProduct(ProductDto productDto);
    Iterable<ProductResponse> listOfProductResponse(Iterable<Product> products);
    void productFromDto(ProductDto productDto, @MappingTarget Product product);
}
