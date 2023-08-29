package br.com.fatec.FatecProjRestAPI.controller;

import br.com.fatec.FatecProjRestAPI.entity.Product;
import br.com.fatec.FatecProjRestAPI.exception.ResponseGenericException;
import br.com.fatec.FatecProjRestAPI.service.ProductService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping(value = "/list")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> list(){
        List<Product> result = productService.getInfoProducts();
        return ResponseEntity.status(HttpStatus.OK).body(ResponseGenericException.response(result));
    }


    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> saveProduct(@RequestBody Product product){
        Product result = productService.saveProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(ResponseGenericException.response(result));
    }

    @DeleteMapping(value = "/delete/{idProduct}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long idProduct){
        HashMap<String, Object> result = productService.deleteProduct(idProduct);
        return ResponseEntity.status(HttpStatus.OK).body(ResponseGenericException.response(result));
    }

    @GetMapping(value = "/findProduct/{idProduct}")
    public ResponseEntity<Object> getProductById(@PathVariable Long idProduct){
        Optional<Product> result = productService.findProductById(idProduct);
        return ResponseEntity.status(HttpStatus.OK).body(ResponseGenericException.response(result));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Object> updateProduct(@RequestBody Product product){
        Product result = productService.updateProduct(product);
        return ResponseEntity.status(HttpStatus.OK).body(ResponseGenericException.response(result));
    }

}
