package sda.soft.academy.productsapi.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import sda.soft.academy.productsapi.dto.ProductDto;
import sda.soft.academy.productsapi.entity.Product;
import sda.soft.academy.productsapi.repository.ProductRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Component
public class ProductDtoEanValidator implements ProductDtoValidator {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MessageSource messageSource;

    @Override
    public Map<String, String> validate(ProductDto productDto) {
        Map<String, String> errors = new HashMap<String, String>();
        String codeEan = productDto.getEAN();
        if(productRepository.countDistinctByCodeEan(codeEan)>0){
            errors.put("errors.productDto.codeEanExist",
                    messageSource.getMessage("errors.productDto.CodeEanExist",
                    new Object[]{codeEan}, Locale.getDefault()));

        }
        return errors;

    }

}
