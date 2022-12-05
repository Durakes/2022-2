#include <iostream>

using namespace std;
struct nodoArb
{
    int info;
    struct nodoArb * izq;
    struct nodoArb * der;
};
typedef struct nodoArb NodoArbol;


NodoArbol* arbol_crea(int v, NodoArbol* i, NodoArbol* d)
{
    NodoArbol* p = (NodoArbol*)malloc(sizeof(NodoArbol)); 
    p->info = v; 
    p->izq = i; 
    p->der = d;  
    return p; 
}

int arbol_vacio(NodoArbol *a)
{
    return a == NULL;    
}

void arbol_imprime(NodoArbol *a)
{
    if(!arbol_vacio(a))
    {
        printf("%d ", a->info); 
        arbol_imprime(a->izq); 
        arbol_imprime(a->der);
    }
}

NodoArbol* arbol_libera(NodoArbol* a) 
{
    if (!arbol_vacio(a))
    { 
        arbol_libera(a->izq); 
        arbol_libera(a->der);
        free(a);  
    }
    return NULL; 
}

int maximo_entre_2(int a, int b)
{
    //return (a>b) ? a:b;
    if(a>b) 
        return a;
    else 
        return b;
}

int altura_arbol(NodoArbol * a)
{
    if(a == NULL)
        return -1;
    else
        1 + maximo_entre_2(altura_arbol(a->izq),altura_arbol(a->der));
}

int arbol_mayor(NodoArbol * a)
{
    if(a->der == NULL)
        return a->info;
    else 
        return arbol_mayor(a->der);
}

void imprime_crecienteAux(NodoArbol * a)
{
    if (a!=NULL)
    {
        imprime_crecienteAux(a->izq);
        if(a->izq !=NULL)
            cout<<",";
        cout<< a->info;
        if(a->der !=NULL)
            cout<<",";
        imprime_crecienteAux(a->der);
    }
}

void imprime_creciente(NodoArbol * a)
{
    if (a!=NULL)
    {
        cout<<"{";
        imprime_crecienteAux(a);
        cout<<"}";
    }
}

int suma(NodoArbol *a)
{
    if(a == NULL)
        return 0;
    else
    {
        return a->info + suma(a->izq) + suma(a->der);
    }
}

int main()
{
    NodoArbol * a= arbol_crea(5,arbol_crea(3,NULL,arbol_crea(4,NULL,NULL)),arbol_crea(9,arbol_crea(7,arbol_crea(6,NULL,NULL),arbol_crea(8,NULL,NULL)),arbol_crea(11,NULL,NULL)));
    
    imprime_creciente(a);
    cout << endl;
    cout << "La suma es: " << suma(a) << endl;
    return 0;
}
