/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.cibertec.ecommerce.apiShoppingCartt.entity;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Customer {
    private Long Id;
    private String nombre;
    private String correo;
}

