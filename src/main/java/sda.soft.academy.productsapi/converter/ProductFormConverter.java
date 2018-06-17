package sda.soft.academy.productsapi.converter;

import sda.soft.academy.productsapi.dto.ProductDto;
import sda.soft.academy.productsapi.web.form.ProductForm;

public interface ProductFormConverter {

    ProductForm convert(ProductDto productDto);

    ProductDto convert(ProductForm productForm);

}
