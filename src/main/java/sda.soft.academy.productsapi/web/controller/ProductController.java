package sda.soft.academy.productsapi.web.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sda.soft.academy.productsapi.converter.ProductFormConverter;
import sda.soft.academy.productsapi.dto.ProductDto;
import sda.soft.academy.productsapi.entity.Product;
import sda.soft.academy.productsapi.entity.ProductType;
import sda.soft.academy.productsapi.exceptions.ProductException;
import sda.soft.academy.productsapi.repository.ProductTypeRepository;
import sda.soft.academy.productsapi.service.ProductService;
import sda.soft.academy.productsapi.validator.ProductDtoValidator;
import sda.soft.academy.productsapi.web.form.ProductForm;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("productWebController")
public class ProductController {

    private Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    @Qualifier("realProductService")
    private ProductService productService;

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Autowired
    private ProductFormConverter productFormConverter;

    @Autowired
    private ProductDtoValidator productDtoValidator;

    @GetMapping("/product")
    public String findById(@RequestParam("productId") Integer productId, Model model){

        ProductDto productDto = null;
        try {
            productDto = productService.findById(productId);

        } catch (ProductException e){

        }

        ProductForm productForm = productFormConverter.convert(productDto);
        model.addAttribute("productModel", productForm);
        Iterable<ProductType> productTypes = productTypeRepository.findAll();
        model.addAttribute("productTypes", productTypes);
        return "productView";
    }

    @RequestMapping(value = "/product/save", method = RequestMethod.POST)
    public String saveProduct(@Valid @ModelAttribute(name = "productModel") ProductForm productForm, BindingResult bindingResult,
                              Model model){

        ProductDto productDto = productFormConverter.convert(productForm);
        Map<String, String> errors = productDtoValidator.validate(productDto);

        if (!bindingResult.hasErrors() && errors.isEmpty()) {
            try {
                    productDto = productService.save(productDto);
            } catch (ProductException e) {
                logger.error("cannot save product " + productDto);
            }
            return "redirect:/product?productId=" + productDto.getId();
        } else {
            model.addAttribute("productErrors", errors);
            model.addAttribute("productModel", productForm);
            Iterable<ProductType> productTypes = productTypeRepository.findAll();
            model.addAttribute("productTypes", productTypes);
            return "productView";
        }
    }

    @GetMapping(value = "/product/add")
    public String addProduct(Model model){
        model.addAttribute("productModel", new ProductForm());
        Iterable<ProductType> productTypes = productTypeRepository.findAll();
        model.addAttribute("productTypes", productTypes);
        return "productView";
    }

    @GetMapping(value = "/product/list")
    public String findAllProducts(Model model){
        List<ProductDto> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "productListView";
    }
}