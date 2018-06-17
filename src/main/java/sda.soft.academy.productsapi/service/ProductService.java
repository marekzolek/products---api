package sda.soft.academy.productsapi.service;

import sda.soft.academy.productsapi.dto.ProductDto;
import sda.soft.academy.productsapi.exceptions.ProductException;

import java.util.List;

public interface ProductService {

    List<ProductDto> findAll();

    ProductDto findById(Integer id) throws ProductException;

    ProductDto save(ProductDto productDto) throws ProductException;

}
