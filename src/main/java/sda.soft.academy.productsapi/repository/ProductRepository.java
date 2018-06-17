package sda.soft.academy.productsapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sda.soft.academy.productsapi.entity.Product;

import java.util.List;


@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {


    int countDistinctByCodeEan(String ean);

}
