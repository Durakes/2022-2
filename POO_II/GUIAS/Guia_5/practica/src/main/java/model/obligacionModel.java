/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.*;
import beans.Obligacion;
import bd.Conexion;
import java.util.ArrayList;
import java.util.List;

//Aqui se hace el array con todos los objetos registrados en la bd, Y LO DEVUELVO
//LUEGO PASO A CONTROLLER

public class obligacionModel {
    
    public List<Obligacion> getLstObligacionModel()
    {
        try 
        {
            List<Obligacion> lst = new ArrayList<>();
            CallableStatement s = Conexion.ObtenerConexion().prepareCall("{CALL uspListar}");
            ResultSet rSet = s.executeQuery(); //se arma tabla con los resultados
            while(rSet.next())
            {
                Obligacion obj = new Obligacion();
                obj.setCodigo(rSet.getString("Id_obligacion"));
                obj.setVencimiento(rSet.getString("obl_vencimiento"));
                obj.setMontoObligacion(rSet.getDouble("obl_montoobligacion"));
                obj.setAlumno(rSet.getString("Id_alumno"));
                obj.setDescripcion(rSet.getString("Id_descripcionobligacion"));
                lst.add(obj);
            }
            Conexion.ObtenerConexion().close();
            rSet.close();
            return lst;
            
        } 
        catch (SQLException ex) 
        {
            System.out.println("Ocurrio un error: "+ex.getMessage());
        }
        
        return null;
    }
    
}
