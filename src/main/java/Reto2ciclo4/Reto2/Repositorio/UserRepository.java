/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto2ciclo4.Reto2.Repositorio;

import Reto2ciclo4.Reto2.Interface.InterfaceUser;
import Reto2ciclo4.Reto2.Modelo.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author usuario
 */
@Repository
public class UserRepository {
        @Autowired
    private InterfaceUser repo;
    
    public List<User> getAll(){
        return repo.findAll();
    }
    
     public Optional<User> getById(Integer id){
        return repo.getById(id);
    }
    
    public User save(User usuario){
        return repo.save(usuario);
    }
    
    public void delete(User usuario){
        repo.delete(usuario);
    }
}


