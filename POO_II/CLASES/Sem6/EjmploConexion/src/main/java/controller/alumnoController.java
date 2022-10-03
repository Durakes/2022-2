package controller;
import java.util.*;
import beans.Alumno;
import model.alumnoModel;
public class alumnoController
{
    public List<Alumno> getLstAlumnoController()
    {   
        return new alumnoModel().getLstAlumnoModel();
    }
}
