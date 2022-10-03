#include <iostream>
#include <vector>
using namespace std;

struct codigo
{
    char tipo;
    char subtipo;
    int ref;
};

void crear(codigo cod, vector<codigo> *vec)
{
    vec->push_back(cod);
}

void imprimeCodigo(vector<codigo> codigos)
{
    for(codigo cod:codigos)
    {
        cout << "Tipo: " << cod.tipo << endl;
        cout << "Subtipo: " << cod.subtipo << endl;
        cout << "referencia: " << cod.ref << endl;
    }
}

void existeTipo(vector<codigo> codigos)
{
    char tipo;
    vector<codigo> cods;
    cout << "Ingrese un tipo a buscar: ";
    cin >> tipo;
    
    for(codigo cod: codigos)
    {
        if(cod.tipo == tipo)
        {
            cods.push_back(cod);
        }
    }

    if(cods.size()!=0)
    {
        cout << "Se encontro las siguientes referencias: " << endl;
        for(codigo cod: cods)
        {
            cout << cod.ref << ", ";
        }
        cout << endl;
    }else
    {
        cout << "No se encontro ninguna coincidencia" << endl;
    }
}

int main()
{
    int numCod;
    char tipo;
    char subtipo;
    int ref;
    vector<codigo> codigos;
    cout<<"Ingrese la cantidad de codigos: ";
    cin >> numCod;
    cout << endl;

    for(int i = 0; i < numCod; i++)
    {
        cout << "Ingrese el tipo: ";
        cin >> tipo;
        cout << "Ingrese el subtipo: ";
        cin >> subtipo;
        cout << "Ingrese el numero de referencia: ";
        cin >> ref;
        
        codigo cod;
        cod.tipo = tipo;
        cod.subtipo = subtipo;
        cod.ref = ref;
        
        crear(cod, &codigos);
        cout << endl;
    }
    
    cout << "Los codigos ingresados son: " << endl;
    imprimeCodigo(codigos);
    cout << endl;
    existeTipo(codigos);
    return 0;
}