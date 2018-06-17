package sda.soft.academy.productsapi.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import sda.soft.academy.productsapi.controllers.ProductController;
import sda.soft.academy.productsapi.dto.ProductDto;
import sda.soft.academy.productsapi.web.form.ProductForm;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

@Component
public class ProductFormConverterImpl implements ProductFormConverter {

    private Logger logger = LoggerFactory.getLogger(ProductFormConverter.class);


    @Override
    public ProductForm convert(ProductDto productDto) {
        ProductForm productForm = new ProductForm();
        productForm.setId(productDto.getId());
        productForm.setName(productDto.getName());
        productForm.setType(productDto.getType());
        productForm.setEan(productDto.getEAN());
        String priceFormated = NumberFormat.getCurrencyInstance().format(productDto.getPrice());
        productForm.setPrice(priceFormated);
        return productForm;
    }

    @Override
    public ProductDto convert(ProductForm productForm) {

        String formattedPrice = productForm.getPrice();
        DecimalFormat decimalFormat = (DecimalFormat)NumberFormat.getInstance(Locale.getDefault());
        decimalFormat.setParseBigDecimal(true);
        BigDecimal price = null;
        try {
            price = (BigDecimal) decimalFormat.parse(formattedPrice);
        } catch (ParseException e){
            logger.error("Price " + formattedPrice + " cannot be converted.");
        }

        ProductDto productDto = new ProductDto(productForm.getId(),
                productForm.getEan(),
                productForm.getName(),
                price,
                productForm.getType());
        return productDto;
    }
}
