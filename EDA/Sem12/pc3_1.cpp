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

void imprimeMayoresCreciente(NodoArbol* a , int v)
{
    if(a != NULL)
    {
        if(a->info >= v)
        {
            imprimeMayoresCreciente(a->izq, v);
            if(a->info % 2 != 0)
                cout << a->info << " ";
            imprimeMayoresCreciente(a->der,v);
        }else
        {
            imprimeMayoresCreciente(a->der,v);
        }
    }
}

int sumarMayoresQue(NodoArbol* a , int n)
{
    if(a == NULL)
        return 0;
    else
    {
        if(a->info > n)
        {
            return a->info + sumarMayoresQue(a->izq, n) + sumarMayoresQue(a->der, n);
        }else
        {
            return sumarMayoresQue(a->der, n);
        }
    }
}

int main()
{
    NodoArbol * a= arbol_crea(5,arbol_crea(3,NULL,arbol_crea(4,NULL,NULL)),arbol_crea(9,arbol_crea(7,arbol_crea(6,NULL,NULL),arbol_crea(8,NULL,NULL)),arbol_crea(11,NULL,NULL)));

    cout << "-----PREGUNTA 1-----" << endl;
    cout << "Para el valor 8: ";
    imprimeMayoresCreciente(a,8);
    cout << endl;
    cout << "Para el valor 7: ";
    imprimeMayoresCreciente(a,7);
    cout << endl;
    cout << "Para el valor 4: ";
    imprimeMayoresCreciente(a,4);
    cout << endl;
    cout << "Para el valor 6: ";
    imprimeMayoresCreciente(a,6);

    NodoArbol * b= arbol_crea(5,arbol_crea(11,NULL,arbol_crea(6,NULL,NULL)),arbol_crea(4,arbol_crea(3,arbol_crea(8,NULL,NULL),arbol_crea(9,NULL,NULL)),arbol_crea(7,NULL,NULL)));

    cout << endl;
    cout << endl;
    cout << "-----PREGUNTA 2-----" << endl;
    cout << endl;
    cout << "La suma de los valores mayores a 4 en el grafo 2b: " << sumarMayoresQue(a,4) << " Es la respuesta correcta." << endl;
    cout << "La suma de los valores mayores a 7 en el grafo 2b: " << sumarMayoresQue(a,7) << " Es la respuesta correcta." << endl;
    cout << "La suma de los valores mayres a 6 en el grafo 2a: " << sumarMayoresQue(b,6) <<  " No es la respuesta correcta."<< endl;
    cout << endl;
    return 0;
}
