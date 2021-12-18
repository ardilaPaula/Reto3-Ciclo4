/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto2ciclo4.Reto2.Controlador;

import Reto2ciclo4.Reto2.Modelo.User;
import Reto2ciclo4.Reto2.Servicio.UserService;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author usuario
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
/**
*Llamado de clase necesaria
*/
    private UserService UsuarioService;

    @PostMapping(path="new")/**Llamado de clase necesaria*/
    public ResponseEntity<User> saveNewUser(@RequestBody User user){
        User user_saved = UsuarioService.Save(user);
        if(user_saved.getId() == null || user_saved.getEmail() == null || user_saved.getIdentification() == null){
            return new ResponseEntity<>(user_saved, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(user_saved, HttpStatus.CREATED);
    }

    @GetMapping(path = "all")/**Llamado de clase necesaria*/
    public List<User> getAllUser(){
        return UsuarioService.getAll();
    }
    
    @GetMapping(path = "{id}")
    public Optional<User> getById(@PathVariable("id") Integer id){
        return UsuarioService.getById(id);
    }
    
    @GetMapping(path = "emailexist/{email}")/**Llamado de clase necesaria*/
    public boolean getByEmail(@PathVariable("email") String email){
        return UsuarioService.EmailExist(email);
    }
    
    @GetMapping(path = "{email}/{password}")/**Llamado de clase necesaria*/
    public User getExistencia(@PathVariable("email") String email, @PathVariable("password") String password){
        User users = UsuarioService.ExisteUsuario(email, password);
        return users;
    }
    
    @PutMapping(path="update")/**Llamado de clase necesaria*/
    public ResponseEntity<User> update_user(@RequestBody User user){
        User userU = UsuarioService.update(user);
        if(userU.getEmail() == null || userU.getPassword() == null || userU.getName() == null){
            return new ResponseEntity<>(userU, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userU, HttpStatus.CREATED);
    }
    
    @DeleteMapping(path="{id}")/**Llamado de clase necesaria*/
    public ResponseEntity deleteUser(@PathVariable("id") Integer ident){
        UsuarioService.Delete(ident);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("birthday/{month}")
    public List<User> getByBirthtDay(@PathVariable("month") String month){
        return UsuarioService.findByBirthtDay(month);
    }
}
