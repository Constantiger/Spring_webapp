package com.example.webapp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Value;
import javax.validation.constraints.NotBlank;

@Value
@ApiModel(value = "User cart data transfer object", description = "Transfer userCart data to service")
public class UserCartDto {
    @ApiModelProperty(value = "Unique username", dataType = "String")
    @NotBlank
    String username;

    @ApiModelProperty(dataType = "String")
    @NotBlank
    String password;
}
