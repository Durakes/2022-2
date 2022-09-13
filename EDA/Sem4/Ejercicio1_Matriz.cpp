#include <iostream>
using namespace std;

class Grafo
{
    private: 
        int** adjMatrix; 
        int numVertices; 
    
    public: 
    
    Grafo(int numVertices)
    {
        this->numVertices = numVertices;
        adjMatrix = new int*[numVertices];
        for (int i = 0; i < numVertices; i++)
        {
            adjMatrix[i] = new int[numVertices];
            for (int j = 0; j < numVertices; j++)
                adjMatrix[i][j] = false;
        }
    }

    
    //adicionar aristas
    void addEdge(int i , int j, int weight)
    {
        adjMatrix[i][j] = weight;
        adjMatrix[j][i] = weight; 
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

    void kruskalCamino(int n)
    {
        int mincamino = 0;

        
    }
    
    
}; 

int main()
{
    Grafo g(5);
    
    g.addEdge(0,1,1);
    g.addEdge(0,2,2);
    g.addEdge(0,3,3);
    g.addEdge(0,4,4);
    g.addEdge(1,2,5);
    g.addEdge(1,4,7);
    g.addEdge(2,3,6);
    
    g.imprime();

    return 0;
}
