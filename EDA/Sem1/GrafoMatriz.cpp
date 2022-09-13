#include <iostream>
using namespace std;

class Grafo
{
    public:
    int numeroVertice;
    bool** adjMatriz;

    Grafo(const int numero)
    {
        this->numeroVertice = numero;
        adjMatriz = new bool*[numeroVertice];

        for (int i = 0; i < numero; i++)
        {
            adjMatriz[i] = new bool [numeroVertice];
            for (int j = 0; j < numero; j++)
                adjMatriz[i][j] = false;
        }
    }

    void agregarArista(int i, int j)
    {
        adjMatriz[i][j] = true;
        //adjMatriz[j][i] = true; /* Si se desea representar un grafo dirigido se toma solo el orden ingresado por parametro */
    }

    void quitarArista(int i, int j)
    {
        adjMatriz[i][j] = false;
        //adjMatriz[j][i] = false; /* Si se desea representar un grafo dirigido se toma solo el orden ingresado por parametro */
    }

    bool verificarArista(int i, int j)
    {
        if(adjMatriz[i][j] == true)
        {
            return true;
        }else
        {
            return false;
        }
    }

    void imprimir()
    {   
        cout << "    ";
        for (int i = 0; i < numeroVertice; i++)
        {
            cout << i << " ";
        }
        cout << "\n";
        
        for (int i = 0; i < numeroVertice; i++)
        {
            cout << i << " : ";
            for (int j = 0; j < numeroVertice; j++)
                cout << adjMatriz[i][j] << " ";
            cout << "\n";
        }
    }

};

int main()
{
    Grafo grafo(5);

    grafo.agregarArista(0,1);
    grafo.agregarArista(0,2);
    grafo.agregarArista(1,3);
    grafo.agregarArista(2,2);
    grafo.agregarArista(1,4);

    grafo.imprimir();

    //cout << grafo.verificarArista(2,4) << endl;
    return 0;
}
