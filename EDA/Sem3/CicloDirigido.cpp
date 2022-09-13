#include <iostream>
#include <bits/stdc++.h>

using namespace std;

class Graph
{
        int V;
        list<int> *adj;
        bool isCyclicUtil(int v, bool visited[], bool *recStack); // recursiva
    
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
}

bool Graph ::isCyclicUtil(int v, bool visited[], bool *recStack) //lo mismo que poner recStack[] (Puede ser para que no se limpie el arrayy)
{
    if(visited[v] == false)
    {
        //Marque el nodo actual como visitado y también marque el índice en la pila de recursión.
        visited[v] = true; 
        recStack[v] = true; //Stack de recursión
        
        list<int>::iterator i; 
        
        for(i = adj[v].begin(); i != adj[v].end(); ++i)
        {
            //1 bucle
            //visited[0]
            //0 ---->> [1, 2]
            //return true

            //2 bucle
            //visited[1]
            //1 --->>[2]
            // return true

            //3 bucle
            //visited[2]
            //2 --->[0,3]
            // return true


            if(!visited[*i] && isCyclicUtil(*i, visited, recStack))
                return true;
            else if(recStack[*i])
                return true;
        }
    }    
    recStack[v] = false;
    return false;   
}

bool Graph::isCyclic()
{
    bool *visited = new bool[V];
    bool *recStack = new bool[V];
    
    for(int i = 0; i<V; i++)
    {
        visited[i] = false;
        recStack[i] = false; 
    }
    
    for(int i= 0 ; i < V; i++)
        if(!visited[i] && isCyclicUtil(i, visited, recStack))
            // i = 0 -- !visited[0] && isCyclicUtil(0, visited, recstack)
            return true;
    
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
    Graph g(4);
    
    g.addEdge(0,1);
    g.addEdge(0,2);
    g.addEdge(1,2);
    g.addEdge(2,3);
    g.addEdge(3,3);
    g.addEdge(2,0);
    
    if(g.isCyclic())
    {
        std::cout <<"Grafo contiene ciclo"  << std::endl;
    }else{
        std::cout <<"Grafo NO contiene ciclo"  << std::endl;
    }

    return 0;
}