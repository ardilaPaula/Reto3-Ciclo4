/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reto2ciclo4.Reto2.Interface;

import Reto2ciclo4.Reto2.Modelo.Order;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author User
 */
public interface InterfaceOrder extends MongoRepository<Order, Integer>{
      @Query("{id: ?0}")
    public Optional<Order> getById(Integer id);  
}
