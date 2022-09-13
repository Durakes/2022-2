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

int main()
{
    
    Graph g(6);
    g.addEdge(0,1); 
    g.addEdge(1,2);
    g.addEdge(2,3);
    g.addEdge(3,4);
    g.addEdge(4,5);
    g.addEdge(5,0);

    if(g.isCyclic()){
        std::cout << "El grafo NO es un arbol" << std::endl;
    }else{
        std::cout << "El grafo SI es un arbol" << std::endl;
    }
    

    return 0;
}