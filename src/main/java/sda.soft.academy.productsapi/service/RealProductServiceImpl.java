package sda.soft.academy.productsapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.soft.academy.productsapi.dto.ProductDto;
import sda.soft.academy.productsapi.entity.Product;
import sda.soft.academy.productsapi.entity.ProductType;
import sda.soft.academy.productsapi.exceptions.ProductException;
import sda.soft.academy.productsapi.repository.ProductRepository;
import sda.soft.academy.productsapi.repository.ProductTypeRepository;
import sda.soft.academy.productsapi.validator.ProductDtoValidator;
import sda.soft.academy.productsapi.web.form.ProductForm;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service("realProductService")
public class RealProductServiceImpl implements ProductService {



    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Override
    public List<ProductDto> findAll() {
        Iterable<Product> products = productRepository.findAll();
        return StreamSupport.stream(products.spliterator(), false).map(new ProductConverter()).collect(Collectors.toList());
    }

    @Override
    public ProductDto findById(Integer id) throws ProductException {
        Optional<Product> product = productRepository.findById(id);
        Optional<ProductDto> productDto = product.map(new ProductConverter());
        if (productDto.isPresent()){
            return productDto.get();
        } else {
            throw new ProductException("There is no product with id= " + id);
        }

    }

    @Override
    public ProductDto save(ProductDto productDto) throws ProductException {
        ProductDtoConverter productDtoConverter = new ProductDtoConverter();
        Product product = productDtoConverter.apply(productDto);
        product = productRepository.save(product);
        ProductConverter productConverter = new ProductConverter();
        return productConverter.apply(product);
    }


    class ProductConverter implements Function<Product, ProductDto>{

        @Override
        public ProductDto apply(Product product) {
            ProductDto productDto = new ProductDto(
                    product.getId(),
                    product.getCodeEan(),
                    product.getName(),
                    product.getPrice(),
                    product.getType().getId());
            return productDto;
        }
    }

    class ProductDtoConverter implements Function<ProductDto, Product>{
        @Override
        public Product apply(ProductDto productDto) {
            Product product = new Product();
            product.setId(productDto.getId());
            product.setName(productDto.getName());
            product.setPrice(productDto.getPrice());
            product.setCodeEan(productDto.getEAN());
            Optional<ProductType> productType = productTypeRepository.findById(productDto.getType());
            product.setType(productType.get());
            return product;
        }
    }

}
