#include <iostream>
#include <cstring>
using namespace std;

struct persona
{
    int edad;
    float peso;
}; 
typedef struct persona Persona;

Persona* crearPersona(int edad, float peso)
{
    Persona* p = (Persona*)malloc(sizeof(Persona));
    p->edad = edad;
    p->peso = peso;
    return p;
}

struct nodoArbol
{
    Persona *info; 
    nodoArbol *izq;
    nodoArbol *der;
};
typedef struct nodoArbol NodoArbol;

NodoArbol* arbol_crea(Persona *persona, NodoArbol* i, NodoArbol* d)
{
    NodoArbol* p = (NodoArbol*)malloc(sizeof(NodoArbol)); 
    p->info = persona; 
    p->izq = i;
    p->der = d;  
    return p; 
}

NodoArbol* insertar(Persona *k, NodoArbol *p)
{ 
    if(p == NULL)
    { 
        return arbol_crea(k,NULL,NULL); 
    } 
    if(k->peso <= p->info->peso) 
        p->izq = insertar(k, p->izq); 
    else 
        p->der = insertar(k, p->der); 
    return p; 
}

float sumaPesos (NodoArbol *a)
{
    if(a == NULL)
        return 0;
    else
    {
        return a->info->peso + sumaPesos(a->izq) + sumaPesos(a->der);
    }
}

int main()
{
    NodoArbol *a = NULL;
    Persona *p1 = crearPersona(20, 60);
    Persona *p2 = crearPersona(19, 50);
    Persona *p3 = crearPersona(18, 45);
    Persona *p4 = crearPersona(19, 70);
    Persona *p5 = crearPersona(19, 90);
    Persona *p6 = crearPersona(19, 60);
    Persona *p7 = crearPersona(19, 55);
    Persona *p8 = crearPersona(19, 70);
    Persona *p9 = crearPersona(19, 85);
    
    a = insertar(p1,a);
    a = insertar(p2,a);
    a = insertar(p3,a);
    a = insertar(p4,a);
    a = insertar(p5,a);
    a = insertar(p6,a);
    a = insertar(p7,a);
    a = insertar(p8,a);
    a = insertar(p9,a);
    cout << "-----PREGUNTA 3-----" << endl;
    cout << "La suma de pesos es igual: " << endl;
    cout << sumaPesos(a);
    return 0;
}