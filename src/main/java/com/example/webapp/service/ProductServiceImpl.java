package com.example.webapp.service;

import com.example.webapp.domain.Product;
import com.example.webapp.domain.ProductFilter;
import com.example.webapp.dto.ProductDto;
import com.example.webapp.dto.ProductResponse;
import com.example.webapp.error.ProductNotFoundException;
import com.example.webapp.mapper.ProductResponseMapper;
import com.example.webapp.repos.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import static com.example.webapp.domain.ProductSpecs.specificationByFilter;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    private final ProductResponseMapper mapper;

    @Override
    public ProductResponse createProduct(ProductDto newProduct) {
        Product product = mapper.productDtoToProduct(newProduct);
        return mapper.productToProductResponse(productRepo.save(product));
    }

    @Override
    public ProductResponse updateProduct(long id, ProductDto updateProduct){
        Product product = productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        mapper.productFromDto(updateProduct, product);
        return mapper.productToProductResponse(productRepo.save(product));
    }

    @Override
    public ProductResponse deleteProduct(long id) {
        Product product = productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        productRepo.deleteById(id);
        return mapper.productToProductResponse(product);
    }

    @Override
    public Product getProductById(long id) {
        return productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    public ProductResponse getProductResponseById(long id) {
        return mapper.productToProductResponse(productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException(id)));
    }

    @Override
    public Iterable<ProductResponse> getProductById(Iterable<Long> ids) {
        return mapper.listOfProductResponse(productRepo.findAllById(ids));
    }

    @Override
    public Iterable<ProductResponse> getProducts(ProductFilter filter) {
        return mapper.listOfProductResponse(productRepo.findAll(
                specificationByFilter(filter),
                ProductFilter.pageRequest(filter)).toList());
    }
}
