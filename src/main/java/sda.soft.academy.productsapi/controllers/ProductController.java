package sda.soft.academy.productsapi.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sda.soft.academy.productsapi.dto.ProductDto;
import sda.soft.academy.productsapi.exceptions.ProductException;
import sda.soft.academy.productsapi.service.ProductService;

import java.util.List;


@RestController
public class ProductController {

    private Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    @Qualifier("realProductService")
    private ProductService productService;

    @RequestMapping("/products")
    public List<ProductDto> findAll(){

        return productService.findAll();

    }
    @RequestMapping("/product/{productId}")
    private ProductDto findById(@PathVariable("productId") Integer productId){
        ProductDto productDto = null;
        try{
            productDto = productService.findById(productId);
        } catch (ProductException e){
            logger.error("product with id= " + productId + " doesn't exist");
        }
        return productDto;

    }

}
