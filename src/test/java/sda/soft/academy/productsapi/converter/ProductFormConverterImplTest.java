package sda.soft.academy.productsapi.converter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sda.soft.academy.productsapi.dto.ProductDto;
import sda.soft.academy.productsapi.web.form.ProductForm;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductFormConverterImplTest {

    @Autowired
    private ProductFormConverter productFormConverter;

    @Test
    public void shouldConvertProductPriceCorrectly() {
        ProductForm productForm = new ProductForm();
        productForm.setPrice("2,40");
        ProductDto productDto = productFormConverter.convert(productForm);
        Assert.assertEquals(new BigDecimal("2.40"), productDto.getPrice());

    }
}