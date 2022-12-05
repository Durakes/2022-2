package poo2_p2_pajueloaraujoarnold_01;
import java.util.*;


public class cLogica
{
    String puestos[] = {"A", "D", "M", "E"};
    Random rand = new Random();
    int minutos = 1001;
    LinkedList<Jugador> listJugadores = new LinkedList<>();

    void GenerarDatos(int numero)
    {
        for(int i = 0; i < numero; i++)
        {
            int randomPuesto = rand.nextInt(4);
            int randomMinutis = rand.nextInt(minutos);

            Jugador jugador = new Jugador();
            jugador.puesto = puestos[randomPuesto];
            jugador.minutosJugados = randomMinutis;
            listJugadores.add(jugador);
        }
    }

    Jugador Lista_MayorTiempo(LinkedList<Jugador> jugadores)
    {
        int mayor = 0;
        Jugador jugador = new Jugador();
        for(Jugador x: jugadores)
        {
            if(x.minutosJugados > mayor)
            {
                mayor = x.minutosJugados;
                jugador = x;
            } 
        }

        return jugador;
    }

    int[][] Total_PuestosyMinutos(LinkedList<Jugador> jugadores)
    {
        int A = 0;
        int D = 0;
        int M = 0;
        int E = 0;
        int contadorA = 0;
        int contadorD = 0;
        int contadorM = 0;
        int contadorE = 0; 
        for(Jugador x: jugadores)
        {
            if(x.puesto == "A")
            {
                contadorA++;
                A += x.minutosJugados;
            }else if(x.puesto == "D")
            {
                contadorD++;
                D += x.minutosJugados;
            }else if(x.puesto == "M")
            {
                contadorM++;
                M+= x.minutosJugados;
            }else if(x.puesto == "E")
            {
                contadorE++;
                E+= x.minutosJugados;
            }
        }

        int temporal[][] = {{contadorA, A}, {contadorD, D}, {contadorM, M}, {contadorE, E}};
        return temporal;
    }

    void imprimirJugadores()
    {
        for(Jugador x: listJugadores)
        {
            System.out.println(x.puesto);
            System.out.println(x.minutosJugados);
        }
    }
}
