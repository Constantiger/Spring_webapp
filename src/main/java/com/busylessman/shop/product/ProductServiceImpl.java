package com.busylessman.shop.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;
    private ProductToProductDtoConverter productToProductDtoConverter;

    @Override
    public ProductDto get(Long id) {
        Product product = productRepository.findById(id).orElseThrow(RuntimeException::new);
        return productToProductDtoConverter.convert(product);
    }

    @Override
    public List<ProductDto> getAll() {
        return productRepository.findAll().stream()
                .map(pr -> productToProductDtoConverter.convert(pr))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto create(ProductDto productDto) {
        return productRepository.save(productDto);
    }

    @Override
    public ProductDto update(ProductDto productDto) {
        return productRepository.save(productDto);
    }

    @Override
    public void delete(Long id) {

    }
}
