package model;
import java.sql.*;
import java.util.List;
import bd.Conexion;
import java.util.ArrayList;
import beans.Alumno;

public class alumnoModel
{
    public List<Alumno> getLstAlumnoModel()
    {
        try
        {
            List<Alumno> lst = new ArrayList<>();
            CallableStatement s = Conexion.ObtenerConexion().prepareCall("{CALL uspListarTodos}");
            ResultSet rSet = s.executeQuery();
            while(rSet.next())
            {
                Alumno obj = new Alumno();
                obj.setCodigo(rSet.getString("Id_alumno"));
                obj.setPaterno(rSet.getString("alu_paterno"));
                obj.setMaterno(rSet.getString("alu_materno"));
                obj.setNombre(rSet.getString("alu_nombres"));
                obj.setSexo(rSet.getString("alu_sexo"));
                obj.setCodModular(rSet.getString("alu_codigo"));
                obj.setEstadoCivil(rSet.getString("Id_estadocivil"));
                obj.setCorreo(rSet.getString("alu_email"));

                lst.add(obj);
            }
            Conexion.ObtenerConexion().close();
            rSet.close();
            return lst;

        } catch (SQLException e)
        {
            System.out.println("Ocurrió un error" + e.getMessage());
        }

        return null;

    }
}
