package com.busylessman.shop.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Accessors(chain = true)
public class ProductDto extends Product{
    private Long id;
    private String name;
    private BigDecimal price;
}
