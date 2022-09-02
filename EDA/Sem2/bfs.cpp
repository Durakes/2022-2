#include <stdio.h>
#include <iostream>
#include <list>
#include <queue> // fila

using namespace std;


class Grafo
{
	int V; // número de vértices
	list<int> *adj; // puntero para un array 

public:
	Grafo(int V); // constructor
	void adicionarArista(int v1, int v2); // adiciona una arista en el grafo

	// hace un BFS a partir de un vértice
	void bfs(int v);
};

Grafo::Grafo(int V)
{
	this->V = V; // atribuye el número de vértices
	adj = new list<int>[V]; // crea las listas
}

void Grafo::adicionarArista(int v1, int v2)
{
	// adiciona vértice v2 a la lista de vértices adyacentes de v1
	adj[v1].push_back(v2);
    adj[v2].push_back(v1);
}

void Grafo::bfs(int v){
    
    queue<int> fila;
    bool visitados[V]; 
    
    for(int i=0; i<V; i++)
        visitados[i] = false;
        
    cout<<"Visitando vertice "<<v<<"....\n";
    visitados[v] = true;
    
    while(true){
        list<int>::iterator it;
        
        for(it = adj[v].begin() ; it != adj[v].end(); it++){
            
            if(!visitados[*it]){
                cout<<"Visitando vertice "<< *it <<"....\n";
                visitados[*it] = true;
                fila.push(*it); // inserta en la fila
            }
        }
        
        // verificar si la fila No esta vacia 
        if(!fila.empty()){
            v = fila.front();
            fila.pop();
        }else{
            break;
        }
    }
        
}



int main()
{
    int V = 14; 
    
    Grafo grafo(V);
    
    // adiciono las aristas
    //grafo.adicionarArista(0,0);
    grafo.adicionarArista(1,2); 
    grafo.adicionarArista(1,4);
    grafo.adicionarArista(1,5);
    grafo.adicionarArista(2,3);
    grafo.adicionarArista(3,6);
    grafo.adicionarArista(3,7);
    grafo.adicionarArista(4,5);
    grafo.adicionarArista(5,12);
    grafo.adicionarArista(5,13);
    grafo.adicionarArista(6,13);
    grafo.adicionarArista(6,7);
    grafo.adicionarArista(7,8);
    grafo.adicionarArista(7,10);
    grafo.adicionarArista(8,9);
    grafo.adicionarArista(8,10);
    grafo.adicionarArista(9,11);
    grafo.adicionarArista(10,11);
    grafo.adicionarArista(12,13);
    
    cout << "El recorrido es el siguiente: " << endl;
    grafo.bfs(7);

    return 0;
}
