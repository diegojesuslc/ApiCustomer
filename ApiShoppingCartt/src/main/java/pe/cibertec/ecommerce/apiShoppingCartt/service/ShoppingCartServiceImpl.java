/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.cibertec.ecommerce.apiShoppingCartt.service;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import pe.cibertec.ecommerce.apiShoppingCartt.dao.ShoppingCartRepository;
import pe.cibertec.ecommerce.apiShoppingCartt.dto.ShoppingCartDTO;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @Override
    public List<ShoppingCartDTO> getAllShoppingCarts() {
        List<ShoppingCart> shoppingCarts = shoppingCartRepository.findAll();
        return shoppingCarts.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ShoppingCartDTO getShoppingCartById(Long id) {
        Optional<ShoppingCart> shoppingCartOptional = shoppingCartRepository.findById(id);
        if (shoppingCartOptional.isPresent()) {
            return convertToDto(shoppingCartOptional.get());
        }
        throw new ShoppingCartNotFoundException("Shopping cart not found with id: " + id);
    }

    @Override
    public ShoppingCartDTO createShoppingCart(ShoppingCartDTO shoppingCartDTO) {
        ShoppingCart shoppingCart = convertToEntity(shoppingCartDTO);
        ShoppingCart savedShoppingCart = shoppingCartRepository.save(shoppingCart);
        return convertToDto(savedShoppingCart);
    }

    @Override
    public ShoppingCartDTO updateShoppingCart(Long id, ShoppingCartDTO shoppingCartDTO) {
        Optional<ShoppingCart> shoppingCartOptional = shoppingCartRepository.findById(id);
        if (shoppingCartOptional.isPresent()) {
            ShoppingCart shoppingCart = shoppingCartOptional.get();
            shoppingCart.setNombre(shoppingCartDTO.getNombre());
            shoppingCart.setCorreo(shoppingCartDTO.getCorreo());
            ShoppingCart updatedShoppingCart = shoppingCartRepository.save(shoppingCart);
            return convertToDto(updatedShoppingCart);
        }
        throw new ShoppingCartNotFoundException("Shopping cart not found with id: " + id);
    }

    @Override
    public void deleteShoppingCart(Long id) {
        Optional<ShoppingCart> shoppingCartOptional = shoppingCartRepository.findById(id);
        if (shoppingCartOptional.isPresent()) {
            shoppingCartRepository.deleteById(id);
        } else {
            throw new ShoppingCartNotFoundException("Shopping cart not found with id: " + id);
        }
    }

    private ShoppingCartDTO convertToDto(ShoppingCart shoppingCart) {
        return new ShoppingCartDTO(
                shoppingCart.getId(),
                shoppingCart.getNombre(),
                shoppingCart.getCorreo()
        );
    }

    private ShoppingCart convertToEntity(ShoppingCartDTO shoppingCartDTO) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setNombre(shoppingCartDTO.getNombre());
        shoppingCart.setCorreo(shoppingCartDTO.getCorreo());
        return shoppingCart;
    }
    
    
}
