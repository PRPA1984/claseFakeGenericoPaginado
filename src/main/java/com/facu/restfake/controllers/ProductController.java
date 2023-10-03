package com.facu.restfake.controllers;

import com.facu.restfake.entities.Product;
import com.facu.restfake.services.ProductServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "fakestoreapi.com/products")
public class ProductController extends BaseControllerImpl<Product, ProductServiceImpl>{

    @GetMapping("/buscarPorTituloQueryMethod")
    public ResponseEntity<?> buscarPorTituloQueryMethod(@RequestParam String title){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarPorTituloQueryMethod(title));
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

}
