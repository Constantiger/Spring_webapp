package com.example.webapp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Value;

@Value
@ApiModel(value = "User cart data response object", description = "Transfer userCart data from service")
public class UserCartResponse {
    @ApiModelProperty(value = "Unique Id", dataType = "Long")
    Long id;
    @ApiModelProperty(value = "Unique username", dataType = "String")
    String username;
    @ApiModelProperty(value = "List of products in cart", dataType = "List<ProductResponse>")
    Iterable<ProductResponse> cart;
}
