package com.example.webapp.mapper;

import com.example.webapp.domain.UserCart;
import com.example.webapp.dto.UserCartDto;
import com.example.webapp.dto.UserCartResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface UserCartResponseMapper {
    UserCartResponse userCartToUserCartResponse(UserCart userCart);
    @Mapping(target = "cart", expression = "java(new ArrayList<>())")
    UserCart userCartDtoToUserCart(UserCartDto userCartDto);
    Iterable<UserCartResponse> listOfUserCartResponse(Iterable<UserCart> userCarts);
}
