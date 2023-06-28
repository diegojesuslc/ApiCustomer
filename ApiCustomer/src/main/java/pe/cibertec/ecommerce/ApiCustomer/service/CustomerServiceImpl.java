/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.cibertec.ecommerce.ApiCustomer.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import pe.cibertec.ecommerce.ApiCustomer.dao.CustomerDao;
import pe.cibertec.ecommerce.ApiCustomer.dto.CustomerDto;
import pe.cibertec.ecommerce.ApiCustomer.entity.Customer;


public class CustomerServiceImpl implements CustomerService {
    
    private CustomerDao customerDao;

    @Override
    public CustomerDto getCustomerById(Long id) {
        
        Customer customer = customerDao.findById(id);
        if (customer != null) {
            CustomerDto customerDTO = new CustomerDto();
            BeanUtils.copyProperties(customer, customerDTO);
            return customerDTO;
        }
        return null;
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        
         List<Customer> customers = customerDao.findAll();
        return customers.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        Customer createdCustomer = customerDao.save(customer);
        return convertToDto(createdCustomer);
    }

    @Override
    public CustomerDto updateCustomer(Long id, CustomerDto customerDTO) {
        
        Customer existingCustomer = customerDao.findById(id);
        if (existingCustomer != null) {
            Object customerDto = null;
            BeanUtils.copyProperties(customerDto, existingCustomer);
            Customer updatedCustomer = customerDao.save(existingCustomer);
            return convertToDto(updatedCustomer);
        }
        return null;
    }

    @Override
    public void deleteCustomer(Long id) {
        customerDao.deleteById(id);
    }
    
    private CustomerDto convertToDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        return customerDto;
    }
    
    
}
