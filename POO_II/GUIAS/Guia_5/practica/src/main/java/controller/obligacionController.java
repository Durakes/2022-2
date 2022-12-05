package controller;

import java.util.*;
import beans.Obligacion;
import model.obligacionModel;

//RECUPERO LA LISTA GENERADA EN MODEL Y PASO AL JSP
public class obligacionController 
{
    public List<Obligacion> getLstObligacionController()
    {
        return new obligacionModel().getLstObligacionModel();
    }
    
}
