#include <iostream>
#include <list>
#include <stack> // pila para usar en la DFS

using namespace std;

class Grafo
{
	int V; // número de vertices
	list<int> *adj;

public:
	Grafo(int V);
	void adicionarArista(int v1, int v2);

	// realiza DFS a partir de un vértice, retorna si encontro ciclo o no
	bool dfs(int v);

	// verifica si el grafo direcionado tiene ciclo
	bool existeCiclo();
};

Grafo::Grafo(int V)
{
	this->V = V;
	adj = new list<int>[V];
}

void Grafo::adicionarArista(int v1, int v2)
{
	adj[v1].push_back(v2);
}

bool Grafo::dfs(int v){
    stack<int> pila;
    bool visitados[V], pila_rec[V];
    
    for(int i=0; i<V; i++)
        visitados[i]=pila_rec[i] = false;
    
    // realizamos DFS
    while(true){
        bool encontro_vecino = false;
        list<int>::iterator it;
        
        if(!visitados[v])
        {
            pila.push(v);
            visitados[v] = pila_rec[v] = true;
        }
        
        for(it = adj[v].begin() ; it != adj[v].end() ; it++){
            // si el vecino ya esta en la pila es porque existe un ciclo
            if(pila_rec[*it])
                return true; 
            else{
                encontro_vecino = true;
                break; 
            }
        }
        
        if(!encontro_vecino)
        {
            cout << "entro al if" << endl;
            pila_rec[pila.top()] = false;  // marca que salio de la pila
            pila.pop(); // saco de la pila al vertice
            
            if(pila.empty())
                break; 
            v = pila.top();
        }else
            v = *it;
    }
    
    return false; 
        
    
}

bool Grafo::existeCiclo(){
    for(int i = 0; i < V ; i++)
    {
        if(dfs(i))
            return true; 
    }
    
    return false;
    
}

int main()
{
    Grafo grafo(4);
    
    //grafo.adicionarArista(0,1);
    grafo.adicionarArista(0,2);
    grafo.adicionarArista(1,3);
    grafo.adicionarArista(3,1);
    
    if(grafo.existeCiclo())
        cout<<"En el grafo existe ciclo"; 
    else 
        cout<<"En el grafo no existe ciclo"; 

    return 0;
}