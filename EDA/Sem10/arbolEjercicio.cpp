
#include <iostream>

using namespace std;

struct nodoArbol  
{
    int valor; 
    char op;
    struct nodoArbol* izq;
    struct nodoArbol* der; 
};

nodoArbol* arbol_crea(char operat, int v, nodoArbol* i, nodoArbol* d)
{
    nodoArbol* p = (nodoArbol*)malloc(sizeof(nodoArbol)); 
    p->valor = v;
    p->op = operat;
    p->izq = i; 
    p->der = d;  
    return p; 
}

int arbol_vacio(nodoArbol* a) 
{
    return a == NULL; 
}

void imprimeExp(nodoArbol *a)
{
    if(!arbol_vacio(a))
    {
        if(arbol_vacio(a->der) && arbol_vacio(a->izq))
            cout<<a->valor;
        else
        {
            cout<<"(";
            imprimeExp(a->izq);
            cout<<a->op;
            imprimeExp(a->der);
            cout<<")";
        }
    }
}

nodoArbol* arbol_libera(nodoArbol* a)
{
    if (!arbol_vacio(a))
    { 
        arbol_libera(a->izq); 
        arbol_libera(a->der);
        free(a);  
    }
    return NULL; 
}

float resolver (nodoArbol* a){
    
    if(!arbol_vacio(a))
    {
        if(arbol_vacio(a->der) && arbol_vacio(a->izq))
        {
            //cout<<a->valor;
            return a->valor;
        }
        else
        {
            if(a->op == '+')
                return resolver(a->izq) + resolver(a->der);
            if(a->op == '-')
                return resolver(a->izq) - resolver(a->der);
            if(a->op == '*')
                return resolver(a->izq) * resolver(a->der);
            if(a->op == '/')
                return resolver(a->izq) / resolver(a->der);
        }
    }
}

int main()
{
    nodoArbol * b;
    
    nodoArbol * a= arbol_crea('+',0, arbol_crea('*',0,arbol_crea('+',0,arbol_crea(NULL,3,NULL,NULL),arbol_crea(NULL,6,NULL,NULL)),arbol_crea('-',0,arbol_crea(NULL,4,NULL,NULL),arbol_crea(NULL,1,NULL,NULL))),
    arbol_crea(NULL,5,NULL,NULL));
    
    imprimeExp(a);
    
    cout<<"\nEl resultado es de la operacion es: "<<resolver(a)<<endl;

    b = arbol_libera(a); //hasta que no se termine de usar la struct no se libera
    
    if(b==NULL)
        cout<<"\nmemoria liberada";
    else
        cout<<"\nhubo un error al liberar la memoria";
    
    return 0;
}

