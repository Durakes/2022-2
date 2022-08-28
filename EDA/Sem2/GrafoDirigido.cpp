#include <iostream>
#include <list> 
#include <algorithm> // funcion find

using namespace std;

class Grafo
{
    private:
        int V; // numero de vertices
        list <int> *adj;
    
    public:
        Grafo( int V);
        void adicionarArista(int v1, int v2); 
        int ObtenerGradoDeSalida(int v);
        bool existeVecino(int v1, int v2); // pregunta si estos dos vertices son vecinos
}; 

Grafo::Grafo(int V)
{
    this->V = V; //  numero de vertices 
    adj = new list<int>[V];
}

void Grafo::adicionarArista(int v1, int v2)
{
    adj[v1].push_back(v2);
}

int Grafo::ObtenerGradoDeSalida(int v)
{
    return adj[v].size();
}

bool Grafo::existeVecino(int v1, int v2)
{    
    if( find( adj[v1].begin(), adj[v1].end(), v2 ) != adj[v1].end() )
        return true; 
    return false; 
}

int main()
{
    
    Grafo grafo(4); 
    
    grafo.adicionarArista(0,1);
    grafo.adicionarArista(0,3);
    grafo.adicionarArista(1,2);
    grafo.adicionarArista(3,1);
    grafo.adicionarArista(3,2);
    
    cout << "Grado de salida del vertice 1: " << grafo.ObtenerGradoDeSalida(1) << "\n"; 
    cout << "Grado de salida del vertice 3: " << grafo.ObtenerGradoDeSalida(3) << "\n";
    
    // verificar si existe Vecino
    
    if(grafo.existeVecino(0,2))
        cout << "\n 2 es vecino de 0";
    else
        cout << "\n 2 No es vecino de 0";
    return 0;
}