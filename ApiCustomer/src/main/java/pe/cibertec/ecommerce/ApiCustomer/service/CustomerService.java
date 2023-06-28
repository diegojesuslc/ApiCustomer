/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.cibertec.ecommerce.ApiCustomer.service;

import java.util.List;
import pe.cibertec.ecommerce.ApiCustomer.dto.CustomerDto;


public interface CustomerService {
    
    CustomerDto getCustomerById(Long id);
    List<CustomerDto> getAllCustomers();
    CustomerDto createCustomer(CustomerDto customerDTO);
    CustomerDto updateCustomer(Long id, CustomerDto customerDTO);
    
    void deleteCustomer(Long id);
}
