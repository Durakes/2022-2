#include <iostream>

using namespace std;

struct _nodo
{ 
    int valor; 
    struct _nodo *izquierdo,  *derecho; 
}; 
typedef struct _nodo Nodo;

Nodo* arbol_crea(int v, Nodo* i, Nodo* d)
{
    Nodo* p = (Nodo*)malloc(sizeof(Nodo)); 
    p->valor = v; 
    p->izquierdo = i; 
    p->derecho = d;  
    return p; 
}

int arbol_vacio(Nodo *a)
{
    return a == NULL;    
}

void pos_orden(Nodo *raiz)
{
    if(raiz!=NULL)
    {
        pos_orden(raiz->izquierdo);
        pos_orden(raiz->derecho);
        cout << raiz->valor << " ";
    }
}

int main()
{
    Nodo* raiz = arbol_crea(25, arbol_crea(15,arbol_crea(10,arbol_crea(4,NULL,NULL),arbol_crea(12,NULL,NULL)),arbol_crea(22,arbol_crea(18,NULL,NULL),arbol_crea(24,NULL,NULL))),arbol_crea(50,arbol_crea(35,arbol_crea(31,NULL,NULL),arbol_crea(44,NULL,NULL)),arbol_crea(70,arbol_crea(66,NULL,NULL),arbol_crea(90,NULL,NULL))));

    cout << "Pos_orden" << endl;
    pos_orden(raiz);
    return 0;
}