package com.example.webapp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Value;

@Value
@ApiModel(value = "Product data response object", description = "Transfer product data from service")
public class ProductResponse {
    @ApiModelProperty(value = "Unique product id", dataType = "String")
    Long id;
    @ApiModelProperty(value = "Accompanying text about product", dataType = "String")
    String  text;
    @ApiModelProperty(dataType = "String")
    String productType;
    @ApiModelProperty(dataType = "Long", allowableValues = "range[0, infinity]")
    Long price;
    @ApiModelProperty(value = "Number of products available", dataType = "Long", allowableValues = "range[0, infinity]")
    Long amount;
}
