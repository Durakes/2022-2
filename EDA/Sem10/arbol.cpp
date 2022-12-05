#include <iostream>
#include <stdlib.h>

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

int arbol_vacio(NodoArbol* a)  {
    return a == NULL; 
    
}

void arbol_imprime(NodoArbol * a)  {
    if (!arbol_vacio(a)){
        printf("%d ", a->info); 
        arbol_imprime(a->izq); 
        arbol_imprime(a->der);
    }
}

NodoArbol* arbol_libera(NodoArbol* a)  {
    if (!arbol_vacio(a)){ 
        arbol_libera(a->izq); 
        arbol_libera(a->der);
        free(a);  
        }
    return NULL; 
}

int arbol_pertenece (NodoArbol* a, int v){ 
    if (arbol_vacio(a))  
        return 0;  
    else  
     return a->info==v || arbol_pertenece (a->izq,v) ||  
                        arbol_pertenece (a->der,v); 
}


int main()
{
    NodoArbol * b;
    NodoArbol * a= arbol_crea(5,arbol_crea(3,NULL,arbol_crea(4,NULL,NULL)),arbol_crea(9,arbol_crea(7,arbol_crea(6,NULL,NULL),arbol_crea(8,NULL,NULL)),arbol_crea(11,NULL,NULL)));
    
    arbol_imprime(a);
    
    b = arbol_libera(a);
    if(b==NULL)
        cout<<"\nmemoria liberada";
    else
        cout<<"\nhubo un error al liberar la memoria";


    return 0;
}
