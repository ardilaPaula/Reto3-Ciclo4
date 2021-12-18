/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto2ciclo4.Reto2.Controlador;

import Reto2ciclo4.Reto2.Modelo.Order;
import Reto2ciclo4.Reto2.Servicio.OrderService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
@RequestMapping("/api/order")
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService Service;
    
    @GetMapping(path = "all")
    public List<Order> getAllUser(){
        return Service.getAll();
    }
    
    @GetMapping(path = "{id}")
    public Optional<Order> getById(@PathVariable("id") Integer id){
        return Service.getOrderById(id);
    }
    
    @PostMapping(path="new")
    public ResponseEntity<Order> saveNewOrder(@RequestBody Order orden){
        Order ordensave = Service.Save(orden);
        if(ordensave.getId() == null || ordensave.getRegisterDay() == null || ordensave.getStatus() == null){
            return new ResponseEntity<>(ordensave, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(ordensave, HttpStatus.CREATED);
    }
    
    @PutMapping(path="update")
    public ResponseEntity<Order> UpdateOrder(@RequestBody Order orden){

        Order ordenupdate = Service.update(orden);
        if (ordenupdate.getStatus() == null || ordenupdate.getId()==null){
            return new ResponseEntity<>(ordenupdate, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(ordenupdate, HttpStatus.CREATED);
    }
    
    @DeleteMapping(path="{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Integer id){
        Service.Delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    
    @GetMapping(path = "zona/{zone}")
    public List<Order> getByZone(@PathVariable("zone") String zona){
        return Service.getAllByZone(zona);
    }

    @GetMapping(path = "salesman/{id}")
    public List<Order> getBySaleMan(@PathVariable("id") Integer id){
        return Service.getBySaleMan(id);
    }

    @GetMapping(path = "date/{date}/{id}")
    public List<Order> getByDate(@PathVariable("date") String date,@PathVariable("id") Integer id){
        return Service.getByDate(date,id);
    }

    @GetMapping(path = "state/{state}/{id}")
    public List<Order> getByStatus(@PathVariable("state") String state,@PathVariable("id") Integer id){
        return Service.getByStatus(state,id);
    }

    
}
