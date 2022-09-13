#include <iostream>

using namespace std;

class Grafo
{
    private: 
        bool** adjMatrix; 
        int numVertices; 
    
    public: 
    
    Grafo(int numVertices)
    {
        this->numVertices = numVertices;
        adjMatrix = new bool*[numVertices];
        for (int i = 0; i < numVertices; i++)
        {
            adjMatrix[i] = new bool[numVertices];
            for (int j = 0; j < numVertices; j++)
                adjMatrix[i][j] = false;
        }
    }

    
    //adicionar aristas
    void addEdge(int i , int j)
    {
        adjMatrix[i][j] = true;
        adjMatrix[j][i] = true; 
    }
    
    
    //eliminar arista
    void removeEdge (int i , int j)
    {
        adjMatrix[i][j] = false;
        adjMatrix[j][i] = false; 
    }
    
    //imprime la matriz
    void imprime()
    {
        for(int i=0 ; i< numVertices; i++)
        {
            cout<< i <<" : ";

            for(int j=0 ; j< numVertices; j++)
                cout<< adjMatrix[i][j] <<" ";
                
            cout<<"\n";
        }
    
    }
    
    
}; 

int main()
{
    Grafo g(4);
    
    g.addEdge(0,1);
    g.addEdge(0,2);
    g.addEdge(1,2);
    g.addEdge(2,0);
    g.addEdge(2,3);
    
    g.imprime();

    return 0;
}
