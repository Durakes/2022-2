#include <iostream>
#include <list>
#include <algorithm> // funcion find
#include <stack> // pila

using namespace std;

class Grafo
{
    private:
        int V; // numero de vertices
        list <int> *adj;
    
    public:
        Grafo( int V);
        void adicionarArista(int v1, int v2); 
        void dfs(int v);
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

void Grafo::dfs(int v)
{     
    stack<int> pila;
    bool visitados[V]; // vector visitados

     // marcamos a todos los vertices como no visitados
    for(int i = 0 ; i < V ; i++)
        visitados[i] = false;

    while(true)
    {
        if(!visitados[v])
        {
            cout<<"Visitando vertice "<< v << "....\n";
            visitados[v] = true;
            pila.push(v);
        }
        bool existe = false;
        list<int>::iterator it; 
         // buscamos un vecino no visitado
        for( it = adj[v].begin() ; it != adj[v].end(); it++)
        {
            if(!visitados[*it])
            {
                existe = true;
                break; 
            }
        }
        
        if(existe)
            v = *it;
        else
        {
             // si todos los vecinos ya fueron visitados
            pila.pop();
            
            if(pila.empty())
                break;
            v = pila.top();
        }
    }
}


int main()
{
    int V = 8; 
    
    Grafo grafo(V);
    
    // adiciono las aristas
    grafo.adicionarArista(0,1); 
    grafo.adicionarArista(0,2);
    grafo.adicionarArista(1,3);
    grafo.adicionarArista(1,4);
    grafo.adicionarArista(2,5);
    grafo.adicionarArista(2,6);
    grafo.adicionarArista(6,7);
    
    grafo.dfs(0);

    return 0;
}