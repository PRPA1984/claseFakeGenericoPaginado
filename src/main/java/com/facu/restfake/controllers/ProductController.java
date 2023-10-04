package com.facu.restfake.controllers;

import com.facu.restfake.entities.Product;
import com.facu.restfake.services.ProductServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "fakestoreapi.com/products")
public class ProductController extends BaseControllerImpl<Product, ProductServiceImpl>{

    @GetMapping("/buscarPorTituloQueryMethodPaged")
    public ResponseEntity<?> buscarPorTituloQueryMethodPaged(@RequestParam String title, Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarPorTituloQueryMethodPaged(title, pageable));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/buscarPorTituloJPQL")
    public ResponseEntity<?> buscarPorTituloJPQL(@RequestParam String title){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarPorTituloJPQL(title));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/buscarPorTituloNative")
    public ResponseEntity<?> buscarPorTituloNative(@RequestParam String title){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarPorTituloNative(title));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/buscarPorCantidadElementosCategoria")
    public ResponseEntity<?> buscarPorCantidadElementosCategoria(@RequestParam Integer cantidad){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarPorCantidadElementosCategoria(cantidad));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

}
