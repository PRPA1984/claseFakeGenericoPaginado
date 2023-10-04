package com.facu.restfake.repositories;



import com.facu.restfake.entities.Product;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends BaseRepository<Product, Long>{
    //Query methods
    List<Product> findByTitleContaining(String title);

    //JPQL
    @Query(
        value =
            "SELECT p FROM Product p WHERE p.title LIKE %:filtro%"
    )
    List<Product> buscarPorTituloJPQL(@Param("filtro") String title);

    //Native
    @Query(
        value =
            "SELECT * FROM product WHERE titulo LIKE %:filtro%",
        nativeQuery = true
    )
    List<Product> buscarPorTituloNative(@Param("filtro") String title);

    //Consultas avanzadas
    @Query(
            value =
                "SELECT * " +
                "FROM product p " +
                "QUALIFY COUNT(*) OVER (PARTITION BY p.categoria) > :cant",
            nativeQuery = true
    )
    List<Product> buscarPorCantidadElementosCategoria(@Param("cant") Integer cantidad);
}
