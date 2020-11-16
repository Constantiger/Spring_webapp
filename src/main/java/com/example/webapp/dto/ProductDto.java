package com.example.webapp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Value;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Value
@ApiModel(value = "Product data transfer object", description = "Transfer product data to service")
public class ProductDto {
    @ApiModelProperty(value = "Accompanying text about product", dataType = "String")
    String text;

    @ApiModelProperty(dataType = "String", required = true)
    @NotBlank
    String productType;

    @ApiModelProperty(dataType = "Long", allowableValues = "range[0, infinity]", required = true)
    @NotNull
    @Positive
    Long price;

    @ApiModelProperty(value = "Number of products available", dataType = "Long", allowableValues = "range[0, infinity]", required = true)
    @NotNull
    @PositiveOrZero
    Long amount;
}
