/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto2ciclo4.Reto2.Repositorio;

import Reto2ciclo4.Reto2.Interface.InterfaceGadgets;
import Reto2ciclo4.Reto2.Modelo.Gadgets;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 *
 * @author usuario
 */
@Repository
public class GadgetsRepository {
    @Autowired
    private InterfaceGadgets repository;
    
    public List<Gadgets> getAll(){
        return repository.findAll();
    }
    
    public Optional<Gadgets> getGadgetById(int id){
        return repository.findById(id);
    }
    
    public Gadgets save(Gadgets gadget){
        return repository.save(gadget);
    }
    
    public void update(Gadgets gadget){
        repository.save(gadget);
    }
    
    public void delete(Gadgets gadget){
        repository.delete(gadget);
    }
}
