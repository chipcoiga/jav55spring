package vn.com.iviettech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.iviettech.entity.ProductEntity;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {

    List<ProductEntity> findByCategoryID(Long categoryID);

}
