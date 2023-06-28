/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.cibertec.ecommerce.apiShoppingCartt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.ecommerce.apiShoppingCartt.dto.ShoppingCartDTO;
import pe.cibertec.ecommerce.apiShoppingCartt.service.ShoppingCartService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
@RequestMapping("/api/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping
    public ResponseEntity<List<ShoppingCartDTO>> getAllShoppingCarts() {
        List<ShoppingCartDTO> shoppingCarts = shoppingCartService.getAllShoppingCarts();
        return ResponseEntity.ok(shoppingCarts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShoppingCartDTO> getShoppingCartById(@PathVariable Long id) {
        ShoppingCartDTO shoppingCart = shoppingCartService.getShoppingCartById(id);
        return ResponseEntity.ok(shoppingCart);
        
    }
    
@Service
public class MiServicio {
    @HystrixCommand(fallbackMethod = "fallbackMetodo")
    public String miMetodo() {
        
    }

    public String fallbackMetodo() {
        
    }
}
