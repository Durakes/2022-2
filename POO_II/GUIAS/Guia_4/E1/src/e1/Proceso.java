package e1;

public class Proceso
{
    int precioFinal;

    public Proceso(){}

    void calcularPrecio(int indexFabricante, int indexTipoPrograma, int indexDispositivo)
    {
        switch (indexFabricante) {
            case 0 :
            {
                if(indexTipoPrograma == 0)
                {
                    precioFinal = 1500;
                }else if(indexTipoPrograma == 1)
                {
                    if(indexDispositivo == 0)
                    {
                        precioFinal = 1800;
                    }else if(indexDispositivo == 1)
                    {
                        precioFinal = 1200;
                    }else if(indexDispositivo == 2)
                    {
                        precioFinal = 900;
                    }
                }
                break;
            }
            case 1 : 
            {
                if(indexTipoPrograma == 0)
                {
                    precioFinal = 2500;
                }else if(indexTipoPrograma == 1)
                {
                    if(indexDispositivo == 0)
                    {
                        precioFinal = 1900;
                    }else if(indexDispositivo == 1)
                    {
                        precioFinal = 1800;
                    }else if(indexDispositivo == 2)
                    {
                        precioFinal = 1600;
                    }
                }
                break;
            }
            case 2 : 
            {
                if(indexTipoPrograma == 0)
                {
                    precioFinal = 1000;
                }else if(indexTipoPrograma == 1)
                {
                    if(indexDispositivo == 0)
                    {
                        precioFinal = 100;
                    }else if(indexDispositivo == 1)
                    {
                        precioFinal = 150;
                    }else if(indexDispositivo == 2)
                    {
                        precioFinal = 50;
                    }
                }
                break;
            }
            default : 
            {
                precioFinal = 0;
                break;
            }
        }
    }
}
