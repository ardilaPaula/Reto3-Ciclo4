/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto2ciclo4.Reto2.Servicio;

import Reto2ciclo4.Reto2.Modelo.Order;
import Reto2ciclo4.Reto2.Modelo.User;
import Reto2ciclo4.Reto2.Repositorio.OrderRepository;
import Reto2ciclo4.Reto2.Repositorio.UserRepository;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class OrderService {
    @Autowired
    private OrderRepository repo;

    @Autowired
    private UserRepository repoU;

    public List<Order> getAll(){
        return repo.getAll();
    }

    public Order Save(Order orden){
        return repo.save(orden);
    }

    public Optional<Order> getOrderById(int id){
        return repo.getById(id);
    }

    public void Delete(Integer id){
        Optional <Order> us = repo.getById(id);
         if (us.isPresent()) {
            repo.delete(us.get());
        }
    }

    public Order update(Order orden) {
        Optional<Order> or = repo.getById(orden.getId());
        if (or.get().getId() != null) {
                or.get().setId(orden.getId());
                or.get().setStatus(orden.getStatus());
                return repo.save(or.get());
        }
        return or.get();
    }

    public List<Order> getAllByZone(String zona){
        List<User> users = repoU.getAll();
        List<Order> orden = repo.getAll();
        List<Order> existencia = new ArrayList<>();
        users.forEach(
                    user ->{
                        if(user.getZone().equals(zona)){
                            orden.forEach(
                                ord ->{
                                    if(ord.getSalesMan().equals(user)){
                                        existencia.add(ord);
                                    }
                                }
                            );
                        }
                    }
            );
        return existencia;
    }

    public List<Order> getBySaleMan(Integer id){
        List<Order> orders = repo.getAll();
        List<User> users = repoU.getAll();
        List<Order> saleManOrder = new ArrayList<>();

        users.forEach(
                user ->{
                    if(user.getId().equals(id)){
                        orders.forEach(
                                ord ->{
                                    if(ord.getSalesMan().equals(user)){
                                        saleManOrder.add(ord);
                                    }
                                }
                        );
                    }
                }
        );
        return saleManOrder;
    }

    public List<Order> getByDate(String date, Integer id){
        List<Order> orders = repo.getAll();
        List<User> users = repoU.getAll();
        List<Order> ordersByDate = new ArrayList<>();


                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        users.forEach(
                                user ->{
                                    if(user.getId()==(id)){
                                        orders.forEach(
                                                ord ->{
                                                    if(ord.getSalesMan().equals(user) && sdf.format(ord.getRegisterDay()).equals(date)){
                                                        ordersByDate.add(ord);
                                                    }
                                                }
                                        );
                                    }
                                }
                        );


        return ordersByDate;
    }

    public List<Order> getByStatus(String  status, Integer id){
        List<Order> statusO = repo.getAll();
        List<User> users = repoU.getAll();
        List<Order> ordersByStatus = new ArrayList<>();

                        users.forEach(
                                user ->{
                                    if(user.getId().equals(id)){
                                        statusO.forEach(
                                                ord ->{
                                                    if(ord.getSalesMan().equals(user) && ord.getStatus().equals(status)){
                                                        ordersByStatus.add(ord);
                                                    }
                                                }
                                        );
                                    }
                                }
                        );



        return ordersByStatus;
    }
       
}
