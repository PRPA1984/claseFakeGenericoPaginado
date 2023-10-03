package com.facu.restfake.repositories;



import com.facu.restfake.entities.Product;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends BaseRepository<Product, Long>{
    //Query methods
    List<Product> findByTitleContaining(String title);

    //JPQL
    @Query(
        value =
            "SELECT p " +
            "FROM Product p " +
            "WHERE p.title like '%?1%'"
    )
    List<Product> buscarPorTituloJPQL(String title);

    //Native
    @Query(
        value =
            "SELECT p " +
            "FROM product p " +
            "WHERE p.title like '%?1%'",
        nativeQuery = true
    )
    List<Product> buscarPorTituloNative(String title);
}
