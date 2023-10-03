package com.facu.restfake.services;


import com.facu.restfake.entities.Product;
import com.facu.restfake.repositories.BaseRepository;
import com.facu.restfake.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl  extends BaseServiceImpl<Product, Long> implements ProductoService {

    //@Autowired
    protected ProductoRepository productoRepository;

    public ProductServiceImpl(BaseRepository<Product, Long> baseRepository, ProductoRepository productoRepository) {
        super(baseRepository);
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Product> buscarPorTituloQueryMethod(String title) throws Exception {
        try {
            return productoRepository.findByTitleContaining(title);
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Product> buscarPorTituloJPQL(String title) throws Exception {
        try {
            return productoRepository.buscarPorTituloJPQL(title);
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Product> buscarPorTituloNative(String title) throws Exception {
        try {
            return productoRepository.buscarPorTituloNative(title);
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
