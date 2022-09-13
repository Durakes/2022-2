#include <iostream>
#include <bits/stdc++.h>

using namespace std;

class Graph
{
    int V;
    list<int> *adj;
    bool isCyclicUtil(int v, bool visited[], int parent);
    
    public:
        Graph(int V);
        void addEdge(int v, int w);
        bool isCyclic();
        //void imprimirVecinos(int v);
}; 

// constructor
Graph::Graph(int V)
{
    this->V = V;
    adj = new list<int>[V];
}

void Graph::addEdge(int v, int w)
{
    adj[v].push_back(w);
    adj[w].push_back(v);
}

bool Graph::isCyclicUtil(int v, bool visited[], int parent)
{
    visited[v] = true;
    
    list<int>::iterator i; 
    for(i = adj[v].begin(); i != adj[v].end(); ++i)
    {
        //1 bucle - nodo (0)
        // 0 --> [1,2]
        // Entra parent = -1, se envía al 2do bucle parent = 0
        //return true

        //2 bucle - nodo (1)
        //1 --> [0,2]
        // Entra parent = 0, se envía al 3er bucle parent = 1
        // return true

        //3 bucle - nodo(2)
        //2 --> [0,3]
        //return true

        if(!visited[*i])
        {
            if(isCyclicUtil(*i,visited, v))
                return true;
        }
        else if (*i !=parent) // Visitar el nodo anterior no puede ser el nodo del que viene.
            return true;
            
    }
    return false; 
        
}

bool Graph::isCyclic()
{
    
    bool *visited = new bool[V];
    
    for(int i = 0; i<V; i++)
    {
        visited[i] = false;
    }
    
    for(int i= 0 ; i < V; i++)
    {
        if(!visited[i])
            if(isCyclicUtil(i, visited, -1))
                return true;
    }
    return false;
}

/*void Graph::imprimirVecinos(int v)
{
    list<int>::iterator i; 
        
    for(i = adj[v].begin(); i != adj[v].end(); ++i)
    {
        cout << *i << endl;
    }
}*/

int main()
{
    
    Graph g(5);
    g.addEdge(1,0); 
    g.addEdge(1,2);
    g.addEdge(2,3);
    //g.addEdge(0,2);
    //g.addEdge(3,4);

    if(g.isCyclic()){
        std::cout << "El grafo tiene ciclo" << std::endl;
    }else{
        std::cout << "El grafo NO tiene ciclo" << std::endl;
    }
    
    
    /*Graph g1(3);
    g1.addEdge(0,1); 
    g1.addEdge(1,2);

    
    if(g1.isCyclic()){
        std::cout << "El grafo  1 tiene ciclo" << std::endl;
    }else{
        std::cout << "El grafo 1 NO tiene ciclo" << std::endl;
    }*/

    return 0;
}