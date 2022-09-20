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

    void utilityCamino(int inicio, int final)
    {
        int *camino = new int[numVertices];
        int index = 0;
        camino[0] = inicio;
        grafoVerificaCamino(inicio, final, index, camino);
    }

    void grafoVerificaCamino(int inicio, int final, int& index, int camino[])
    {
        if(inicio != final)
        {
            for(int i = inicio + 1; i < numVertices; i++)
            {
                if(adjMatrix[inicio][i] == true)
                {
                    camino[index+1] = i;
                    index++;
                    grafoVerificaCamino(i, final, index, camino);
                }
            }
        }else
        {
            for(int i = 0; i < index+1; i++)
            {
                if(i!= index)
                    cout << camino[i] << " -> ";
                else
                    cout << camino[i];
            }
            cout << endl;
        }
        index--;
    }
}; 

int main()
{
    Grafo grafo(4);
    
    grafo.addEdge(0,1);
    grafo.addEdge(0,2);
    grafo.addEdge(1,2);
    grafo.addEdge(2,3);
    
    int inicio = 0;
    int final = 3;
    cout << "Los caminos entre " << inicio << " y " << final << " son: " << endl;
    grafo.utilityCamino(0, 3);

    return 0;
}
