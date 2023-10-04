package com.facu.restfake.services;


import com.facu.restfake.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ProductoService extends BaseService<Product,Long> {

    Page<Product> buscarPorTituloQueryMethodPaged(String title, Pageable pageable) throws Exception;
    List<Product> buscarPorTituloJPQL(String title) throws Exception;
    List<Product> buscarPorTituloNative(String title) throws Exception;
    List<Product> buscarPorCantidadElementosCategoria(Integer cantidad) throws Exception;
}


