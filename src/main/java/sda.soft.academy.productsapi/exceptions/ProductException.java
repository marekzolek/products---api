package sda.soft.academy.productsapi.exceptions;

public class ProductException extends Exception {

    public ProductException(String message) {
        super(message);
    }

    public ProductException(String message, Throwable cause) {
        super(message, cause);
    }
}
