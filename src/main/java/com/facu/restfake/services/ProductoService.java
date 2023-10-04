package com.facu.restfake.services;


import com.facu.restfake.entities.Product;

import java.util.List;


public interface ProductoService extends BaseService<Product,Long> {

    List<Product> buscarPorTituloQueryMethod(String title) throws Exception;
    List<Product> buscarPorTituloJPQL(String title) throws Exception;
    List<Product> buscarPorTituloNative(String title) throws Exception;
    List<Product> buscarPorCantidadElementosCategoria(Integer cantidad) throws Exception;
}


