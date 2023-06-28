/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.cibertec.ecommerce.ApiCustomer.dao;

import jakarta.persistence.PersistenceContext;
import java.util.List;
import org.springframework.stereotype.Repository;
import pe.cibertec.ecommerce.ApiCustomer.entity.Customer;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.EntityManager;

@Repository
public class CustomerDao {
    @PersistenceContext
    private EntityManager entityManager;

    public Customer findById(Long id) {
        return entityManager.find(Customer.class, id);
    }

    public List<Customer> findAll() {
        TypedQuery<Customer> query = entityManager.createQuery("SELECT c FROM Customer c", Customer.class);
        return query.getResultList();
    }

    public Customer save(Customer customer) {
        entityManager.persist(customer);
        return customer;
    }

    public void deleteById(Long id) {
        Customer customer = findById(id);
        if (customer != null) {
            entityManager.remove(customer);
        }
    }
}
