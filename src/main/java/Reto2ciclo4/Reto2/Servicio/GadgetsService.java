/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto2ciclo4.Reto2.Servicio;

import Reto2ciclo4.Reto2.Modelo.Gadgets;
import Reto2ciclo4.Reto2.Repositorio.GadgetsRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author usuario
 */
@Service
public class GadgetsService {
    @Autowired
    private GadgetsRepository gadgetsRepository;
    
    public List<Gadgets> getAll(){
        return gadgetsRepository.getAll();
    }

    
    public Optional<Gadgets> getGadgetById(int id){
        return gadgetsRepository.getGadgetById(id);
    }
    public Gadgets save (Gadgets gadget){
        if(gadget.getId() == null){
            return gadget;
        }else{
            return gadgetsRepository.save(gadget);
        }
    }
    
    public Gadgets update(Gadgets gadget){
        if(gadget.getId() != null){
           Optional<Gadgets> gadgetDb = gadgetsRepository.getGadgetById(gadget.getId());
           if(!gadgetDb.isEmpty()){
               
               if(gadget.getBrand() != null){
                   gadgetDb.get().setBrand(gadget.getBrand());
               }
               
               if(gadget.getCategory() != null){
                   gadgetDb.get().setCategory(gadget.getCategory());
               }
               
               if(gadget.getName() != null){
                   gadgetDb.get().setName(gadget.getName());
               }
               
               if(gadget.getDescription() != null){
                   gadgetDb.get().setDescription(gadget.getDescription());
               }
               
               if(gadget.getPrice() != 0.0){
                   gadgetDb.get().setPrice(gadget.getPrice());
               }
               
               if(gadget.getQuantity() != 0){
                   gadgetDb.get().setQuantity(gadget.getQuantity());
               }
               
               if(gadget.getPhotography() != null){
                   gadgetDb.get().setPhotography(gadget.getPhotography());
               }
               gadgetDb.get().setAvailability(gadget.isAvailability());
               gadgetsRepository.update(gadgetDb.get());
               return gadgetDb.get();
        }else{
               return gadget;
           }
            
        }else{
            return gadget;
        }
    }
    
    public boolean delete(Integer id){
        Boolean aBoolean = getGadgetById(id).map(gadget -> {
          gadgetsRepository.delete(gadget);
          return true;
        }).orElse(false);
        return aBoolean;
    }

    public List<Gadgets> findByDesc(String description){
        List<Gadgets> gadgets = gadgetsRepository.getAll();
        List<Gadgets> gadgetsList = new ArrayList<>();

        gadgets.forEach(
                gadgets1 -> {
                    if(gadgets1.getDescription().contains(description)==true){
                        gadgetsList.add(gadgets1);
                    }
                }
        );
        return gadgetsList;
    }

    public List<Gadgets> findByPrice(double price){
        List<Gadgets> gadgets = gadgetsRepository.getAll();
        List<Gadgets> gadgetsList = new ArrayList<>();

        gadgets.forEach(
                gadgets1 -> {
                    if(gadgets1.getPrice() <= price){
                        gadgetsList.add(gadgets1);
                    }
                }
        );
        return gadgetsList;
    }
}
