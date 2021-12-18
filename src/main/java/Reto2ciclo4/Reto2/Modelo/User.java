/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto2ciclo4.Reto2.Modelo;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author usuario
 */
@Document(collection = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
   @Id
private Integer id;
/**
 *@param Id
 */
private String identification;
/**
 *@param identificación
 */
private String name;
/**
 *@param nombre
 */
private Date birthtDay;
/**
 *@param cumpleaños
 */
private String monthBirthtDay;
/**
 *@param mes
 */
private String address;
/**
 *@param dirección
 */
private String cellPhone;
/**
 *@param Celular
 */
private String email;
/**
 *@param correo
 */
private String password;
/**
 *@param contraseña
 */
private String zone;
/**
 *@param zona
 */
private String type;
/**
 *@param Tipo
 */

}
