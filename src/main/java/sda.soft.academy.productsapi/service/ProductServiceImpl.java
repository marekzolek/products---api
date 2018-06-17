package sda.soft.academy.productsapi.service;

import org.springframework.stereotype.Service;
import sda.soft.academy.productsapi.dto.ProductDto;
import sda.soft.academy.productsapi.exceptions.ProductException;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public List<ProductDto> findAll() {
        ProductDto productDto1 = new ProductDto(1,"123", "warter", BigDecimal.valueOf(2.50f), 3);
        ProductDto productDto2 = new ProductDto(2,"123532", "bread", BigDecimal.valueOf(3.50f), 1);
        ProductDto productDto3 = new ProductDto(3,"678654", "tablet", BigDecimal.valueOf(550.50f), 2);

        return Arrays.asList(productDto1,productDto2,productDto3);
    }

    @Override
    public ProductDto findById(Integer id) throws ProductException {
        return null;
    }

    @Override
    public ProductDto save(ProductDto productDto) throws ProductException {
        return null;
    }

}
