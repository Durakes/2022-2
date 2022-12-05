#include <iostream>
using namespace std;

struct nodo
{
    int dato;
    struct nodo *siguiente;
};

struct nodo *pila = NULL;

void insertarPila(int n)
{
    struct nodo *nuevo;
    nuevo = (struct nodo*)malloc(sizeof(struct nodo));
    nuevo->dato = n;
    nuevo->siguiente = pila;
    pila = nuevo;
}

void mostrarPila()
{
    struct nodo *aux;
    aux = pila;
    while(aux != NULL)
    {
        cout << aux->dato << " ";
        aux = aux->siguiente;
    }
}

int extraerPila()
{
    struct nodo *aux;
    int n;
    aux = pila;
    n = aux->dato;
    pila = aux->siguiente;
    free(aux);
    return n;
}

void liberarPila()
{
    struct nodo *aux;
    while(pila != NULL)
    {
        aux = pila;
        pila = aux->siguiente;
        free(aux);
    }
}

void eliminarCambiar()
{
	if(pila != NULL)
    {
		int dato = extraerPila();
		eliminarCambiar();
		if(dato != 0)
        {
			insertarPila(dato * -1);
		}
	}
}

int main()
{

    insertarPila(0);
    insertarPila(-1);
    insertarPila(-8);
    insertarPila(0);
    insertarPila(-9);

    cout << "Pila original: " << endl;
    mostrarPila();
    cout << endl;
    cout << "Pila cambiada: " << endl;
    eliminarCambiar();
    mostrarPila();

	return 0;
}
