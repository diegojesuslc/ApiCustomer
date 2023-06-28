/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.cibertec.ecommerce.apiShoppingCartt.service;

import java.util.List;
import pe.cibertec.ecommerce.apiShoppingCartt.dto.ShoppingCartDTO;


public interface ShoppingCartService {
    
    List<ShoppingCartDTO> getAllShoppingCarts();

    ShoppingCartDTO getShoppingCartById(Long id);

    ShoppingCartDTO createShoppingCart(ShoppingCartDTO shoppingCartDTO);

    ShoppingCartDTO updateShoppingCart(Long id, ShoppingCartDTO shoppingCartDTO);

    void deleteShoppingCart(Long id);
}
