/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reto2ciclo4.Reto2.Interface;

import Reto2ciclo4.Reto2.Modelo.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author usuario
 */
public interface InterfaceUser extends MongoRepository<User, Integer> {
    @Query("{id: ?0}")
    public Optional<User> getById(Integer id);
    
    
}
