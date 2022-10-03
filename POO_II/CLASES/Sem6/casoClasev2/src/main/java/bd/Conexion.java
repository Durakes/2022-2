/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bd;
import java.sql.*;//libreria para trabajar con bases de datos en java
//import com.mysql.jdbc.Driver;
import java.util.logging.Level;
import java.sql.DriverManager;
import java.util.logging.Logger;
public class Conexion
{
    public Conexion(){}
    public static Connection ObtenerConexion()
    { //No se necesita inicializar un objeto
        Connection cn = null; //Creando la variable conexion
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bduniversidad","root","");
            System.out.println("Conexion exitosa!!!");
        }catch(Exception ex)
        {
            System.out.println("Error al conectar con la BD" + ex.getMessage());
        }   
        return cn;//si hay una conexion
    } 
}
