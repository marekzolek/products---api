package sda.soft.academy.productsapi.validator;

import sda.soft.academy.productsapi.dto.ProductDto;

import java.util.Map;

public interface ProductDtoValidator {

    Map<String,String> validate(ProductDto productDto);

}
