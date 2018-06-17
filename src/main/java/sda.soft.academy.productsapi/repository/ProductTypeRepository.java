package sda.soft.academy.productsapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sda.soft.academy.productsapi.entity.ProductType;

@Repository
public interface ProductTypeRepository extends CrudRepository<ProductType, Integer> {
}
