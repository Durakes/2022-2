/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;
import java.sql.*;//libreria para trabajar con bases de datos en java
//import com.mysql.jdbc.Driver;
import java.util.logging.Level;
import java.sql.DriverManager;
import java.util.logging.Logger;
//HAGO LA CONEXION CON LA BD Y VOY A MODEL
public class Conexion {
    public Conexion(){}
    public static Connection ObtenerConexion(){ //llamar a metodo estático: Conexion.ObtenerConexion()
                                                //No es necesario inicializar un objeto    
        Connection cn = null; //Creando la variable conexion
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbpractica","root","");
            System.out.println("Conexion exitosa!!!");
        }catch(Exception ex){
            System.out.println("Error al conectar con la BD" + ex.getMessage());
        }   
        return cn;//si hay una conexion
    } 
}